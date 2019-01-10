package webuilder.flow.db.bridge;

import java.util.List;

import webuilder.flow.FlowContext;
import webuilder.flow.db.domain.DBFlowHistory;

public interface DBFlowHistoryService {
	/**
	 * 记录流程的历史步骤
	 * 
	 * @param history
	 */
	void create(DBFlowHistory history);

	/**
	 * 获取一条历史步骤
	 * 
	 * @param flowHistoryId
	 * @return
	 */
	DBFlowHistory get(Long flowHistoryId);

	/**
	 * 查找单个流程实例的单个节点的历史步骤
	 * 
	 * @param instanceId
	 * @param nodeId
	 * @return
	 */
	List<DBFlowHistory> findByNode(Long instanceId, String nodeId);

	/**
	 * 将当前流程的历史步骤标记为已完成
	 * 
	 * @param instanceId
	 * @param context TODO
	 */
	void historyDone(Long instanceId, FlowContext context);

	/**
	 * 查询指定流程实例的历史步骤
	 * 
	 * @param instanceId
	 * @return
	 */
	List<DBFlowHistory> findByInstance(Long instanceId);
}
