package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public abstract class CreateResponse {
	@SerializedName("server_code")
	private Integer serverCode ;
    
    @SerializedName("api_id")
    private String apiID ;
    
    @SerializedName("message")
    private String message;
    
    @SerializedName("error")
    private String error;


    public boolean isCreated() {
    	return serverCode == 201 && error == null;
    }
    
	public Integer getServerCode() {
		return serverCode;
	}

	public String getApiID() {
		return apiID;
	}

	public String getMessage() {
		return message;
	}

    
}
