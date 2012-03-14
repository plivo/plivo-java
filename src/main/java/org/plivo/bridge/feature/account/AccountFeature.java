package com.plivo.bridge.feature.account;

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


public class AccountFeature extends BaseFeature {

	public AccountFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	// Get Account
	// /v1/Account/{auth_id}/
	public String getDetails()
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// Modify Account
	// /v1/Account/{auth_id}/
	public String modify(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
				.path("Account/"+this.getAccountId()+"/")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Get All Subaccounts
	// End point: /v1/Account/{auth_id}/Subaccount/
	public String allSubaccounts()
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/
	public String subaccount(String SubAuthId)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// Modify Subaccount
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/
	public String modifySubaccount(String SubAuthId, Map<String, String> parameters) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.type(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	

	// Delete Subaccount
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/
	public String deleteSubaccount(String SubAuthId) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}	
}
