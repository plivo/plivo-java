package com.plivo.api;

import com.plivo.api.util.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ScopedSignatureV3Test {
  private static final String TOKEN_1 = "PLV" + "obLD1OX2BxgpOktcbX6PkBEiM0RVZneImaq7zN3u_wA";
  private static final String TOKEN_2 = "PLV" + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
  private static final String AUTH_TOKEN = "test-auth-token";
  private static final String NONCE = "01456268273535255990";
  private static final String POST_URL = "https://acme.example.com/sms/status";
  private static final String POST_SIG = "Kxo1ZuQEWE578HnfEhiJvLjXNzZXYPvkZDKNq9s4kvk=";
  private static final String GET_URL = "https://acme.example.com/answer?From=14155550100&CallUUID=abc";
  private static final String GET_SIG = "nr+QWHZTVoEP0rWEEWMeWjgKRzfOOuBhJvJqQQ8ZC2s=";

  private static Map<String, String> postParams(String status) {
    Map<String, String> p = new HashMap<>();
    p.put("MessageUUID", "6f1c2a90-0d7e-4b1e-9c11-1d2e3f4a5b6c");
    p.put("Status", status);
    p.put("To", "14155550100");
    return p;
  }

  private static String hex(byte[] b) {
    StringBuilder sb = new StringBuilder();
    for (byte x : b) {
      sb.append(String.format("%02x", x));
    }
    return sb.toString();
  }

  @Test
  public void deriveSigningKeyMatchesVectors() throws Exception {
    assertEquals("e55b316ef14f5830de74d2cc2ae794b87c6c349f577d2fabd648884afba6c7ca", hex(Utils.deriveSigningKey(TOKEN_1)));
    assertEquals("c89d8ad56ac99e1a8def8cecce07ffb55332fe813673be81df8b1297d1206368", hex(Utils.deriveSigningKey(TOKEN_2)));
  }

  @Test
  public void validatesPostAndGet() throws Exception {
    assertTrue(Utils.validateSignatureV3Scoped(POST_URL, NONCE, POST_SIG, TOKEN_1, "POST", postParams("delivered")));
    assertTrue(Utils.validateSignatureV3Scoped(GET_URL, NONCE, GET_SIG, TOKEN_1, "GET"));
  }

  @Test
  public void rejectsWrongTokenOrTamperedParams() throws Exception {
    assertFalse(Utils.validateSignatureV3Scoped(POST_URL, NONCE, POST_SIG, TOKEN_2, "POST", postParams("delivered")));
    assertFalse(Utils.validateSignatureV3Scoped(POST_URL, NONCE, POST_SIG, TOKEN_1, "POST", postParams("failed")));
  }

  @Test
  public void acceptsAnyOfMultipleSignatures() throws Exception {
    assertTrue(Utils.validateSignatureV3Scoped(POST_URL, NONCE, "bogus," + POST_SIG, TOKEN_1, "POST", postParams("delivered")));
  }

  @Test
  public void authTokenValidatorDoesNotAcceptScopedSignature() throws Exception {
    assertFalse(Utils.validateSignatureV3(POST_URL, NONCE, POST_SIG, TOKEN_1, "POST", postParams("delivered")));
  }

  private static String authSig() throws Exception {
    return Utils.computeSignatureV3(POST_URL, NONCE, AUTH_TOKEN, "POST", postParams("delivered"));
  }

  private static boolean validateKeys(String header, List<String> keys) throws Exception {
    return Utils.validateSignatureV3Scoped(POST_URL, NONCE, header, keys, "POST", postParams("delivered"));
  }

  @Test
  public void keyListAcceptsScopedSignature() throws Exception {
    assertEquals(POST_SIG, Utils.computeSignatureV3Scoped(POST_URL, NONCE, TOKEN_1, "POST", postParams("delivered")));
    assertTrue(validateKeys(POST_SIG, Arrays.asList(TOKEN_1, AUTH_TOKEN)));
  }

  @Test
  public void keyListAcceptsAuthTokenSignature() throws Exception {
    assertTrue(validateKeys(authSig(), Arrays.asList(TOKEN_1, AUTH_TOKEN)));
  }

  @Test
  public void keyListMatchesAuthTokenAmongMultipleSignatures() throws Exception {
    assertTrue(validateKeys(POST_SIG + "," + authSig(), Arrays.asList(TOKEN_2, AUTH_TOKEN)));
  }

  @Test
  public void keyListRejectsWrongScopedToken() throws Exception {
    assertFalse(validateKeys(POST_SIG, Collections.singletonList(TOKEN_2)));
  }

  @Test
  public void keyListEmptyOrWithBlankEntries() throws Exception {
    assertFalse(validateKeys(POST_SIG, Collections.<String>emptyList()));
    assertTrue(validateKeys(POST_SIG, Arrays.asList(null, "", TOKEN_1)));
  }
}
