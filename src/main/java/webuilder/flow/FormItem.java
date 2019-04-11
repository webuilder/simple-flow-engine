package webuilder.flow;

/**
 * 表单项
 * 
 * @author lijian
 *
 */
public interface FormItem extends Cloneable {
	/** 字段名 */
	String getName();

	/** 提示文字 */
	String getText();

	/** 表单项的类型 */
	String getType();
	
	/** 自定义的标志位，可以为null */
	Object getFlag();

	/** 此字段是否只读 */
	boolean isReadonly();

	FormItem clone() throws CloneNotSupportedException;

	/**
	 * 为当前的表单项创建一个带有只读属性的副本
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 */
	FormItem createReadonlyItem() throws CloneNotSupportedException;
}
