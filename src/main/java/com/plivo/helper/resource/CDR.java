package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class CDR extends Resource {
	@SerializedName("bill_duration")
	private Integer billDuration;

	@SerializedName("billed_duration")
	private Integer billedDuration;

	@SerializedName("call_duration")
	private Integer callDuration;

	@SerializedName("total_amount")
	private String totalAmount;

	@SerializedName("parent_call_uuid")
	private String parentCallUUID;

	@SerializedName("call_direction")
	private String callDirection;

	@SerializedName("to_number")
	private String toNumber;

	@SerializedName("total_rate")
	private String totalRate;

	@SerializedName("from_number")
	private String fromNumber;

	@SerializedName("end_time")
	private String endTime;

	@SerializedName("call_uuid")
	private String callUUID;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("api_id")
	private String apiId;

	private static String baseLoc = "/Call/";

	protected static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	public static CDR get(String recordId, PlivoRestConf conf)
			throws PlivoException, APIException {
		CDR cdr = getRequest(getIdLoc(recordId),
				new LinkedHashMap<String, String>(), CDR.class, conf);
		cdr.conf = conf;
		return cdr;

	}

	public static CDRList getList(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		CDRList cdrList = getRequest(baseLoc, params, CDRList.class, conf);
		cdrList.conf = conf;
		return cdrList;

	}

	public Integer getBillDuration() {
		return billDuration;
	}

	public Integer getBilledDuration() {
		return billedDuration;
	}

	public Integer getCallDuration() {
		return callDuration;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public String getParentCallUUID() {
		return parentCallUUID;
	}

	public String getCallDirection() {
		return callDirection;
	}

	public String getToNumber() {
		return toNumber;
	}

	public String getTotalRate() {
		return totalRate;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public String getApiId() {
		return apiId;
	}
}
