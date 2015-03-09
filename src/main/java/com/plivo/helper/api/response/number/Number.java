package com.plivo.helper.api.response.number;

import com.google.gson.annotations.SerializedName;

public class Number {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String region ;

    @SerializedName("voice_enabled")
    public Boolean isVoiceEnabled ;
    
    @SerializedName("sms_enabled")
    public Boolean isSmsEnabled ;
    
    @SerializedName("fax_enabled")
    public Boolean isFaxEnabled ;
    
    public String number ;

    @SerializedName("api_id")
    public String apiId ;
    
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
    
    @SerializedName("prefix")
    public String numberPrefix ;

    @SerializedName("rental_rate")
    public String rentalRate ;
    
    @SerializedName("setup_rate")
    public String setupRate ;
    
    @Deprecated
    public String country ;
    
    @Deprecated
    public Integer lata ;
    
    @Deprecated
    @SerializedName("monthly_rental_rate")
    public String monthlyRentalRrate ;
    
    public String error;

    @SerializedName("carrier")
    public String inboundCarrier ;
    
    public Number() {
        // empty
    }

	@Override
	public String toString() {
		return "Number [serverCode=" + serverCode + ", region=" + region
				+ ", isVoiceEnabled=" + isVoiceEnabled + ", isSmsEnabled="
				+ isSmsEnabled + ", isFaxEnabled=" + isFaxEnabled + ", number="
				+ number + ", apiId=" + apiId + ", voiceRate=" + voiceRate
				+ ", application=" + application + ", smsRate=" + smsRate
				+ ", numberType=" + numberType + ", subAccount=" + subAccount
				+ ", addedOn=" + addedOn + ", resourceUri=" + resourceUri
				+ ", numberPrefix=" + numberPrefix + ", rentalRate="
				+ rentalRate + ", setupRate=" + setupRate + ", country="
				+ country + ", lata=" + lata + ", monthlyRentalRrate="
				+ monthlyRentalRrate + ", error=" + error + ", inboundCarrier="
				+ inboundCarrier + "]";
	}
}
