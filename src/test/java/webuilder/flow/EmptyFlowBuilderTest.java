package webuilder.flow;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import webuilder.flow.impl.DefaultFlowContext;
import webuilder.flow.impl.DefaultFlowDefinition;
import webuilder.flow.impl.DefaultFlowLink;
import webuilder.flow.mem.MemFlowEngine;

public class EmptyFlowBuilderTest {

	private FlowBuilder builder;

	private final String FLOW_NAME = "TEST-FLOW";

	@Before
	public void setUp() {
		builder = new FlowBuilder() {

			@Override
			public FlowDefinition build() {
				DefaultFlowDefinition def = new DefaultFlowDefinition(FLOW_NAME);

				StartNode start = new StartNode();
				start.addFunction(new NodeFunction() {

					@Override
					public void run(FlowInstance flowInstance, FlowContext context) {
						System.out.println("Exec Start Node");
					}
				});
				def.addNode(start);

				EndNode end = new EndNode();
				end.addFunction(new NodeFunction() {

					@Override
					public void run(FlowInstance flowInstance, FlowContext context) {
						System.out.println("Exec End Node");
					}
				});
				def.addNode(end);

				DefaultFlowLink b01 = new DefaultFlowLink("b01", "申请休假", start, end);
				def.addLink(b01);

				def.addNodeListener(new NodeListener() {

					@Override
					public void onNodeBegin(FlowNode node, FlowInstance instance, FlowContext context) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onNodeEnd(FlowNode node, FlowInstance instance, FlowContext context) {

					}

				});
				return def;
			}
		};
	}

	@Test
	public void test1() {
		FlowDefinition def = builder.build();
		MemFlowEngine engine = new MemFlowEngine(Arrays.asList(def));

		DefaultFlowContext context = new DefaultFlowContext();
		FlowInstance instance = engine.startFlow(FLOW_NAME, context);

		System.out.println("[" + instance.getFlowName() + "] 当前节点 -> " + instance.getCurrentNode());

	}
}
