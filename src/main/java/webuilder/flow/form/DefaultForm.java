package webuilder.flow.form;

import java.util.List;

import lombok.Data;
import webuilder.flow.Form;
import webuilder.flow.FormItem;

@Data
public class DefaultForm implements Form {

	private List<FormItem> items;
}
