package com.plivo.helper.resource;

import com.google.gson.annotations.SerializedName;

public class ConferenceMember {
	private Boolean muted;

	@SerializedName("member_id")
	private String memberId;

	private Boolean deaf;

	private String from;

	private String to;

	@SerializedName("caller_name")
	private String callerName;

	private String direction;

	@SerializedName("call_uuid")
	private String callUUID;

	@SerializedName("join_time")
	private String joinTime;

	public Boolean getMuted() {
		return muted;
	}

	public String getMemberId() {
		return memberId;
	}

	public Boolean getDeaf() {
		return deaf;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getCallerName() {
		return callerName;
	}

	public String getDirection() {
		return direction;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public String getJoinTime() {
		return joinTime;
	}

}
