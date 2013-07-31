package com.plivo.helper.xml.elements;

public class Play extends PlivoElement {

   public Play(String uri) {
       /**
        * Instantiates a new play object.
        *
        * @param uri
        */
      super(E_PLAY, uri);
        this.nestableElements = null;
    }

    /**
     * Number of time to say this text
     * @param loop
     */
    public void setLoop(Integer loop) {
        this.set("loop", loop.toString());
    }

}
