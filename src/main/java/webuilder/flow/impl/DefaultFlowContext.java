package webuilder.flow.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import webuilder.flow.FlowContext;
import webuilder.flow.FlowUser;

@Data
public class DefaultFlowContext implements FlowContext {

	private Map<String, Object> variables = new HashMap<>();
	/**
	 * 执行此操作的用户
	 */
	private FlowUser user;
	/**
	 * 给下一节点指派的用户
	 */
	private FlowUser nextUser;

}
