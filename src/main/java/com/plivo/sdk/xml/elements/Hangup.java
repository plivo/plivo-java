package com.plivo.sdk.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Hangup implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String reason;

    @XmlAttribute
    private Integer schedule;

    public Hangup() {

    }

    public String getReason() {
        return reason;
    }

    /**
     * Give the reason of han gup
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSchedule() {
        return schedule;
    }

    /**
     * Set the schedule time, in seconds
     * @param schedule
     */
    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }
}