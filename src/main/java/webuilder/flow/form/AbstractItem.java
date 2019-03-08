package webuilder.flow.form;

import lombok.Data;
import webuilder.flow.FormItem;

@Data
public abstract class AbstractItem implements FormItem {

	private String name;

	private String text;

	private boolean notNull = false;

	private boolean isReadonly = false;

	public AbstractItem() {
		super();
	}

	/**
	 * 
	 * @param name
	 *            字段名
	 * @param text
	 *            字段中文描述
	 */
	public AbstractItem(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

	public FormItem clone() throws CloneNotSupportedException {
		return (FormItem) super.clone();
	}

	@Override
	public FormItem createReadonlyItem() throws CloneNotSupportedException {
		AbstractItem cloned = (AbstractItem) this.clone();
		cloned.setReadonly(true);
		return cloned;
	}

}
