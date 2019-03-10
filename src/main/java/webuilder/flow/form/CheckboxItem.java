package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CheckboxItem extends HaveOptionChildrenItem implements FormItem {

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.CHECKBOX;
	}

	public CheckboxItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckboxItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

}
