package org.ihsp.data.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private final Log log = LogFactory.getLog(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("current data source:" + DataSourceSwitcher.getDataSource());
        return DataSourceSwitcher.getDataSource();
    }
}
