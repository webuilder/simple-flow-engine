package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

/**
 * 文本域
 * 
 * @author lijian
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TextareaItem extends AbstractItem implements FormItem {

	private String placeholder;

	private int maxLength;

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "textarea";
	}

	public TextareaItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TextareaItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

}
