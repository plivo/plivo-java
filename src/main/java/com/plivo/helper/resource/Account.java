package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.Response;

public class Account extends Resource {
	private String city;

	private String name;

	@SerializedName("cash_credits")
	private String cashCredits;

	private String created;

	private String enabled;

	private String modified;

	private String postpaid;

	private String state;

	private String address;

	private String timezone;

	@SerializedName("auth_id")
	private String authID;

	/**
	 * Get account details
	 * 
	 * @see http://plivo.com/docs/api/account/#detail
	 * @param conf
	 *            Plivo REST config
	 * @return account details
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static Account get(PlivoRestConf conf) throws PlivoException,
			APIException {
		Account a = getRequest("/", new LinkedHashMap<String, String>(),
				Account.class, conf);
		a.conf = conf;
		return a;
	}

	/**
	 * Modify an account
	 * 
	 * @see http://plivo.com/docs/api/account/#modify
	 * @param authId
	 *            Auth ID
	 * @param params
	 *            modification parameters
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void modify(String authId,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect("/" + authId + "/", params, Response.class, conf, 202);
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public String getCashCredits() {
		return cashCredits;
	}

	public String getCreated() {
		return created;
	}

	public String getEnabled() {
		return enabled;
	}

	public String getModified() {
		return modified;
	}

	public String getPostpaid() {
		return postpaid;
	}

	public String getState() {
		return state;
	}

	public String getAddress() {
		return address;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getAuthID() {
		return authID;
	}
}
