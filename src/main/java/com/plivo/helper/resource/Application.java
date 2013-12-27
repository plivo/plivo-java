package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;

public class Application extends Resource{
    @SerializedName("fallback_method")
    private String fallbackMethod ;
    
    @SerializedName("default_app")
    private Boolean isDefaultApplication ;
    
    @SerializedName("app_name")
    private String applicationName ;
    
    @SerializedName("production_app")
    private Boolean isProductionApplication ;
    
    @SerializedName("app_id")
    private String applicationID ;
    
    @SerializedName("hangup_url")
    private String hangupUrl ;
    
    @SerializedName("answer_url")
    private String answerUrl ;
    
    @SerializedName("message_url")
    private String messageUrl ;
    
    @SerializedName("resource_uri")
    private String resourceUri ;
    
    @SerializedName("answer_method")
    private String answerMethod ;
    
    @SerializedName("hangup_method")
    private String hangupMethod ;
    
    @SerializedName("message_method")
    private String messageMethod ;
    
    @SerializedName("fallback_answer_url")
    private String fallbackAnswerUrl ;

    public Application(PlivoRestClient client) {
    	super(client);
    }
    
    public Application(PlivoRestClient client, String appId) {
    	super(client);
    	this.applicationID = appId;
    }
    
    /**
     * Delete this application.
     * @return true if successful.
     * @throws PlivoException
     */
    public boolean delete() throws PlivoException {
    	DeleteResponse dr;
    	Gson gson = new Gson();
    	dr = gson.fromJson(this.client.request("DELETE", String.format("/Application/%s/", this.applicationID), 
    			new LinkedHashMap<String, String>()), 
    			DeleteResponse.class);
    	return dr.isSuccessful();
    }
    
    public boolean modify(LinkedHashMap<String, String> parameters)  throws PlivoException{
    	Gson gson = new Gson();
    	ModifyResponse mr = gson.fromJson(this.client.request("POST", String.format("/Application/%s/", this.applicationID), parameters), 
    			ModifyResponse.class);
    	return mr.isSuccessful();
    }
    
    public Integer getServerCode() {
		return serverCode;
	}

	public String getFallbackMethod() {
		return fallbackMethod;
	}

	public Boolean getIsDefaultApplication() {
		return isDefaultApplication;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public Boolean getIsProductionApplication() {
		return isProductionApplication;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public String getHangupUrl() {
		return hangupUrl;
	}

	public String getAnswerUrl() {
		return answerUrl;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public String getAnswerMethod() {
		return answerMethod;
	}

	public String getHangupMethod() {
		return hangupMethod;
	}

	public String getMessageMethod() {
		return messageMethod;
	}

	public String getFallbackAnswerUrl() {
		return fallbackAnswerUrl;
	}
}
