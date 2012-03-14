package com.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CallResponse extends BasePlivoResponse {

	private static final long serialVersionUID = 2532295151490831435L;
	
	private String RequestUUID;
	
	public CallResponse() {
		
	}
		
	public String getRequestUUID() {
		return RequestUUID;
	}


	public void setRequestUUID(String requestUUID) {
		RequestUUID = requestUUID;
	}
}
