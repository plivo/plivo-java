package org.plivo.bridge.client;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import org.plivo.bridge.feature.call.CallFeature;
import org.plivo.bridge.feature.conference.ConferenceFeature;
import org.plivo.bridge.feature.phone.PhoneFeature;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class PlivoClient {
	private WebResource baseResource;
	private String apiVersion;

	private String accountId;
	private String authToken;
	private Client restClient;
	private final String CLOUD_URL 			= "http://api.plivo.com";
	private final String CLOUD_VERSION		= "v1";

	/**
	 * Create a new instance of PlivoClient
	 * @param accountId Account Id of your Cloud Application
	 * @param authToken Auth Token of your Cloud Application
	 * @param debug True to get the HTTP logs
	 */
	public PlivoClient(String accountId, String authToken, boolean debug) {
		this.setAccountId(accountId);
		this.setAuthToken(authToken);
		this.restClient = Client.create();
		this.restClient.addFilter(new HTTPBasicAuthFilter(this.getAccountId(),
				this.getAuthToken()));
		this.setBaseResource(this.restClient.resource(CLOUD_URL).path(CLOUD_VERSION));
		if (debug)
			this.restClient.addFilter(new LoggingFilter(System.out));
	}
	
	public static PlivoClient create(String accountId, String authToken, boolean debug) {
		return new PlivoClient(accountId, authToken, debug);
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
	
	public PhoneFeature phone() {
		PhoneFeature f = new PhoneFeature(this, this.getBaseResource());
		
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

	public String getAccountId() {
		return accountId;
	}

	void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAuthToken() {
		return authToken;
	}

	void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
