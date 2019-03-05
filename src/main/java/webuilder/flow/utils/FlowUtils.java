package webuilder.flow.utils;

import java.util.Collections;
import java.util.List;

import webuilder.flow.FormItem;
import webuilder.flow.Form;

public abstract class FlowUtils {

	public static boolean isEmptyString(String s) {
		return s == null || "".equals(s);
	}

	/**
	 * 一个空白的Form，不包含任何表单项
	 */
	public static final Form EMPTY_FORM = new EmptyForm();

	private static final class EmptyForm implements Form {

		@Override
		public List<FormItem> getItems() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
	}
}
