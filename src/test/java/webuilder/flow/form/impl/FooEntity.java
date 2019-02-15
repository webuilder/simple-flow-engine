package webuilder.flow.form.impl;

import java.time.Instant;

import lombok.Data;

@Data
public class FooEntity {

	private Long id;
	private String name;
	/** 备注 */
	private String remark;

	private FooEntityStatus status;

	private Instant createTime;
}
