package webuilder.flow.impl;

import java.util.ArrayList;
import java.util.List;

import webuilder.flow.FlowContext;
import webuilder.flow.FlowInstance;
import webuilder.flow.FlowUser;
import webuilder.flow.UserFinder;

/**
 * 仅仅返回当前用户的 UserFinder 实现
 * 
 * @author lijian
 *
 */
public class SelfUserFinder implements UserFinder {

	@Override
	public List<FlowUser> find(FlowInstance instance, String linkId, FlowContext context) {
		List<FlowUser> result = new ArrayList<FlowUser>();
		result.add(context.getUser());
		return result;
	}

}
