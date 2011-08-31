package org.plivo.bridge.to.callback;

import java.io.Serializable;
import java.util.Map;

import org.plivo.bridge.utils.PlivoUtils;

public class CallbackStatus implements Serializable {

	private static final long serialVersionUID = 8045921256311010877L;
	
	private String from;
	
	private String to;
	
	private String dialBLegUUID;
	
	private CallDirection direction;
	
	private HangupReason hangupReason;
	
	private String alegUUID;
	
	private boolean dialRingStatus;
	
	private String dialALegUUID;
	
	private String aLegRequestUUID;
	
	private String callUUID;
	
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

	public String getDialBLegUUID() {
		return dialBLegUUID;
	}

	public void setDialBLegUUID(String dialBLegUUID) {
		this.dialBLegUUID = dialBLegUUID;
	}

	public CallDirection getDirection() {
		return direction;
	}

	public void setDirection(CallDirection direction) {
		this.direction = direction;
	}

	public HangupReason getHangupReason() {
		return hangupReason;
	}

	public void setHangupReason(HangupReason hangupReason) {
		this.hangupReason = hangupReason;
	}

	public String getAlegUUID() {
		return alegUUID;
	}

	public void setAlegUUID(String alegUUID) {
		this.alegUUID = alegUUID;
	}

	public boolean isDialRingStatus() {
		return dialRingStatus;
	}

	public void setDialRingStatus(boolean dialRingStatus) {
		this.dialRingStatus = dialRingStatus;
	}

	public String getDialALegUUID() {
		return dialALegUUID;
	}

	public void setDialALegUUID(String dialALegUUID) {
		this.dialALegUUID = dialALegUUID;
	}

	public String getaLegRequestUUID() {
		return aLegRequestUUID;
	}

	public void setaLegRequestUUID(String aLegRequestUUID) {
		this.aLegRequestUUID = aLegRequestUUID;
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
		builder.append("CallbackStatus [from=").append(from).append(", to=")
				.append(to).append(", dialBLegUUID=").append(dialBLegUUID)
				.append(", direction=").append(direction)
				.append(", hangupReason=").append(hangupReason)
				.append(", alegUUID=").append(alegUUID)
				.append(", dialRingStatus=").append(dialRingStatus)
				.append(", dialALegUUID=").append(dialALegUUID)
				.append(", aLegRequestUUID=").append(aLegRequestUUID)
				.append(", callUUID=").append(callUUID).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aLegRequestUUID == null) ? 0 : aLegRequestUUID.hashCode());
		result = prime * result
				+ ((alegUUID == null) ? 0 : alegUUID.hashCode());
		result = prime * result
				+ ((callUUID == null) ? 0 : callUUID.hashCode());
		result = prime * result
				+ ((dialALegUUID == null) ? 0 : dialALegUUID.hashCode());
		result = prime * result
				+ ((dialBLegUUID == null) ? 0 : dialBLegUUID.hashCode());
		result = prime * result + (dialRingStatus ? 1231 : 1237);
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result
				+ ((hangupReason == null) ? 0 : hangupReason.hashCode());
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
		CallbackStatus other = (CallbackStatus) obj;
		if (aLegRequestUUID == null) {
			if (other.aLegRequestUUID != null)
				return false;
		} else if (!aLegRequestUUID.equals(other.aLegRequestUUID))
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
		if (dialALegUUID == null) {
			if (other.dialALegUUID != null)
				return false;
		} else if (!dialALegUUID.equals(other.dialALegUUID))
			return false;
		if (dialBLegUUID == null) {
			if (other.dialBLegUUID != null)
				return false;
		} else if (!dialBLegUUID.equals(other.dialBLegUUID))
			return false;
		if (dialRingStatus != other.dialRingStatus)
			return false;
		if (direction != other.direction)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (hangupReason != other.hangupReason)
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

	public static CallbackStatus create(Map<?, ?> parameters) {
		CallbackStatus callback = new CallbackStatus();
		
		callback.setFrom(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "From"));
		callback.setTo(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "To"));
		callback.setDialBLegUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "DialBLegUUID"));
		callback.setDirection(CallDirection.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "Direction")));
		callback.setHangupReason(HangupReason.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "DialHangupCause")));
		callback.setAlegUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "ALegUUID"));
		callback.setDialRingStatus(Boolean.valueOf(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "DialRingStatus")));
		callback.setDialALegUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "DialALegUUID"));
		callback.setaLegRequestUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "ALegRequestUUID"));
		callback.setCallUUID(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallUUID"));
		callback.setStatus(CallStatus.fromValue(PlivoUtils.ParameterUtils.getSingleParameter(parameters, "CallStatus")));
		
		return callback;
	}

}
