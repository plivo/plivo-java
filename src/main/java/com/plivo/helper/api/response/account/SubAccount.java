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

    @SerializedName("new_auth_token")
    public String newAuthToken ;

    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("created")
    public String createdOn ;
    
    @SerializedName("enabled")
    public Boolean isEnabled ;
    
    @SerializedName("modified")
    public String lastModifiedOn ;
    
    public String name ;
    
    public String message;
    
    public SubAccount() {
        // empty
    }

	@Override
	public String toString() {
		return "SubAccount [account=" + account + ", error=" + error
				+ ", apiId=" + apiId + ", authId=" + authId + ", authToken="
				+ authToken + ", newAuthToken=" + newAuthToken
				+ ", resourceUri=" + resourceUri + ", createdOn=" + createdOn
				+ ", isEnabled=" + isEnabled + ", lastModifiedOn="
				+ lastModifiedOn + ", name=" + name + ", message=" + message
				+ "]";
	}
    
}
