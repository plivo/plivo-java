package com.plivo.helper.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Wait implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private Integer length;

    @XmlAttribute
    private Boolean silence;

    public Wait() {

    }

    /**
     * Length of wait time in seconds
     * @param length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

	/**
	 * If silence is also set to "true", the XML will process 
	 * the next element when there is no voice or sound at the other end,
	 * overriding the value of the length attribute. 
	 * @param silence
	 */
    public void setSilence(Boolean silence) {
        this.silence = silence;
    }

    public Boolean isSilence() {
        return silence;
    }
}
