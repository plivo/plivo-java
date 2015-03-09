package com.plivo.helper.api.response.call;

import com.google.gson.annotations.SerializedName;

public class LiveCall {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String direction ;
    
    public String from ;
    
    @SerializedName("call_status")
    public String callStatus ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String to ;

    @SerializedName("caller_name")
    public String callerName ;
    
    @SerializedName("call_uuid")
    public String callUuuid ;
    
    @SerializedName("session_start")
    public String sessionStart ;
    
    public String error ;
    
    public LiveCall() {
        // empty
    }

	@Override
	public String toString() {
		return "LiveCall [serverCode=" + serverCode + ", direction="
				+ direction + ", from=" + from + ", callStatus=" + callStatus
				+ ", apiId=" + apiId + ", to=" + to + ", callerName="
				+ callerName + ", callUuuid=" + callUuuid + ", sessionStart="
				+ sessionStart + ", error=" + error + "]";
	}
    
}
