package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
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
	
	public static HangupCallback create(HttpServletRequest request) {
		HangupCallback obj = new HangupCallback();
		obj.setRequestUUID(request.getParameter("request_uuid"));
		obj.setCallID(request.getParameter("call_uuid"));
		obj.setReason(HangupReason.from(request.getParameter("reason")));
		
		return obj;
	}
}
