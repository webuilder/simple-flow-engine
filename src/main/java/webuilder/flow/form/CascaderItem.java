package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CascaderItem extends HaveChildrenItem implements FormItem {
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.CASCADER;
	}

	public CascaderItem() {
		super();
	}
	
	public CascaderItem(String name, String text) {
		super(name, text);
	}
}
