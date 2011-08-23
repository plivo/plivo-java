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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	private String finishOnKey;
	
	@XmlAttribute
	private boolean playBeep;
	
	@XmlAttribute
	private String format;

	@XmlAttribute
	private String filePath;
	
	@XmlAttribute
	private String fileName;
	
	@XmlAttribute
	private boolean bothLegs;
	
	public Record() {
		
	}
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * Maximum number of seconds to record (default 60)
	 * @param maxLength
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public String getAction() {
		return action;
	}

	/**
	 * Submit the result of the record to this URL
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	public int getTimeout() {
		return timeout;
	}

	/**
	 * Seconds of silence before considering the recording complete (default 500) 
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getMethod() {
		return method;
	}

	/**
	 * Submit to 'action' URL using GET or POST
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getFinishOnKey() {
		return finishOnKey;
	}

	/**
	 * Stop recording on this key
	 * @param finishOnKey
	 */
	public void setFinishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
	}

	public boolean isPlayBeep() {
		return playBeep;
	}
	
	/**
	 * Play a beep before recording (true/false, default true)
	 * @param playBeep
	 */
	public void setPlayBeep(boolean playBeep) {
		this.playBeep = playBeep;
	}
	
	public String getFormat() {
		return format;
	}

	/**
	 * File format (default mp3)
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	public String getFilePath() {
		return filePath;
	}

	/**
	 * Complete file path to save the file to
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public boolean isBothLegs() {
		return bothLegs;
	}

	/**
	 * Record both legs (true/false, default false)
              no beep will be played
	 * @param bothLegs
	 */
	public void setBothLegs(boolean bothLegs) {
		this.bothLegs = bothLegs;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Filename to be used for recording of file
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
