package webuilder.flow;

public interface FlowLink {

	String getLinkId();

	String getFromNode();

	String getToNode();

	String getName();

	Condition getCondition();

	Object getAttribute(String attributeName);

	void run(FlowInstance flowInstance, FlowContext context);

}
