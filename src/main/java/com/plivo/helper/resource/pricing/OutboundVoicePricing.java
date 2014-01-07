package com.plivo.helper.resource.pricing;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class OutboundVoicePricing {
	@SerializedName("local")
	private Rate local;

	@SerializedName("tollfree")
	private Rate tollfree;

	@SerializedName("ip")
	private Rate ip;

	@SerializedName("rates")
	private ArrayList<RatesPrefixes> prefixesRates;
}
