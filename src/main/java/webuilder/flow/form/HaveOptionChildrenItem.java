package webuilder.flow.form;

import webuilder.flow.form.HaveChildrenItem.Option;

/**
 * 子元素类型为Option的表单项
 * @author lijian
 *
 */
public abstract class HaveOptionChildrenItem extends HaveChildrenItem<Option> {

	public HaveOptionChildrenItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HaveOptionChildrenItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	public void addItem(String value, String label) {
		Option option = new Option();
		option.setValue(value);
		option.setLabel(label);
		items.add(option);
	}
}
