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
public class GetDigits implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private int timeout;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private boolean finishOnKey;
	
	@XmlAttribute
	private int numDigits;
	
	@XmlAttribute
	private int tries;
	
	@XmlAttribute
	private boolean playBeep;
	
	@XmlAttribute
	private boolean validDigits;
	
	@XmlAttribute
	private boolean invalidDigitsSound;
	
	@javax.xml.bind.annotation.XmlElement(name="Play")
	private Play play;
	
	@javax.xml.bind.annotation.XmlElement(name="Speak")
	private Speak speak;
	
	@javax.xml.bind.annotation.XmlElement(name="Wait")
	private Wait wait;
	
	public GetDigits() {
		
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public boolean isFinishOnKey() {
		return finishOnKey;
	}

	public void setFinishOnKey(boolean finishOnKey) {
		this.finishOnKey = finishOnKey;
	}

	public int getNumDigits() {
		return numDigits;
	}

	public void setNumDigits(int numDigits) {
		this.numDigits = numDigits;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public boolean isPlayBeep() {
		return playBeep;
	}

	public void setPlayBeep(boolean playBeep) {
		this.playBeep = playBeep;
	}

	public boolean isValidDigits() {
		return validDigits;
	}

	public void setValidDigits(boolean validDigits) {
		this.validDigits = validDigits;
	}

	public boolean isInvalidDigitsSound() {
		return invalidDigitsSound;
	}

	public void setInvalidDigitsSound(boolean invalidDigitsSound) {
		this.invalidDigitsSound = invalidDigitsSound;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public Speak getSpeak() {
		return speak;
	}

	public void setSpeak(Speak speak) {
		this.speak = speak;
	}

	public Wait getWait() {
		return wait;
	}

	public void setWait(Wait wait) {
		this.wait = wait;
	}
}
