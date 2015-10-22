package org.ihsp.data.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class YhxiaCacheEventListener implements CacheEventListener {
	Log log = LogFactory.getLog(YhxiaCacheEventListener.class);
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementEvicted(Ehcache paramEhcache, Element paramElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementExpired(Ehcache paramEhcache, Element paramElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementPut(Ehcache paramEhcache, Element paramElement)
			throws CacheException {
		paramEhcache.flush();
		log.debug("notify ElementPut method invoked");
	}

	@Override
	public void notifyElementRemoved(Ehcache paramEhcache, Element paramElement)
			throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementUpdated(Ehcache paramEhcache, Element paramElement)
			throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyRemoveAll(Ehcache paramEhcache) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
