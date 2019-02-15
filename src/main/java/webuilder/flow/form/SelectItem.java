package webuilder.flow.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FlowFormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SelectItem extends AbstractItem implements FlowFormItem {

	private List<Option> items = new ArrayList<>();

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "select";
	}

	public SelectItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	public void addItem(String value, String text) {
		Option option = new Option();
		option.setValue(value);
		option.setText(text);
		items.add(option);
	}

	@Data
	public static class Option {
		private String value;
		private String text;
	}
}
