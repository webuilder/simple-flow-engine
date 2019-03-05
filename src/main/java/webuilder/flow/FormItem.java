package webuilder.flow;

/**
 * 表单项
 * 
 * @author lijian
 *
 */
public interface FormItem {
	/** 字段名 */
	String getName();

	/** 提示文字 */
	String getText();

	/** 表单项的类型 */
	String getType();
}
