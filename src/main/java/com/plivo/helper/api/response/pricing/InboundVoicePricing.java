package com.plivo.helper.api.response.pricing;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.LocalInboundPricing;
import com.plivo.helper.api.response.pricing.TollfreeInboundPricing;

public class InboundVoicePricing {
	@SerializedName("local")
	public LocalInboundPricing localInbound ;
	
	@SerializedName("tollfree")
	public TollfreeInboundPricing tollfreeInbound ;
	
	@SerializedName("ip")
	public SipInboundPricing ipInboundRate ;
	
	public InboundVoicePricing() {
		// empty
	}

	@Override
	public String toString() {
		return "InboundVoicePricing [localInbound=" + localInbound
				+ ", tollfreeInbound=" + tollfreeInbound + ", ipInboundRate="
				+ ipInboundRate + "]";
	}
}
