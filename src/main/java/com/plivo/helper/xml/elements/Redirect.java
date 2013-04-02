package com.plivo.helper.xml.elements;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Redirect implements Serializable {

    private static final long serialVersionUID = 158509162906138363L;

    @XmlAttribute
    private String method;

    @XmlValue
    private String url;

    public Redirect() {

    }

	/**
	 * Used to specify the HTTP request mode to obtain 
	 * the Redirect URL.
	 * @param method
	 */
    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    /**
     * The URL to redirect the call
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
