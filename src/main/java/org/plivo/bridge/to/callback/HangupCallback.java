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
public class HangupCallback implements Serializable {

	private static final long serialVersionUID = 7437844399059919787L;
	
	private String requestUUID;
	
	private String callID;
	
	private HangupReason reason;
	
	public static enum HangupReason {
		USER_NOT_REGISTERED,
		USER_BUSY,
		NORMAL_CLEARING;
		
		public static HangupReason from(String value) {
			for(HangupReason reason: HangupReason.values())
				if(reason.name().equals(value)) return reason;
			
			return null;
		}
	}

	public String getRequestUUID() {
		return requestUUID;
	}

	public void setRequestUUID(String requestUUID) {
		this.requestUUID = requestUUID;
	}

	public String getCallID() {
		return callID;
	}

	public void setCallID(String callID) {
		this.callID = callID;
	}

	public HangupReason getReason() {
		return reason;
	}

	public void setReason(HangupReason reason) {
		this.reason = reason;
	}
	
	public static HangupCallback create(Map<String, String> parameters) {
		HangupCallback obj = new HangupCallback();
		obj.setRequestUUID(parameters.get("request_uuid"));
		obj.setCallID(parameters.get("call_uuid"));
		obj.setReason(HangupReason.from(parameters.get("reason")));
		
		return obj;
	}
}
