package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public class Endpoint extends Resource {
	private String username;

	@SerializedName("sip_uri")
	private String sipUri;

	private String alias;

	@SerializedName("endpoint_id")
	private String endpointId;

	private String password;

	@SerializedName("resource_uri")
	private String resourceUri;

	private static String baseLoc = "/Endpoint/";

	public static Endpoint get(String endpointId, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Endpoint e = gson.fromJson(
				request("GET", String.format(baseLoc + "%s/", endpointId),
						new LinkedHashMap<String, String>(), conf),
				Endpoint.class);
		if (e.isGetOK()) {
			e.conf = conf;
			return e;
		}
		return null;
	}

	public static EndpointList getList(PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		EndpointList el = gson.fromJson(
				request("GET", baseLoc, new LinkedHashMap<String, String>(),
						conf), EndpointList.class);
		if (el.isGetOK()) {
			el.conf = conf;
			return el;
		}
		return null;
	}

	public String getUsername() {
		return username;
	}

	public String getSipUri() {
		return sipUri;
	}

	public String getAlias() {
		return alias;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getPassword() {
		return password;
	}

	public String getResourceUri() {
		return resourceUri;
	}
}
