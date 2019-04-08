package webuilder.flow.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import webuilder.flow.EndNode;
import webuilder.flow.FlowContext;
import webuilder.flow.FlowDefinition;
import webuilder.flow.FlowEngine;
import webuilder.flow.FlowEngineConfiguration;
import webuilder.flow.FlowInstance;
import webuilder.flow.FlowLink;
import webuilder.flow.FlowNode;
import webuilder.flow.FlowRuntimeException;
import webuilder.flow.FlowUser;
import webuilder.flow.NodeListener;
import webuilder.flow.UserFinder;
import webuilder.flow.utils.FlowUtils;

@Slf4j
public abstract class AbstractFlowEngine implements FlowEngine {
	protected Map<String, FlowDefinition> flows;

	@Getter
	@Setter
	protected FlowEngineConfiguration config = new FlowEngineConfiguration();

	public AbstractFlowEngine(Collection<FlowDefinition> flows) {
		super();
		this.flows = flows.stream().collect(Collectors.toMap((t) -> t.getName(), (t) -> t));
	}

	@Override
	public void run(FlowInstance instance, FlowContext context, String linkId) {
		FlowDefinition flow = flows.get(instance.getFlowName());
		String nodeId = instance.getCurrentNode();
		FlowNode node = flow.getNodes().get(nodeId);

		FlowLink nextLink = null;
		if (!(node instanceof EndNode)) {
			List<FlowLink> validLinks = getValidLinks(instance, context);
			if (FlowUtils.isEmptyString(linkId)) {
				if (validLinks.size() == 1) {
					nextLink = validLinks.get(0);
					linkId = nextLink.getLinkId();
				} else {
					throw new FlowRuntimeException(
							"FlowInstance[" + instance.getInstanceId() + "] node[" + nodeId + "] 未指定linkId");
				}
			} else {
				// 判断linkId是否为合法的操作

				for (FlowLink link : validLinks) {
					if (link.getLinkId().equals(linkId)) {
						nextLink = link;
						break;
					}
				}
				if (nextLink == null) {
					throw new FlowRuntimeException("FlowInstance[" + instance.getInstanceId() + "] node[" + nodeId
							+ "] 指定了错误的linkId[" + linkId + "]");

				}
			}
		}
		List<NodeListener> listeners = flow.getNodeListeners();
		int listenerCount = listeners.size();

		for (int i = 0; i < listenerCount; i++) {
			NodeListener listener = listeners.get(i);
			listener.onNodeBegin(node, instance, context);
		}

		log.debug("run flow_instance[{}] node[{}]", instance.getInstanceId(), node.getNodeId());
		node.run(instance, context);

		for (int i = listenerCount - 1; i >= 0; i--) {
			NodeListener listener = listeners.get(i);
			listener.onNodeEnd(node, instance, context);
		}

		if (!(node instanceof EndNode)) {
			nextLink.run(instance, context);
			saveInstance(node, linkId, instance, context);
			String next = nextLink.getToNode();

			if (!FlowUtils.isEmptyString(next)) {
				FlowNode nextNode = flow.getNodes().get(next);
				if (nextNode != null) {
					instance.setCurrentNode(next);
					if (nextNode.isAuto()) {
						run(instance, context, null);
					}
				} else {
					throw new RuntimeException("Unknown node[" + next + "] in flow[" + instance.getFlowName() + "]");
				}
			}
		}
	}

	/**
	 * 对于start节点做处理，如果start节点是自动节点，那么将自动开始流转<br>
	 * 子类的startFlow方法内，创建流程实例后，应当调用此方法
	 * 
	 * @param instance
	 */
	protected void runStartNode(FlowInstance instance, FlowContext context) {
		String flowName = instance.getFlowName();
		FlowDefinition flow = getFlowDefinition(flowName);
		String startNodeName = flow.getStartNode();
		FlowNode startNode = flow.getNodes().get(startNodeName);
		if (startNode.isAuto()) {
			run(instance, context, null);
		}
	}

	protected abstract void saveInstance(FlowNode node, String linkId, FlowInstance instance, FlowContext context);

	@Override
	public List<FlowLink> getValidStartLinks(String flowName, FlowContext context) {
		FlowDefinition flow = flows.get(flowName);
		String nodeId = flow.getStartNode();
		List<FlowLink> links = flow.getLinks();

		// 起始节点的操作
		List<FlowLink> startLinks = links.stream().filter((t) -> t.getFromNode().equals(nodeId))
				.collect(Collectors.toList());
		return getInternalValidLinks(startLinks, null, context);
	}

	@Override
	public List<FlowLink> getValidLinks(FlowInstance instance, FlowContext context) {
		String flowName = instance.getFlowName();
		FlowDefinition flow = flows.get(flowName);
		String nodeId = instance.getCurrentNode();
		List<FlowLink> links = flow.getLinks();
		List<FlowLink> nodeLinks = links.stream().filter((t) -> t.getFromNode().equals(nodeId))
				.collect(Collectors.toList());
		List<FlowLink> validLinks = getInternalValidLinks(nodeLinks, instance, context);

		if (config.isIgnoreNoUserLinks()) {
			validLinks = validLinks.stream().filter(t -> {
				UserFinder userFinder = t.getOperatorFinder();
				List<FlowUser> flowUsers = userFinder.find(instance, t.getLinkId(), context);
				return !flowUsers.isEmpty();
			}).collect(Collectors.toList());
		}
		return validLinks;
	}

	private List<FlowLink> getInternalValidLinks(List<FlowLink> links, FlowInstance instance, FlowContext context) {
		List<FlowLink> result = new ArrayList<>();
		for (FlowLink link : links) {
			if (link.getCondition() == null) {
				result.add(link);
			} else if (link.getCondition().evaluate(instance, context)) {
				result.add(link);
			}
		}
		return result;
	}

	@Override
	public FlowDefinition getFlowDefinition(String flowName) {
		return flows.get(flowName);
	}
}
