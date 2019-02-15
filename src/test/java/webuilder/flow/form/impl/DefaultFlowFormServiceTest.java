package webuilder.flow.form.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import webuilder.flow.FlowForm;
import webuilder.flow.impl.DefaultFlowFormService;

public class DefaultFlowFormServiceTest {

	@Test
	public void test1() {
		DefaultFlowFormService service = new DefaultFlowFormService();
		service.register(new FooEntityRegister());
		FlowForm form = service.getFlowForm("FOO-FLOW");
		assertNotNull(form);

		System.out.println(form.toString());
	}
}
