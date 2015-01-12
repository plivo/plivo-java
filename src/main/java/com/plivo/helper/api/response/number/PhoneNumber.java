package com.plivo.helper.api.response.number;

import com.google.gson.annotations.SerializedName;

public class PhoneNumber {
    public String country ;
    
    public Integer lata ;
    
    @SerializedName("monthly_rental_rate")
    public String monthlyRentalRrate ;
    
    public String number;
    
    public String type;
    
    @SerializedName("prefix")
    public String numberPrefix ;
    
    @SerializedName("rate_center")
    public String rateCenter;

    public String region;
    
    @SerializedName("resource_uri")
    public String resourceURI;

    public String restriction;
    
    @SerializedName("restriction_text")
    public String restriction_text;
    
    @SerializedName("setup_rate")
    public String setupRate ;
    
    @SerializedName("voice_enabled")
    public Boolean isVoiceEnabled;
    
    @SerializedName("sms_enabled")
    public Boolean isSmsEnabled;
    
    @SerializedName("voice_rate")
    public String voiceRate ;
    
    @SerializedName("sms_rate")
    public String smsRate ;

    public PhoneNumber() {
        // empty
    }
}
