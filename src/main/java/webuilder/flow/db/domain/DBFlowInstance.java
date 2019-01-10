package webuilder.flow.db.domain;

import java.time.Instant;

import lombok.Data;
import webuilder.flow.FlowInstance;

@Data
public class DBFlowInstance implements FlowInstance {
	/**
	 * 流程名称
	 */
	private String flowName;

	/**
	 * 流程实例ID
	 */
	private Long instanceId;

	/**
	 * 当前节点
	 */
	private String currentNode;

	private String currentNodeName;

	/**
	 * 当前的步数
	 */
	private int step;

	/**
	 * 最后更新时间
	 */
	private Instant updateTime;
}
