package com.plivo.helper.api.response.call;

import com.google.gson.annotations.SerializedName;

public class Call {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String message;
    
    @SerializedName("request_uuid")
    public String requestUUID ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error;
    
    public Call() {
        // empty
    }

	@Override
	public String toString() {
		return "Call [serverCode=" + serverCode + ", message=" + message
				+ ", requestUUID=" + requestUUID + ", apiId=" + apiId
				+ ", error=" + error + "]";
	}
    
}
