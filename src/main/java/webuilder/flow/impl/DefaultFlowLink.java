package webuilder.flow.impl;

import webuilder.flow.Condition;
import webuilder.flow.FlowLink;
import webuilder.flow.FlowNode;

public class DefaultFlowLink implements FlowLink {

	private final String linkId;

	private final String name;

	private String fromNode;

	private String toNode;

	private Condition condition;

	public DefaultFlowLink(String linkId, String name) {
		super();
		this.linkId = linkId;
		this.name = name;
	}

	public DefaultFlowLink(String linkId, String name, String fromNode, String toNode) {
		super();
		this.linkId = linkId;
		this.name = name;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	public DefaultFlowLink(String linkId, String name, FlowNode fromNode, FlowNode toNode) {
		super();
		this.linkId = linkId;
		this.name = name;
		this.fromNode = fromNode.getNodeId();
		this.toNode = toNode.getNodeId();
	}

	@Override
	public String getLinkId() {
		// TODO Auto-generated method stub
		return linkId;
	}

	@Override
	public String getFromNode() {
		// TODO Auto-generated method stub
		return fromNode;
	}

	@Override
	public String getToNode() {
		// TODO Auto-generated method stub
		return toNode;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
