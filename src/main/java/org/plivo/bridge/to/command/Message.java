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
public class Message implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String src;

	@XmlAttribute
	private String dst;

	@XmlAttribute
	private String type;

	@XmlAttribute
	private String callbackUrl;

	@XmlAttribute
	private String callbackMethod;
	
	@XmlValue
	private String text;
	
	public Message() {
		
	}

	/**
	 * Destination number
	 * @param dst
	 */
	public String getdst() {
		return dst;
	}
	
	public void setdst(String dst) {
		this.dst = dst;
	}

	/**
	 * Source number
	 * @param src
	 */

	public String getsrc() {
		return src;
	}
	
	public void setsrc(String src) {
		this.src = src;
	}

	/**
	 * Message type
	 * @param type
	 */

	public String gettype() {
		return type;
	}
	
	public void settype(String type) {
		this.type = type;
	}

	/**
	 * callbackUrl 
	 * @param callbackUrl
	 */

	public String getcallbackUrl() {
		return callbackUrl;
	}
	
	public void setcallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}


	/**
	 * callbackMethod 
	 * @param callbackMethod
	 */

	public String getcallbackMethod() {
		return callbackMethod;
	}
	
	public void setcallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	/**
	 * Text to be sent 
	 * @param text
	 */

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
