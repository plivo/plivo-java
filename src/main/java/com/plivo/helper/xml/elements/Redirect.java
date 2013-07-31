package com.plivo.helper.xml.elements;

public class Redirect extends PlivoElement {

    public Redirect(String uri) {
       super(E_REDIRECT, uri);
       this.nestableElements = null;
    }

   /**
    * Used to specify the HTTP request mode to obtain 
    * the Redirect URL.
    * @param method
    */
    public void setMethod(String method) {
        this.set("method", method);
    }

    /**
     * The URL to redirect the call
     * @param url
     */
    public void setUrl(String url) {
        this.set("url", url);
    }

}
