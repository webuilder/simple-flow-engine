package webuilder.flow.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import webuilder.flow.AbstractFlowLink;
import webuilder.flow.Condition;
import webuilder.flow.FlowLink;
import webuilder.flow.FlowNode;
import webuilder.flow.UserFinder;

@Data
@EqualsAndHashCode(callSuper = false)
public class DefaultFlowLink extends AbstractFlowLink implements FlowLink {

	private static final UserFinder DEFAULT_OPERATOR_USER_FINDER = new SelfUserFinder();

	private final String linkId;

	private final String name;

	private String fromNode;

	private String toNode;

	private Condition condition;

	private UserFinder operatorFinder = DEFAULT_OPERATOR_USER_FINDER;

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

}
