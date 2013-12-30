package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.api.response.pricing.PhoneNumbers;
import com.plivo.helper.api.response.pricing.SmsRates;
import com.plivo.helper.api.response.pricing.VoiceRates;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class Pricing extends Resource {
	@SerializedName("country_code")
	private String countryCode;

	@SerializedName("country_iso")
	private String countryIso;

	private String country;

	@SerializedName("phone_numbers")
	private PhoneNumbers phoneNumbers;

	@SerializedName("voice")
	private VoiceRates voiceRates;

	@SerializedName("message")
	private SmsRates smsRates;

	private static final String baseLoc = "/Pricing/";

	public static Pricing get(String countryIso, PlivoRestConf restConf)
			throws PlivoException, APIException {
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("country_iso", countryIso);
		Pricing p = getRequest(baseLoc, params, Pricing.class, restConf, 200);
		p.conf = restConf;
		return p;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public String getCountry() {
		return country;
	}

	public PhoneNumbers getPhoneNumbers() {
		return phoneNumbers;
	}

	public VoiceRates getVoiceRates() {
		return voiceRates;
	}

	public SmsRates getSmsRates() {
		return smsRates;
	}

}
