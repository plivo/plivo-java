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


public class ApplicationFeature extends BaseFeature {

	public ApplicationFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	// Get All Applications
	// /v1/Account/{auth_id}/Application/
	public String getAllApplications()
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Application/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// Create an Application
	// /v1/Account/{auth_id}/Application/
	public String createApplication(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
				.path("Account/"+this.getAccountId()+"/Application/")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


    // Modify an Application
	//  /v1/Account/{auth_id}/Application/{app_id}/
	public String modifyApplication(String ApplicationId, Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Application/"+ApplicationId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	

	// Delete an Application
	// /v1/Account/{auth_id}/Application/{app_id}/
	public String deleteApplication(String ApplicationId) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Application/"+ApplicationId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	// Get All Subaccount Applications
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Application/
	public String getAllSubAccountApplications(String SubAuthId)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Application/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// Get Subaccount Application
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Application/{app_id}/

	public String getAllSubAccountApplications(String SubAuthId, String ApplicationId)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Application/"+ApplicationId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// Create a Subaccount Application
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Application/
	public String createSubaccountApplication(String SubAuthId, Map<String, String> parameters)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
				.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Application/")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// Modify a Subaccount Application
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Application/{app_id}/
	public String modifySubaccountApplication(String SubAuthId, String ApplicationId, Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Application/"+ApplicationId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// Delete a Subaccount Application
	// /v1/Account/{auth_id}/Subaccount/{subauthg_id}/Application/{app_id}/
	public String deleteApplication(String SubAuthId, String ApplicationId) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Application/"+ApplicationId+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


}
