package com.plivo.helper.xml.elements;

public class Speak extends PlivoElement {

    public Speak(String text) {
       super(E_SPEAK, text);
    }

    /**
     * Sets the integer.
     *
     * @param attr the attr
     * @param intr the intr
     */
    private void setInteger(String attr, Integer intr) {
       this.set(attr, intr.toString()); 
    }

    /**
     * Voice to be used based on TTS engine
     * @param voice
     */
    public void setVoice(String voice) {
        this.set("voice", voice);
    }

    /**
     * Language to use
     * @param language
     */
    public void setLanguage(String language) {
        this.set("language", language);
    }

    /**
     * Number of times to say this text
     * @param loop
     */
    public void setLoop(Integer loop) {
        this.setInteger("loop", loop);
    }

}
