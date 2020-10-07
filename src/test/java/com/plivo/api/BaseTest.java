package com.plivo.api;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

  protected MockWebServer server;
  protected String authId = "MA123456789012345678";
  private String authToken = "authToken";
  private ObjectMapper mapper = new ObjectMapper();

  protected String expectResponse(String fixtureName, int statusCode) {
    MockResponse mockResponse = new MockResponse()
      .setResponseCode(statusCode);

    String body = loadFixture(fixtureName);

    if (body != null) {
      mockResponse.setBody(body);
    }

    server.enqueue(
      mockResponse
    );

    return body;
  }

  protected JsonNode actualRequestPayload() throws InterruptedException, IOException {
    RecordedRequest recordedRequest = server.takeRequest();
    return mapper.readTree(recordedRequest.getBody().readUtf8());
  }

  private static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
    Map<String, String> queryPairs = new LinkedHashMap<>();
    String query = uri.getQuery();
    if (query == null) {
      return queryPairs;
    }

    String[] pairs = query.split("&");
    for (String pair : pairs) {
      int idx = pair.indexOf("=");
      if (pair.substring(idx+1).length() > 0){
        queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
          URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
      }
    }
    return queryPairs;
  }

  protected void assertRequest(RecordedRequest request, String method, String format, Map<String,
    String> params, Object... objects) throws UnsupportedEncodingException {
    assertEquals(method, request.getMethod());
    URI uri = URI.create(request.getPath());
    assertEquals(String.format(format, objects), uri.getPath());
    assertEquals(params, splitQuery(uri));
  }

  protected void assertRequest(String method, String format, Object... objects)
    throws InterruptedException, UnsupportedEncodingException {
    assertRequest(server.takeRequest(), method, "/Account/" + authId + "/" + format,
      new LinkedHashMap<>(), objects);
  }

  protected void assertBaseRequest(String method, String format, Map<String, String> params, Object... objects)
    throws InterruptedException, UnsupportedEncodingException {
    RecordedRequest request = server.takeRequest();
    assertEquals(method, request.getMethod());
    assertEquals(String.format(format, objects), request.getPath());
    URI uri = URI.create(request.getPath());
    assertEquals(params, splitQuery(uri));
  }

  protected void assertApiRequest(String method, String apiPrefix, String format)
    throws InterruptedException, UnsupportedEncodingException {
    assertRequest(server.takeRequest(), method, apiPrefix + format,
      new LinkedHashMap<>());
  }

  protected void assertRequest(String method, String format, Map<String, String> params,
                               Object... objects) throws InterruptedException, UnsupportedEncodingException {
    assertRequest(server.takeRequest(), method, "/Account/" + authId + "/" + format,
      params, objects);
  }

  @Before
  public void setUp() throws Exception {
    server = new MockWebServer();
    server.start();

    PlivoClient.BASE_URL = server.url("/").toString();
    PlivoClient.VOICE_BASE_URL = server.url("/").toString();
    PlivoClient.VOICE_FALLBACK1_URL = server.url("/").toString();
    PlivoClient.VOICE_FALLBACK2_URL = server.url("/").toString();
    PhloRestClient.BASE_URL = server.url("/").toString();
    Plivo.init(authId, authToken);
    Plivo.getClient().setTesting(true);
    Plivo.getPhloClient().setTesting(true);
  }

  @After
  public void tearDown() throws Exception {
    server.shutdown();
  }
}
