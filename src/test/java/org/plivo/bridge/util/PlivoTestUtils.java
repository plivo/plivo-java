package org.plivo.bridge.util;
/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-28
 * @author Paulo reis
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public abstract class PlivoTestUtils {
	
	private static final Properties testProp = new Properties();
	private static volatile boolean initialized = false;
	
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
	
	private static String get(String name) {
		initProperties();
		
		return testProp.getProperty(name);
	}

	public static String getAccountId( ) {
		return get("accountId");
	}

	public static String getCallbackUrl( ) {
		return get("callbackUrl");
	}
	
	public static String getAuthToken( ) {
		return get("authToken");
	}
	
	private static void initProperties( ) {
		if(initialized) return;
		synchronized(PlivoTestUtils.class) {
			if(initialized) return;
			
			try {
				testProp.load(PlivoTestUtils.class.getResourceAsStream("/test.properties"));
				initialized = true;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
