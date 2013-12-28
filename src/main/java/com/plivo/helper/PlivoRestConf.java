package com.plivo.helper;

public class PlivoRestConf {
	private final String authId;
	private final String authToken;
	private final String version;
	private final String apiURL = "https://api.plivo.com";

	public PlivoRestConf(String authId, String authToken, String version) {
		this.authId = authId;
		this.authToken = authToken;
		this.version = version;
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
