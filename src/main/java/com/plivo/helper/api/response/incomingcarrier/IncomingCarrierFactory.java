package com.plivo.helper.api.response.incomingcarrier;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.incomingcarrier.IncomingCarrier;
import com.plivo.helper.api.response.incomingcarrier.IncomingCarrierMeta;

public class IncomingCarrierFactory {
	public IncomingCarrierMeta meta ;

    @SerializedName("api_id")
    public String apiID ;
    
    @SerializedName("objects")
    public List<IncomingCarrier> incomingCarrierList ;
    
    public String error;
    
    public IncomingCarrierFactory() {
    	// empty
    }
}
