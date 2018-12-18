package webuilder.flow;

/**
 * 流程状态判断条件
 * 
 * @author lijian
 *
 */
public interface Condition {

	boolean evaluate(FlowInstance instance, FlowContext context);
}
