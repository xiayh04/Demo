package org.ihsp.data.component.impl;

import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;

public class MyContextLoaderListener extends ContextLoaderListener {
    Log log = LogFactory.getLog(MyContextLoaderListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        log.info("contextInitialized, start to init Data");
        initData();
    }

    private void initData() {
        log.info("do some thing after context loaded :) ");
    }

}
