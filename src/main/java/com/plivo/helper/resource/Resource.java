package com.plivo.helper.resource;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestClient;

public abstract class Resource {
	protected PlivoRestClient client;
	@SerializedName("server_code")
	protected Integer serverCode ;
	protected String error;
	private boolean isOK;

	public Resource(PlivoRestClient client) {
		this.client = client;
		this.isOK = true;
	}
	
	/**
	 * Check if GET operation is OK.
	 * @return
	 */
	public boolean isGetOK() {
		return serverCode == 200 && error == null;
	}
	
	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

}
