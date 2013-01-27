package com.plivo.sdk.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Message implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String src;

    @XmlAttribute
    private String dst;

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String callbackUrl;

    @XmlAttribute
    private String callbackMethod;

    @XmlValue
    private String text;

    public Message() {

    }

    /**
     * Destination number
     * @param dst
     */
    public void setDestination(String dst) {
        this.dst = dst;
    }

    public String getDestination() {
        return dst;
    }

    /**
     * Source number
     * @param src
     */
    public void setSource(String src) {
        this.src = src;
    }

    public String getSource() {
        return src;
    }

    /**
     * Message type
     * @param type
     */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * URL that is notified by Plivo when a response is available 
	 * and to which the response is sent. 
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * The method used to notify the callbackUrl.
     * @param callbackMethod
     */

    public String getCallbackMethod() {
        return callbackMethod;
    }

    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    /**
     * Message text to be sent 
     * @param text
     */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
