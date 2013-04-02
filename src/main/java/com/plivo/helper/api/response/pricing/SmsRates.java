package com.plivo.helper.api.response.pricing;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.InboundSmsPricing;
import com.plivo.helper.api.response.pricing.OutboundSmsPricing;

public class SmsRates {
	@SerializedName("inbound")
	public InboundSmsPricing inboundSms ;
	
	@SerializedName("outbound")
	public OutboundSmsPricing outboundSms ;
	
	public SmsRates() {
		// empty
	}
}
