package com.plivo.helper.xml.elements;

import java.util.ArrayList;

public class Dial extends PlivoElement {

    public Dial() {
       super(E_DIAL, null);
       this.nestableElements = new ArrayList<String>();
       this.nestableElements.add(E_NUMBER);
       this.nestableElements.add(E_USER);
    }

    /**
     * Sets the integer.
     *
     * @param attr the attr
     * @param intr the intr
     */
    private void setInteger(String attr, Integer intr) {
       this.set(attr, intr.toString()); 
    }

    /**
     * Sets the boolean.
     *
     * @param attr the attr
     * @param bool the bool
     */
    private void setBoolean(String attr, Boolean bool) {
       this.set(attr, bool.toString().toLowerCase()); 
    }

    /**
     *  Hang up the call after these many seconds. 0 means no timeLimit
     * @param timeLimit
     */
    public void setTimeLimit(Integer timeLimit) {
        this.setInteger("timeLimit", timeLimit);
    }

    /**
     *  Hang up the call after these many seconds. 0 means no timeLimit
     * @param timeLimit
     */
    public void setTimeout(Integer timeout) {
        this.setInteger("timeout", timeout);
    }

    /**
     * Submit the result of the dial and redirect to this URL 
     * @param action
     */
    public void setAction(String action) {
        this.set("action", action);
    }

    /**
     * Submit to 'action' URL using GET or POST
     * @param method
     */
    public void setMethod(String method) {
        this.set("method", method);
    }

    /**
     * Hang up the b leg if a leg presses start and this is true
     * @param hangupOnStar
     */
    public void setHangupOnStar(Boolean hangupOnStar) {
        this.setBoolean("hangupOnStar", hangupOnStar);
    }

    /**
     * Caller id to be send to the dialed number
     * @param callerId
     */
    public void setCallerId(String callerId) {
        this.set("callerId", callerId);
    }

    /**
     * Sound to be played to b leg before call is bridged
     * @param confirmSound
     */
    public void setConfirmSound(String confirmSound) {
        this.set("confirmSound", confirmSound);
    }

    /**
     * Key to be pressed to bridge the call.
     * @param confirmKey
     */
    public void setConfirmKey(String confirmKey) {
        this.set("confirmKey", confirmKey);
    }

    /**
     * Play music to a leg while doing a dial to b leg
                Can be a list of files separated by comma
     * @param dialMusic
     */
    public void setDialMusic(String dialMusic) {
        this.set("dialMusic", dialMusic);
    }

    /**
     *  If 'false', don't redirect to 'action', only request url 
        and continue to next element. (default 'true')
     * @param redirect
     */
    public void setRedirect(Boolean redirect) {
        this.setBoolean("redirect", redirect);
    }

    /**
     *  URL to request when bridge starts and bridge ends
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.set("callbackUrl", callbackUrl);
    }

    /**
     * Submit to 'callbackUrl' URL using GET or POST
     * @param callbackMethod
     */
    public void setCallbackMethod(String callbackMethod) {
        this.set("callbackMethod", callbackMethod);
    }

    /**
     * Set matching key combination for the caller (A leg).
     * @param digitsMatch
     */
    public void setDigitsMatch(String digitsMatch) {
        this.set("digitsMatch", digitsMatch);
    }

    /**
     * Set matching key combination for the caller (B leg).
     * @param digitsMatchBLeg
     */
    public void setDigitsMatchBLeg(String digitsMatchBLeg) {
        this.set("digitsMatchBLeg", digitsMatchBLeg);
    }

    /**
     * If set to a string, caller name will be set to this 
    * string value. Default is current caller name.
     * @param callerName
     */
    public void setCallerName(String callerName) {
        this.set("callerName", callerName);
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
        this.set("sipHeaders", sipHeaders);
    }

}
