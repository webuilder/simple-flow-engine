package webuilder.flow;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import webuilder.flow.impl.DefaultFlowContext;
import webuilder.flow.impl.DefaultFlowDefinition;
import webuilder.flow.impl.DefaultFlowLink;
import webuilder.flow.mem.MemFlowEngine;

/**
 * 条件判断的例子
 *
 */
public class ConditionFlowTest {

	private FlowBuilder builder;

	private final String FLOW_NAME = "TEST-FLOW2";

	@Before
	public void setUp() {
		// 报销流程的例子
		// 有“项目组长审核”和“总经理审核”两个审核步骤
		// 如果报销金额小于1000，只需项目组长审核通过
		// 如果报销金额大于或等于1000，需要项目组长审核后，再经过总经理审核
		builder = new FlowBuilder() {

			@Override
			public FlowDefinition build() {
				DefaultFlowDefinition def = new DefaultFlowDefinition(FLOW_NAME);

				StartNode start = new StartNode();
				def.addNode(start);
				
				TaskNode apply = new TaskNode("a01", "申请报销", false);
				def.addNode(apply);
				
				
				TaskNode audit1 = new TaskNode("a02", "项目组长审核", false);
				def.addNode(audit1);
				
				TaskNode judge = new TaskNode("a05", "判断", true);
				def.addNode(judge);
				
				TaskNode audit2 = new TaskNode("a03", "总经理审核", false);
				def.addNode(audit2);
				
				TaskNode archive = new TaskNode("a04", "归档", true);
				def.addNode(archive);

				EndNode end = new EndNode();
				def.addNode(end);
				
				DefaultFlowLink b01 = new DefaultFlowLink("b01", "申请报销", start, apply);
				def.addLink(b01);
				
				DefaultFlowLink b02 = new DefaultFlowLink("b02", "提交项目组长审核", apply, audit1);
				def.addLink(b02);
				
				DefaultFlowLink b03 = new DefaultFlowLink("b03", "条件判断", audit1, judge);
				def.addLink(b03);
				
				DefaultFlowLink b04 = new DefaultFlowLink("b04", "提交总经理审核", judge, audit2);
				b04.setCondition(new Condition() {

					@Override
					public boolean evaluate(FlowInstance instance, FlowContext context) {
						//  报销价格大于等于1000时，条件为真
						BigDecimal price = (BigDecimal)context.getVariables().get("price");
						if (price!= null && price.compareTo(new BigDecimal(1000))>=0) {
							return true;
						}
						return false;
					}
					
				});
				def.addLink(b04);
				
				DefaultFlowLink b05 = new DefaultFlowLink("b05", "总经理审核后归档", audit2, archive);
				def.addLink(b05);
				
				DefaultFlowLink b06 = new DefaultFlowLink("b06", "项目组长审核后归档", judge, archive);
				b06.setCondition(new Condition() {

					@Override
					public boolean evaluate(FlowInstance instance, FlowContext context) {
					//  报销价格小于1000时，条件为真
						BigDecimal price = (BigDecimal)context.getVariables().get("price");
						if (price!= null && price.compareTo(new BigDecimal(1000))>=0) {
							return false;
						}
						return true;
					}
					
				});
				def.addLink(b06);
				
				FlowLink b07 = new DefaultFlowLink("b07", "结束", archive, end);
				def.addLink(b07);
				return def;
			}
		};
	}

	@Test
	public void test1() {
		// 报销金额为1500，需经过总经理审核
		FlowDefinition def = builder.build();
		MemFlowEngine engine = new MemFlowEngine(Arrays.asList(def));
		DefaultFlowContext context = new DefaultFlowContext();
		
		Map<String, Object> variable = new HashMap<>();
		variable.put("price", new BigDecimal("1500.00"));
		context.setVariables(variable);
		
		FlowInstance instance = engine.startFlow(FLOW_NAME, context);
		
		List<FlowLink> validLinks = engine.getValidLinks(instance, context);
		assertEquals(1, validLinks.size());
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());

		engine.run(instance, context, "b02"); // 提交项目组长审核
		
		validLinks = engine.getValidLinks(instance, context);
		assertEquals(1, validLinks.size());
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		
		System.out.println("当前节点 --> " + instance.getCurrentNode());
		
		engine.run(instance, context, "b03"); // 提交判断
		
		validLinks = engine.getValidLinks(instance, context);
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());
		
		engine.run(instance, context, "b05"); // 提交总经理审核
		
		validLinks = engine.getValidLinks(instance, context);
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());
	}
	
	
	@Test
	public void test2() {
		// 报销金额为300，不要总经理审核
		FlowDefinition def = builder.build();
		MemFlowEngine engine = new MemFlowEngine(Arrays.asList(def));
		DefaultFlowContext context = new DefaultFlowContext();
		
		Map<String, Object> variable = new HashMap<>();
		variable.put("price", new BigDecimal("300.00"));
		context.setVariables(variable);
		
		FlowInstance instance = engine.startFlow(FLOW_NAME, context);
		
		List<FlowLink> validLinks = engine.getValidLinks(instance, context);
		assertEquals(1, validLinks.size());
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());

		engine.run(instance, context, "b02"); // 提交项目组长审核
		
		validLinks = engine.getValidLinks(instance, context);
		assertEquals(1, validLinks.size());
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		
		System.out.println("当前节点 --> " + instance.getCurrentNode());
		
		engine.run(instance, context, "b03"); // 提交判断
		
		validLinks = engine.getValidLinks(instance, context);
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());
		
		engine.run(instance, context, "b05"); // 提交总经理审核
		
		validLinks = engine.getValidLinks(instance, context);
		System.out.println("Links : " + validLinks.stream().map(FlowLink::getLinkId).collect(Collectors.toList()));
		System.out.println("当前节点 --> " + instance.getCurrentNode());
	}
}
