package org.ihsp.data.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.ihsp.data.common.UnitTestBase;
import org.ihsp.data.dao.base.support.Page;
import org.ihsp.data.entity.DeviceData;
import org.ihsp.data.service.DeviceDataService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeviceDataServiceImplTest extends UnitTestBase {
	DeviceData deviceData;
	List<DeviceData> list = null;
	@Autowired
	DeviceDataService deviceDataService;

	@Before
	public void beforeClass() {
		deviceData = new DeviceData();
		deviceData.setApplicationId(applicationId);
		deviceData.setCreateTime(new Date());
		deviceData.setData("device data for test");
		deviceData.setMac(mac);

		list = new ArrayList<DeviceData>();
		list.add(deviceData);

	}

	@Test
	public void testSaveDeviceData() {
		deviceDataService.save(deviceData);
	}

	@Test
	public void testSaveDeviceDatas() {
		list.add(deviceData);
		deviceDataService.saves(list);
	}

	@Test
	public void testGetDeviceDatas() {
		Page<DeviceData> datas = deviceDataService.getDatas(page, start, limit, applicationId, macs, null, null);
		Assert.assertTrue(datas.getData().size() > 0);
	}

}
