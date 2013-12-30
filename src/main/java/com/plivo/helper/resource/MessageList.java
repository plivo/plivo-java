package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.message.Message;
import com.plivo.helper.api.response.message.MessageMeta;

public class MessageList extends Resource {

	private MessageMeta meta;

	@SerializedName("objects")
	private List<Message> list;

	public MessageMeta getMeta() {
		return meta;
	}

	public List<Message> getList() {
		return list;
	}

}
