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
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Conference implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private Boolean muted;
	
	@XmlAttribute
	private Boolean beep;
	
	@XmlAttribute
	private String enterSound;
	
	@XmlAttribute
	private String exitSound;
	
	@XmlAttribute
	private Boolean startConferenceOnEnter;
	
	@XmlAttribute
	private Boolean redirect;
	
	@XmlAttribute
	private Boolean endConferenceOnExit;
	
	@XmlAttribute
	private Boolean stayAlone;

	@XmlAttribute
	private String waitSound;
	
	@XmlAttribute
	private Integer maxMembers;
	
	@XmlAttribute
	private Integer timeLimit;
	
	@XmlAttribute
	private Boolean hangupOnStar;
	
	@XmlAttribute
	private Boolean record;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String digitsMatch;
	
	@XmlAttribute
	private String callbackUrl;
	
	@XmlAttribute
	private String callbackMethod;
	
	@XmlAttribute
	private Boolean floorEvent;

	@XmlValue
	private String room;
	
	public Conference() {
		
	}

	/**
	 *  Enter conference muted
          (default false)
	 * @param muted
	 */
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}
	
	/**
	 * The conference start when this member joins
          (default true)
	 * @param startConferenceOnEnter
	 */
	public void setStartConferenceOnEnter(Boolean startConferenceOnEnter) {
		this.startConferenceOnEnter = startConferenceOnEnter;
	}

	/**
	 * Close conference after all members
            with this attribute set to 'true' leave. (default false)
	 * @param endConferenceOnExit
	 */
	public void setEndConferenceOnExit(Boolean endConferenceOnExit) {
		this.endConferenceOnExit = endConferenceOnExit;
	}

	/**
	 * If 'false' and member is alone, conference is closed and member kicked out
          (default true)
	 * @param stayAlone
	 */
	public void setStayAlone(Boolean stayAlone) {
		this.stayAlone = stayAlone;
	}

	public String getEnterSound() {
		return enterSound;
	}

	/**
	 * Sound to play when a member enters
          if empty, disabled
          if 'beep:1', play one beep
          if 'beep:2', play two beeps
          (default disabled)
	 * @param enterSound
	 */
	public void setEnterSound(String enterSound) {
		this.enterSound = enterSound;
	}

	public String getExitSound() {
		return exitSound;
	}

	/**
	 * Sound to play when a member exits
          if empty, disabled
          if 'beep:1', play one beep
          if 'beep:2', play two beeps
          (default disabled)
	 * @param exitSound
	 */
	public void setExitSound(String exitSound) {
		this.exitSound = exitSound;
	}

	public String getWaitSound() {
		return waitSound;
	}

	/**
	 * Sound to play while alone in conference
          Can be a list of sound files separated by comma.
          (default no sound)
	 * @param waitSound
	 */
	public void setWaitSound(String waitSound) {
		this.waitSound = waitSound;
	}

	public Integer getMaxMembers() {
		return maxMembers;
	}

	/**
	 * Max members in conference
          (0 for max : 200)
	 * @param maxMembers
	 */
	public void setMaxMembers(Integer maxMembers) {
		this.maxMembers = maxMembers;
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	/**
	 * Max time in seconds before closing conference
          (default 0, no timeLimit)
	 * @param timeLimit
	 */
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * Exit conference when member press '*'
          (default false)
	 * @param hangupOnStar
	 */
	public void setHangupOnStar(Boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}

	public void setBeep(Boolean beep) {
		this.beep = beep;
	}

	/**
	 * Record conference or not
	 * @param record
	 */
	public void setRecord(Boolean record) {
		this.record = record;
	}
	public String getAction() {
		return action;
	}

	/**
	 * Redirect to this URL after leaving conference
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
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	public String getDigitsMatch() {
		return digitsMatch;
	}

	/**
	 * A list of matching digits to send with callbackUrl
            Can be a list of digits patterns separated by comma.
	 * @param digitsMatch
	 */
	public void setDigitsMatch(String digitsMatch) {
		this.digitsMatch = digitsMatch;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * Url to request when call enters/leaves conference
            or has pressed digits matching (digitsMatch)
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

	public String getRoom() {
		return room;
	}

	/**
	 * Room name
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	
	/** Floor Event
	 * 'true' or 'false'. When this member speaks, 
            send notification to callbackUrl. (default 'false')
	 * @param floorEvent
	 */
	public void setFloorEvent(Boolean floorEvent) {
		this.floorEvent = floorEvent;
	}

	public Boolean getRedirect() {
		return redirect;
	}

	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}

	public Boolean getMuted() {
		return muted;
	}

	public Boolean getBeep() {
		return beep;
	}

	public Boolean getStartConferenceOnEnter() {
		return startConferenceOnEnter;
	}

	public Boolean getEndConferenceOnExit() {
		return endConferenceOnExit;
	}

	public Boolean getStayAlone() {
		return stayAlone;
	}

	public Boolean getHangupOnStar() {
		return hangupOnStar;
	}

	public Boolean getRecord() {
		return record;
	}

	public Boolean getFloorEvent() {
		return floorEvent;
	}
}
