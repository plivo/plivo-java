package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.CallCreateResponse;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;
import com.plivo.helper.response.RecordResponse;
import com.plivo.helper.response.Response;
import com.plivo.helper.util.HtmlEntity;

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

	/**
	 * Record a call.
	 * 
	 * @see http://plivo.com/docs/api/call/record/#record
	 * @param callUUID
	 *            uuid of the call
	 * @param params
	 *            optionals params
	 * @param conf
	 *            Plivo REST config
	 * @return tru
	 * @throws PlivoException
	 */
	public static boolean record(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		RecordResponse r = gson.fromJson(
				request("POST",
						String.format(baseLoc + "%s/Record/", callUUID),
						params, conf), RecordResponse.class);
		return r.isSuccessful();
	}

	/**
	 * Stop recording a call.
	 * 
	 * @see http://plivo.com/docs/api/call/record/#stoprecord
	 * @param callUUID
	 *            uuid of the call.
	 * @param params
	 *            optional params.
	 * @param conf
	 *            Plivo REST config
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean stopRecord(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("DELETE",
						String.format(baseLoc + "%s/Record/", callUUID),
						params, conf), Response.class);
		return r.getServerCode() == 204;
	}

	/**
	 * Play a sounds during a call.
	 * 
	 * @see http://plivo.com/docs/api/call/play/#play
	 * @param callUUID
	 *            uuid of the call
	 * @param parameters
	 *            optional parameters
	 * @param conf
	 *            Plivo REST config
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean play(String callUUID,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("POST", String.format(baseLoc + "%s/Play/", callUUID),
						parameters, conf), Response.class);
		return r.getServerCode() == 202;
	}

	/**
	 * Stop playing sound during a call.
	 * 
	 * @see http://plivo.com/docs/api/call/play/#stopplay
	 * @param callUUID
	 *            uuid of the call.
	 * @param conf
	 *            Plivo REST config
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean stopPlay(String callUUID, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("POST", String.format(baseLoc + "%s/Play/", callUUID),
						new LinkedHashMap<String, String>(), conf),
				Response.class);
		return r.getServerCode() == 202;
	}

	/**
	 * Play Text During a Call (Text to Speech).
	 * 
	 * @see http://plivo.com/docs/api/call/speak/#play
	 * @param callUUID
	 *            uuid of the call
	 * @param parameters
	 *            parameters
	 * @param conf
	 *            plivo rest config
	 * @return true if successful.
	 * @throws PlivoException
	 */
	public static boolean speak(String callUUID,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		String text = HtmlEntity.convert(getKeyValue(parameters, "text"));
		parameters.put("text", text);
		Response r = gson.fromJson(
				request("POST", String.format(baseLoc + "%s/Speak/", callUUID),
						parameters, conf), Response.class);
		return r.getServerCode() == 202;
	}

	/**
	 * Stop Playing Text During a Call.
	 * 
	 * @see http://plivo.com/docs/api/call/speak/#stopplay
	 * @param callUUID
	 *            uuid of the call.
	 * @param conf
	 *            plivo rest config
	 * @return true if successful.
	 * @throws PlivoException
	 */
	public static boolean stopSpeak(String callUUID, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("DELETE",
						String.format(baseLoc + "%s/Speak/", callUUID),
						new LinkedHashMap<String, String>(), conf),
				Response.class);
		return r.getServerCode() == 202;
	}

	/**
	 * Send digits on a call
	 * 
	 * @see http://plivo.com/docs/api/call/dtmf/
	 * @param callUUID
	 *            uuid of the call
	 * @param params
	 *            parameters
	 * @param conf
	 *            Plivo REST config
	 * @return true if successful.
	 * @throws PlivoException
	 */
	public static boolean sendDigits(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("POST", String.format(baseLoc + "%s/DTMF/", callUUID),
						params, conf), Response.class);
		return r.getServerCode() == 202;
	}

	/**
	 * Hangup a call request.
	 * 
	 * @see http://plivo.com/docs/api/call/request/
	 * @param requestUUID
	 *            uuid of call request.
	 * @param conf
	 *            Plivo REST config
	 * @return true if successful
	 * @throws PlivoException
	 */
	public static boolean hangupCallRequest(String requestUUID,
			PlivoRestConf conf) throws PlivoException {
		Gson gson = new Gson();
		Response r = gson.fromJson(
				request("DELETE", String.format("/Request/%s/", requestUUID),
						new LinkedHashMap<String, String>(), conf),
				Response.class);
		return r.getServerCode() == 204;
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
