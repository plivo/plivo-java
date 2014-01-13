package com.plivo.helper.resource;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;

public class Recording extends Resource {
	@SerializedName("recording_id")
	private String id;

	private String conferenceName;

	@SerializedName("recording_type")
	private String recordingType;

	@SerializedName("recording_format")
	private String recordingFormat;

	@SerializedName("call_uuid")
	private String callUUID;

	@SerializedName("recording_url")
	private String recordingURL;

	@SerializedName("add_time")
	private String addTime;

	@SerializedName("recording_start_ms")
	private String recordingStartMs;

	@SerializedName("recording_end_ms")
	private String recordingEndMs;

	@SerializedName("recording_duration_ms")
	private String recordingDurationMs;

	private static String baseLoc = "/Recording/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Get a particular recording
	 * 
	 * @see http://plivo.com/docs/api/recording/#list_one
	 * @param id
	 *            recording id
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static Recording get(String id, PlivoRestConf conf)
			throws PlivoException, APIException {
		Recording r = getRequest(getIdLoc(id), new HashMap<String, Object>(),
				Recording.class, conf);
		r.setConf(conf);
		return r;
	}

	public String getId() {
		return id;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public String getRecordingType() {
		return recordingType;
	}

	public String getRecordingFormat() {
		return recordingFormat;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public String getRecordingURL() {
		return recordingURL;
	}

	public String getAddTime() {
		return addTime;
	}

	public String getRecordingStartMs() {
		return recordingStartMs;
	}

	public String getRecordingEndMs() {
		return recordingEndMs;
	}

	public String getRecordingDurationMs() {
		return recordingDurationMs;
	}

}
