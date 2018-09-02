package com.plivo.api;

import okhttp3.OkHttpClient;

public class PlivoRestClient extends BaseClient {

  protected static String BASE_URL = "https://api.plivo.com/v1/";

  public PlivoRestClient(String authId, String authToken) {
    super(authId, authToken, BASE_URL);
  }

  public PlivoRestClient(String authId, String authToken, OkHttpClient.Builder httpClientBuilder) {
    super(authId, authToken, httpClientBuilder, BASE_URL);
  }
}
