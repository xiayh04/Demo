package org.ihsp.data.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class DataSourceSwitcher {
    private static final Log log = LogFactory.getLog(DataSourceSwitcher.class);
    private static final String MASTER = "master";
    private static final String SLAVE = "slave";
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal contextHolder = new ThreadLocal();

    @SuppressWarnings("unchecked")
    public static void switchDataSource(String dataSourceGroup, boolean isMaster) {
        Assert.notNull(dataSourceGroup);

        String dataSource = generateDataSource(dataSourceGroup, isMaster);
        log.info("switchDataSource(): current threadlocal:" + contextHolder.toString() + " ,setDataSource:" + dataSource);
        contextHolder.set(dataSource);
    }

    private static String generateDataSource(String dataSourceGroup, boolean isMaster) {
        if (isMaster) return generateMasterDataSource(dataSourceGroup);
        return generateSlaveDataSource(dataSourceGroup);
    }

    private static String generateMasterDataSource(String dataSourceGroup) {
        StringBuilder dataSource = new StringBuilder(dataSourceGroup);
        dataSource.append("_").append(MASTER);

        return dataSource.toString();
    }

    private static String generateSlaveDataSource(String dataSourceGroup) {
        StringBuilder dataSource = new StringBuilder(dataSourceGroup);
        dataSource.append("_").append(SLAVE);
        // TODO 应该根据规则来生产，暂时固定使用
        dataSource.append("0000");
        return dataSource.toString();
    }

    public static String getDataSource() {
        return (String) contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
