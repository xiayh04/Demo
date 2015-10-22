package org.ihsp.data.service;

import java.util.List;

import org.ihsp.data.dao.base.support.Page;
import org.ihsp.data.entity.DeviceData;

public interface DeviceDataService {

	public void save(DeviceData deviceData);

	public void saves(List<DeviceData> list);

	public Page<DeviceData> getDatas(int page, int start, int limit, Integer applicationId, String macs, Long startTime,
			Long endTime);

}
