package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.pricing.PhoneNumbers;
import com.plivo.helper.resource.pricing.SMSRates;
import com.plivo.helper.resource.pricing.VoiceRates;

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
	private SMSRates smsRates;

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

	public SMSRates getSmsRates() {
		return smsRates;
	}

}
