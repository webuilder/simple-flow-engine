package webuilder.flow.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FlowFormItem;

/**
 * 日期选择框
 * 
 * @author lijian
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DateItem extends AbstractItem implements FlowFormItem {

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "date";
	}

	public DateItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateItem(String name, String text) {
		super(name, text);
		// TODO Auto-generated constructor stub
	}

}
