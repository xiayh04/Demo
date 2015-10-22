package org.ihsp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

@Entity
@Table(name = "DEVICE_DATA")
public class DeviceData extends CommonEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "data", unique = false, nullable = false)
	private String data;

	@Column(name = "mac", nullable = false, unique = false)
	private Long mac;

	/*
	 * 数据所属的应用类型编号
	 */
	@Column(name = "application_id", nullable = false, unique = false, length = 8)
	private int applicationId;

	public DeviceData() {
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMac() {
		return WordUtils.capitalize(Long.toHexString(mac));
	}

	public void setMac(String mac) {
		this.mac = Long.parseLong(mac, 16);
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

}
