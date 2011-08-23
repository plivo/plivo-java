package org.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SIPTransfer implements Serializable {

	private static final long serialVersionUID = -8673349979809375985L;
	
	@XmlValue
	private String url;
	
	public SIPTransfer() {
		
	}

	public String getUrl() {
		return url;
	}

	/**
	 * Set the URL to transfer to.
	 * For more than one address, use comma between them.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
