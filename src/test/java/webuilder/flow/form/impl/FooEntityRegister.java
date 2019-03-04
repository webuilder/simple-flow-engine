package webuilder.flow.form.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import webuilder.flow.Form;
import webuilder.flow.FlowFormItem;
import webuilder.flow.form.DefaultForm;
import webuilder.flow.form.FlowFormRegister;
import webuilder.flow.form.ReadonlyItem;
import webuilder.flow.form.SelectItem;
import webuilder.flow.form.TextItem;
import webuilder.flow.form.TextareaItem;

public class FooEntityRegister implements FlowFormRegister<FooEntity> {

	private Form form;

	public FooEntityRegister() {
		DefaultForm form = new DefaultForm();
		form.setFlowName("FOO-FLOW");

		List<FlowFormItem> items = new ArrayList<>();
		ReadonlyItem idItem = new ReadonlyItem("id", "ID");
		items.add(idItem);

		TextItem nameItem = new TextItem("name", "名称");
		nameItem.setMaxLength(20);
		items.add(nameItem);

		TextareaItem remarkItem = new TextareaItem("remark", "备注");
		remarkItem.setMaxLength(200);
		items.add(remarkItem);

		SelectItem statusItem = new SelectItem("status", "状态");
		statusItem.addItem("ONE", "第一阶段");
		statusItem.addItem("TWO", "第二阶段");
		statusItem.addItem("THREE", "第三阶段");
		items.add(statusItem);

		form.setItems(items);

		this.form = form;
	}

	@Override
	public String getFlowName() {
		// TODO Auto-generated method stub
		return "FOO-FLOW";
	}

	@Override
	public Form getForm() {

		return form;
	}

	@Override
	public Map<String, String> loadValue(FooEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FooEntity saveValue(Map<String, String> dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
