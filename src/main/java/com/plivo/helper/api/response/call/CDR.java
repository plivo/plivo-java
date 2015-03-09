package com.plivo.helper.api.response.call;

import com.google.gson.annotations.SerializedName;

public class CDR {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("bill_duration")
    public Integer billDuration ;
    
    @SerializedName("billed_duration")
    public Integer billedDuration ;
   
    @SerializedName("call_duration")
    public Integer callDuration ;
    
    @SerializedName("total_amount")
    public String totalAmount ;
    
    @SerializedName("parent_call_uuid")
    public String parentCallUUID ;
    
    @SerializedName("call_direction")
    public String callDirection ;
    
    @SerializedName("to_number")
    public String toNumber ;
    
    @SerializedName("total_rate")
    public String totalRate ;
    
    @SerializedName("from_number")
    public String fromNumber ;
    
    @SerializedName("end_time")
    public String endTime ;
    
    @SerializedName("call_uuid")
    public String callUUID ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public CDR() {
        // empty
    }

	@Override
	public String toString() {
		return "CDR [serverCode=" + serverCode + ", billDuration="
				+ billDuration + ", billedDuration=" + billedDuration
				+ ", callDuration=" + callDuration + ", totalAmount="
				+ totalAmount + ", parentCallUUID=" + parentCallUUID
				+ ", callDirection=" + callDirection + ", toNumber=" + toNumber
				+ ", totalRate=" + totalRate + ", fromNumber=" + fromNumber
				+ ", endTime=" + endTime + ", callUUID=" + callUUID
				+ ", resourceUri=" + resourceUri + ", error=" + error
				+ ", apiId=" + apiId + "]";
	}
    
}