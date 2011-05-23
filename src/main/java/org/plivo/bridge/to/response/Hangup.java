package org.plivo.bridge.to.response;

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
public class Hangup implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	
	public Hangup() {
		
	}
}
