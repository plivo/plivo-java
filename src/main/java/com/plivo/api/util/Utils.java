package com.plivo.api.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plivo.api.exceptions.PlivoXmlException;

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

  public static String generateUrl(String url, String method, Map<String, String> params) throws MalformedURLException {
    String decodedUrl = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8);
    URL parsedURL = new URL(decodedUrl);
    String paramString = "";
    List<String> keys = new ArrayList<String>(params.keySet());
    String uri = parsedURL.getProtocol() + "://" + parsedURL.getHost() + parsedURL.getPath();
    int queryParamLength = 0;
    try {
      queryParamLength = parsedURL.getQuery().length();
      if (params.size() > 0 || queryParamLength > 0) {
        uri += "?";
      }
    } catch (Exception e) {
      queryParamLength = 0;
      uri += "?";
    }
    if (queryParamLength > 0) {
      if (method == "GET") {
        Map<String, String> queryParamMap = getMapFromQueryString(parsedURL.getQuery());
        for (Entry<String, String> entry : params.entrySet()) {
          queryParamMap.put(entry.getKey(), entry.getValue());
        }
        uri += GetSortedQueryParamString(queryParamMap, true);
      } else {
        uri += GetSortedQueryParamString(getMapFromQueryString(parsedURL.getQuery()), true) + "." + GetSortedQueryParamString(params, false);
        uri = uri.replace(".$", "");
      }
    } else {
      if (method == "GET") {
        uri += GetSortedQueryParamString(params, true);
      } else {
        uri += GetSortedQueryParamString(params, false);
      }
    }
    return uri;
  }

  public static Map<String, String> getMapFromQueryString(String query) {
    Map<String, String> params = null;
    if (query.length() == 0) {
      return params;
    }
    params = Arrays.stream(query.split("&")).map(s -> s.split("=", 2)).collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
    return params;
  }

  public static String GetSortedQueryParamString(Map<String, String> params, boolean queryParams) {
    String url = "";
    List<String> keys = new ArrayList(params.keySet());
    Collections.sort(keys);
    if (queryParams) {
      for (String key : keys) {
        url += key + "=" + params.get(key) + "&";
      }
      url = url.substring(0, url.length() - 1);
    } else {
      for (String key : keys) {
        url += key + params.get(key);
      }
    }
    return url;
  }

  public static String computeSignatureV3(String url, String nonce, String authToken, String method, Map<String, String> params)
    throws NoSuchAlgorithmException, InvalidKeyException, MalformedURLException, UnsupportedEncodingException {
    if (!allNotNull(url, nonce, authToken)) {
      throw new IllegalArgumentException("url, nonce and authToken must be non-null");
    }

    URL parsedURL = new URL(url);
    String payload = generateUrl(url, method, params) + "." + nonce;
    SecretKeySpec signingKey = new SecretKeySpec(authToken.getBytes("UTF-8"), SIGNATURE_ALGORITHM);
    Mac mac = Mac.getInstance(SIGNATURE_ALGORITHM);
    mac.init(signingKey);
    return new String(Base64.getEncoder().encode(mac.doFinal(payload.getBytes("UTF-8"))));
  }

  public static boolean validateSignatureV3(String url, String nonce, String signature, String authToken, String method, Map<String, String>... params)
    throws NoSuchAlgorithmException, InvalidKeyException, MalformedURLException, UnsupportedEncodingException {
    Map<String, String> parameters = new HashMap<String, String>();
    if(params.length > 0){
      parameters = params[0];
    }
    List<String> splitSignature = Arrays.asList(signature.split(","));
    return splitSignature.contains(computeSignatureV3(url, nonce, authToken, method, parameters));
  }

  private static Map<String, List<String>> getLanguageVoices() {
    Map<String, List<String>> languageVoices = new HashMap<>();
    languageVoices.put("arb", new ArrayList<String>(Arrays.asList("Zeina")));
    languageVoices.put("cmn-CN", new ArrayList<String>(Arrays.asList("Zhiyu")));
    languageVoices.put("da-DK", new ArrayList<String>(Arrays.asList("Naja", "Mads")));
    languageVoices.put("nl-NL", new ArrayList<String>(Arrays.asList("Lotte", "Ruben")));
    languageVoices.put("en-AU", new ArrayList<String>(Arrays.asList("Nicole", "Russell")));
    languageVoices.put("en-GB", new ArrayList<String>(Arrays.asList("Amy", "Emma", "Brian")));
    languageVoices.put("en-IN", new ArrayList<String>(Arrays.asList("Raveena", "Aditi")));
    languageVoices.put("en-US", new ArrayList<String>(Arrays.asList("Joanna", "Salli", "Kendra", "Kimberly", "Ivy", "Matthew", "Justin", "Joey")));
    languageVoices.put("en-GB-WLS", new ArrayList<String>(Arrays.asList("Geraint")));
    languageVoices.put("fr-CA", new ArrayList<String>(Arrays.asList("Chantal", "Chantal")));
    languageVoices.put("fr-FR", new ArrayList<String>(Arrays.asList("Léa", "Céline", "Mathieu")));
    languageVoices.put("de-DE", new ArrayList<String>(Arrays.asList("Vicki", "Hans")));
    languageVoices.put("hi-IN", new ArrayList<String>(Arrays.asList("Aditi")));
    languageVoices.put("is-IS", new ArrayList<String>(Arrays.asList("Dóra", "Karl")));
    languageVoices.put("it-IT", new ArrayList<String>(Arrays.asList("Carla", "Giorgio")));
    languageVoices.put("ja-JP", new ArrayList<String>(Arrays.asList("Mizuki", "Takumi")));
    languageVoices.put("ko-KR", new ArrayList<String>(Arrays.asList("Seoyeon")));
    languageVoices.put("nb-NO", new ArrayList<String>(Arrays.asList("Liv")));
    languageVoices.put("pl-PL", new ArrayList<String>(Arrays.asList("Ewa", "Maja", "Jacek", "Jan")));
    languageVoices.put("pt-BR", new ArrayList<String>(Arrays.asList("Vitória", "Ricardo")));
    languageVoices.put("pt-PT", new ArrayList<String>(Arrays.asList("Inês", "Cristiano")));
    languageVoices.put("ro-RO", new ArrayList<String>(Arrays.asList("Carmen")));
    languageVoices.put("ru-RU", new ArrayList<String>(Arrays.asList("Tatyana", "Maxim")));
    languageVoices.put("es-ES", new ArrayList<String>(Arrays.asList("Conchita", "Lucia", "Enrique")));
    languageVoices.put("es-MX", new ArrayList<String>(Arrays.asList("Mia")));
    languageVoices.put("es-US", new ArrayList<String>(Arrays.asList("Penélope", "Miguel")));
    languageVoices.put("sv-SE", new ArrayList<String>(Arrays.asList("Astrid")));
    languageVoices.put("tr-TR", new ArrayList<String>(Arrays.asList("Filiz")));
    languageVoices.put("cy-GB", new ArrayList<String>(Arrays.asList("Gwyneth")));

    return languageVoices;
  }

  public static void validateLanguageVoice(String language, String voice) throws PlivoXmlException {
    String[] voiceParts = voice.split("\\.");
    System.out.println(language);
    if (voiceParts.length != 2 || !voiceParts[0].equals("Polly")) {
      throw new PlivoXmlException("XML Validation Error: Invalid language. Voice " + voice + " is not valid. " +
        "Refer <https://www.plivo.com/docs/voice/getting-started/advanced/getting-started-with-ssml/#ssml-voices> for the list of supported voices.");
    }

    Map<String, List<String>> languageVoices = getLanguageVoices();
    // Validate supported languages.
    if (languageVoices.get(language) == null || languageVoices.get(language).isEmpty()) {
      throw new PlivoXmlException("XML Validation Error: Invalid language. Language " + language + " is not supported.");
    }

    // Transform the available language voices and the voice name into a common format.
    List<String> availableLanguageVoices = languageVoices.get(language);
    for (int i = 0; i < availableLanguageVoices.size(); i++) {
      availableLanguageVoices.set(i, transformString(availableLanguageVoices.get(i)));
    }
    String transformedVoiceName = transformString(voiceParts[1]);

    if (!voiceParts[1].equals("*") && !availableLanguageVoices.contains(transformedVoiceName)) {
      throw new PlivoXmlException("XML Validation Error: <Speak> voice '" + voice +
        "' is not valid. Refer <https://www.plivo.com/docs/voice/getting-started/advanced/getting-started-with-ssml/#ssml-voices> for list of supported voices.");
    }
  }

  public static String transformString(String s) {
    String transformedString;
    // Replace all accented characters with comparable english alphabets
    transformedString = Normalizer.normalize(s.trim(), Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    transformedString = pattern.matcher(transformedString).replaceAll("");

    // To title case and replace spaces with '_'
    transformedString = (new ArrayList<>(Arrays.asList(transformedString.toLowerCase().split(" "))))
      .stream()
      .map(word -> Character.toTitleCase(word.charAt(0)) + word.substring(1))
      .collect(Collectors.joining("_"));
    return transformedString;
  }
}
