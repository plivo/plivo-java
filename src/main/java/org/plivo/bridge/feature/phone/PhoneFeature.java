package org.plivo.bridge.feature.phone;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.feature.base.BaseFeature;
import org.plivo.bridge.to.response.CallResponse;
import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class PhoneFeature extends BaseFeature {

	public PhoneFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	public CallResponse search(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			CallResponse response = this.getBaseResource()
					.path("Phone/")
					.path("Search/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_XML_TYPE)
					.post(CallResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	public CallResponse order(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			CallResponse response = this.getBaseResource()
					.path("Phone/")
					.path("Order/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_XML_TYPE)
					.post(CallResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	public CallResponse status(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			CallResponse response = this.getBaseResource()
					.path("Phone/")
					.path("Status/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_XML_TYPE)
					.post(CallResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
}
