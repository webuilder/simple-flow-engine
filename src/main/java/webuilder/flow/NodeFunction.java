package webuilder.flow;

/**
 * 节点函数，每个节点可以包含0个或多个NodeFunction
 * 
 * @author lijian
 *
 */
public interface NodeFunction {

	void run(FlowInstance flowInstance, FlowContext context);
}
