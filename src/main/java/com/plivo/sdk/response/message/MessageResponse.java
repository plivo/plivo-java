package com.plivo.sdk.response.message;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {
    public String message ;
    
    @SerializedName("message_uuid")
    public List<String> messageUUID ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiID ;
    
    public MessageResponse() {
        // TODO Auto-generated constructor stub
    }
}
