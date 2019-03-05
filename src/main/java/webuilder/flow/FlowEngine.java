package webuilder.flow;

import java.util.List;

/**
 * 流程引擎
 * 
 * @author lijian
 *
 */
public interface FlowEngine {

	/**
	 * 启动一个流程
	 * 
	 * @param flowName
	 *            流程定义(FlowDefinition)名称
	 * @param context
	 *            流程引擎的上下文
	 * @return
	 */
	FlowInstance startFlow(String flowName, FlowContext context);

	/**
	 * 读取一个流程实例
	 * 
	 * @param instanceId
	 * @return
	 */
	FlowInstance getInstance(Long instanceId);

	/**
	 * 获取流程启动节点所允许的操作
	 * 
	 * @param flowName
	 * @param context
	 * @return
	 */
	List<FlowLink> getValidStartLinks(String flowName, FlowContext context);

	/**
	 * 执行一个节点
	 * 
	 * @param instance
	 * @param context
	 * @param linkId
	 *            指定下一步使用的Link; 可以为null，那么由引擎自行选择合适的Link
	 */
	void run(FlowInstance instance, FlowContext context, String linkId);

	/**
	 * 获取流程当前节点所允许的操作
	 * 
	 * @param instance
	 * @param context
	 * @return
	 */
	List<FlowLink> getValidLinks(FlowInstance instance, FlowContext context);

	/**
	 * 获取流程定义
	 * 
	 * @param flowName
	 * @return
	 */
	FlowDefinition getFlowDefinition(String flowName);
}
