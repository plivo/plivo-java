package com.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dial implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private Integer timeLimit;
	
	@XmlAttribute
	private Integer timeout;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String callerName;
	
	@XmlAttribute
	private Boolean hangupOnStar;
	
	@XmlAttribute
	private String confirmSound;
	
	@XmlAttribute
	private String confirmKey;
	
	@XmlAttribute
	private String dialMusic;
	
	@XmlAttribute
	private String callerId;
	
	@XmlAttribute
	private Boolean redirect;
	
	@XmlAttribute
	private String callbackUrl;
	
	@XmlAttribute
	private String callbackMethod;
	
	@XmlAttribute
	private String digitsMatch;
	
	@XmlElement(name="Number", required=true)
	private Number number;
	
	public Dial() {
		
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	/**
	 *  Hang up the call after these many seconds. 0 means no timeLimit
	 * @param timeLimit
	 */
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public String getAction() {
		return action;
	}

	/**
	 * Submit the result of the dial and redirect to this URL 
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
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

	public Boolean getHangupOnStar() {
		return hangupOnStar;
	}
	
	/**
	 * Hang up the b leg if a leg presses start and this is true
	 * @param hangupOnStar
	 */
	public void setHangupOnStar(Boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}

	public String getCallerId() {
		return callerId;
	}

	/**
	 * Caller id to be send to the dialed number
	 * @param callerId
	 */
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

	/**
	 * Sound to be played to b leg before call is bridged
	 * @param confirmSound
	 */
	public void setConfirmSound(String confirmSound) {
		this.confirmSound = confirmSound;
	}

	public String getConfirmKey() {
		return confirmKey;
	}

	/**
	 * Key to be pressed to bridge the call.
	 * @param confirmKey
	 */
	public void setConfirmKey(String confirmKey) {
		this.confirmKey = confirmKey;
	}

	public String getDialMusic() {
		return dialMusic;
	}

	/**
	 * Play music to a leg while doing a dial to b leg
                Can be a list of files separated by comma
	 * @param dialMusic
	 */
	public void setDialMusic(String dialMusic) {
		this.dialMusic = dialMusic;
	}

	/**
	 *  If 'false', don't redirect to 'action', only request url 
        and continue to next element. (default 'true')
	 * @param redirect
	 */
	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}

	public Boolean getRedirect() {
		return redirect;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 *  URL to request when bridge starts and bridge ends
	 * @param callbackUrl
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getCallbackMethod() {
		return callbackMethod;
	}

	/**
	 * Submit to 'callbackUrl' URL using GET or POST
	 * @param callbackMethod
	 */
	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	public String getDigitsMatch() {
		return digitsMatch;
	}

	public void setDigitsMatch(String digitsMatch) {
		this.digitsMatch = digitsMatch;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
}
