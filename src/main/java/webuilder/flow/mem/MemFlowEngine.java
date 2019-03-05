package webuilder.flow.mem;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import webuilder.flow.FlowContext;
import webuilder.flow.FlowDefException;
import webuilder.flow.FlowDefinition;
import webuilder.flow.FlowEngine;
import webuilder.flow.FlowInstance;
import webuilder.flow.FlowNode;
import webuilder.flow.impl.AbstractFlowEngine;
import webuilder.flow.utils.FlowUtils;

public class MemFlowEngine extends AbstractFlowEngine implements FlowEngine {

	private Map<Long, MemFlowInstance> instances = new ConcurrentHashMap<>();

	public MemFlowEngine(Collection<FlowDefinition> flows) {
		super(flows);
	}

	@Override
	public FlowInstance startFlow(String flowName, FlowContext context) {
		long instanceId = ThreadLocalRandom.current().nextLong();
		MemFlowInstance instance = new MemFlowInstance(instanceId);
		instance.setFlowName(flowName);

		FlowDefinition flow = flows.get(instance.getFlowName());
		String startNodeName = flow.getStartNode();
		if (FlowUtils.isEmptyString(startNodeName)) {
			throw new FlowDefException("Flow[" + flowName + "] have not startNode.");
		}
		instance.setCurrentNode(startNodeName);

		flow.getNodes().get(startNodeName);
		instances.put(instanceId, instance);

		runStartNode(instance, context);
		return instance;
	}

	@Override
	public FlowInstance getInstance(Long instanceId) {
		// TODO Auto-generated method stub
		return instances.get(instanceId);
	}

	@Override
	protected void saveInstance(FlowNode node, String linkId, FlowInstance instance, FlowContext context) {
		System.out.println("@@@ 保存流转结果 [instanceId=" + instance.getInstanceId() + "] 当前节点 [" + node.getNodeId() + ":"
				+ node.getNodeName() + "]");
	}
}
