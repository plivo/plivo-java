package com.plivo.sdk.xml.elements;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class GetDigits implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute(required=true)
    private String action;

    @XmlAttribute()
    private Integer timeout;
    
    @XmlAttribute
    private Integer digitTimeout;

    @XmlAttribute
    private String method;

    @XmlAttribute
    private String finishOnKey;

    @XmlAttribute
    private Integer numDigits;

    @XmlAttribute
    private Integer retries;

    @XmlAttribute
    private Boolean playBeep;

    @XmlAttribute
    private String validDigits;

    @XmlAttribute
    private String invalidDigitsSound;

    @XmlElement(name="Play")
    private ArrayList<Play> playList;

    @XmlElement(name="Speak")
    private ArrayList<Speak> speakList;

    @XmlElement(name="Wait")
    private ArrayList<Wait> waitList;

    public GetDigits() {
		playList = new ArrayList<Play>();
		speakList = new ArrayList<Speak>();
		waitList = new ArrayList<Wait>();
    }

     /**
     * URL to which the digits entered will be sent
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    /**
     * Time in seconds to wait for receiving the first digit. 
     * If the user inputs the timeout value, the next element 
     * in the response is processed.
     * @param timeout
     */
    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    
    /**
     * Time in seconds to wait in between two digits entered
     * by the user.
     * @param digitTimeout
     */
    public Integer getDigitTimeout() {
        return digitTimeout;
    }
    
    public void setDigitTimeout(Integer digitTimeout) {
        this.digitTimeout = digitTimeout;
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
     * Key that triggers the end of caller input
     * @param finishOnKey
     */
    public void setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
    }

    public String isFinishOnKey() {
        return finishOnKey;
    }
    
    /**
     * How many digits to gather before returning
     * @param numDigits
     */
    public void setNumDigits(Integer numDigits) {
        this.numDigits = numDigits;
    }

    public Integer getNumDigits() {
        return numDigits;
    }

    /**
     * Number of tries to execute all says and plays one by one
     * @param retries
     */
    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public Integer getRetries() {
        return retries;
    }

    /**
     * Play a beep after all plays and says finish
     * @param playBeep
     */
    public void setPlayBeep(Boolean playBeep) {
        this.playBeep = playBeep;
    }

    public Boolean isPlayBeep() {
        return playBeep;
    }

    /**
     * Digits which are allowed to be pressed
     * @param validDigits
     */
    public void setValidDigits(String validDigits) {
        this.validDigits = validDigits;
    }

    public String isValidDigits() {
        return validDigits;
    }

    /**
     * Sound played when invalid digit pressed
     * @param invalidDigitsSound
     */
    public void setInvalidDigitsSound(String invalidDigitsSound) {
        this.invalidDigitsSound = invalidDigitsSound;
    }

    public String isInvalidDigitsSound() {
        return invalidDigitsSound;
    }

    public void addPlay(Play play) {
        this.playList.add(play);
    }

    public void addSpeak(Speak speak) {
        this.speakList.add(speak);
    }

    public void addWait(Wait wait) {
        this.waitList.add(wait);
    }
}
