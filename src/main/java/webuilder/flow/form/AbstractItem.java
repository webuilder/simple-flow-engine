package webuilder.flow.form;

import lombok.Data;
import webuilder.flow.FlowFormItem;

@Data
public abstract class AbstractItem implements FlowFormItem {

	private String name;

	private String text;

	private boolean notNull;

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

}
