package webuilder.flow.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webuilder.flow.FlowConst;
import webuilder.flow.FlowDefException;
import webuilder.flow.FlowDefinition;
import webuilder.flow.FlowLink;
import webuilder.flow.FlowNode;
import webuilder.flow.FlowRuntimeException;
import webuilder.flow.NodeListener;

/**
 * 流程定义
 * 
 * @author lijian
 *
 */
public class DefaultFlowDefinition implements FlowDefinition {

	private final String name;

	private String startNode = FlowConst.DEFAULT_START_NODE;

	private Map<String, FlowNode> nodes = new HashMap<>();

	private List<String> requiredVariables = new ArrayList<>();

	private List<NodeListener> nodeListeners = new ArrayList<>();

	private List<FlowLink> links = new ArrayList<>();

	private Map<String, FlowLink> linkMap = new HashMap<>();

	public DefaultFlowDefinition(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void addNode(FlowNode node) {
		nodes.put(node.getNodeId(), node);
	}

	public void requireVariable(String variableName) {
		requiredVariables.add(variableName);
	}

	public void addNodeListener(NodeListener listener) {
		nodeListeners.add(listener);
	}

	public Map<String, FlowNode> getNodes() {
		return nodes;
	}

	public List<String> getRequiredVariables() {
		return requiredVariables;
	}

	@Override
	public List<NodeListener> getNodeListeners() {
		return nodeListeners;
	}

	public void setNodeListeners(List<NodeListener> nodeListeners) {
		this.nodeListeners = nodeListeners;
	}

	@Override
	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	@Override
	public List<FlowLink> getLinks() {
		return links;
	}

	public void addLink(FlowLink link) {
		if (linkMap.get(link.getLinkId()) != null) {
			throw new FlowDefException("Repeated FlowLink[" + link.getLinkId() + "]");
		}
		linkMap.put(link.getLinkId(), link);
		this.links.add(link);
	}

	@Override
	public FlowLink getLink(String linkId) {
		FlowLink link = linkMap.get(linkId);
		if (link == null) {
			throw new FlowRuntimeException("Not exist FlowLink[" + linkId + "]");
		}
		return link;
	}

}
