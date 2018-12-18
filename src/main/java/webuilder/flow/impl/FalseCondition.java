package webuilder.flow.impl;

import webuilder.flow.Condition;
import webuilder.flow.FlowContext;
import webuilder.flow.FlowInstance;

/**
 * 永远为“假”的条件，用于作为流程节点的默认条件
 * 
 * @author lijian
 *
 */
public class FalseCondition implements Condition {

	@Override
	public boolean evaluate(FlowInstance instance, FlowContext context) {
		return false;
	}

}
