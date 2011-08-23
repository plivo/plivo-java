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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conference implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private boolean muted;
	
	@XmlAttribute
	private boolean beep;
	
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
	
	@XmlAttribute
	private String recordFilePath;
	
	@XmlAttribute
	private String recordFileFormat;
	
	@XmlAttribute
	private String recordFileName;
	
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

	@XmlValue
	private String room;
	
	public Conference() {
		
	}

	public boolean isMuted() {
		return muted;
	}

	/**
	 *  Enter conference muted
          (default false)
	 * @param muted
	 */
	public void setMuted(boolean muted) {
		this.muted = muted;
	}

	public boolean isStartConferenceOnEnter() {
		return startConferenceOnEnter;
	}

	/**
	 * The conference start when this member joins
          (default true)
	 * @param startConferenceOnEnter
	 */
	public void setStartConferenceOnEnter(boolean startConferenceOnEnter) {
		this.startConferenceOnEnter = startConferenceOnEnter;
	}

	public boolean isEndConferenceOnExit() {
		return endConferenceOnExit;
	}

	/**
	 * Close conference after all members
            with this attribute set to 'true' leave. (default false)
	 * @param endConferenceOnExit
	 */
	public void setEndConferenceOnExit(boolean endConferenceOnExit) {
		this.endConferenceOnExit = endConferenceOnExit;
	}

	public boolean isStayAlone() {
		return stayAlone;
	}

	/**
	 * If 'false' and member is alone, conference is closed and member kicked out
          (default true)
	 * @param stayAlone
	 */
	public void setStayAlone(boolean stayAlone) {
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

	public boolean isHangupOnStar() {
		return hangupOnStar;
	}

	/**
	 * Exit conference when member press '*'
          (default false)
	 * @param hangupOnStar
	 */
	public void setHangupOnStar(boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}

	public boolean isBeep() {
		return beep;
	}

	public void setBeep(boolean beep) {
		this.beep = beep;
	}

	public String getRecordFilePath() {
		return recordFilePath;
	}

	/**
	 * Path where recording is saved.
        (default "" so recording wont happen)
	 * @param recordFilePath
	 */
	public void setRecordFilePath(String recordFilePath) {
		this.recordFilePath = recordFilePath;
	}

	public String getRecordFileFormat() {
		return recordFileFormat;
	}

	/**
	 * File format in which recording tis saved
        (default mp3)
	 * @param recordFileFormat
	 */
	public void setRecordFileFormat(String recordFileFormat) {
		this.recordFileFormat = recordFileFormat;
	}

	public String getRecordFileName() {
		return recordFileName;
	}

	/**
	 * By default empty, if provided this name will be used for the recording
        (any unique name)
	 * @param recordFileName
	 */
	public void setRecordFileName(String recordFileName) {
		this.recordFileName = recordFileName;
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
}
