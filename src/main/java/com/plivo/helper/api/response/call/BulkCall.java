package com.plivo.helper.api.response.call;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BulkCall {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String message;
    
    @SerializedName("request_uuid")
    public List<String> requestUUID ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error;

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tserverCode: " + serverCode
				+ "\n\tmessage: " + message + "\n\trequestUUID: " + requestUUID
				+ "\n\tapiId: " + apiId + "\n\terror: " + error + "\n}";
	}

}
