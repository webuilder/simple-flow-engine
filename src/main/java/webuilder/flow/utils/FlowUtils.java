package webuilder.flow.utils;

import java.util.Collections;
import java.util.List;

import webuilder.flow.Form;
import webuilder.flow.FlowFormItem;
import webuilder.flow.FlowRuntimeException;

public abstract class FlowUtils {

	public static boolean isEmptyString(String s) {
		return s == null || "".equals(s);
	}

	public static final Form EMPTY_FORM = new EmptyFlowForm();

	private static final class EmptyFlowForm implements Form {

		@Override
		public List<FlowFormItem> getItems() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
	}
}
