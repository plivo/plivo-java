package com.plivo.api;

import com.plivo.api.models.base.LogLevel;
import okhttp3.OkHttpClient;

public class Plivo {

    private static PlivoClient plivoInstance = null;
    private static PlivoClient phloInstance = null;

    /**
     * Initializes the global {@link PlivoClient} plivoInstance
     */
    public static synchronized void init(String authId, String authToken) {
        plivoInstance = new PlivoClient(authId, authToken);
        phloInstance = new PhloRestClient(authId, authToken).getClient();
    }

  public static synchronized void init(String authId, String authToken, OkHttpClient.Builder httpClientBuilder) {
      plivoInstance = new PlivoClient(authId, authToken, httpClientBuilder);
  }

  public static synchronized void init(String authId, String authToken, LogLevel logLevel) {
    plivoInstance = new PlivoClient(authId, authToken, logLevel);
    phloInstance = new PhloRestClient(authId, authToken).getClient();
  }

  public static synchronized void init(String authId, String authToken, OkHttpClient.Builder httpClientBuilder,
                                       LogLevel logLevel) {
    plivoInstance = new PlivoClient(authId, authToken, httpClientBuilder, logLevel);
  }

    /**
     * Initializes the global {@link PlivoClient} plivoInstance, taking the authId and authToken from
     * environment variables called PLIVO_AUTH_ID and PLIVO_AUTH_TOKEN.
     */
    public static synchronized void init() {
        init(System.getenv("PLIVO_AUTH_ID"), System.getenv("PLIVO_AUTH_TOKEN"));
    }

    public static PlivoClient getClient() {
        return plivoInstance;
    }

    public static PlivoClient getPhloClient() {
        return phloInstance;
    }
}
