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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HangupCallback [from=").append(from).append(", to=")
				.append(to).append(", direction=").append(direction)
				.append(", alegUUID=").append(alegUUID).append(", reason=")
				.append(reason).append(", callUUID=").append(callUUID)
				.append(", alegRequestUUID=").append(alegRequestUUID)
				.append(", requestUUID=").append(requestUUID)
				.append(", status=").append(status).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alegRequestUUID == null) ? 0 : alegRequestUUID.hashCode());
		result = prime * result
				+ ((alegUUID == null) ? 0 : alegUUID.hashCode());
		result = prime * result
				+ ((callUUID == null) ? 0 : callUUID.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result
				+ ((requestUUID == null) ? 0 : requestUUID.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangupCallback other = (HangupCallback) obj;
		if (alegRequestUUID == null) {
			if (other.alegRequestUUID != null)
				return false;
		} else if (!alegRequestUUID.equals(other.alegRequestUUID))
			return false;
		if (alegUUID == null) {
			if (other.alegUUID != null)
				return false;
		} else if (!alegUUID.equals(other.alegUUID))
			return false;
		if (callUUID == null) {
			if (other.callUUID != null)
				return false;
		} else if (!callUUID.equals(other.callUUID))
			return false;
		if (direction != other.direction)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (reason != other.reason)
			return false;
		if (requestUUID == null) {
			if (other.requestUUID != null)
				return false;
		} else if (!requestUUID.equals(other.requestUUID))
			return false;
		if (status != other.status)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
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
