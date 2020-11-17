package com.plivo.api;

public class Plivo {

    private static PlivoClient plivoInstance = null;
    private static PlivoClient phloInstance = null;

    /**
     * Initializes the global {@link PlivoClient} plivoInstance
     */
    public static synchronized void init(String authId, String authToken) {
        System.out.println("New build");
        plivoInstance = new PlivoClient(authId, authToken);
        phloInstance = new PhloRestClient(authId, authToken).getClient();
    }

    /**
     * Initializes the global {@link PlivoClient} plivoInstance, taking the authId and authToken from
     * environment variables called PLIVO_AUTH_ID and PLIVO_AUTH_TOKEN.
     */
    public static synchronized void init() {
        System.out.println("New build");
        init(System.getenv("PLIVO_AUTH_ID"), System.getenv("PLIVO_AUTH_TOKEN"));
    }

    public static PlivoClient getClient() {
        return plivoInstance;
    }

    public static PlivoClient getPhloClient() {
        return phloInstance;
    }
}
