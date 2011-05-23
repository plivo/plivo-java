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
public class Dial implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private int timeLimit;
	
	@XmlAttribute
	private int timeout;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private boolean hangupOnStar;
	
	@XmlAttribute
	private String confirmSound;
	
	@XmlAttribute
	private String confirmKey;
	
	@XmlAttribute
	private String dialMusic;
	
	@XmlAttribute
	private String callerId;
	
	@javax.xml.bind.annotation.XmlElement(name="Number")
	private Number number;
	
	public Dial() {
		
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public boolean isHangupOnStar() {
		return hangupOnStar;
	}

	public void setHangupOnStar(boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}

	public String getCallerId() {
		return callerId;
	}

	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}

	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}

	public String getConfirmSound() {
		return confirmSound;
	}

	public void setConfirmSound(String confirmSound) {
		this.confirmSound = confirmSound;
	}

	public String getConfirmKey() {
		return confirmKey;
	}

	public void setConfirmKey(String confirmKey) {
		this.confirmKey = confirmKey;
	}

	public String getDialMusic() {
		return dialMusic;
	}

	public void setDialMusic(String dialMusic) {
		this.dialMusic = dialMusic;
	}
}
