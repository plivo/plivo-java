package com.plivo.helper.factory;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.ApplicationCreateResponse;

public class ApplicationFactory {
	private PlivoRestClient client;
	public ApplicationFactory (PlivoRestClient client) {
		this.client = client;
	}
	
	public String create(LinkedHashMap<String, String> parameters)  throws PlivoException{
		Gson gson = new Gson();
		ApplicationCreateResponse acr =  gson.fromJson(this.client.request("POST", "/Application/", parameters), 
				ApplicationCreateResponse.class);
		if (acr.isCreated()) {
			return acr.getApplicationId();
		}else {
			return null;
		}
	}
}
