package org.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduleHangupResponse extends BasePlivoResponse {
	
	private static final long serialVersionUID = 6140190626859327286L;
	private String SchedHangupId;
	
	public ScheduleHangupResponse() {
		
	}
	
	public String getSchedHangupId() {
		return SchedHangupId;
	}
	public void setSchedHangupId(String schedHangupId) {
		SchedHangupId = schedHangupId;
	}
	
	@Override
	public String toString() {
		return "{ScheduledHangupId: "+this.getSchedHangupId()+"}";
	}
}
