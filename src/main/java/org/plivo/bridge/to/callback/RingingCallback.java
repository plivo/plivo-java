package org.plivo.bridge.to.callback;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RingingCallback implements Serializable {

	private static final long serialVersionUID = 4797143358692598287L;
	
	private String to;
	
	private String requestUUID;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getRequestUUID() {
		return requestUUID;
	}

	public void setRequestUUID(String requestUUID) {
		this.requestUUID = requestUUID;
	}
	
	public static RingingCallback create(Map<String, String> parameters) {
		RingingCallback callback = new RingingCallback();
		callback.setRequestUUID(parameters.get("request_uuid"));
		callback.setTo(parameters.get("to"));
		
		return callback;
	}

}
