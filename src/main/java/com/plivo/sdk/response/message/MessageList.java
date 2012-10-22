package com.plivo.sdk.response.message;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MessageList {
    public MessageMeta meta ;

    @SerializedName("api_id")
    public String apiID ;
    
    @SerializedName("objects")
    public List<Message> messageList ;
    
    public String error;
    
    public MessageList() {
        // empty
    }
}
