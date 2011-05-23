package org.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conference implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private boolean muted;
	
	@XmlAttribute
	private boolean beep;
	
	@XmlAttribute
	private boolean startConferenceOnEnter;
	
	@XmlAttribute
	private boolean endConferenceOnExit;
	
	@XmlAttribute
	private String waitUrl;
	
	@XmlAttribute
	private String waitMethod;
	
	
	public Conference() {
		
	}


	public boolean isMuted() {
		return muted;
	}


	public void setMuted(boolean muted) {
		this.muted = muted;
	}


	public boolean isBeep() {
		return beep;
	}


	public void setBeep(boolean beep) {
		this.beep = beep;
	}


	public boolean isStartConferenceOnEnter() {
		return startConferenceOnEnter;
	}


	public void setStartConferenceOnEnter(boolean startConferenceOnEnter) {
		this.startConferenceOnEnter = startConferenceOnEnter;
	}


	public boolean isEndConferenceOnExit() {
		return endConferenceOnExit;
	}


	public void setEndConferenceOnExit(boolean endConferenceOnExit) {
		this.endConferenceOnExit = endConferenceOnExit;
	}


	public String getWaitUrl() {
		return waitUrl;
	}


	public void setWaitUrl(String waitUrl) {
		this.waitUrl = waitUrl;
	}


	public String getWaitMethod() {
		return waitMethod;
	}


	public void setWaitMethod(String waitMethod) {
		this.waitMethod = waitMethod;
	}
}
