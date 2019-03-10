package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RateItem extends HaveChildrenItem implements FormItem {@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.RATE;
	}

	public RateItem() {
		super();
	}
	
	public RateItem(String name, String text) {
		super(name, text);
	}
}
