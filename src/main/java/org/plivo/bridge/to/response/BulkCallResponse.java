package org.plivo.bridge.to.response;


/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BulkCallResponse extends BaseResponse {

	private static final long serialVersionUID = 2532295151490831435L;
	
	private String[] RequestUUID;
	
	public BulkCallResponse() {
		
	}
		
	
	public String[] getRequestUUID() {
		return RequestUUID;
	}


	public void setRequestUUID(String[] requestUUID) {
		RequestUUID = requestUUID;
	}
}
