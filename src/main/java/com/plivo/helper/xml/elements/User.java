package com.plivo.helper.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String sendDigits;
    
    @XmlAttribute
    private String sendDigitsMode;

    @XmlAttribute
    private Boolean sendOnPreanswer;

    @XmlValue
    private String sipUser;

    public User() {

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
     * Key to press after connecting to the user
     * @param sendDigits
     */
    public void setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
    }

	public String getSendDigits() {
        return sendDigits;
    }

    /**
     * SIP URI to dial
     * @param sipUser
     */
    public void setUser(String sipUser) {
        this.sipUser = sipUser;
    }

    public String getUser() {
        return sipUser;
    }

    /**
     * If the digits need to be sent during
	 * early media.
     * @param sendOnPreanswer
     */
    public void setSendOnPreanswer(Boolean sendOnPreanswer) {
        this.sendOnPreanswer = sendOnPreanswer;
    }

    public Boolean isSendOnPreanswer() {
        return sendOnPreanswer;
    }
}
