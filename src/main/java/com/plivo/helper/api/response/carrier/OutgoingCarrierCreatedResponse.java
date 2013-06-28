package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.api.response.carrier.OutgoingCarrierErrorMessage;

public class OutgoingCarrierCreatedResponse {
	@SerializedName("server_code")
	public Integer serverCode ;

	@SerializedName("api_id")
	public String apiId ;

    @SerializedName("carrier_id")
    public Object carrierId ;
    
	public String message ;

	public OutgoingCarrierErrorMessage error ;
    
    public OutgoingCarrierCreatedResponse() {
        // empty
    }
}

