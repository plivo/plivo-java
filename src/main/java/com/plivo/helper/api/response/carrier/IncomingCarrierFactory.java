package com.plivo.helper.api.response.carrier;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.carrier.IncomingCarrier;
import com.plivo.helper.api.response.carrier.IncomingCarrierMeta;

public class IncomingCarrierFactory {
	public IncomingCarrierMeta meta ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<IncomingCarrier> incomingCarrierList ;
    
    public String error;
    
    public IncomingCarrierFactory() {
    	// empty
    }
}
