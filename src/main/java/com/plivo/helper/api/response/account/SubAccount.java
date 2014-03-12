package com.plivo.helper.api.response.account;

import com.google.gson.annotations.SerializedName;

public class SubAccount {
    public String account ;

    public String error ;
    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("auth_id")
    public String authId ;
    
    @SerializedName("auth_token")
    public String authToken ;

    @SerializedName("old_auth_token")
    public String oldAuthToken ;

    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("created")
    public String createdOn ;
    
    @SerializedName("enabled")
    public Boolean isEnabled ;
    
    @SerializedName("modified")
    public String lastModifiedOn ;
    
    public String name ;
    
    public SubAccount() {
        // empty
    }
}
