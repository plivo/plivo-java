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
public class AnsweredCallback implements Serializable {

	private static final long serialVersionUID = 2391305204443745296L;
	
	private String alegUUID;
	
	private String callUUID;
	
	private AnsweredDirection direction;
	
	private String callNumber;
	
	private Integer scheduleHangupID;
	
	private String alegRequestUUID;
	
	private String fromNumber;
	
	
	public static enum AnsweredDirection {
		INBOUND,
		OUTBOUND;
		
		
		public static AnsweredDirection from(String value) {
			for(AnsweredDirection r: AnsweredDirection.values())
				if(r.name().equals(value)) return r;
			
			return null;
		}
	
	}


	public String getAlegUUID() {
		return alegUUID;
	}


	public void setAlegUUID(String alegUUID) {
		this.alegUUID = alegUUID;
	}


	public String getCallUUID() {
		return callUUID;
	}


	public void setCallUUID(String callUUID) {
		this.callUUID = callUUID;
	}


	public AnsweredDirection getDirection() {
		return direction;
	}


	public void setDirection(AnsweredDirection direction) {
		this.direction = direction;
	}


	public String getCallNumber() {
		return callNumber;
	}


	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}


	public Integer getScheduleHangupID() {
		return scheduleHangupID;
	}


	public void setScheduleHangupID(Integer scheduleHangupID) {
		this.scheduleHangupID = scheduleHangupID;
	}


	public String getAlegRequestUUID() {
		return alegRequestUUID;
	}


	public void setAlegRequestUUID(String alegRequestUUID) {
		this.alegRequestUUID = alegRequestUUID;
	}


	public String getFromNumber() {
		return fromNumber;
	}


	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	
	public static AnsweredCallback create(HttpServletRequest request) {
		AnsweredCallback callback = new AnsweredCallback();
		callback.setAlegRequestUUID(request.getParameter("aleg_uuid"));
		callback.setCallUUID(request.getParameter("call_uuid"));
		callback.setDirection(AnsweredDirection.from(request.getParameter("direction")));
		callback.setCallNumber(request.getParameter("called_no"));
		String hangupId = request.getParameter("sched_hangup_id");
		callback.setScheduleHangupID((null == hangupId || "".equals(hangupId.trim()) ? null : Integer.valueOf(hangupId)));
		callback.setAlegRequestUUID(request.getParameter("aleg_request_uuid"));
		callback.setFromNumber(request.getParameter("from_no"));
		
		return callback;
	}

}
