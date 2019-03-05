package webuilder.flow.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import webuilder.flow.Form;
import webuilder.flow.FormItem;

/**
 * 受权限控制的表单
 * 
 * @author lijian
 *
 */
public class PermissionedForm implements Form {

	private Form form;

	/**
	 * 只读字段
	 */
	private List<String> readonlyFields = Collections.emptyList();

	/**
	 * 可编辑字段
	 */
	private List<String> editableFields = Collections.emptyList();

	public PermissionedForm(Form form) {
		super();
		this.form = form;
	}

	@Override
	public List<FormItem> getItems() {
		List<FormItem> result = new ArrayList<>();
		for (FormItem item : form.getItems()) {
			if (editableFields.contains(item.getName())) {
				result.add(item);
			} else if (readonlyFields.contains(item.getName())) {
				result.add(new ReadonlyItem(item.getName(), item.getText()));
			}
		}
		return result;
	}

	/**
	 * 设置只读的字段
	 * 
	 * @param readonlyFields
	 */
	public void readonly(String... readonlyFields) {
		this.readonlyFields = Arrays.asList(readonlyFields);
	}

	/**
	 * 设置可编辑的字段
	 * 
	 * @param editableFields
	 */
	public void editable(String... editableFields) {
		this.editableFields = Arrays.asList(editableFields);
	}
}
