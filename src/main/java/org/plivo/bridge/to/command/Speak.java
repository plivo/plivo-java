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
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Speak implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String voice; 
	@XmlAttribute
	private String language;
	@XmlAttribute
	private int loop;
	@XmlAttribute
	private String engine;
	@XmlAttribute
	private String type;
	@XmlAttribute
	private String method;
	
	@XmlValue
	private String value;
	
	public Speak() {
		
	}

	public String getVoice() {
		return voice;
	}
	
	/**
	 * Voice to be used based on TTS engine
	 * @param voice
	 */
	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getLanguage() {
		return language;
	}

	/**
	 * Language to use
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLoop() {
		return loop;
	}

	/**
	 * Number of times to say this text
	 * @param loop
	 */
	public void setLoop(int loop) {
		this.loop = loop;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	/**
	 * 
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
