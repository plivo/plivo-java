package org.plivo.bridge.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class PlivoTestUtils {
	
	public static Map<String, String> mapToSingleValue(Map<String, String[]> seed) {
		Map<String, String> result = new HashMap<String, String>();
		Iterator<String> iterator = seed.keySet().iterator();
		String key = null;
		String[] value = null;
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext()) {
			key = iterator.next();
			value = seed.get(key);
			if(null == value) continue;
			if(1 == value.length) result.put(key, value[0]);
			else {
				for(String v: value) {
					if(sb.length() > 0) sb.append(",");
					sb.append(v);
				}
				result.put(key, value[0]);
			}
		}
		
		return result;
	}

}
