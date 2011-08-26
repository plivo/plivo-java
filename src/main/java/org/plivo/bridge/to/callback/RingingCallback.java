package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RingingCallback implements Serializable {

	private static final long serialVersionUID = 4797143358692598287L;
	
	private String from;
	private String to;
	private CallDirection direction;
	private String requestUUID;
	private String callUUID;
	private CallStatus status;
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getRequestUUID() {
		return requestUUID;
	}

	public void setRequestUUID(String requestUUID) {
		this.requestUUID = requestUUID;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public CallDirection getDirection() {
		return direction;
	}

	public void setDirection(CallDirection direction) {
		this.direction = direction;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public void setCallUUID(String callUUID) {
		this.callUUID = callUUID;
	}

	public CallStatus getStatus() {
		return status;
	}

	public void setStatus(CallStatus status) {
		this.status = status;
	}

	public static RingingCallback create(Map<String, String> parameters) {
		RingingCallback callback = new RingingCallback();
		callback.setDirection(CallDirection.fromValue(parameters.get("Direction")));
		callback.setFrom(parameters.get("From"));
		callback.setTo(parameters.get("To"));
		callback.setRequestUUID(parameters.get("RequestUUID"));
		callback.setCallUUID(parameters.get("CallUUID"));
		callback.setStatus(CallStatus.fromValue(parameters.get("CallStatus")));
		
		return callback;
	}
}
