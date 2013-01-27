package com.plivo.sdk.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dtmf implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlValue
    private String digits;

    public Dtmf() {

    }

    /**
     * Send DTMF digits from the current call. 
	 * Use the character 'w' for a 0.5 second delay 
	 * and the character 'W' for a 1 second delay.
     * @param digits
     */
    public void setLength(String digits) {
        this.digits = digits;
    }

    public String getLength() {
        return digits;
    }
}
