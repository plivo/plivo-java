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
public class Play implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private Integer loop;
	
	@XmlValue
	private String url;
	
	public Play() {
		
	}
	public Integer getLoop() {
		return loop;
	}
	
	/**
	 * Number of time to say this text
	 * @param loop
	 */
	public void setLoop(Integer loop) {
		this.loop = loop;
	}
	public String getUrl() {
		return url;
	}
	
	/**
	 * URL of audio file, MIME type on file must be set correctly
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
