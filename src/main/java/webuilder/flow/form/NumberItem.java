package webuilder.flow.form;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import webuilder.flow.FormItem;

/**
 * 文本框，仅能输入数字
 * 
 * @author lijian
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NumberItem extends AbstractItem implements FormItem {

	private String placeholder;

	private BigDecimal min;

	private BigDecimal max;

	private BigDecimal step;

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "number";
	}

	public NumberItem() {
		super();
	}

	public NumberItem(String name, String text) {
		super(name, text);
	}

	public NumberItem(String name, String text, BigDecimal min, BigDecimal max, BigDecimal step) {
		super(name, text);
		this.min = min;
		this.max = max;
		this.step = step;
	}

}
