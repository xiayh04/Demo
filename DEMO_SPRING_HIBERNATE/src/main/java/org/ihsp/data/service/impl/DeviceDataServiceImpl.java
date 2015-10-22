package org.ihsp.data.service.impl;

import java.util.List;

import org.ihsp.data.dao.DeviceDataDao;
import org.ihsp.data.dao.base.support.Page;
import org.ihsp.data.entity.DeviceData;
import org.ihsp.data.service.DeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deviceDataService")
public class DeviceDataServiceImpl implements DeviceDataService {

	@Autowired
	DeviceDataDao deviceDataDao;

	@Override
	public void save(DeviceData deviceData) {
		deviceDataDao.save(deviceData);
	}

	@Override
	public void saves(List<DeviceData> list) {
		for (DeviceData data : list) {
			deviceDataDao.save(data);
		}
	}

	@Override
	public Page<DeviceData> getDatas(int page, int start, int limit, Integer applicationId, String macs,
			Long startTime, Long endTime) {
		return deviceDataDao.getDatas(page, start, limit, applicationId, macs, startTime, endTime);
	}

}
