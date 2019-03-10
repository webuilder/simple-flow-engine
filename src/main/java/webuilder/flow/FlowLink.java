package webuilder.flow;

public interface FlowLink {

	String getLinkId();

	String getFromNode();

	String getToNode();

	String getName();

	Condition getCondition();

	Object getAttribute(Object attributeName);

	void run(FlowInstance flowInstance, FlowContext context);

	UserFinder getOperatorFinder();
}
