package org.plivo.bridge.to.response;


/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-22
 * @author Paulo reis
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupCallResponse extends BasePlivoResponse {

	private static final long serialVersionUID = 2532295151490831435L;
	
	private String RequestUUID;
	
	public GroupCallResponse() {
		
	}
		
	
	public String getRequestUUID() {
		return RequestUUID;
	}


	public void setRequestUUID(String requestUUID) {
		RequestUUID = requestUUID;
	}
}
