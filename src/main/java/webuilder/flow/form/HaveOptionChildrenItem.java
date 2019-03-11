package webuilder.flow.form;

/**
 * 子元素类型为Option的表单项
 * @author lijian
 *
 */
public abstract class HaveOptionChildrenItem extends HaveChildrenItem<Object> {

	public HaveOptionChildrenItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HaveOptionChildrenItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	public <T> void addItem(T value, String label) {
		Option<T> option = new Option<T>();
		option.setValue(value);
		option.setLabel(label);
		items.add(option);
	}
}
