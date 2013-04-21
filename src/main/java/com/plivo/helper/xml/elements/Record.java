package com.plivo.helper.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private Integer maxLength;

    @XmlAttribute
    private String action;

    @XmlAttribute
    private Integer timeout;

    @XmlAttribute
    private String method;

    @XmlAttribute
    private String finishOnKey;

    @XmlAttribute
    private Boolean playBeep;

    @XmlAttribute
    private Boolean bothLegs;

    @XmlAttribute
    private Boolean redirect;

    @XmlAttribute
    private Boolean startOnDialAnswer;

    @XmlAttribute
    private Boolean recordSession;

    @XmlAttribute
    private String callbackUrl;

    @XmlAttribute
    private String callbackMethod;

    public Record() {

    }

    /**
     * Maximum number of seconds to record (default 60)
     * @param maxLength
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * Submit the result of the record to this URL
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    /**
     * Seconds of silence before considering the recording complete (default 500) 
     * @param timeout
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Submit to 'action' URL using GET or POST
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    /**
     * Stop recording on this key
     * @param finishOnKey
     */
    public void setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
    }

    public String getFinishOnKey() {
        return finishOnKey;
    }

    /**
     * Play a beep before recording (true/false, default true)
     * @param playBeep
     */
    public void setPlayBeep(Boolean playBeep) {
        this.playBeep = playBeep;
    }

    public Boolean isPlayBeep() {
        return playBeep;
    }

    /**
     * Redirect to action url or not (true/false, default false)
     * @param redirect
     */
    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    /**
     * Record call when called party answers in a Dial 
	 * (true/false, default false). No beep will be played.
     * @param startOnDialAnswer
     */
    public void setStartOnDialAnswer(Boolean startOnDialAnswer) {
        this.startOnDialAnswer = startOnDialAnswer;
    }

    public Boolean getStartOnDialAnswer() {
        return startOnDialAnswer;
    }

	/**
	 * Record current call session in background 
	 * (true/false, default false). No beep will be played.
	 * @param recordSession
	 */
    public void setRecordSession(Boolean recordSession) {
        this.recordSession = recordSession;
    }

    public Boolean getRecordSession() {
        return recordSession;
    }

    public void setCallbackUrl(String callbackUrl){
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackUrl(){
        return callbackUrl;
    }

    public void setCallbackMethod(String callbackMethod){
        this.callbackMethod = callbackMethod;
    }

    public String getCallbackMethod(){
        return callbackMethod;
    }
}
