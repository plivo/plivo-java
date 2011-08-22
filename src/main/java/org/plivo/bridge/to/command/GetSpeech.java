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

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetSpeech implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private int timeout;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String engine;
	
	@XmlAttribute
	private String grammar;
	
	@XmlAttribute
	private boolean playBeep;
	
	@javax.xml.bind.annotation.XmlElement(name="Play")
	private Play play;
	
	@javax.xml.bind.annotation.XmlElement(name="Speak")
	private Speak speak;
	
	@javax.xml.bind.annotation.XmlElement(name="Wait")
	private Wait wait;
	
	public GetSpeech() {
		
	}

	public String getAction() {
		return action;
	}

	/**
	 * URL to which the detected speech will be sent
	 * @param action
	 */
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

	/**
	 * Submit to 'action' URL using GET or POST
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	public String getEngine() {
		return engine;
	}

	/**
	 * Engine to be used by detect speech
	 * @param engine
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getGrammar() {
		return grammar;
	}

	/**
	 * Grammar to load
	 * @param grammar
	 */
	public void setGrammar(String grammar) {
		this.grammar = grammar;
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

	/**
	 * Wait for this many seconds before returning
	 * @param wait
	 */
	public void setWait(Wait wait) {
		this.wait = wait;
	}
}
