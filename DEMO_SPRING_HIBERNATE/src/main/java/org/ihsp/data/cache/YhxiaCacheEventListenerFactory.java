package org.ihsp.data.cache;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class YhxiaCacheEventListenerFactory extends CacheEventListenerFactory 
{
    @Override
    public CacheEventListener createCacheEventListener(Properties properties)
    {
        // TODO Auto-generated method stub
        return new YhxiaCacheEventListener();
    }

}