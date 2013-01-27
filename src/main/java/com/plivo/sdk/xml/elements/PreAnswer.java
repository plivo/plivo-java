package com.plivo.sdk.xml.elements;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PreAnswer implements Serializable {

    private static final long serialVersionUID = 2635662975269038297L;

    @XmlElement(name="Speak")
    private ArrayList<Speak> speakFactory;

    @XmlElement(name="Play")
    private ArrayList<Play> playFactory;

    @XmlElement(name="GetDigits")
    private ArrayList<GetDigits> getDigitsFactory;

    @XmlElement(name="Wait")
    private ArrayList<Wait> waitFactory;

    @XmlElement(name="Redirect")
    private ArrayList<Redirect> redirectFactory;

    @XmlElement(name="Message")
    private ArrayList<Message> messageFactory;

    public PreAnswer() {
		speakFactory = new ArrayList<Speak>();
		playFactory = new ArrayList<Play>();
		getDigitsFactory = new ArrayList<GetDigits>();
		waitFactory = new ArrayList<Wait>();
		redirectFactory = new ArrayList<Redirect>();
		messageFactory = new ArrayList<Message>();
    }

    public void addSpeak(Speak speak) {
        this.speakFactory.add(speak);
    }

    public void addPlay(Play play) {
        this.playFactory.add(play);
    }

    public void addGetDigits(GetDigits getDigits) {
        this.getDigitsFactory.add(getDigits);
    }

    public void addWait(Wait wait) {
        this.waitFactory.add(wait);
    }

    public void addRedirect(Redirect redirect) {
        this.redirectFactory.add(redirect);
    }
}
