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
public class GetDigits implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private int timeout;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String finishOnKey;
	
	@XmlAttribute
	private int numDigits;
	
	@XmlAttribute
	private int retries;
	
	@XmlAttribute
	private boolean playBeep;
	
	@XmlAttribute
	private String validDigits;
	
	@XmlAttribute
	private String invalidDigitsSound;
	
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

	/**
	 * URL to which the digits entered will be sent
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	public int getTimeout() {
		return timeout;
	}

	/**
	 * Wait for this many seconds before retry or returning
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getMethod() {
		return method;
	}

	/**
	 * Submit to 'action' URL using GET or POST
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	public String isFinishOnKey() {
		return finishOnKey;
	}

	/**
	 * Key that triggers the end of caller input
	 * @param finishOnKey
	 */
	public void setFinishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
	}

	public int getNumDigits() {
		return numDigits;
	}

	/**
	 * How many digits to gather before returning
	 * @param numDigits
	 */
	public void setNumDigits(int numDigits) {
		this.numDigits = numDigits;
	}

	public int getRetries() {
		return retries;
	}
	
	/**
	 * Number of tries to execute all says and plays one by one
	 * @param retries
	 */
	public void setRetries(int retries) {
		this.retries = retries;
	}

	public boolean isPlayBeep() {
		return playBeep;
	}

	/**
	 * Play a beep after all plays and says finish
	 * @param playBeep
	 */
	public void setPlayBeep(boolean playBeep) {
		this.playBeep = playBeep;
	}

	public String isValidDigits() {
		return validDigits;
	}

	/**
	 * Digits which are allowed to be pressed
	 * @param validDigits
	 */
	public void setValidDigits(String validDigits) {
		this.validDigits = validDigits;
	}

	public String isInvalidDigitsSound() {
		return invalidDigitsSound;
	}

	/**
	 * Sound played when invalid digit pressed
	 * @param invalidDigitsSound
	 */
	public void setInvalidDigitsSound(String invalidDigitsSound) {
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
