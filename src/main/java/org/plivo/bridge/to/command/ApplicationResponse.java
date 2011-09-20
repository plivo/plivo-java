package org.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationResponse implements Serializable {

	private static final long serialVersionUID = 8071673898735283084L;
	
	@XmlElement(name="Speak")
	private Speak speak;
	
	@XmlElement(name="Play")
	private Play play;
	
	@XmlElement(name="GetDigits")
	private GetDigits getDigits;
	
	@XmlElement(name="Record")
	private Record record;
	
	@XmlElement(name="Dial")
	private Dial dial;
	
	@XmlElement(name="Redirect")
	private Redirect redirect;
	
	@XmlElement(name="Wait")
	private Wait wait;
	
	@XmlElement(name="Hangup")
	private Hangup hangup;
	
	@XmlElement(name="PreAnswer")
	private PreAnswer preAnswer;
	
	@XmlElement(name="Conference")
	private Conference conference;
	
	@XmlElement(name="SIPTransfer")
	private SIPTransfer sipTransfer;
	
	public ApplicationResponse() {
		
	}

	public Speak getSpeak() {
		return speak;
	}

	public void setSpeak(Speak speak) {
		this.speak = speak;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public GetDigits getGetDigits() {
		return getDigits;
	}

	public void setGetDigits(GetDigits getDigits) {
		this.getDigits = getDigits;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Dial getDial() {
		return dial;
	}

	public void setDial(Dial dial) {
		this.dial = dial;
	}

	public Redirect getRedirect() {
		return redirect;
	}

	public void setRedirect(Redirect redirect) {
		this.redirect = redirect;
	}

	public Wait getWait() {
		return wait;
	}

	public void setWait(Wait wait) {
		this.wait = wait;
	}

	public Hangup getHangup() {
		return hangup;
	}

	public void setHangup(Hangup hangup) {
		this.hangup = hangup;
	}

	public PreAnswer getPreAnswer() {
		return preAnswer;
	}

	public void setPreAnswer(PreAnswer preAnswer) {
		this.preAnswer = preAnswer;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public SIPTransfer getSipTransfer() {
		return sipTransfer;
	}

	public void setSipTransfer(SIPTransfer sipTransfer) {
		this.sipTransfer = sipTransfer;
	}
}
