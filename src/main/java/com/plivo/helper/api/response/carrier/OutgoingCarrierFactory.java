package com.plivo.helper.api.response.carrier;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.carrier.OutgoingCarrier;
import com.plivo.helper.api.response.carrier.OutgoingCarrierMeta;

public class OutgoingCarrierFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

	public OutgoingCarrierMeta meta ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<OutgoingCarrier> outgoingCarrierList ;
    
    public String error;
    
    public OutgoingCarrierFactory() {
    	// empty
    }

	@Override
	public String toString() {
		return "OutgoingCarrierFactory [serverCode=" + serverCode + ", meta="
				+ meta + ", apiId=" + apiId + ", outgoingCarrierList="
				+ outgoingCarrierList + ", error=" + error + "]";
	}
}
