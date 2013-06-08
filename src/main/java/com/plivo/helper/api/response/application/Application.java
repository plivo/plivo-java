package com.plivo.helper.api.response.application;

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

    public String error ;
    
    public Application() {
        // empty
    }
}