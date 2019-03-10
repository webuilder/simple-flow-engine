package webuilder.flow.form;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CascaderItem extends HaveChildrenItem<Object> implements FormItem {
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.CASCADER;
	}

	public CascaderItem() {
		super();
	}
	
	public CascaderItem(String name, String text) {
		super(name, text);
	}

	public void addItem(String value, String label, List<Object> children) {
		CascaderOption option = new CascaderOption();
		option.setValue(value);
		option.setLabel(label);
		option.setChildren(children);
		items.add(option);
	}
	
	@Data
	public static class CascaderOption {
		private String value;
		private String label;
		private List<Object> children;
	}

}
