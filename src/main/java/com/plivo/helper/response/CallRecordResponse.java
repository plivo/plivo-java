package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class CallRecordResponse extends Response {
	private String url;

	@SerializedName("recording_id")
	private String recordingId;

	public boolean isSuccessful() {
		return this.getServerCode() == 202 && this.getError() == null;
	}

	public String getUrl() {
		return url;
	}

	public String getRecordingId() {
		return recordingId;
	}

}
