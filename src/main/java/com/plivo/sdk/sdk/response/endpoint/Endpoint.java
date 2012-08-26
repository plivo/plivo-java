package com.plivo.sdk.response.endpoint;

import com.google.gson.annotations.SerializedName;

public class Endpoint {
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
    public String apiID ;
    
    public String error ;
    
    public Endpoint() {
        // empty
    }
}
