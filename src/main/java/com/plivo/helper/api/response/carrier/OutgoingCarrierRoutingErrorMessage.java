package com.plivo.helper.api.response.carrier;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OutgoingCarrierRoutingErrorMessage {
    public List<String> prefixes ;
    
    public List<String> priority ;
    
    @SerializedName("outgoing_carrier")
    public List<String> outgoingCarrier ;
    
    public String error;
    
    public OutgoingCarrierRoutingErrorMessage() {
        // empty
    }

}