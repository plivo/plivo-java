package org.plivo.bridge.feature.call;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.feature.base.BaseFeature;
import org.plivo.bridge.to.request.BulkCallRequest;
import org.plivo.bridge.to.request.CallRequest;
import org.plivo.bridge.to.request.CancelScheduleHangupRequest;
import org.plivo.bridge.to.request.HangupAllCallRequest;
import org.plivo.bridge.to.request.HangupCallRequest;
import org.plivo.bridge.to.request.ScheduleHangupRequest;
import org.plivo.bridge.to.request.TransfCallRequest;
import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class CallFeature extends BaseFeature {

	public CallFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
		this.setBaseResource(this.getBaseResource());
	}

	public CallRequest single(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			CallRequest response = this.getBaseResource()
					.path("Call/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(CallRequest.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public BulkCallRequest bulk(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			BulkCallRequest result = this.getBaseResource()
					.path("BulkCall/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(BulkCallRequest.class, 
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public TransfCallRequest transfer(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			TransfCallRequest result = this.getBaseResource()
				.path("TransferCall/")
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(TransfCallRequest.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public HangupCallRequest hangUp(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			HangupCallRequest result = this.getBaseResource()
					.path("HangupCall/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(HangupCallRequest.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public HangupAllCallRequest hangUpAll(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			HangupAllCallRequest result = this.getBaseResource()
					.path("HangupAllCalls/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(HangupAllCallRequest.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ScheduleHangupRequest scheduleHangup(Map<String, String> parameters)
			throws PlivoClientException {
		try {
			ScheduleHangupRequest result = this.getBaseResource()
					.path("ScheduleHangup/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ScheduleHangupRequest.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public CancelScheduleHangupRequest cancelScheduledHangup(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			CancelScheduleHangupRequest result = this.getBaseResource()
					.path("CancelScheduledHangup/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(CancelScheduleHangupRequest.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
}
