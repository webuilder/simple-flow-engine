package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 只读字段，仅用于显示
 * 
 * @author lijian
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReadonlyItem extends AbstractItem {

	public ReadonlyItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReadonlyItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "readonly";
	}

}
