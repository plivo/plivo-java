package com.plivo.helper.xml.elements;

public class Number extends PlivoElement {

    public Number(String number) {
       super(E_NUMBER, number);
       this.nestableElements = null;
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
     * specify if you need inband (default = rfc2833)
     * @param sendDigitsMode
     */
    public void setSendDigitsMode(String sendDigitsMode) {
        this.set("sendDigitsMode", sendDigitsMode);
    }

    /**
     * Key to press after connecting to the number
     * @param sendDigits
     */
    public void setSendDigits(String sendDigits) {
        this.set("sendDigits", sendDigits);
    }

    /**
     * If the digits need to be sent during
    * early media.
     * @param sendOnPreanswer
     */
    public void setSendOnPreanswer(Boolean sendOnPreanswer) {
        this.setBoolean("sendOnPreanswer", sendOnPreanswer);
    }
    
 }
