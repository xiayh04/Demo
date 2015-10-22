package org.ihsp.data.common;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyObjectId {
	static Log log = LogFactory.getLog("MyObjectId");
	private static AtomicInteger inc = new AtomicInteger(0);
	private final static String SERVER_ID_PROPERTY = "server_id";
	private static Integer serverId = null;

	public static long generateId(int serverId) {
		long time = Calendar.getInstance().getTimeInMillis();
		int current = inc.incrementAndGet();
		if (current == 4095) {
			inc.set(0);
		}
		long id = time << 21 | serverId << 12 | current;
		log.debug("-------------id:" + id + " ,time:" + time + " ,serverId:" + serverId + " ,inc:" + current);
		return id;
	}

	public static long generateId(long time, int serverId, int inc) {
		long id = time << 21 | serverId << 12 | inc;
		// log.info("-------------id:" + id + " ,time:" + time + " ,serverId:" +
		// serverId + " ,inc:" + inc);
		return id;
	}

	public static long generateId() {
		serverId = getServerId();
		long id = generateId(serverId);
		return id;
	}

	public static Calendar getTime(long id) {
		Calendar c = Calendar.getInstance();
		long time = id >> 21;

		c.setTimeInMillis(time);
		return c;
	}

	private static Integer getServerId() {
		if (serverId == null) {
			serverId = Integer.valueOf(System.getProperty(SERVER_ID_PROPERTY));
		}

		return serverId;
	}

	public static long getServer(long id) {
		return (id & 4194303) >> 12;
	}

	public static long getInc(long id) {
		return (id & 4095);
	}
}
