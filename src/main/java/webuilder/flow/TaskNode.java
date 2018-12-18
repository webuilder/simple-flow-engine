package webuilder.flow;

import webuilder.flow.utils.FlowUtils;

/**
 * 人工节点
 * 
 * @author lijian
 *
 */
public class TaskNode extends AbstractTaskNode implements FlowNode {

	private final String nodeId;

	private final String nodeName;

	private final boolean auto;

	private FlowForm form = FlowUtils.EMPTY_FORM;

	public TaskNode(String nodeId, String nodeName, boolean auto) {
		super();
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.auto = auto;
	}

	@Override
	public final boolean isAuto() {
		return auto;
	}

	@Override
	public String getNodeId() {
		return nodeId;
	}

	@Override
	public String getNodeName() {
		return nodeName;
	}

	@Override
	public FlowForm getForm() {
		return form;
	}

	public void setForm(FlowForm form) {
		this.form = form;
	}

}
