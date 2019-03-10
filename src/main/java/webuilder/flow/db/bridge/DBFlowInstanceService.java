package webuilder.flow.db.bridge;

import webuilder.flow.db.domain.DBFlowInstance;

public interface DBFlowInstanceService {
	/**
	 * 读取一个流程实例
	 * 
	 * @param instanceId 流程实例ID
	 * @return
	 */
	DBFlowInstance get(Long instanceId);

	/**
	 * 创建一个流程实例
	 * 
	 * @param instance
	 */
	void create(DBFlowInstance instance);

	/**
	 * 更新一个流程实例
	 * 
	 * @param instance 流程实例
	 */
	void update(DBFlowInstance instance);

	/**
	 * 删除一个流程实例
	 * 
	 * @param instanceId 即将删除的流程实例ID
	 */
	void delete(Long instanceId);
}
