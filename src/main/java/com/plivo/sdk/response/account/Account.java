package com.plivo.sdk.response.account;

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
    public String apiID ;
    
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
