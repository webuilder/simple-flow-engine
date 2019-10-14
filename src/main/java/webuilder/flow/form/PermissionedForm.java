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

	protected Form form;

	/**
	 * 只读字段
	 */
	protected List<String> readonlyFields = Collections.emptyList();

	/**
	 * 可编辑字段
	 */
	protected List<String> editableFields = Collections.emptyList();

	/**
	 * 允许编辑所有未设置的字段
	 */
	protected boolean editableUnknownFields = false;

	/**
	 * 允许查看所有未设置的字段
	 */
	protected boolean readonlyUnknownFields = false;

	public PermissionedForm(Form form) {
		super();
		this.form = form;
	}

	@Override
	public List<FormItem> getItems() {
		List<FormItem> result = new ArrayList<>();
		for (FormItem item : form.getItems()) {
			if (editableFields.contains(item.getName()) || editableUnknownFields) {
				result.add(item);
			} else if (readonlyFields.contains(item.getName()) || readonlyUnknownFields) {
				try {
					FormItem newItem = item.createReadonlyItem();
					result.add(newItem);
				} catch (CloneNotSupportedException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}

	/**
	 * 设置只读的字段
	 * 
	 * @param readonlyFields 只读的字段名称列表
	 */
	public void readonly(String... readonlyFields) {
		this.readonlyFields = Arrays.asList(readonlyFields);
	}

	/**
	 * 设置可编辑的字段
	 * 
	 * @param editableFields 可编辑的字段名称列表
	 */
	public void editable(String... editableFields) {
		this.editableFields = Arrays.asList(editableFields);
	}

	public void setEditableUnknownFields(boolean editableUnknownFields) {
		this.editableUnknownFields = editableUnknownFields;
	}

	public void setReadonlyUnknownFields(boolean readonlyUnknownFields) {
		this.readonlyUnknownFields = readonlyUnknownFields;
	}
	
}
