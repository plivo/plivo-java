package com.plivo.helper.api.response.call;

import com.google.gson.annotations.SerializedName;

public class CDR {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("bill_duration")
    public Integer billDuration ;
    
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
}