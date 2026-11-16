package com.plivo.api;

import com.plivo.api.util.Utils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class UtilsTest {
  @Test
  public void computeSignatureShouldWork() throws Exception {
    assertEquals("ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc=",
      Utils.computeSignature("https://answer.url", "12345", "my_auth_token")
      );
  }

  @Test
  public void validateSignatureShouldWork() throws Exception {
    assertEquals(true,
      Utils.validateSignature("https://answer.url", "12345", "ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc=", "my_auth_token")
    );
  }

  @Test
  public void validateSignatureWithTrailingSlashShouldWork() throws Exception {
    assertEquals(
      true,
      Utils.validateSignature(
        "https://answer.url/",
        "12345",
        "do1CXv+k99A6+B+eTcyqbxWlezFIxJ/1vz72787r37g=",
        "my_auth_token")
    );
  }

  public void validateSignatureWithPortShouldWork() throws Exception {
    assertEquals(
      true,
      Utils.validateSignature(
        "https://answer.url:8000",
        "12345",
        "Gm7Z7AGBmf5JpSHrtUmeofrGyA4xV0ZiV0rH8JPXWGU=",
        "my_auth_token")
    );
  }


  @Test
  public void validateSignatureShouldFail() throws Exception {
    assertEquals(false,
      Utils.validateSignature("https://answer.url", "12345", "ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc", "my_auth_tokens")
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void computeSignatureShouldThrowIllegalArgumentException() throws Exception {
    Utils.computeSignature(null, null, null);
  }

  private static final String V3_TOKEN = "test-auth-token";
  private static final String V3_NONCE = "12345678901234567890";

  private static Map<String, String> params(String... keyValues) {
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < keyValues.length; i += 2) {
      map.put(keyValues[i], keyValues[i + 1]);
    }
    return map;
  }

  private static String v3(String url, String method, Map<String, String> params) throws Exception {
    return Utils.computeSignatureV3(url, "12345", V3_TOKEN, method, params);
  }

  // Expected values were computed before WebSocket URL support was added and must not change.
  @Test
  public void computeSignatureV3HttpGetIsUnchanged() throws Exception {
    assertEquals("M6E4JHLszMD69E7oDM1gME6QvQ12Z1C/CVm/KzuRdBw=", v3("https://example.com/answer?b=2&a=1", "GET", params()));
    assertEquals("+w3uX1zOLLVSE88pDk8JZIc3L9cSzJrUjwPOiv5w3zY=", v3("https://example.com/answer?b=2&a=1", "GET", params("c", "3")));
    assertEquals("oW13me/dUQKSK7jbfGx7WYNPX1y0sOPjKsTiL/uY270=", v3("https://example.com/answer?name=John+Doe&sig=abc%3D%3D", "GET", params()));
    assertEquals("tjQBHz34cYoHY0CJjtogchKvKxqNB4xvydJqZ7Xj5o8=", v3("http://example.com/cb/?x=1", "GET", params()));
    assertEquals("H6v9bPKSIHD2+lrJsQ2j8nJB2J+5X0vCWKMglwaJB1w=", v3("https://example.com/answer", "GET", params("a", "1")));
  }

  @Test
  public void computeSignatureV3HttpPostIsUnchanged() throws Exception {
    assertEquals("hXyfOAeD4St/Nkyb4xd1sEOSZNMo643bXkzUTN8KU/Q=", v3("https://example.com/answer", "POST", params("CallUUID", "abc", "From", "1234")));
    assertEquals("MFeNMBvihN4T6GqkfuO81CHDSndhSwfc61N7AU5MZrE=", v3("https://example.com/answer?b=2&a=1", "POST", params("CallUUID", "abc", "From", "1234")));
    assertEquals("t8Np9lEsAQwySG9XORCstq7hkndBCKc9lXkzRAlcejM=", v3("https://example.com/answer", "POST", params()));
    assertEquals("+v7M6Y5OENSXVjOZHXy/EFRTiQuf0NG9qYnsefG4byw=", v3("https://example.com/answer?q=1", "POST", params()));
  }

  @Test
  public void generateUrlKeepsPort() throws Exception {
    assertEquals("https://example.com:8443/answer?a=1", Utils.generateUrl("https://example.com:8443/answer?a=1", "GET", params()));
    assertEquals("https://example.com:8443/answer?CallUUIDabc", Utils.generateUrl("https://example.com:8443/answer", "POST", params("CallUUID", "abc")));
  }

  @Test
  public void generateUrlGetWithoutQuery() throws Exception {
    assertEquals("https://example.com/answer", Utils.generateUrl("https://example.com/answer", "GET", params()));
    assertEquals("https://example.com/answer", Utils.generateUrl("https://example.com/answer?", "GET", params()));
  }

  @Test
  public void generateUrlRepeatedQueryKeyUsesFirstValue() throws Exception {
    assertEquals("https://example.com/answer?a=2&b=", Utils.generateUrl("https://example.com/answer?a=2&a=1&b=", "GET", params()));
  }

  @Test
  public void generateUrlComparesMethodByValue() throws Exception {
    assertEquals("https://example.com/answer?a=1", Utils.generateUrl("https://example.com/answer?a=1", new String("GET"), params()));
  }

  // {url, signature} pairs produced by Plivo's reference signer for GET.
  private static final String[][] WEBSOCKET_VECTORS = {
    {"wss://example.com/media/stream?tenant=42&env=prod", "Ni6eSQI9zg/LjUt95Nlt5nTYA7FpL6CQuY2F+Yy3jyc="},
    {"ws://example.com/media/stream?tenant=42&env=prod", "De3cjnXuPrS4pSTyrva6wFEYh9CpRgvlyaQ1gct9auo="},
    {"wss://example.com/media/stream", "paNuAIW+AAlyCT4lFH8ZrCvzj3gkNuvrX0r877mN3nM="},
    {"wss://example.com:8443/ws/?b=2&a=1", "d4mqJrd9gtwO+Dfc7IT4u144WmmoPrnCjYUTmM3HBSk="},
    {"wss://example.com/s?sig=abc%3D%3D&name=John+Doe", "WkbN9mLc0kqBHtOjlD4GiUIvDkZ+cSfqUsEKrF8ixmY="},
    {"wss://example.com/s?a=2&a=1&b=", "2cKu0gQz5RJiYNmM0R6KIxu2Wphx3qSHChoOgvNdGKo="},
    {"wss://example.com/my%20stream/ws?id=1", "5hGH/IknEopkorKviPg1OTVLJvkZ/oqs3GBHF9Si4mw="},
    {"wss://example.com/s?name=Jos%C3%A9", "j0fffZVummAvqXtvGPkEVhnNDmDeFaTPXDP4CedUaow="},
    {"wss://example.com/s?flag&x=1", "EZ6eDWNK9Elkw49HS/1NHdZH/ItKIISoqPVbfhgM7tE="},
    {"wss://example.com/media/stream?", "paNuAIW+AAlyCT4lFH8ZrCvzj3gkNuvrX0r877mN3nM="},
    {"wss://example.com/media/stream#frag", "paNuAIW+AAlyCT4lFH8ZrCvzj3gkNuvrX0r877mN3nM="},
    {"wss://example.com", "mXPltZtATpEE0xZ2FUiuVHgIis/d14y8t/rtESnFGjU="},
    {"wss://example.com/a%2Fb/ws?q=1", "ZnGd8sbUoc4m+gsJK4smUKQF51bEy5S2dSEYnS/FZdc="}
  };

  @Test
  public void validateSignatureV3AcceptsWebSocketUrls() throws Exception {
    for (String[] vector : WEBSOCKET_VECTORS) {
      assertTrue(vector[0], Utils.validateSignatureV3(vector[0], V3_NONCE, vector[1], V3_TOKEN, "GET"));
    }
  }

  @Test
  public void validateSignatureV3AcceptsEitherOfTwoSignatures() throws Exception {
    String url = "wss://example.com/media/stream?tenant=42&env=prod";
    String signature = "Ni6eSQI9zg/LjUt95Nlt5nTYA7FpL6CQuY2F+Yy3jyc=";
    assertTrue(Utils.validateSignatureV3(url, V3_NONCE, "other," + signature, V3_TOKEN, "GET"));
    assertTrue(Utils.validateSignatureV3(url, V3_NONCE, signature + ",other", V3_TOKEN, "GET"));
  }

  @Test
  public void validateSignatureV3RejectsWebSocketSignatureForOtherInput() throws Exception {
    String signature = "Ni6eSQI9zg/LjUt95Nlt5nTYA7FpL6CQuY2F+Yy3jyc=";
    assertFalse(Utils.validateSignatureV3("wss://example.com/media/stream?tenant=43&env=prod", V3_NONCE, signature, V3_TOKEN, "GET"));
    assertFalse(Utils.validateSignatureV3("ws://example.com/media/stream?tenant=42&env=prod", V3_NONCE, signature, V3_TOKEN, "GET"));
    assertFalse(Utils.validateSignatureV3("https://example.com/media/stream?tenant=42&env=prod", V3_NONCE, signature, V3_TOKEN, "GET"));
    assertFalse(Utils.validateSignatureV3("wss://example.com/media/stream?tenant=42&env=prod", V3_NONCE, signature, "wrong-token", "GET"));
  }
}
