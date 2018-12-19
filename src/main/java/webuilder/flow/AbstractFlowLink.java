package webuilder.flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractFlowLink implements FlowLink {

	private List<LinkFunction> funcs = new ArrayList<>();

	private Map<String, Object> attributes = new HashMap<>();

	@Override
	public void run(FlowInstance flowInstance, FlowContext context) {
		for (LinkFunction func : funcs) {
			func.run(flowInstance, context);
		}
	}

	public void addFunction(LinkFunction func) {
		funcs.add(func);
	}

	@Override
	public Object getAttribute(String attributeName) {
		return attributes.get(attributeName);
	}
	
	public void setAttribute(String attributeName, Object value){
		attributes.put(attributeName, value);
	}

}
