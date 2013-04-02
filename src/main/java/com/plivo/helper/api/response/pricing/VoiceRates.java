package com.plivo.helper.api.response.pricing;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.InboundVoicePricing;
import com.plivo.helper.api.response.pricing.OutboundVoicePricing;

public class VoiceRates {
	@SerializedName("inbound")	
	public InboundVoicePricing voiceInbound ;

	@SerializedName("outbound")	
	public OutboundVoicePricing voiceOutbound ;
	
	public VoiceRates() {
		// empty
	}
}
