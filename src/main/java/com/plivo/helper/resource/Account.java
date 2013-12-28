package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public class Account extends Resource {
	private String city;

	private String name;

	@SerializedName("cash_credits")
	private String cashCredits;

	private String created;

	private String enabled;

	private String modified;

	@SerializedName("api_id")
	private String apiId;

	private String postpaid;

	private String state;

	private String address;

	private String timezone;

	@SerializedName("auth_id")
	private String authID;

	@SerializedName("resource_uri")
	private String resourceURI;

	public static Account get(PlivoRestConf conf) throws PlivoException {
		Gson gson = new Gson();
		String resp = request("GET", "/", new LinkedHashMap<String, String>(),
				conf);
		Account a = gson.fromJson(resp, Account.class);
		if (a.isGetOK()) {
			a.conf = conf;
			return a;
		} else {
			return null;
		}
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

	public String getApiId() {
		return apiId;
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

	public String getResourceURI() {
		return resourceURI;
	}

}
