package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.factory.ApplicationFactory;

public class Account extends Resource {
	private PlivoRestClient restClient;
	
    private String city ;
    
    private String name ;
    
    @SerializedName("cash_credits")
    private String cashCredits ;
    
    private String created ;
    
    private String enabled ;
    
    private String modified ;
     
    @SerializedName("api_id")
    private String apiId ;
    
    private String postpaid ;
    
    private String state ;
    
    private String address ;
    
    private String timezone ;
    
    @SerializedName("auth_id")
    private String authID ;
    
    @SerializedName("resource_uri")
    private String resourceURI ;

	public Account (PlivoRestClient client) {
		super(client);
	}
	
	public Application getApplication(String appId) throws PlivoException {
		Gson gson = new Gson();
		Application app =  gson.fromJson(this.restClient.request("GET", String.format("/Application/%s/", appId), 
	                new LinkedHashMap<String, String>()), Application.class);
		if (app.isGetOK()) {
			app.setOK(true);
		}
		return app;
	}
	
	public ApplicationFactory getApplicationFactory() {
		return new ApplicationFactory(this.restClient);
	}
	
	public ApplicationList getApplications(LinkedHashMap<String, String> params)  throws PlivoException {
		Gson gson = new Gson();
		return gson.fromJson(this.restClient.request("GET", "/Application/", params), ApplicationList.class);
	}
	
	public void setClient(PlivoRestClient client) {
		this.restClient = client;
	}

	public String getCity() {
		return city;
	}


	public String getName() {
		return name;
	}


	public String getCashCredits() {
		return cashCredits;
	}


	public String getCreated() {
		return created;
	}


	public String getEnabled() {
		return enabled;
	}


	public String getModified() {
		return modified;
	}
	

	public String getApiId() {
		return apiId;
	}


	public String getPostpaid() {
		return postpaid;
	}


	public String getState() {
		return state;
	}


	public String getAddress() {
		return address;
	}


	public String getTimezone() {
		return timezone;
	}


	public String getAuthID() {
		return authID;
	}


	public String getResourceURI() {
		return resourceURI;
	}
	
}
