package webuilder.flow;

import java.util.List;
import java.util.Map;

public interface FlowDefinition {

	String getName();

	Map<String, FlowNode> getNodes();

	String getStartNode();

	List<FlowLink> getLinks();
	
	FlowLink getLink(String linkId);

	List<NodeListener> getNodeListeners();
}