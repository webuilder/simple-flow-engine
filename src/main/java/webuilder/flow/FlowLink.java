package webuilder.flow;


public interface FlowLink {

	String getLinkId();

	String getFromNode();

	String getToNode();

	String getName();

	Condition getCondition();

//	/**
//	 * 获取用于查找经办人的UserFinder
//	 * 
//	 * @return
//	 */
//	UserFinder getOperatorFinder();
//
//	/**
//	 * 获取用于通知用户的UserFinder
//	 * 
//	 * @return
//	 */
//	UserFinder getNotifyUserFinder();
}
