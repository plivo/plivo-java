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

@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private Integer maxLength;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private Integer timeout;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String finishOnKey;
	
	@XmlAttribute
	private Boolean playBeep;
	
	@XmlAttribute
	private Boolean bothLegs;

	@XmlAttribute
	private Boolean redirect;
	
	@XmlAttribute
	private Boolean startOnDialAnswer;

	@XmlAttribute
	private Boolean recordSession;

	public Record() {
		
	}
	
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * Maximum number of seconds to record (default 60)
	 * @param maxLength
	 */
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public String getAction() {
		return action;
	}

	/**
	 * Submit the result of the record to this URL
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	public Integer getTimeout() {
		return timeout;
	}

	/**
	 * Seconds of silence before considering the recording complete (default 500) 
	 * @param timeout
	 */
	public void setTimeout(Integer timeout) {
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
	
	public String getFinishOnKey() {
		return finishOnKey;
	}

	/**
	 * Stop recording on this key
	 * @param finishOnKey
	 */
	public void setFinishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
	}

	public Boolean isPlayBeep() {
		return playBeep;
	}
	
	/**
	 * Play a beep before recording (true/false, default true)
	 * @param playBeep
	 */
	public void setPlayBeep(Boolean playBeep) {
		this.playBeep = playBeep;
	}
	
	/**
	 * Redirect to action url or not (true/false, default false)
	 * @param redirect
	 */
	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}

	public Boolean getPlayBeep() {
		return playBeep;
	}

	public Boolean getBothLegs() {
		return bothLegs;
	}

	public Boolean getRedirect() {
		return redirect;
	}

    public void setStartOnDialAnswer(Boolean startOnDialAnswer) {
        this.startOnDialAnswer = startOnDialAnswer;
    }

    public Boolean getStartOnDialAnswer() {
        return startOnDialAnswer;
    }

    public void setRecordSession(Boolean recordSession) {
        this.recordSession = recordSession;
    }

    public Boolean getRecordSession() {
        return recordSession;
    }
	
}
