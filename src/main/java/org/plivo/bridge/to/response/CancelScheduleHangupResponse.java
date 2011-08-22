package org.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelScheduleHangupResponse extends BasePlivoResponse {
	
	private static final long serialVersionUID = 6140190626859327286L;
	private String SchedHangupId;
	
	public CancelScheduleHangupResponse() {
		
	}
	
	public String getSchedHangupId() {
		return SchedHangupId;
	}
	public void setSchedHangupId(String schedHangupId) {
		SchedHangupId = schedHangupId;
	}
}
