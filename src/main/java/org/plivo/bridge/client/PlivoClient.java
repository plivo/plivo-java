package org.plivo.bridge.client;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.plivo.bridge.feature.call.CallFeature;

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

	private PlivoClient(String version, String accountId, String authToken,
			String url, boolean debug) {
		this.setAccountId(accountId);
		this.setAuthToken(authToken);
		this.restClient = Client.create();
		this.restClient.addFilter(new HTTPBasicAuthFilter(this.getAccountId(),
				this.getAuthToken()));
		this.setBaseResource(this.restClient.resource(url).path(version));
		if (debug)
			this.restClient.addFilter(new LoggingFilter(System.out));
	}

	public CallFeature call() {
		CallFeature f = new CallFeature(this, this.getBaseResource());

		return f;
	}

	public static PlivoClient create(String accountId, String authToken,
			String url, boolean debug) {
		// read properties to get the api version
		InputStream input = PlivoClient.class
				.getResourceAsStream("/bridge.properties");
		Properties p = new Properties();

		try {
			p.load(input);
		} catch (IOException e) {

		}

		String version = p.getProperty("plivo.api.version");
		if (null == version || "".equals(version.trim()))
			throw new RuntimeException(
					"Problem with this version. Couldn't find resource named 'bridge.properties'. Download another JAR.");

		return new PlivoClient(version, accountId, authToken, url, debug);
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
