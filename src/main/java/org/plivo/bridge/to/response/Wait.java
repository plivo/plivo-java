package org.plivo.bridge.to.response;

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

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Wait implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private int length;
	
	@XmlAttribute
	private boolean transferEnabled;
	
	@XmlValue
	private String value;
	
	public Wait() {
		
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isTransferEnabled() {
		return transferEnabled;
	}

	public void setTransferEnabled(boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
