package com.plivo.helper.api.response.message;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MessageFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    public MessageMeta meta ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<Message> messageList ;
    
    public String error;
    
    public MessageFactory() {
        // empty
    }

	@Override
	public String toString() {
		return "MessageFactory [serverCode=" + serverCode + ", meta=" + meta
				+ ", apiId=" + apiId + ", messageList=" + messageList
				+ ", error=" + error + "]";
	}
}
