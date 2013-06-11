package com.plivo.helper.api.response.endpoint;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EndpointFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    public EndpointMeta meta ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<Endpoint> endpointList ;
    
    public EndpointFactory() {
        // empty
    }
}
