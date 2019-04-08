package webuilder.flow;

import lombok.Data;

/**
 * 流程引擎配置信息
 * 
 * @author lijian
 *
 */
@Data
public class FlowEngineConfiguration {

	/**
	 * 是否忽略没有可用用户的FlowLink<br>
	 * 如果设为true，那么FlowEngine.getValidLinks将调用每个 FlowLink 的
	 * UserFinder，过滤掉没有可用用户的FlowLink
	 */
	private boolean ignoreNoUserLinks = false;
}
