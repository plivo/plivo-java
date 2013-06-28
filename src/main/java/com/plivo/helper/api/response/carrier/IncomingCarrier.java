package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class IncomingCarrier {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("carrier_id")
    public String carrierId ;
    
    @SerializedName("ip_set")
    public String ipSet ;
    
    @SerializedName("name")
    public String name ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("sms")
    public Boolean sms ;
    
    @SerializedName("voice")
    public Boolean voice ;
    
    public IncomingCarrier() {
        // empty
    }
}
