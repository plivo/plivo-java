package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.plivo.bridge.utils.PlivoUtils;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RingingCallback [from=").append(from).append(", to=")
				.append(to).append(", direction=").append(direction)
				.append(", requestUUID=").append(requestUUID)
				.append(", callUUID=").append(callUUID).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((callUUID == null) ? 0 : callUUID.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
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
		RingingCallback other = (RingingCallback) obj;
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

	public static RingingCallback create(Map<?, ?> parameters) {
		RingingCallback callback = new RingingCallback();
		callback.setDirection(CallDirection.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "Direction")));
		callback.setFrom(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "From"));
		callback.setTo(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "To"));
		callback.setRequestUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "RequestUUID"));
		callback.setCallUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallUUID"));
		callback.setStatus(CallStatus.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallStatus")));
		
		return callback;
	}
}
