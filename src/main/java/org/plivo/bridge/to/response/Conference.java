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
	private String enterSound;
	
	@XmlAttribute
	private String exitSound;
	
	@XmlAttribute
	private boolean startConferenceOnEnter;
	
	@XmlAttribute
	private boolean endConferenceOnExit;
	
	@XmlAttribute
	private boolean stayAlone;

	@XmlAttribute
	private String waitSound;
	
	@XmlAttribute
	private Integer maxMembers;
	
	@XmlAttribute
	private Integer timeLimit;
	
	@XmlAttribute
	private boolean hangupOnStar;
	
	public Conference() {
		
	}


	public boolean isMuted() {
		return muted;
	}


	public void setMuted(boolean muted) {
		this.muted = muted;
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


	public boolean isStayAlone() {
		return stayAlone;
	}


	public void setStayAlone(boolean stayAlone) {
		this.stayAlone = stayAlone;
	}

	public String getEnterSound() {
		return enterSound;
	}


	public void setEnterSound(String enterSound) {
		this.enterSound = enterSound;
	}


	public String getExitSound() {
		return exitSound;
	}


	public void setExitSound(String exitSound) {
		this.exitSound = exitSound;
	}


	public String getWaitSound() {
		return waitSound;
	}


	public void setWaitSound(String waitSound) {
		this.waitSound = waitSound;
	}


	public Integer getMaxMembers() {
		return maxMembers;
	}


	public void setMaxMembers(Integer maxMembers) {
		this.maxMembers = maxMembers;
	}


	public Integer getTimeLimit() {
		return timeLimit;
	}


	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}


	public boolean isHangupOnStar() {
		return hangupOnStar;
	}


	public void setHangupOnStar(boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}

}
