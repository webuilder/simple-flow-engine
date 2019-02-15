package webuilder.flow.utils;

import java.util.Collections;
import java.util.List;

import webuilder.flow.FlowForm;
import webuilder.flow.FlowFormItem;
import webuilder.flow.FlowRuntimeException;

public abstract class FlowUtils {

	public static boolean isEmptyString(String s) {
		return s == null || "".equals(s);
	}

	public static final FlowForm EMPTY_FORM = new EmptyFlowForm();

	private static final class EmptyFlowForm implements FlowForm {

		@Override
		public String getFlowName() {
			throw new FlowRuntimeException("Not allow access flowName");
		}

		@Override
		public List<FlowFormItem> getItems() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
	}
}
