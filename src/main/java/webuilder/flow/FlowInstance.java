package webuilder.flow;

/**
 * 流程实例<br>
 * 表示一个正在运行或者已经结束的流程的实例
 * 
 * @author lijian
 *
 */
public interface FlowInstance {

	/**
	 * 获取流程定义ID
	 * 
	 * @return
	 */
	String getFlowName();

	/**
	 * 获取流程实例ID
	 * 
	 * @return
	 */
	Long getInstanceId();

	/**
	 * 获取当前节点ID
	 * 
	 * @return
	 */
	String getCurrentNode();

	void setCurrentNode(String currentNode);
	
	/** 获取此流程实例的当前经办人ID */
	String getOperator();
	/** 获取此流程实例的当前经办人姓名 */
	String getOperatorName();
}
