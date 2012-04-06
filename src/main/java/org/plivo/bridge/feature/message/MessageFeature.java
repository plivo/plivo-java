package com.plivo.bridge.feature.message;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.plivo.bridge.client.PlivoClient;
import com.plivo.bridge.exception.PlivoClientException;
import com.plivo.bridge.feature.base.BaseFeature;

import com.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;


public class MessageFeature extends BaseFeature {

	public MessageFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	//  /v1/Account/{auth_id}/Message/
	public String sendMessage(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Message/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class,
							PlivoUtils.ParameterUtils.mapToJSON(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
}
