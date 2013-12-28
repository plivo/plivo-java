package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class RecordResponse extends Response {
	private String url;

	@SerializedName("recording_id")
	private String recordingId;

	@Override
	public boolean isSuccessful() {
		return serverCode == 202 && error == null;
	}

	public String getUrl() {
		return url;
	}

	public String getRecordingId() {
		return recordingId;
	}

}
