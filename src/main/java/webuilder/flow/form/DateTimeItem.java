package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

/**
 * 日期与时间选择框
 * 
 * @author lijian
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DateTimeItem extends AbstractItem implements FormItem {

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "datetime";
	}

	public DateTimeItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

}
