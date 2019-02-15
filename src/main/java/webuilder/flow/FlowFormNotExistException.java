package webuilder.flow;

/**
 * 流程表单未定义
 * 
 * @author lijian
 *
 */
public class FlowFormNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6752566048233171663L;

	public FlowFormNotExistException(String flowName) {
		super("FlowForm not exist, by flowName[" + flowName + "]");
	}

}
