package org.plivo.bridge.to.command;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements Serializable {

	private static final long serialVersionUID = 158509162906138363L;
	
	@XmlAttribute
	private int maxLength;
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private int timeout;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private boolean finishOnKey;
	
	@XmlAttribute
	private boolean transcribe;
	
	@XmlAttribute
	private boolean transcribeCallback;
	
	@XmlAttribute
	private boolean playBepp;
	
	@XmlAttribute
	private String format;

	@XmlAttribute
	private String filePath;
	
	@XmlAttribute
	private String prefix;
	
	@XmlAttribute
	private boolean bothLegs;
	
	public Record() {
		
	}


	public int getMaxLength() {
		return maxLength;
	}


	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public int getTimeout() {
		return timeout;
	}


	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public boolean isFinishOnKey() {
		return finishOnKey;
	}


	public void setFinishOnKey(boolean finishOnKey) {
		this.finishOnKey = finishOnKey;
	}


	public boolean isTranscribe() {
		return transcribe;
	}


	public void setTranscribe(boolean transcribe) {
		this.transcribe = transcribe;
	}


	public boolean isTranscribeCallback() {
		return transcribeCallback;
	}


	public void setTranscribeCallback(boolean transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
	}


	public boolean isPlayBepp() {
		return playBepp;
	}


	public void setPlayBepp(boolean playBepp) {
		this.playBepp = playBepp;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getPrefix() {
		return prefix;
	}


	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}


	public boolean isBothLegs() {
		return bothLegs;
	}


	public void setBothLegs(boolean bothLegs) {
		this.bothLegs = bothLegs;
	}
}
