package com.plivo.api;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

  protected MockWebServer server;
  protected String authId = "MA123456789012345678";
  private String authToken = "authToken";

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

  private static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
    Map<String, String> queryPairs = new LinkedHashMap<String, String>();
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

  protected void assertRequest(RecordedRequest request, String method, String format, Map<String, String> params,
    Object... objects) throws MalformedURLException, UnsupportedEncodingException {
    assertEquals(method, request.getMethod());
    URI uri = URI.create(request.getPath());
    assertEquals(String.format(format, objects), uri.getPath());
    assertEquals(params, splitQuery(uri));
  }

  protected void assertRequest(String method, String format, Object... objects)
    throws InterruptedException, MalformedURLException, UnsupportedEncodingException {
    assertRequest(server.takeRequest(), method, "/Account/" + authId + "/" + format,
      new LinkedHashMap<>(), objects);
  }

  protected void assertRequest(String method, String format, Map<String, String> params, Object... objects)
    throws InterruptedException, MalformedURLException, UnsupportedEncodingException {
    assertRequest(server.takeRequest(), method, "/Account/" + authId + "/" + format, params, objects);
  }

  @Before
  public void setUp() throws Exception {
    server = new MockWebServer();
    server.start();

    PlivoClient.BASE_URL = server.url("/").toString();
    Plivo.init(authId, authToken);
    Plivo.getClient().setTesting(true);
  }

  @After
  public void tearDown() throws Exception {
    server.shutdown();
  }
}
