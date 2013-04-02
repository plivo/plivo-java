package com.plivo.helper.xml.elements;

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
    
    @XmlAttribute
    private Integer loop;

    @XmlValue
    private String text;

    public Speak() {

    }

    /**
     * Voice to be used based on TTS engine
     * @param voice
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    /**
     * Language to use
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    /**
     * Number of times to say this text
     * @param loop
     */
    public void setLoop(Integer loop) {
        this.loop = loop;
    }

    public Integer getLoop() {
        return loop;
    }

    /**
     * Text to be spoken by the TTS engine
     * @param text
     */
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
