package webuilder.flow;

public class EndNode extends AbstractTaskNode implements FlowNode {

	private String nodeId;

	private String nodeName;

	public EndNode() {
		this.nodeId = FlowConst.DEFAULT_END_NODE;
		this.nodeName = FlowConst.DEFAULT_END_NODE_TEXT;
	}

	public EndNode(String nodeId, String nodeName) {
		super();
		this.nodeId = nodeId;
		this.nodeName = nodeName;
	}

	@Override
	public String getNodeId() {
		// TODO Auto-generated method stub
		return nodeId;
	}

	@Override
	public String getNodeName() {
		// TODO Auto-generated method stub
		return nodeName;
	}

	@Override
	public boolean isAuto() {
		return true;
	}

	@Override
	public FlowForm getForm() {
		// TODO Auto-generated method stub
		return null;
	}

}
