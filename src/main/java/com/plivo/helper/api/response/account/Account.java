package com.plivo.helper.api.response.account;

import com.google.gson.annotations.SerializedName;

public class Account {

    public String city ;
    
    public String name ;
    
    @SerializedName("cash_credits")
    public String cashCredits ;
    
    public String created ;
    
    public String enabled ;
    
    public String modified ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String postpaid ;
    
    public String state ;
    
    public String address ;
    
    public String timezone ;
    
    @SerializedName("auth_id")
    public String authID ;
    
    @SerializedName("resource_uri")
    public String resourceURI ;
    
    public Account() {
        // empty
    }
    
    @Override
	public String toString() {
		return "Account [city=" + city + ", name=" + name + ", cashCredits="
				+ cashCredits + ", created=" + created + ", enabled=" + enabled
				+ ", modified=" + modified + ", error=" + error + ", apiId="
				+ apiId + ", postpaid=" + postpaid + ", state=" + state
				+ ", address=" + address + ", timezone=" + timezone
				+ ", authID=" + authID + ", resourceURI=" + resourceURI + "]";
	}
}
