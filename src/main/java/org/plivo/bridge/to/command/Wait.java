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
public class Wait implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private Integer length;
		
	public Wait() {
		
	}

	public Integer getLength() {
		return length;
	}

	/**
	 * Length of wait time in seconds
	 * @param length
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
}
