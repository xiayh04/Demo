package org.ihsp.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.ihsp.data.common.MyObjectId;

@MappedSuperclass
public abstract class CommonEntity {
	private static final long serialVersionUID = 1L;

	@Id
	// @GenericGenerator(name = "idGenerator", strategy = "uuid")
	// @GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = true, unique = true)
	protected Long id = MyObjectId.generateId();

	@Column(name = "create_time", nullable = false, length = 7)
	protected Date createTime = new Date();

	public CommonEntity() {
	}

	public Date getCreateTime() {

		return createTime == null ? null : (Date) createTime.clone();
	}

	public void setCreateTime(final Date createTime) {
		if (createTime == null)
			this.createTime = new Date();
		else
			this.createTime = (Date) createTime.clone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null)
			this.id = MyObjectId.generateId();
		else
			this.id = id;
	}
}
