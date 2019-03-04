package webuilder.flow;

public class StartNode extends AbstractTaskNode implements FlowNode {

	@Override
	public String getNodeId() {
		// TODO Auto-generated method stub
		return FlowConst.DEFAULT_START_NODE;
	}

	@Override
	public String getNodeName() {
		// TODO Auto-generated method stub
		return FlowConst.DEFAULT_START_NODE_TEXT;
	}

	@Override
	public boolean isAuto() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Form getForm() {
		// TODO Auto-generated method stub
		return null;
	}

}
