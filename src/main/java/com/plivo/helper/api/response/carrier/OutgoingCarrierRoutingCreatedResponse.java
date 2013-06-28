package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.api.response.carrier.OutgoingCarrierRoutingErrorMessage;

public class OutgoingCarrierRoutingCreatedResponse {
	@SerializedName("server_code")
	public Integer serverCode ;

	@SerializedName("api_id")
	public String apiId ;

    @SerializedName("routes")
    public Object routes ;
    
	public String message ;

	public OutgoingCarrierRoutingErrorMessage error ;
    
    public OutgoingCarrierRoutingCreatedResponse() {
        // empty
    }
}

