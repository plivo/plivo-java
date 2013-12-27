package com.plivo.helper;

public class PlivoRestConf {
	private String authId;
	private String authToken;
	private String version;
	private String apiURL = "https://api.plivo.com";
	
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
