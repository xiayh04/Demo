package org.ihsp.data.dao;

import org.ihsp.data.dao.base.IBaseDao;
import org.ihsp.data.dao.base.support.Page;
import org.ihsp.data.entity.DeviceData;

public interface DeviceDataDao extends IBaseDao<DeviceData, Long> {

	public Page<DeviceData> getDeviceDatas(int page, int start, int limit);

	public Page<DeviceData> getDatas(int page, int start, int limit,
			Integer applicationId, String macs, Long startTime, Long endTime);

}