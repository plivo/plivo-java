package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class OutgoingCarrierRouting {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("routing_id")
    public String routingId ;
    
    @SerializedName("digits")
    public String digits ;
    
    @SerializedName("priority")
    public String priority ;
    
    @SerializedName("outgoing_carrier")
    public String outgoingCarrier ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    public OutgoingCarrierRouting() {
        // empty
    }
}
