package org.plivo.bridge.feature.base;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.util.Iterator;
import java.util.Map;

import org.plivo.bridge.client.PlivoClient;

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