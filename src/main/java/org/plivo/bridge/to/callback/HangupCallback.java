package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

public class HangupCallback implements Serializable {

	private static final long serialVersionUID = 7437844399059919787L;
	
	private String from;
	
	private String to;
	
	private CallDirection direction;
	
	private String alegUUID;
	
	private HangupReason reason;
	
	private String callUUID;
	
	private String alegRequestUUID;
	
	private String requestUUID;
	
	private CallStatus status;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public CallDirection getDirection() {
		return direction;
	}

	public void setDirection(CallDirection direction) {
		this.direction = direction;
	}

	public String getAlegUUID() {
		return alegUUID;
	}

	public void setAlegUUID(String alegUUID) {
		this.alegUUID = alegUUID;
	}

	public HangupReason getReason() {
		return reason;
	}

	public void setReason(HangupReason reason) {
		this.reason = reason;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public void setCallUUID(String callUUID) {
		this.callUUID = callUUID;
	}

	public String getAlegRequestUUID() {
		return alegRequestUUID;
	}

	public void setAlegRequestUUID(String alegRequestUUID) {
		this.alegRequestUUID = alegRequestUUID;
	}

	public String getRequestUUID() {
		return requestUUID;
	}

	public void setRequestUUID(String requestUUID) {
		this.requestUUID = requestUUID;
	}

	public CallStatus getStatus() {
		return status;
	}

	public void setStatus(CallStatus status) {
		this.status = status;
	}
	
	public static HangupCallback create(Map<String, String> parameters) {
		HangupCallback callback = new HangupCallback();
		
		callback.setFrom(parameters.get("From"));
		callback.setTo(parameters.get("To"));
		callback.setDirection(CallDirection.fromValue(parameters.get("Direction")));
		callback.setReason(HangupReason.fromValue(parameters.get("HangupCause")));
		callback.setAlegUUID(parameters.get("ALegUUID"));
		callback.setCallUUID(parameters.get("CallUUID"));
		callback.setStatus(CallStatus.fromValue(parameters.get("CallStatus")));
		callback.setAlegRequestUUID(parameters.get("ALegRequestUUID"));
		callback.setRequestUUID(parameters.get("RequestUUID"));
		
		return callback;
	}
	
}
