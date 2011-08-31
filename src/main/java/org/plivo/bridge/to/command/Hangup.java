package org.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Hangup implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String reason;

	@XmlAttribute
	private int schedule;
	
	public Hangup() {
		
	}

	public String getReason() {
		return reason;
	}

	/**
	 * Give the reason of han gup
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getSchedule() {
		return schedule;
	}

	/**
	 * Set the schedule time, in seconds
	 * @param schedule
	 */
	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}
}
