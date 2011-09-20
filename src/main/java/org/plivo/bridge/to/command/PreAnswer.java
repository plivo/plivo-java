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

@XmlAccessorType(XmlAccessType.FIELD)
public class PreAnswer implements Serializable {

	private static final long serialVersionUID = 2635662975269038297L;

	@XmlElement(name="Speak")
	private Speak speak;
	
	@XmlElement(name="Play")
	private Play play;
	
	@XmlElement(name="GetDigits")
	private GetDigits getDigits;
	
	@XmlElement(name="Wait")
	private Wait wait;
	
	@XmlElement(name="SIPTransfer")
	private SIPTransfer sipTransfer;
	
	@XmlElement(name="Redirect")
	private Redirect redirect;
	
	public PreAnswer() {
		
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

	public Wait getWait() {
		return wait;
	}

	public void setWait(Wait wait) {
		this.wait = wait;
	}

	public SIPTransfer getSipTransfer() {
		return sipTransfer;
	}

	public void setSipTransfer(SIPTransfer sipTransfer) {
		this.sipTransfer = sipTransfer;
	}

	public Redirect getRedirect() {
		return redirect;
	}

	public void setRedirect(Redirect redirect) {
		this.redirect = redirect;
	}
}
