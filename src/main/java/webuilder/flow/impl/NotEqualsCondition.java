package webuilder.flow.impl;

import java.util.Objects;

import webuilder.flow.Condition;
import webuilder.flow.FlowContext;
import webuilder.flow.FlowInstance;

/**
 * 流程变量不等于给定值时，为真
 * 
 * @author lijian
 *
 */
public class NotEqualsCondition implements Condition {

	private final String variableName;
	private final Object value;

	public NotEqualsCondition(String variableName, Object value) {
		super();
		this.variableName = variableName;
		this.value = value;
	}

	@Override
	public boolean evaluate(FlowInstance instance, FlowContext context) {
		Object obj = context.getVariables().get(variableName);
		return !Objects.equals(obj, value);
	}

}
