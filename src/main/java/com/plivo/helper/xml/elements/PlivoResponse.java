package com.plivo.helper.xml.elements;


import java.util.ArrayList;

public class PlivoResponse extends PlivoElement {
    
    /**
     * Instantiates a new plivo element response.
     */
    public PlivoResponse() {
      // TODO Auto-generated constructor stub
        super(PlivoElement.E_RESPONSE, null);
        this.nestableElements = new ArrayList<String>();
        this.nestableElements.add(PlivoElement.E_DIAL);
        this.nestableElements.add(PlivoElement.E_CONFERENCE);
        this.nestableElements.add(PlivoElement.E_GETDIGITS);
        this.nestableElements.add(PlivoElement.E_HANGUP);
        this.nestableElements.add(PlivoElement.E_MESSAGE);
        this.nestableElements.add(PlivoElement.E_PLAY);
        this.nestableElements.add(PlivoElement.E_PREANSWER);
        this.nestableElements.add(PlivoElement.E_RECORD);
        this.nestableElements.add(PlivoElement.E_REDIRECT);
        this.nestableElements.add(PlivoElement.E_SPEAK);
        this.nestableElements.add(PlivoElement.E_WAIT);
        this.nestableElements.add(PlivoElement.E_DTMF);
    }

}
