package webuilder.flow;

import java.util.List;

/**
 * 流程表单
 * 
 * @author lijian
 *
 */
public interface FlowForm {

	String getFlowName();

	List<FlowFormItem> getItems();
}
