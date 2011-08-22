package org.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PreAnswer implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@javax.xml.bind.annotation.XmlElement(name="Speak")
	private Speak speak;
	
	@javax.xml.bind.annotation.XmlElement(name="Play")
	private Play play;
	
	@javax.xml.bind.annotation.XmlElement(name="GetDigits")
	private GetDigits getDigits;
	
	@javax.xml.bind.annotation.XmlElement(name="Wait")
	private Wait wait;
	
	@javax.xml.bind.annotation.XmlElement(name="GetSpeech")
	private Wait getSpeech;
	
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

	public Wait getGetSpeech() {
		return getSpeech;
	}

	public void setGetSpeech(Wait getSpeech) {
		this.getSpeech = getSpeech;
	}
}
