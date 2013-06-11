package com.plivo.helper.api.response.message;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String message ;
    
    @SerializedName("message_uuid")
    public List<String> messageUuids ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public MessageResponse() {
        // TODO Auto-generated constructor stub
    }
}
