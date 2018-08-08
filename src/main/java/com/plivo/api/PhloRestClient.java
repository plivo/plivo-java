package com.plivo.api;

import okhttp3.OkHttpClient;

public class PhloRestClient extends BaseClient {
  protected static String BASE_URL = "https://phlorunner.plivo.com/";

  public PhloRestClient(String authId, String authToken) {
    super(authId, authToken, BASE_URL);
  }

  public PhloRestClient(String authId, String authToken, OkHttpClient.Builder httpClientBuilder) {
    super(authId, authToken, httpClientBuilder, BASE_URL);
  }
}
