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
public abstract class HaveChildrenItem<T> extends AbstractItem implements FormItem {

	protected List<T> items = new ArrayList<>();

	protected ItemProvider<T> provider;

	public HaveChildrenItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HaveChildrenItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	public List<T> getItems() {
		if (provider != null) {
			return provider.getItems();
		} else {
			return items;
		}
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void setProvider(ItemProvider<T> provider) {
		this.provider = provider;
	}

	@Data
	public static class Option<T> {
		private T value;
		private String label;
	}


	public static interface ItemProvider<T> {
		List<T> getItems();
	}
}
