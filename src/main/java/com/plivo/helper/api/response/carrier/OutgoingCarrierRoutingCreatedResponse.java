package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

import com.plivo.helper.api.response.carrier.OutgoingCarrierRoutingErrorMessage;

public class OutgoingCarrierRoutingCreatedResponse {
	@SerializedName("server_code")
	public Integer serverCode ;

	@SerializedName("api_id")
	public String apiId ;

    public Object routes ;
    
	public String message ;

	public OutgoingCarrierRoutingErrorMessage error ;
    
    public OutgoingCarrierRoutingCreatedResponse() {
        // empty
    }

	@Override
	public String toString() {
		return "OutgoingCarrierRoutingCreatedResponse [serverCode="
				+ serverCode + ", apiId=" + apiId + ", routes=" + routes
				+ ", message=" + message + ", error=" + error + "]";
	}
}

