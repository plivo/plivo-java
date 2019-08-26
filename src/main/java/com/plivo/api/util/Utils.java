package com.plivo.api.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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

  private static Map<String, List<String>> getLanguageVoices() {
    Map<String, List<String>> languageVoices = new HashMap<>();
    languageVoices.put("Australian English", new ArrayList<String>(Arrays.asList("Nicole", "Russell")));
    languageVoices.put("Brazilian Portuguese", new ArrayList<String>(Arrays.asList("Vitória", "Ricardo")));
    languageVoices.put("Canadian French", new ArrayList<String>(Arrays.asList("Chantal", "Chantal")));
    languageVoices.put("Danish", new ArrayList<String>(Arrays.asList("Naja", "Mads")));
    languageVoices.put("Dutch", new ArrayList<String>(Arrays.asList("Lotte", "Ruben")));
    languageVoices.put("French", new ArrayList<String>(Arrays.asList("Léa", "Céline", "Mathieu")));
    languageVoices.put("German", new ArrayList<String>(Arrays.asList("Vicki", "Hans")));
    languageVoices.put("Hindi", new ArrayList<String>(Arrays.asList("Aditi")));
    languageVoices.put("Icelandic", new ArrayList<String>(Arrays.asList("Dóra", "Karl")));
    languageVoices.put("Indian English", new ArrayList<String>(Arrays.asList("Raveena", "Aditi")));
    languageVoices.put("Italian", new ArrayList<String>(Arrays.asList("Carla", "Giorgio")));
    languageVoices.put("Japanese", new ArrayList<String>(Arrays.asList("Mizuki", "Takumi")));
    languageVoices.put("Korean", new ArrayList<String>(Arrays.asList("Seoyeon")));
    languageVoices.put("Mandarin Chinese", new ArrayList<String>(Arrays.asList("Zhiyu")));
    languageVoices.put("Norwegian", new ArrayList<String>(Arrays.asList("Liv")));
    languageVoices.put("Polish", new ArrayList<String>(Arrays.asList("Ewa", "Maja", "Jacek", "Jan")));
    languageVoices.put("Portuguese-Iberic", new ArrayList<String>(Arrays.asList("Inês", "Cristiano")));
    languageVoices.put("Romanian", new ArrayList<String>(Arrays.asList("Carmen")));
    languageVoices.put("Russian", new ArrayList<String>(Arrays.asList("Tatyana", "Maxim")));
    languageVoices.put("Spanish-Castilian", new ArrayList<String>(Arrays.asList("Conchita", "Enrique")));
    languageVoices.put("Swedish", new ArrayList<String>(Arrays.asList("Astrid")));
    languageVoices.put("Turkish", new ArrayList<String>(Arrays.asList("Filiz")));
    languageVoices.put("UK English", new ArrayList<String>(Arrays.asList("Amy", "Emma", "Brian")));
    languageVoices.put("US English", new ArrayList<String>(Arrays.asList("Joanna", "Salli", "Kendra", "Kimberly", "Ivy", "Matthew", "Justin", "Joey")));
    languageVoices.put("US Spanish", new ArrayList<String>(Arrays.asList("Penélope","Miguel")));
    languageVoices.put("Welsh", new ArrayList<String>(Arrays.asList("Gwyneth")));
    languageVoices.put("Welsh English", new ArrayList<String>(Arrays.asList("Geraint")));

    return languageVoices;
  }

  public static void validateLanguageVoice(String language, String voice) throws PlivoXmlException {
    String[] voiceParts = voice.split("\\.");
    if (voiceParts.length != 2 || !voiceParts[0].equals("Polly")) {
      throw new PlivoXmlException("XML Validation Error: Invalid language. Voice " + voice + " is not valid. " +
        "Refer <link> for the list of supported voices.");
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

    if (!voiceParts[1].equals("*") && !availableLanguageVoices.contains(transformedVoiceName) ){
      throw new PlivoXmlException("XML Validation Error: <Speak> voice '" + voice +
        "' is not valid. Refer <link> for list of supported voices.");
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
