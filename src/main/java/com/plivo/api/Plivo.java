package com.plivo.api;

public class Plivo {

  private static Client plivoInstance = null;
  private static Client phloInstance = null;

  /**
   * Initializes the global {@link Client} plivoInstance
   */
  public static synchronized void init(String authId, String authToken) {
    plivoInstance = new PlivoClient(authId, authToken).getClient();
    phloInstance = new PhloClient(authId, authToken).getClient();
  }

  /**
   * Initializes the global {@link Client} plivoInstance, taking the authId and authToken from
   * environment variables called PLIVO_AUTH_ID and PLIVO_AUTH_TOKEN.
   */
  public static synchronized void init() {
    init(System.getenv("PLIVO_AUTH_ID"), System.getenv("PLIVO_AUTH_TOKEN"));
  }

  public static Client getClient() {
    return plivoInstance;
  }

  public static Client getPhloClient() {
    return phloInstance;
  }
}
