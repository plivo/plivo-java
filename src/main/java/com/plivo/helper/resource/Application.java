package com.plivo.helper.resource;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestClient;

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
