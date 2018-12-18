package webuilder.flow;

/**
 * 流程节点监听器
 * 
 * @author lijian
 *
 */
public interface NodeListener {

	void onNodeBegin(FlowNode node, FlowInstance instance, FlowContext context);

	void onNodeEnd(FlowNode node, FlowInstance instance, FlowContext context);
}
