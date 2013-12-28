package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.CallCreateResponse;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;

public class Call extends Resource {
	private String message;

	@SerializedName("request_uuid")
	private String requestUUID;

	@SerializedName("api_id")
	private String apiId;

	private static String baseLoc = "/Call/";

	/**
	 * Get details of a call record (CDR)
	 * 
	 * @param recordId
	 *            Record ID of the call
	 * @param conf
	 * @return CDR object if successful, null if failed.
	 * @throws PlivoException
	 */
	public static CDR getCDR(String recordId, PlivoRestConf conf)
			throws PlivoException {
		return CDR.get(recordId, conf);
	}

	/**
	 * Get all record details.
	 * 
	 * @param params
	 *            optional params.
	 * @param conf
	 * @return CDRList object if successful, null if failed.
	 * @throws PlivoException
	 */
	public static CDRList getCDRList(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException {
		return CDR.getList(params, conf);
	}

	/**
	 * Create a call.
	 * 
	 * @param params
	 * @param conf
	 * @return true if call can be fired.
	 * @throws PlivoException
	 */
	public static boolean create(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException {
		Gson gson = new Gson();
		CallCreateResponse ccr = gson.fromJson(
				request("POST", baseLoc, params, conf),
				CallCreateResponse.class);
		return ccr.isSuccessful();
	}

	/**
	 * Hangup a call.
	 * 
	 * @param callUUID
	 *            call uuid of the call
	 * @param conf
	 *            Plivo Rest Configuration
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean hangup(String callUUID, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		DeleteResponse dr = gson.fromJson(
				request("DELETE", String.format(baseLoc + "%s/", callUUID),
						new LinkedHashMap<String, String>(), conf),
				DeleteResponse.class);
		return dr.isSuccessful();
	}

	/**
	 * Hangup all calls
	 * 
	 * @param conf
	 *            Plivo Rest Config
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean hangupAll(PlivoRestConf conf) throws PlivoException {
		Gson gson = new Gson();
		DeleteResponse dr = gson.fromJson(
				request("DELETE", baseLoc, new LinkedHashMap<String, String>(),
						conf), DeleteResponse.class);
		return dr.isSuccessful();
	}

	/**
	 * Transfer a call.
	 * 
	 * @see http://plivo.com/docs/api/call/#transfer
	 * @param callUUID
	 *            call uuid of the call that will be transfered.
	 * @param params
	 *            optional parameters.
	 * @param conf
	 *            Plivo Rest Config.
	 * @return
	 * @throws PlivoException
	 */
	public static boolean transfer(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		ModifyResponse r = gson.fromJson(
				request("POST", String.format(baseLoc + "%s/", callUUID),
						params, conf), ModifyResponse.class);
		return r.isSuccessful();
	}

	/**
	 * Get details of a live call.
	 * 
	 * @param callUUID
	 *            uuid of the call
	 * @param conf
	 *            Plivo REST config
	 * @return call object if successful, null if failed.
	 * @throws PlivoException
	 */
	public static Call getLive(String callUUID, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("status", "live");
		Call call = gson.fromJson(
				request("GET", String.format(baseLoc + "%s/", callUUID),
						params, conf), Call.class);
		if (call.isGetOK()) {
			call.conf = conf;
			return call;
		}
		return null;
	}

	/**
	 * Get all live calls.
	 * 
	 * @see http://plivo.com/docs/api/call/#live
	 * @param conf
	 *            Plivo REST config.
	 * @return
	 * @throws PlivoException
	 */
	public static CallList getLiveAll(PlivoRestConf conf) throws PlivoException {
		Gson gson = new Gson();
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("status", "live");
		CallList callList = gson.fromJson(
				request("GET", baseLoc, params, conf), CallList.class);
		if (callList.isGetOK()) {
			callList.conf = conf;
			return callList;
		}
		return null;
	}

	public String getMessage() {
		return message;
	}

	public String getRequestUUID() {
		return requestUUID;
	}

	public String getApiId() {
		return apiId;
	}
}
