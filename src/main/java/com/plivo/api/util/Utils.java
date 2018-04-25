package com.plivo.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;

public class Utils {

  public static boolean allNotNull(Object... objects) {
    return Stream.of(objects)
      .noneMatch(Objects::isNull);
  }

  public static boolean isSubaccountIdValid(String id) {
    return id != null && id.startsWith("SA") && id.length() == 20;
  }

  public static boolean isAccountIdValid(String id) {
    return id != null && id.startsWith("MA") && id.length() == 20;
  }

  public static boolean anyNotNull(Object... objects) {
    return Stream.of(objects)
      .anyMatch(Objects::nonNull);
  }

  public static Map<String, Object> objectToMap(ObjectMapper objectMapper, Object object) {
    Map<String, Object> origMap = objectMapper.convertValue(object, Map.class);
    Map<String, Object> map = new LinkedHashMap<>();
    for (Entry<String, Object> entry : origMap.entrySet()) {
      if (entry.getValue() != null) {
        if (entry.getValue() instanceof Map) {
          Map<String, Object> innerEntries = objectMapper.convertValue(entry.getValue(), Map.class);
          for (Entry<String, Object> innerEntry : innerEntries.entrySet()) {
            map.put(entry.getKey() + innerEntry.getKey(), innerEntry.getValue());
          }
        } else {
          map.put(entry.getKey(), entry.getValue());
        }
      }
    }
    return map;
  }

  private final static String SIGNATURE_ALGORITHM = "HmacSHA256";

  public static String computeSignature(String url, String nonce, String authToken)
    throws NoSuchAlgorithmException, InvalidKeyException, MalformedURLException, UnsupportedEncodingException {
    if (!allNotNull(url, nonce, authToken)) {
      throw new IllegalArgumentException("url, nonce and authToken must be non-null");
    }

    URL parsedURL = new URL(url);
    String baseUrl = parsedURL.getProtocol() + "://" + parsedURL.getHost();
    if (parsedURL.getPort() != -1) {
      baseUrl += ":" + Integer.toString(parsedURL.getPort());
    }
    baseUrl += parsedURL.getPath();
    String payload = baseUrl + nonce;
    SecretKeySpec signingKey = new SecretKeySpec(authToken.getBytes("UTF-8"), SIGNATURE_ALGORITHM);
    Mac mac = Mac.getInstance(SIGNATURE_ALGORITHM);
    mac.init(signingKey);
    return new String(Base64.getEncoder().encode(mac.doFinal(payload.getBytes("UTF-8"))));
  }

  public static boolean validateSignature(String url, String nonce, String signature, String authToken)
    throws NoSuchAlgorithmException, InvalidKeyException, MalformedURLException, UnsupportedEncodingException {
    return computeSignature(url, nonce, authToken).equals(signature);
  }
}
