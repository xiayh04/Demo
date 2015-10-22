package org.ihsp.data.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ihsp.data.common.StringUtils;
import org.ihsp.data.dao.DeviceDataDao;
import org.ihsp.data.dao.base.impl.BaseDao;
import org.ihsp.data.dao.base.support.Page;
import org.ihsp.data.entity.DeviceData;
import org.springframework.stereotype.Repository;

@Repository("deviceDataDao")
public class DeviceDataDaoImpl extends BaseDao<DeviceData, Long> implements
		DeviceDataDao {

	@Override
	public Page<DeviceData> getDeviceDatas(int page, int start, int limit) {
		Page<DeviceData> pageObj = super.pagedQuery(page, limit, "createTime",
				false);
		return pageObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<DeviceData> getDatas(int page, int start, int limit,
			Integer applicationId, String macs, Long startTime, Long endTime) {
		Criteria criteria = super.createCriteria().addOrder(
				Order.desc("createTime"));
		Criterion criterion;
		if (startTime != null) {

			criterion = Restrictions.ge("createTime", new Date(startTime));
			criteria.add(criterion);
		}
		if (endTime != null) {
			criterion = Restrictions.le("createTime", new Date(endTime));
			criteria.add(criterion);
		}

		if (applicationId != null) {
			criterion = Restrictions.eq("applicationId", applicationId);
			criteria.add(criterion);
		}
		if (!StringUtils.isEmpty(macs)) {
			Long[] macsArray = StringUtils.macsToHex(macs);
			criterion = Restrictions.in("mac", macsArray);
			criteria.add(criterion);
		}

		Page<DeviceData> pageObj = super.pagedQuery(criteria, page, limit);
		return pageObj;
	}
}
