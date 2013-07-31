package com.plivo.helper.xml.elements;

public class Dtmf extends PlivoElement {

    public Dtmf(String body) {
       super(E_DTMF, body);
       this.nestableElements = null;
    }

    /**
     * Send DTMF digits from the current call. 
    * Use the character 'w' for a 0.5 second delay 
    * and the character 'W' for a 1 second delay.
     * @param digits
     */
    public void setDigits(String digits) {
        this.set(body, digits);
    }

}
