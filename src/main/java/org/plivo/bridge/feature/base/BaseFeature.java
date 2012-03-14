package com.plivo.bridge.feature.base;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.util.Iterator;
import java.util.Map;

import com.plivo.bridge.client.PlivoClient;

import com.sun.jersey.api.client.WebResource;

public abstract class BaseFeature {

	private PlivoClient client;
	private WebResource baseResource;

	public BaseFeature(PlivoClient client, WebResource baseResource) {
		this.setClient(client);
		this.setBaseResource(baseResource);
	}

	protected WebResource populateGETResource(WebResource resource,
			Map<String, String> parameters) {
		Iterator<String> iterator = parameters.keySet().iterator();
		String key = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			resource = resource.queryParam(key, parameters.get(key));
		}

		return resource;
	}

	protected PlivoClient getClient() {
		return client;
	}

	protected String getAccountId() {
		return client.getAccountId();
	}

	protected void setClient(PlivoClient client) {
		this.client = client;
	}

	protected WebResource getBaseResource() {
		return baseResource;
	}

	protected void setBaseResource(WebResource baseResource) {
		this.baseResource = baseResource;
	}
}