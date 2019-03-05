package webuilder.flow.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

/**
 * 带有子元素的表单项
 * 
 * @author lijian
 *
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class HaveChildrenItem extends AbstractItem implements FormItem {

	protected List<Option> items = new ArrayList<>();

	protected ItemProvider provider;

	public HaveChildrenItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HaveChildrenItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	public void addItem(String value, String text) {
		Option option = new Option();
		option.setValue(value);
		option.setText(text);
		items.add(option);
	}

	public List<Option> getItems() {
		if (provider != null) {
			return provider.getItems();
		} else {
			return items;
		}
	}

	public void setItems(List<Option> items) {
		this.items = items;
	}

	public void setProvider(ItemProvider provider) {
		this.provider = provider;
	}

	@Data
	public static class Option {
		private String value;
		private String text;
	}

	public static interface ItemProvider {
		List<Option> getItems();
	}
}
