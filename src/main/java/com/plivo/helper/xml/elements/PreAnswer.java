package com.plivo.helper.xml.elements;

import java.util.ArrayList;

public class PreAnswer extends PlivoElement {

    public PreAnswer() {
       super(E_PREANSWER, null);
       this.nestableElements = new ArrayList<String>();
       this.nestableElements.add(E_PLAY);
       this.nestableElements.add(E_SPEAK);
       this.nestableElements.add(E_GETDIGITS);
       this.nestableElements.add(E_WAIT);
       this.nestableElements.add(E_REDIRECT);
    }

}
