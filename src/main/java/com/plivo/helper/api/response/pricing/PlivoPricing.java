package com.plivo.helper.api.response.pricing;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.PhoneNumbers;
import com.plivo.helper.api.response.pricing.VoiceRates;
import com.plivo.helper.api.response.pricing.SmsRates;

public class PlivoPricing {
	@SerializedName("server_code")
	public Integer serverCode ;

	@SerializedName("country_code")
	public String countryCode ;
	
	@SerializedName("country_iso")
	public String countryIso;
	
	public String country ;
	
	@SerializedName("api_id")
	public String apiId ;
	
	@SerializedName("phone_numbers")
	public PhoneNumbers phoneNumbers ;
	
	@SerializedName("voice")
	public VoiceRates voiceRates ;
	
	@SerializedName("message")
	public SmsRates smsRates ;
	
	public PlivoPricing() {
		// empty
	}

	@Override
	public String toString() {
		return "PlivoPricing [serverCode=" + serverCode + ", countryCode="
				+ countryCode + ", countryIso=" + countryIso + ", country="
				+ country + ", apiId=" + apiId + ", phoneNumbers="
				+ phoneNumbers + ", voiceRates=" + voiceRates + ", smsRates="
				+ smsRates + "]";
	}
}
