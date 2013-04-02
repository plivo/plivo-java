package com.plivo.helper.api.response.message;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("cloud_rate")
    public String cloudRate ;
    
    @SerializedName("carrier_rate")
    public String carrierRate ;
    
    @SerializedName("message_direction")
    public String messageDirection ;
    
    @SerializedName("to_number")
    public String toNumber ;
    
    @SerializedName("message_state")
    public String messageState ;
    
    @SerializedName("total_amount")
    public String totalAmount ;
    
    @SerializedName("from_number")
    public String fromNumber ;
    
    @SerializedName("message_uuid")
    public String messageUUID ;
    
    @SerializedName("message_time")
    public String messageTime ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("message_type")
    public String messageType ;
    
    public String error ;

    @SerializedName("api_id")
    public String apiID ;
    
    public Message() {
        // empty
    }
}
