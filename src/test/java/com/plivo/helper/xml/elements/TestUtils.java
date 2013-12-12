package com.plivo.helper.xml.elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestUtils {
	public static String inStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		}catch (IOException ie) {
			return null;
		}
		return sb.toString();
	}

}
