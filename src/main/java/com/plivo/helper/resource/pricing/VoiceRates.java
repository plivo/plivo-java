package com.plivo.helper.resource.pricing;

import com.google.gson.annotations.SerializedName;

public class VoiceRates {
	@SerializedName("inbound")
	private InboundVoicePricing inbound;

	@SerializedName("outbound")
	private OutboundVoicePricing outbound;
}
