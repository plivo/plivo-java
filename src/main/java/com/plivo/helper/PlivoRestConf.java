package com.plivo.helper;

public class PlivoRestConf {
	private final String authId;
	private final String authToken;
	private final String version;
	private final String apiURL = "https://api.plivo.com";

	/**
	 * 
	 * @param authId
	 *            Plivo API Auth ID
	 * @param authToken
	 *            Plivo API Auth token
	 * @param version
	 *            Plivo API Version
	 */
	public PlivoRestConf(String authId, String authToken, String version) {
		this.authId = authId;
		this.authToken = authToken;
		this.version = version;
	}

	/**
	 * Contruct Plivo REST configuration object with default API version.
	 * Current default API version is v1
	 * 
	 * @param authId
	 *            Plivo API Auth ID
	 * @param authToken
	 *            Plivo API Auth token
	 */
	public PlivoRestConf(String authId, String authToken) {
		this.authId = authId;
		this.authToken = authToken;
		this.version = "v1";
	}

	public String getAuthId() {
		return authId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getVersion() {
		return version;
	}

	public String getApiURL() {
		return apiURL;
	}
}
