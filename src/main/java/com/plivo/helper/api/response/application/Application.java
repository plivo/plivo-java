package com.plivo.helper.api.response.application;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Application {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("fallback_method")
    public String fallbackMethod ;
    
    @SerializedName("default_app")
    public Boolean isDefaultApplication ;
    
    @SerializedName("app_name")
    public String applicationName ;
    
    @SerializedName("production_app")
    public Boolean isProductionApplication ;
    
    @SerializedName("app_id")
    public String applicationID ;
    
    @SerializedName("hangup_url")
    public String hangupUrl ;
    
    @SerializedName("answer_url")
    public String answerUrl ;
    
    @SerializedName("message_url")
    public String messageUrl ;
    
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    @SerializedName("answer_method")
    public String answerMethod ;
    
    @SerializedName("hangup_method")
    public String hangupMethod ;
    
    @SerializedName("message_method")
    public String messageMethod ;
    
    @SerializedName("fallback_answer_url")
    public String fallbackAnswerUrl ;

    public Map<String, Object> error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String message;
    
    public Application() {
        // empty
    }

	@Override
	public String toString() {
		return "Application [serverCode=" + serverCode + ", fallbackMethod="
				+ fallbackMethod + ", isDefaultApplication="
				+ isDefaultApplication + ", applicationName=" + applicationName
				+ ", isProductionApplication=" + isProductionApplication
				+ ", applicationID=" + applicationID + ", hangupUrl="
				+ hangupUrl + ", answerUrl=" + answerUrl + ", messageUrl="
				+ messageUrl + ", resourceUri=" + resourceUri
				+ ", answerMethod=" + answerMethod + ", hangupMethod="
				+ hangupMethod + ", messageMethod=" + messageMethod
				+ ", fallbackAnswerUrl=" + fallbackAnswerUrl + ", error="
				+ error + ", apiId=" + apiId + ", message=" + message + "]";
	}
   
}