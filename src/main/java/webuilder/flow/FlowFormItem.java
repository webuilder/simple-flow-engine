package webuilder.flow;

/**
 * 流程表单项
 * 
 * @author lijian
 *
 */
public interface FlowFormItem {
	/** 字段名 */
	String getName();

	/** 提示文字 */
	String getText();

	/** 表单项的类型 */
	String getType();
}
