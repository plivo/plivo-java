package com.plivo.sdk.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Speak implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String voice; 
    @XmlAttribute
    private String language;
    @XmlAttribute(required=false)
    private Integer loop;

    @XmlValue
    private String text;

    public Speak() {

    }

    public String getVoice() {
        return voice;
    }

    /**
     * Voice to be used based on TTS engine
     * @param voice
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getLanguage() {
        return language;
    }

    /**
     * Language to use
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getLoop() {
        return loop;
    }

    /**
     * Number of times to say this text
     * @param loop
     */
    public void setLoop(Integer loop) {
        this.loop = loop;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}