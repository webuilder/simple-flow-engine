package webuilder.flow;

/**
 * 流程节点
 * 
 * @author lijian
 *
 */
public interface FlowNode {
	/**
	 * 获取流程节点ID
	 * 
	 * @return
	 */
	String getNodeId();

	/**
	 * 获取流程节点名称
	 * 
	 * @return
	 */
	String getNodeName();

	/**
	 * 执行当前流程节点
	 * 
	 * @param flowInstance
	 * @param context
	 */
	void run(FlowInstance flowInstance, FlowContext context);

	/**
	 * 本节点是否为自动节点
	 * 
	 * @return
	 */
	boolean isAuto();

	Form getForm();

	Object getAttribute(String attributeName);
}
