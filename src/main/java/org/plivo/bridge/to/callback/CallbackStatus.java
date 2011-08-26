package org.plivo.bridge.to.callback;

import java.io.Serializable;
import java.util.Map;

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
	
	public static CallbackStatus create(Map<String, String> parameters) {
		CallbackStatus callback = new CallbackStatus();
		
		callback.setFrom(parameters.get("From"));
		callback.setTo(parameters.get("To"));
		callback.setDialBLegUUID(parameters.get("DialBLegUUID"));
		callback.setDirection(CallDirection.fromValue(parameters.get("Direction")));
		callback.setHangupReason(HangupReason.fromValue(parameters.get("DialHangupCause")));
		callback.setAlegUUID(parameters.get("ALegUUID"));
		callback.setDialRingStatus(Boolean.valueOf(parameters.get("DialRingStatus")));
		callback.setDialALegUUID(parameters.get("DialALegUUID"));
		callback.setaLegRequestUUID(parameters.get("ALegRequestUUID"));
		callback.setCallUUID(parameters.get("CallUUID"));
		callback.setStatus(CallStatus.fromValue(parameters.get("CallStatus")));
		
		return callback;
	}

}
