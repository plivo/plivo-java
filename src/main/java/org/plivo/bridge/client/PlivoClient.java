package com.plivo.bridge.client;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import com.plivo.bridge.feature.call.CallFeature;
import com.plivo.bridge.feature.conference.ConferenceFeature;
import com.plivo.bridge.feature.account.AccountFeature;
import com.plivo.bridge.feature.application.ApplicationFeature;
import com.plivo.bridge.feature.number.NumberFeature;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class PlivoClient {
	private WebResource baseResource;
	private String apiVersion;

	private String authId;
	private String authToken;
	private Client restClient;
	private final String CLOUD_URL 			= "https://api.plivo.com";
	private final String CLOUD_VERSION		= "v1";

	/**
	 * Create a new instance of PlivoClient
	 * @param authId Account Id of your Cloud Application
	 * @param authToken Auth Token of your Cloud Application
	 * @param debug True to get the HTTP logs
	 */
	public PlivoClient(String authId, String authToken, boolean debug) {
		this.setAuthId(authId);
		this.setAuthToken(authToken);
		this.restClient = Client.create();
		this.restClient.addFilter(new HTTPBasicAuthFilter(this.getAuthId(),
				this.getAuthToken()));
		this.setBaseResource(this.restClient.resource(CLOUD_URL).path(CLOUD_VERSION));
		if (debug)
			this.restClient.addFilter(new LoggingFilter(System.out));
	}
	
	public static PlivoClient create(String authId, String authToken, boolean debug) {
		return new PlivoClient(authId, authToken, debug);
	}
	
	/**
	 * Connection timeout (in milliseconds)
	 * @param timeout
	 */
	public void setConnectionTimeout( int timeout ) {
		restClient.setConnectTimeout(timeout);
	}
	
	/**
	 * Read timeout (in milliseconds)
	 * @param timeout
	 */
	public void setReadTimeout(int timeout) {
		restClient.setReadTimeout(timeout);
	}

	public CallFeature call() {
		CallFeature f = new CallFeature(this, this.getBaseResource());

		return f;
	}
	
	public ConferenceFeature conference() {
		ConferenceFeature f = new ConferenceFeature(this, this.getBaseResource());
		
		return f;
	}
	
	public NumberFeature number() {
		NumberFeature f = new NumberFeature(this, this.getBaseResource());
		
		return f;
	}

	public AccountFeature account() {
		AccountFeature f = new AccountFeature(this, this.getBaseResource());
		
		return f;
	}

	public ApplicationFeature application() {
		ApplicationFeature f = new ApplicationFeature(this, this.getBaseResource());
		
		return f;
	}

	public WebResource getBaseResource() {
		return baseResource;
	}

	public void setBaseResource(WebResource baseResource) {
		this.baseResource = baseResource;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAuthId() {
		return authId;
	}

	void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthToken() {
		return authToken;
	}

	void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
