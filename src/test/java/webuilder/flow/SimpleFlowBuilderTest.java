package webuilder.flow;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import webuilder.flow.impl.DefaultFlowContext;
import webuilder.flow.impl.DefaultFlowDefinition;
import webuilder.flow.impl.DefaultFlowLink;
import webuilder.flow.mem.MemFlowEngine;

public class SimpleFlowBuilderTest {

	private FlowBuilder builder;

	private final String FLOW_NAME = "TEST-FLOW";

	@Before
	public void setUp() {
		builder = new FlowBuilder() {

			@Override
			public FlowDefinition build() {
				DefaultFlowDefinition def = new DefaultFlowDefinition(FLOW_NAME);

				StartNode start = new StartNode();
				def.addNode(start);

				TaskNode apply = new TaskNode("a01", "申请休假", false);
				def.addNode(apply);

				TaskNode audit1 = new TaskNode("a02", "部门经理审核", false);
				audit1.addFunction(new NodeFunction() {

					@Override
					public void run(FlowInstance flowInstance, FlowContext context) {
						String option = (String) context.getVariables().get("option");
						System.out.println("部门经理意见 : " + option);
						assertEquals("基本同意，请总经理批示", option);
					}
				});
				def.addNode(audit1);

				TaskNode audit2 = new TaskNode("a03", "总经理审核", false);
				def.addNode(audit2);

				TaskNode archive = new TaskNode("a04", "归档", true);
				def.addNode(archive);

				EndNode end = new EndNode();
				def.addNode(end);

				DefaultFlowLink b01 = new DefaultFlowLink("b01", "申请休假", start, apply);
				def.addLink(b01);

				DefaultFlowLink b02 = new DefaultFlowLink("b02", "提交经理审批", apply, audit1);
				def.addLink(b02);

				FlowLink b03 = new DefaultFlowLink("b03", "提交总经理审批", audit1, audit2);
				def.addLink(b03);

				FlowLink b04 = new DefaultFlowLink("b04", "提交人事部归档", audit2, archive);
				def.addLink(b04);

				FlowLink b05 = new DefaultFlowLink("b05", "结束", archive, end);
				def.addLink(b05);

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
		// context.setUser(user);
		FlowInstance instance = engine.startFlow(FLOW_NAME, context);

		System.out.println("[" + instance.getFlowName() + "] 当前节点 -> " + instance.getCurrentNode());

		engine.run(instance, context, "b02");
		System.out.println("[" + instance.getFlowName() + "] 当前节点 -> " + instance.getCurrentNode());

		context.getVariables().put("option", "基本同意，请总经理批示");
		engine.run(instance, context, "b03");
		System.out.println("[" + instance.getFlowName() + "] 当前节点 -> " + instance.getCurrentNode());

		context.getVariables().put("option2", "同意");
		engine.run(instance, context, "b04");
		System.out.println("[" + instance.getFlowName() + "] 当前节点 -> " + instance.getCurrentNode());

	}
}
