package com.plivo.helper.resource;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;

public class Message extends Resource {
	@SerializedName("cloud_rate")
	private String cloudRate;

	@SerializedName("carrier_rate")
	private String carrierRate;

	@SerializedName("message_direction")
	private String messageDirection;

	@SerializedName("to_number")
	private String toNumber;

	@SerializedName("message_state")
	private String messageState;

	@SerializedName("total_amount")
	private String totalAmount;

	@SerializedName("from_number")
	private String fromNumber;

	@SerializedName("message_uuid")
	private String messageUUID;

	@SerializedName("message_time")
	private String messageTime;

	@SerializedName("message_type")
	private String messageType;

	private static final String baseLoc = "/Message/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Get a specific message recording
	 * 
	 * @see http://plivo.com/docs/api/message/#message_rec
	 * @param id
	 *            message id
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server.
	 */
	public static Message get(String id, PlivoRestConf conf)
			throws PlivoException, APIException {
		Message m = getRequest(getIdLoc(id), new HashMap<String, String>(),
				Message.class, conf, 200);
		m.setConf(conf);
		return m;
	}

	/**
	 * Get all messages recording
	 * 
	 * @see http://plivo.com/docs/api/message/#messages_rec
	 * @param params
	 *            optional params
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static MessageList getList(Map<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		MessageList ml = getRequest(baseLoc, params, MessageList.class, conf,
				200);
		ml.setConf(conf);
		return ml;
	}

	/**
	 * Send message
	 * 
	 * @see http://plivo.com/docs/api/message/#message
	 * @param params
	 *            Message parameters
	 * @param conf
	 *            Plivo REST Config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void send(Map<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequest(baseLoc, params, MessageList.class, conf);
	}

	public String getCloudRate() {
		return cloudRate;
	}

	public String getCarrierRate() {
		return carrierRate;
	}

	public String getMessageDirection() {
		return messageDirection;
	}

	public String getToNumber() {
		return toNumber;
	}

	public String getMessageState() {
		return messageState;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public String getMessageUUID() {
		return messageUUID;
	}

	public String getMessageTime() {
		return messageTime;
	}

	public String getMessageType() {
		return messageType;
	}

}
