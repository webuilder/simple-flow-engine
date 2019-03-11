package webuilder.flow;

import webuilder.flow.utils.FlowUtils;

public class EndNode extends AbstractTaskNode implements FlowNode {

	private String nodeId;

	private String nodeName;
	
	private Form form = FlowUtils.EMPTY_FORM;

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
	public Form getForm() {
		// TODO Auto-generated method stub
		return form;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}

}
