package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

import org.plivo.bridge.utils.PlivoUtils;

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
		AnsweredCallback other = (AnsweredCallback) obj;
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
		if (status != other.status)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnsweredCallback [to=").append(to).append(", from=")
				.append(from).append(", direction=").append(direction)
				.append(", alegUUID=").append(alegUUID)
				.append(", alegRequestUUID=").append(alegRequestUUID)
				.append(", callUUID=").append(callUUID).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}


	public static AnsweredCallback create(Map<?,?> parameters) {
		AnsweredCallback callback = new AnsweredCallback();
		
		callback.setFrom(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "From"));
		callback.setTo(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "To"));
		callback.setDirection(CallDirection.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "Direction")));
		callback.setAlegUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "ALegUUID"));
		callback.setAlegRequestUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "ALegRequestUUID"));
		callback.setCallUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallUUID"));
		callback.setStatus(CallStatus.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallStatus")));
		
		return callback;
	}
}
