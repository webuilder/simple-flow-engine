package webuilder.flow.db.domain;

import java.time.Instant;

import lombok.Data;

@Data
public class DBFlowHistory {
	private Long id;
	private Long instanceId;
	private int step;
	private String flowName;
	/**
	 * 流程节点ID
	 */
	private String nodeId;
	/** 流程节点名称 */
	private String nodeName;
	/** 经办人ID */
	private String operatorId;
	/** 经办人姓名 */
	private String operatorName;
	private Instant updateTime;
	private String datas;
	/** 当前步骤是否为在办 */
	private boolean active;
}
