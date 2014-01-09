package com.plivo.helper.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MessageSendResponse extends Response {
	@SerializedName("message_uuid")
	private List<String> uuidList;

	public List<String> getUuidList() {
		return uuidList;
	}

}
