package com.plivo.api;

public class Plivo {

  private static PlivoClient instance = null;
  private static PlivoClient phloInstance = null;

  /**
   * Initializes the global {@link PlivoClient} instance
   */
  public static synchronized void init(String authId, String authToken) {
    instance = new PlivoRestClient(authId, authToken).getClient();
    phloInstance = new PhloRestClient(authId, authToken).getClient();
  }

  /**
   * Initializes the global {@link PlivoClient} instance, taking the authId and authToken from
   * environment variables called PLIVO_AUTH_ID and PLIVO_AUTH_TOKEN.
   */
  public static synchronized void init() {
    init(System.getenv("PLIVO_AUTH_ID"), System.getenv("PLIVO_AUTH_TOKEN"));
  }

  public static PlivoClient getClient() {
    return instance;
  }

  public static PlivoClient getPhloClient() {
    return phloInstance;
  }
}
