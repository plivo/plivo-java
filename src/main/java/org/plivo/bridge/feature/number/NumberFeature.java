package com.plivo.bridge.feature.number;

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


public class NumberFeature extends BaseFeature {

	public NumberFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	// Get All Numbers rented
	// /v1/Account/{auth_id}/Number/
	public String getAllRented()
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Number/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// Get one Number rented
	// /v1/Account/{auth_id}/Number/{number}/
	public String getOneRented(String Number)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
				.path("Account/"+this.getAccountId()+"/Number/"+Number+"/")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Search new Numbers
	// End point:  /v1/Account/{auth_id}/AvailableNumber/
	public String search(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/AvailableNumber/"+PlivoUtils.ParameterUtils.mapToString(parameters))
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}


	// Rent one number
	// /v1/Account/{auth_id}/AvailableNumber/{number}/
	public String rent(String Number)
			throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/AvailableNumber/"+Number+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	
	// Unrent one number
	// /v1/Account/{auth_id}/Number/{number}/
	public String unRent(String Number) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Number/"+Number+"/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.type(MediaType.APPLICATION_JSON_TYPE)
					.delete(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	

	// Link or Unlink an Application to one Number
	// /v1/Account/{auth_id}/Number/{number}/
	public String deleteSubaccount(String Number, Map<String, String> parameters) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Number/"+Number+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}	

	// Get All Subaccount Numbers rented
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Number/
	public String subAccountRented(String SubAuthId) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/SubAccount/"+SubAuthId+"/Number/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}	

	// Get one Subaccount Number rented
	// /v1/Account/{auth_id}/Subaccount/{subauth_id}/Number/{number}/
	public String oneSubAccountRented(String SubAuthId, String Number) 
		throws PlivoClientException {
		
		try {
			String result = this.getBaseResource()
					.path("Account/"+this.getAccountId()+"/Subaccount/"+SubAuthId+"/Number/"+Number+"/")
					.type(MediaType.APPLICATION_JSON_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}	



}
