package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

public class AnsweredCallback implements Serializable {

	private static final long serialVersionUID = 2391305204443745296L;
	
	private String to;
	
	private String from;
	
	private CallDirection direction;
	
	private String alegUUID;
	
	private String alegRequestUUID;
	
	private String callUUID;
	
	private CallStatus status;
	
	
	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
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


	public String getAlegUUID() {
		return alegUUID;
	}


	public void setAlegUUID(String alegUUID) {
		this.alegUUID = alegUUID;
	}


	public String getAlegRequestUUID() {
		return alegRequestUUID;
	}


	public void setAlegRequestUUID(String alegRequestUUID) {
		this.alegRequestUUID = alegRequestUUID;
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


	public static AnsweredCallback create(Map<String, String> parameters) {
		AnsweredCallback callback = new AnsweredCallback();
		
		callback.setFrom(parameters.get("From"));
		callback.setTo(parameters.get("To"));
		callback.setDirection(CallDirection.fromValue(parameters.get("Direction")));
		callback.setAlegUUID(parameters.get("ALegUUID"));
		callback.setAlegRequestUUID(parameters.get("ALegRequestUUID"));
		callback.setCallUUID(parameters.get("CallUUID"));
		callback.setStatus(CallStatus.fromValue(parameters.get("CallStatus")));
		
		return callback;
	}
}
