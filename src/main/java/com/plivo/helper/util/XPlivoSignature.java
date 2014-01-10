package com.plivo.helper.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.plivo.helper.exception.PlivoException;

public class XPlivoSignature {
	public static Boolean verify(String uri, Map<String, String> parameters,
			String xsignature, String authToken) throws PlivoException {
		Boolean isMatch = false;
		Map<String, String> sortedParams = new TreeMap<String, String>(
				parameters);
		for (Entry<String, String> pair : sortedParams.entrySet()) {
			uri += pair.getKey() + pair.getValue();
		}

		try {
			byte[] keyBytes = authToken.getBytes();
			byte[] textBytes = uri.getBytes();
			Mac hmac = Mac.getInstance("HmacSHA1");
			SecretKeySpec macKey = new SecretKeySpec(keyBytes, "HmacSHA1");
			hmac.init(macKey);
			byte[] signBytes = hmac.doFinal(textBytes);
			String signature = new String(Base64.encodeBase64(signBytes));
			if (signature.equals(xsignature))
				isMatch = true;
		} catch (Exception e) {
			throw new PlivoException(e.getLocalizedMessage());
		}

		return isMatch;
	}
}
