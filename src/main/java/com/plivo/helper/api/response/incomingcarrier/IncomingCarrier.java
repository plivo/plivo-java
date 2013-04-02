package com.plivo.helper.api.response.incomingcarrier;

import com.google.gson.annotations.SerializedName;

public class IncomingCarrier {
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
