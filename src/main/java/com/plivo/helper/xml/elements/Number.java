package com.plivo.helper.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Number implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String sendDigits;

    @XmlAttribute
    private String sendDigitsMode;
    
    @XmlAttribute
    private Boolean sendOnPreanswer;

    @XmlValue
    private String number;

    public Number() {

    }

    /**
     * specify if you need inband (default = rfc2833)
     * @param sendDigitsMode
     */
    public void setSendDigitsMode(String sendDigitsMode) {
        this.sendDigitsMode = sendDigitsMode;
    }

    public String getSendDigitsMode() {
        return sendDigitsMode;
    }

    /**
     * Key to press after connecting to the number
     * @param sendDigits
     */
    public void setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
    }

    public String getSendDigits() {
        return sendDigits;
    }

    /**
     * Phone number to dial
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    /**
     * If the digits need to be sent during
	 * early media.
     * @param sendOnPreanswer
     */
    public Boolean isSendOnPreanswer() {
        return sendOnPreanswer;
    }

    public void setSendOnPreanswer(Boolean sendOnPreanswer) {
        this.sendOnPreanswer = sendOnPreanswer;
    }
 }
