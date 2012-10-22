package com.plivo.sdk.response.number;

import com.google.gson.annotations.SerializedName;

public class Number {
    public String region ;

    @SerializedName("voice_enabled")
    public Boolean voiceEnabled ;
    
    @SerializedName("sms_enabled")
    public Boolean smsEnabled ;
    
    @SerializedName("fax_enabled")
    public Boolean faxEnabled ;
    
    public String number ;

    @SerializedName("api_id")
    public String apiID ;
    
    @SerializedName("voice_rate")
    public String voiceRate ;
    
    public String application ;

    @SerializedName("sms_rate")
    public String smsRate ;
    
    @SerializedName("number_type")
    public String numberType ;
    
    @SerializedName("sub_account")
    public String subAccount ;
    
    @SerializedName("added_on")
    public String addedOn ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("group_id")
    public String groupID ;
    
    public String prefix ;

    @SerializedName("rental_rate")
    public String rentalRate ;
    
    @SerializedName("setup_rate")
    public String setupRate ;
    
    public Integer stock ;
    
    @Deprecated
    public String country ;
    
    @Deprecated
    public Integer lata ;
    
    @Deprecated
    @SerializedName("monthly_rental_rate")
    public String monthlyRentalRrate ;
    
    public String error;
    
    public Number() {
        // empty
    }
}
