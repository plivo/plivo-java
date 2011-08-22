package org.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-22
 * @author Paulo reis
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SchedulePlayResponse extends BasePlivoResponse {

	private static final long serialVersionUID = -2015380532129538279L;
	
	private String SchedPlayId;

	public String getSchedPlayId() {
		return SchedPlayId;
	}

	public void setSchedPlayId(String schedPlayId) {
		SchedPlayId = schedPlayId;
	}
}
