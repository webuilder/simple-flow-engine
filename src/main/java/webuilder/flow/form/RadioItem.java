package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RadioItem extends HaveChildrenItem implements FormItem {

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.RADIO;
	}

	public RadioItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RadioItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}
}
