package webuilder.flow.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SelectItem extends HaveChildrenItem implements FormItem {

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return FormItemType.SELECT;
	}

	public SelectItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

}
