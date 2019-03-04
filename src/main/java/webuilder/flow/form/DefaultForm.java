package webuilder.flow.form;

import java.util.List;

import lombok.Data;
import webuilder.flow.Form;
import webuilder.flow.FlowFormItem;

@Data
public class DefaultForm implements Form {

	private String flowName;

	private List<FlowFormItem> items;
}
