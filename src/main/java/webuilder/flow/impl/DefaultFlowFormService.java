package webuilder.flow.impl;

import java.util.HashMap;
import java.util.Map;

import webuilder.flow.FlowForm;
import webuilder.flow.FlowFormNotExistException;
import webuilder.flow.FlowFormService;
import webuilder.flow.form.FlowFormRegister;

public class DefaultFlowFormService implements FlowFormService {

	private Map<String, FlowFormRegister<?>> map = new HashMap<>();

	public void register(FlowFormRegister<?> register) {
		map.put(register.getFlowName(), register);
	}

	@Override
	public FlowForm getFlowForm(String flowName) {
		FlowFormRegister<?> register = map.get(flowName);
		if (register == null) {
			throw new FlowFormNotExistException(flowName);
		}
		return register.getForm();
	}

}
