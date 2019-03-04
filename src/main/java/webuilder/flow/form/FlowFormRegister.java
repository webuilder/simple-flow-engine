package webuilder.flow.form;

import java.util.Map;

import webuilder.flow.Form;

/**
 * 向系统注册流程表单
 * 
 * @author lijian
 *
 * @param <T>
 *            实体类的类型
 */
public interface FlowFormRegister<T> {

	String getFlowName();

	Form getForm();

	Map<String, String> loadValue(T entity);

	T saveValue(Map<String, String> dto);
}
