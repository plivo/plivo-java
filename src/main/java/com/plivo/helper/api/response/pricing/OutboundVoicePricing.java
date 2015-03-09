package com.plivo.helper.api.response.pricing;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.LocalOutboundPricing;
import com.plivo.helper.api.response.pricing.TollfreeOutboundPricing;
import com.plivo.helper.api.response.pricing.SipOutboundPricing;

public class OutboundVoicePricing {
	@SerializedName("local")
	public LocalOutboundPricing localOutbound ;
	
	@SerializedName("tollfree")
	public TollfreeOutboundPricing tollfreeOutbound ;
	
	@SerializedName("ip")
	public SipOutboundPricing ipOutbound ;
	
	@SerializedName("rates")
	public ArrayList<RatesPrefixes> prefixesRates ;
	
	public OutboundVoicePricing() {
		// empty
	}

	@Override
	public String toString() {
		return "OutboundVoicePricing [localOutbound=" + localOutbound
				+ ", tollfreeOutbound=" + tollfreeOutbound + ", ipOutbound="
				+ ipOutbound + ", prefixesRates=" + prefixesRates + "]";
	}
}
