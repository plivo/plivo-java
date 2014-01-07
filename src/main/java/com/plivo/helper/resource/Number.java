package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;

public class Number extends Resource {
	private String region;

	@SerializedName("voice_enabled")
	private Boolean isVoiceEnabled;

	@SerializedName("sms_enabled")
	private Boolean isSmsEnabled;

	@SerializedName("fax_enabled")
	private Boolean isFaxEnabled;

	private String number;

	@SerializedName("voice_rate")
	private String voiceRate;

	private String application;

	@SerializedName("sms_rate")
	private String smsRate;

	@SerializedName("number_type")
	private String numberType;

	@SerializedName("sub_account")
	private String subAccount;

	@SerializedName("added_on")
	private String addedOn;

	@SerializedName("prefix")
	private String numberPrefix;

	@SerializedName("rental_rate")
	private String rentalRate;

	@SerializedName("setup_rate")
	private String setupRate;

	@Deprecated
	private String country;

	@Deprecated
	private Integer lata;

	@Deprecated
	@SerializedName("monthly_rental_rate")
	private String monthlyRentalRrate;

	@SerializedName("carrier")
	private String inboundCarrier;

	private static String baseLoc = "/Number/";

	private static String getIdLoc(String number) {
		return baseLoc + number + "/";
	}

	/**
	 * Get details of a rented number
	 * 
	 * @see http://plivo.com/docs/api/numbers/number/#number_detail
	 * @param number
	 *            the number
	 * @param conf
	 *            Plivo REST config
	 * @return rented number
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server.
	 */
	public static Number get(String number, PlivoRestConf conf)
			throws PlivoException, APIException {
		Number n = getRequest(getIdLoc(number),
				new LinkedHashMap<String, String>(), Number.class, conf);
		n.setConf(conf);
		return n;
	}

	/**
	 * List all rented numbers
	 * 
	 * @see http://plivo.com/docs/api/numbers/number/#number_list
	 * @param params
	 *            optional params
	 * @param conf
	 *            Plivo REST config
	 * @return number list
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static NumberList getList(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		NumberList nl = getRequest(baseLoc, params, NumberList.class, conf);
		nl.setConf(conf);
		return nl;
	}

	/**
	 * Add a number from your own carrier
	 * 
	 * @see http://plivo.com/docs/api/numbers/number/#carrier_number_add
	 * @param params
	 *            number parameters
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public static void addFromCarrier(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		postRequestExpect(baseLoc, params, NumberList.class, conf, 202);
	}

	/**
	 * Edit a number
	 * 
	 * @see http://plivo.com/docs/api/numbers/number/#number_edit
	 * @param number
	 *            number to edit
	 * @param params
	 *            edit parameters
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void edit(String number,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(getIdLoc(number), params, Number.class, conf, 202);
	}

	/**
	 * Unrent a number
	 * 
	 * @see http://plivo.com/docs/api/numbers/number/#number_unrent
	 * @param number
	 *            number to unrent
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void unrent(String number, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(getIdLoc(number),
				new LinkedHashMap<String, String>(), Number.class, conf, 204);
	}

	public String getRegion() {
		return region;
	}

	public Boolean getIsVoiceEnabled() {
		return isVoiceEnabled;
	}

	public Boolean getIsSmsEnabled() {
		return isSmsEnabled;
	}

	public Boolean getIsFaxEnabled() {
		return isFaxEnabled;
	}

	public String getNumber() {
		return number;
	}

	public String getVoiceRate() {
		return voiceRate;
	}

	public String getApplication() {
		return application;
	}

	public String getSmsRate() {
		return smsRate;
	}

	public String getNumberType() {
		return numberType;
	}

	public String getSubAccount() {
		return subAccount;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public String getNumberPrefix() {
		return numberPrefix;
	}

	public String getRentalRate() {
		return rentalRate;
	}

	public String getSetupRate() {
		return setupRate;
	}

	public String getCountry() {
		return country;
	}

	public Integer getLata() {
		return lata;
	}

	public String getMonthlyRentalRrate() {
		return monthlyRentalRrate;
	}

	public String getInboundCarrier() {
		return inboundCarrier;
	}

}
