package com.plivo.helper.api.response.endpoint;

import com.google.gson.annotations.SerializedName;

public class Endpoint {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String username ;

    @SerializedName("sip_uri")
    public String sipUri ;
    
    public String alias ;
    
    @SerializedName("endpoint_id")
    public String endpointId ;
    
    public String password ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error ;
    
    public Endpoint() {
        // empty
    }

	@Override
	public String toString() {
		return "Endpoint [serverCode=" + serverCode + ", username=" + username
				+ ", sipUri=" + sipUri + ", alias=" + alias + ", endpointId="
				+ endpointId + ", password=" + password + ", resourceUri="
				+ resourceUri + ", apiId=" + apiId + ", error=" + error + "]";
	}
}
