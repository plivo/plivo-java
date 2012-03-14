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
public class Number implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private String sendDigits;
	
	@XmlAttribute
	private Boolean sendOnPreanswer;
	
	@XmlValue
	private String number;
	
	public Number() {
		
	}

	public String getSendDigits() {
		return sendDigits;
	}

	/**
	 * Key to press after connecting to the number
	 * @param sendDigits
	 */
	public void setSendDigits(String sendDigits) {
		this.sendDigits = sendDigits;
	}

	public String getNumber() {
		return number;
	}

	/**
	 * Phone number to dial
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean isSendOnPreanswer() {
		return sendOnPreanswer;
	}

	public void setSendOnPreanswer(Boolean sendOnPreanswer) {
		this.sendOnPreanswer = sendOnPreanswer;
	}
}
