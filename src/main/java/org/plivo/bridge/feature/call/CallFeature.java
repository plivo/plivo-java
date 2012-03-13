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

import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import org.json.JSONObject;

public class CallFeature extends BaseFeature {

	public CallFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	//  /v1/Account/{auth_id}/Call/
	public String makeCall(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			String response = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class,
							PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// /v1/Account/{auth_id}/Call/{call_uuid}/
	public String transfer(String CallUUID, Map<String, String> parameters)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
				.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// End point: /v1/Account/{auth_id}/Call/{call_uuid}/
	public String hangUp(String CallUUID)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// /v1/Account/{auth_id}/Call/
	public String hangUpAll()
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// /v1/Account/{auth_id}/Call/{call_uuid}/Record/
	public String recordStart(String CallUUID, Map<String, String> parameters) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/Record/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.type(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	// /v1/Account/{auth_id}/Call/{call_uuid}/Record/
	public String recordStop(String CallUUID, Map<String, String> parameters) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/Record/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	// /v1/Account/{auth_id}/Call/{call_uuid}/Play/
	public String play(String CallUUID, Map<String, String> parameters) 
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/Play/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	// /v1/Account/{auth_id}/Call/{call_uuid}/Play/
	public String playStop(String CallUUID) 
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Call/"+CallUUID+"/Play/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
}
