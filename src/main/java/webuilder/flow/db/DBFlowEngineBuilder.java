package webuilder.flow.db;

import java.util.Collection;
import java.util.Collections;

import webuilder.flow.FlowDefinition;
import webuilder.flow.db.bridge.DBFlowHistoryService;
import webuilder.flow.db.bridge.DBFlowInstanceService;

public class DBFlowEngineBuilder {

	private Collection<FlowDefinition> flows;

	private DBFlowInstanceService instanceService;

	private DBFlowHistoryService historyService;

	public DBFlowEngineBuilder flows(Collection<FlowDefinition> flows) {
		this.flows = Collections.unmodifiableCollection(flows);
		return this;
	}

	public DBFlowEngineBuilder instanceService(DBFlowInstanceService instanceService) {
		this.instanceService = instanceService;
		return this;
	}

	public DBFlowEngineBuilder historyService(DBFlowHistoryService historyService) {
		this.historyService = historyService;
		return this;
	}

	public DBFlowEngine build() {
		return new DBFlowEngine(flows, instanceService, historyService);
	}
}
