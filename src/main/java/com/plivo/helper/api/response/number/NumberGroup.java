package com.plivo.helper.api.response.number;

import com.google.gson.annotations.SerializedName;

public class NumberGroup {
	@SerializedName("group_id")
	public String groupId ;
	
	@SerializedName("number_type")
	public String numberType ;
	
	@SerializedName("rental_rate")
	public String rentalRate ;
	
	@SerializedName("setup_rate")
	public String setupRate ;
	
	@SerializedName("resource_uri")
	public String resourceUri ;
	
	@SerializedName("sms_enabled")
	public Boolean isSmsEnabled ;
	
	@SerializedName("sms_rate")
	public String smsRate ;
	
	@SerializedName("voice_enabled")
	public Boolean isVoiceEnabled ;
	
	@SerializedName("voice_rate")
	public String voiceRate ;
	
	@SerializedName("stock")
	public Integer inStock ;
	
	@SerializedName("prefix")
	public String numberPrefix ;

	public String region ;
	
	public String error ;
	
	public NumberGroup() {
		// empty
	}
}
