package webuilder.flow.mem;

import webuilder.flow.FlowInstance;

public class MemFlowInstance implements FlowInstance {

	private String flowName;

	private String currentNode;

	private final Long instanceId;

	public MemFlowInstance(Long instanceId) {
		super();
		this.instanceId = instanceId;
	}

	@Override
	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	@Override
	public Long getInstanceId() {
		// TODO Auto-generated method stub
		return instanceId;
	}

	public String getCurrentNode() {
		return currentNode;
	}

	@Override
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
}
