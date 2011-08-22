package org.plivo.bridge.to.response;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BasePlivoResponse implements Serializable {

	private static final long serialVersionUID = -7120130174373804625L;
	private String Message;
	private boolean Success;
	
	public BasePlivoResponse() {
		
	}
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("{")
		.append("MSG: "+this.getMessage()).append(", ")
		.append("SUCCESS: "+this.isSuccess())
		.append("}").toString();
	}
}
