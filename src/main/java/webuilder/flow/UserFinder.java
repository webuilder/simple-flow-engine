package webuilder.flow;

import java.util.List;

/**
 * 查找允许使用FlowLink的用户
 * 
 * @author lijian
 *
 */
public interface UserFinder {

	/**
	 * 查找允许使用FlowLink的用户
	 * 
	 * @param instance 流程实例
	 * @param linkId   FlowLink的ID
	 * @param context  流程引擎上下文
	 * @return
	 */
	List<FlowUser> find(FlowInstance instance, String linkId, FlowContext context);
}
