package com.plivo.helper.api.response.account;

import com.google.gson.annotations.SerializedName;

public class Account {
	@SerializedName("server_code")
	public Integer serverCode ;

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
}
