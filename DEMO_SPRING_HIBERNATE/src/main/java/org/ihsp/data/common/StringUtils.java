package org.ihsp.data.common;

import java.util.HashSet;
import java.util.Set;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	public static Long[] macsToHex(String macs) {
		String[] macArrayStr = macs.split(",");
		Set<Long> macSet = new HashSet<Long>(macArrayStr.length);
		for (String mac : macArrayStr) {
			macSet.add(Long.parseLong(mac, 16));
		}
		Long[] a = new Long[macSet.size()];
		return macSet.toArray(a);
	}
}
