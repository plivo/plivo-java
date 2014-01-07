package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.response.CallCreateResponse;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.GenericResponse;
import com.plivo.helper.response.ModifyResponse;
import com.plivo.helper.response.RecordResponse;
import com.plivo.helper.util.HtmlEntity;

public class Call extends Resource {
	private String message;

	@SerializedName("request_uuid")
	private String requestUUID;

	private static String baseLoc = "/Call/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

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
			throws PlivoException, APIException {
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
			PlivoRestConf conf) throws PlivoException, APIException {
		return CDR.getList(params, conf);
	}

	/**
	 * Make an outbound call.
	 * 
	 * @see http://plivo.com/docs/api/call/#outbound
	 * @param params
	 *            call parameter
	 * @param conf
	 *            Plivo REST Config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server.
	 */
	public static void create(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		postRequestExpect(baseLoc, params, CallCreateResponse.class, conf, 200);
	}

	/**
	 * Hangup a call
	 * 
	 * @see http://plivo.com/docs/api/call/#hangupone
	 * @param callUUID
	 *            call UUID
	 * @param conf
	 *            Plivo REST Config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void hangup(String callUUID, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequest(getIdLoc(callUUID), new LinkedHashMap<String, String>(),
				DeleteResponse.class, conf);

	}

	/**
	 * Hangup all call
	 * 
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error detail from server
	 */
	public static void hangupAll(PlivoRestConf conf) throws PlivoException,
			APIException {
		deleteRequest(baseLoc, new LinkedHashMap<String, String>(),
				DeleteResponse.class, conf);
	}

	/**
	 * Transfer a call
	 * 
	 * @see http://plivo.com/docs/api/call/#transfer
	 * @param callUUID
	 *            call UUID
	 * @param params
	 *            parameters
	 * @param conf
	 *            Plivo REST Config
	 * 
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void transfer(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(String.format(baseLoc + "%s/", callUUID), params,
				ModifyResponse.class, conf, 202);
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
	 * @throws APIException
	 *             error details from server
	 */
	public static Call getLive(String callUUID, PlivoRestConf conf)
			throws PlivoException, APIException {
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("status", "live");

		Call call = getRequest(getIdLoc(callUUID), params, Call.class, conf);

		call.setConf(conf);
		return call;
	}

	/**
	 * Get all live calls.
	 * 
	 * @see http://plivo.com/docs/api/call/#live
	 * @param conf
	 *            Plivo REST config.
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static CallList getLiveAll(PlivoRestConf conf)
			throws PlivoException, APIException {
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("status", "live");
		CallList callList = getRequest(baseLoc, params, CallList.class, conf);

		callList.setConf(conf);
		return callList;
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
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void record(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(String.format(baseLoc + "%s/Record/", callUUID),
				params, RecordResponse.class, conf, 202);
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
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void stopRecord(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(String.format(baseLoc + "%s/Record/", callUUID),
				params, GenericResponse.class, conf, 204);
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
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void play(String callUUID,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(String.format(baseLoc + "%s/Play/", callUUID),
				parameters, GenericResponse.class, conf, 202);
	}

	/**
	 * Stop playing sound during a call.
	 * 
	 * @see http://plivo.com/docs/api/call/play/#stopplay
	 * @param callUUID
	 *            uuid of the call.
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void stopPlay(String callUUID, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(String.format(baseLoc + "%s/Play/", callUUID),
				new LinkedHashMap<String, String>(), GenericResponse.class,
				conf, 202);
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
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void speak(String callUUID,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {
		String text = HtmlEntity.convert(getKeyValue(parameters, "text"));
		parameters.put("text", text);
		postRequestExpect(String.format(baseLoc + "%s/Speak/", callUUID),
				parameters, GenericResponse.class, conf, 202);
	}

	/**
	 * Stop Playing Text During a Call.
	 * 
	 * @see http://plivo.com/docs/api/call/speak/#stopplay
	 * @param callUUID
	 *            uuid of the call.
	 * @param conf
	 *            plivo rest config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void stopSpeak(String callUUID, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(String.format(baseLoc + "%s/Speak/", callUUID),
				new LinkedHashMap<String, String>(), GenericResponse.class,
				conf, 202);
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
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void sendDigits(String callUUID,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(String.format(baseLoc + "%s/DTMF/", callUUID),
				params, GenericResponse.class, conf, 202);
	}

	/**
	 * Hangup a call request.
	 * 
	 * @see http://plivo.com/docs/api/call/request/
	 * @param requestUUID
	 *            uuid of call request.
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void hangupCallRequest(String requestUUID, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(String.format("/Request/%s/", requestUUID),
				new LinkedHashMap<String, String>(), GenericResponse.class,
				conf, 204);
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getRequestUUID() {
		return requestUUID;
	}
}
