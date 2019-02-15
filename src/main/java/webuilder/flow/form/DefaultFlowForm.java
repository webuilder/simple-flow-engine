package webuilder.flow.form;

import java.util.List;

import lombok.Data;
import webuilder.flow.FlowForm;
import webuilder.flow.FlowFormItem;

@Data
public class DefaultFlowForm implements FlowForm {

	private String flowName;

	private List<FlowFormItem> items;
}
