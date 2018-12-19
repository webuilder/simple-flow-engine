package webuilder.flow.db;

import java.time.Instant;
import java.util.Collection;

import webuilder.flow.EndNode;
import webuilder.flow.FlowContext;
import webuilder.flow.FlowDefException;
import webuilder.flow.FlowDefinition;
import webuilder.flow.FlowEngine;
import webuilder.flow.FlowInstance;
import webuilder.flow.FlowLink;
import webuilder.flow.FlowNode;
import webuilder.flow.FlowRuntimeException;
import webuilder.flow.FlowUser;
import webuilder.flow.db.bridge.DBFlowHistoryService;
import webuilder.flow.db.bridge.DBFlowInstanceService;
import webuilder.flow.db.domain.DBFlowHistory;
import webuilder.flow.db.domain.DBFlowInstance;
import webuilder.flow.impl.AbstractFlowEngine;
import webuilder.flow.utils.FlowUtils;

public class DBFlowEngine extends AbstractFlowEngine implements FlowEngine {

	private final DBFlowInstanceService instanceService;

	private final DBFlowHistoryService historyService;

	public DBFlowEngine(Collection<FlowDefinition> flows, DBFlowInstanceService instanceService,
			DBFlowHistoryService historyService) {
		super(flows);
		this.instanceService = instanceService;
		this.historyService = historyService;
	}

	@Override
	public FlowInstance startFlow(String flowName, FlowContext context) {
		DBFlowInstance instance = new DBFlowInstance();
		instance.setFlowName(flowName);

		FlowDefinition flow = flows.get(instance.getFlowName());
		String startNode = flow.getStartNode();
		if (FlowUtils.isEmptyString(startNode)) {
			throw new FlowDefException("Flow[" + flowName + "] have not startNode.");
		}

		FlowNode node = flow.getNodes().get(startNode);
		instance.setCurrentNode(startNode);
		instance.setCurrentNodeName(node.getNodeName());

		instance.setOperator(context.getUser().getUserId());
		instance.setOperatorName(context.getUser().getName());
		instance.setStep(1);
		instance.setUpdateTime(Instant.now());

		instanceService.create(instance);

		saveHistory(instance);

		runStartNode(instance, context);
		return instance;
	}

	@Override
	public FlowInstance getInstance(Long instanceId) {
		DBFlowInstance instance = instanceService.get(instanceId);
		return instance;
	}

	@Override
	protected void saveInstance(FlowNode node, String linkId, FlowInstance instance, FlowContext context) {
		String flowName = instance.getFlowName();
		FlowDefinition flow = this.getFlowDefinition(flowName);
		FlowLink link = flow.getLink(linkId);
		final String nextNodeId = link.getToNode();

		FlowNode nextNode = flow.getNodes().get(nextNodeId);

		DBFlowInstance dbInstance = (DBFlowInstance) instance;
		dbInstance.setCurrentNode(nextNodeId);
		dbInstance.setCurrentNodeName(nextNode.getNodeName());
		if (nextNode instanceof EndNode) {
			dbInstance.setOperator("");
			dbInstance.setOperatorName("");
		} else {
			FlowUser nextUser = context.getNextUser();
			if (nextUser == null) {
				throw new FlowRuntimeException("下一节点经办人设置错误");
			}
			dbInstance.setOperator(nextUser.getUserId());
			dbInstance.setOperatorName(nextUser.getName());
		}
		instanceService.update(dbInstance);
		dbInstance = instanceService.get(instance.getInstanceId());

		saveHistory(dbInstance);
	}

	private void saveHistory(DBFlowInstance dbInstance) {
		historyService.historyDone(dbInstance.getInstanceId());

		DBFlowHistory his = new DBFlowHistory();
		his.setInstanceId(dbInstance.getInstanceId());
		his.setFlowName(dbInstance.getFlowName());
		his.setNodeId(dbInstance.getCurrentNode());
		his.setNodeName(dbInstance.getCurrentNodeName());
		his.setOperatorId(dbInstance.getOperator());
		his.setOperatorName(dbInstance.getOperatorName());
		his.setStep(dbInstance.getStep());
		his.setUpdateTime(Instant.now());
		historyService.create(his);
	}

}
