package webuilder.flow;

import java.util.Map;

public interface FlowContext {

	Map<String, Object> getVariables();

	FlowUser getUser();

	FlowUser getNextUser();
}
