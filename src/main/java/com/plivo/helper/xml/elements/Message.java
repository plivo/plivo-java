package com.plivo.helper.xml.elements;

public class Message extends PlivoElement {

	public Message(String text, String src, String dst) {
		super(E_MESSAGE, text);
		this.setSource(src);
		this.setDestination(dst);
		this.nestableElements = null;
	}

	/**
	 * Destination number
	 * 
	 * @param dst
	 */
	public void setDestination(String dst) {
		this.set("dst", dst);
	}

	/**
	 * Source number
	 * 
	 * @param src
	 */
	public void setSource(String src) {
		this.set("src", src);
	}

	/**
	 * Message type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.set("type", type);
	}

	/**
	 * URL that is notified by Plivo when a response is available and to which
	 * the response is sent.
	 * 
	 * @param callbackUrl
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.set("callbackUrl", callbackUrl);
	}

	/**
	 * The method used to notify the callbackUrl.
	 * 
	 * @param callbackMethod
	 */

	public void setCallbackMethod(String callbackMethod) {
		this.set("callbackMethod", callbackMethod);
	}

}
