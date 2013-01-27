package com.plivo.sdk.xml.elements;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dial implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private Integer timeLimit;

    @XmlAttribute
    private Integer timeout;

    @XmlAttribute
    private String action;

    @XmlAttribute
    private String method;

    @XmlAttribute
    private String callerName;

    @XmlAttribute
    private Boolean hangupOnStar;

    @XmlAttribute
    private String confirmSound;

    @XmlAttribute
    private String confirmKey;

    @XmlAttribute
    private String dialMusic;

    @XmlAttribute
    private String callerId;

    @XmlAttribute
    private Boolean redirect;

    @XmlAttribute
    private String callbackUrl;

    @XmlAttribute
    private String callbackMethod;

    @XmlAttribute
    private String digitsMatch;

    @XmlAttribute
    private String sipHeaders;

    @XmlElement(name="Number")
    private ArrayList<Number> numberFactory;

    @XmlElement(name="User")
    private ArrayList<User> sipUserFactory;

    public Dial() {
		numberFactory = new ArrayList<Number>();
		sipUserFactory = new ArrayList<User>();
    }

    /**
     *  Hang up the call after these many seconds. 0 means no timeLimit
     * @param timeLimit
     */
    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    /**
     *  Hang up the call after these many seconds. 0 means no timeLimit
     * @param timeLimit
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Submit the result of the dial and redirect to this URL 
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
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
     * Hang up the b leg if a leg presses start and this is true
     * @param hangupOnStar
     */
    public void setHangupOnStar(Boolean hangupOnStar) {
        this.hangupOnStar = hangupOnStar;
    }

    public Boolean getHangupOnStar() {
        return hangupOnStar;
    }

    /**
     * Caller id to be send to the dialed number
     * @param callerId
     */
    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getCallerId() {
        return callerId;
    }

    /**
     * The number to be dialed
     * @param number
     */
    public void addNumber(Number number) {
        this.numberFactory.add(number);
    }

    /**
     * The sip uri to be dialed
     * @param sipUser
     */
    public void addUser(User sipUser) {
        this.sipUserFactory.add(sipUser);
    }

    /**
     * Sound to be played to b leg before call is bridged
     * @param confirmSound
     */
    public void setConfirmSound(String confirmSound) {
        this.confirmSound = confirmSound;
    }

    public String getConfirmSound() {
        return confirmSound;
    }

    /**
     * Key to be pressed to bridge the call.
     * @param confirmKey
     */
    public void setConfirmKey(String confirmKey) {
        this.confirmKey = confirmKey;
    }

    public String getConfirmKey() {
        return confirmKey;
    }

    /**
     * Play music to a leg while doing a dial to b leg
                Can be a list of files separated by comma
     * @param dialMusic
     */
    public void setDialMusic(String dialMusic) {
        this.dialMusic = dialMusic;
    }

    public String getDialMusic() {
        return dialMusic;
    }

    /**
     *  If 'false', don't redirect to 'action', only request url 
        and continue to next element. (default 'true')
     * @param redirect
     */
    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    /**
     *  URL to request when bridge starts and bridge ends
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Submit to 'callbackUrl' URL using GET or POST
     * @param callbackMethod
     */
    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    public String getCallbackMethod() {
        return callbackMethod;
    }

    /**
     * Set matching key combination for the caller (A leg).
     * @param digitsMatch
     */
    public String getDigitsMatch() {
        return digitsMatch;
    }

    public void setDigitsMatch(String digitsMatch) {
        this.digitsMatch = digitsMatch;
    }

    /**
     * If set to a string, caller name will be set to this 
	 * string value. Default is current caller name.
     * @param callerName
     */
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallerName() {
        return callerName;
    }

    /**
     * The SIP headers are always prefixed with X-PH-. For every HTTP Request 
	 * called by the dialed leg, the SIP headers will be present. 
	 * Only [A-Z], [a-z] and [0-9] characters are allowed for SIP headers key. 
	 * Only [A-Z], [a-z], [0-9] and '%' characters are allowed for SIP headers 
	 * value (so you can URL encode this value).
     * @param sipHeaders
     */
    public void setSipHeaders(String sipHeaders) {
        this.sipHeaders = sipHeaders;
    }

    public String getSipHeaders() {
        return sipHeaders;
    }
}
