package webuilder.flow.utils;

import webuilder.flow.FlowForm;

public abstract class FlowUtils {

	public static boolean isEmptyString(String s) {
		return s == null || "".equals(s);
	}

	public static final FlowForm EMPTY_FORM = new EmptyFlowForm();

	private static final class EmptyFlowForm implements FlowForm {
	}
}
