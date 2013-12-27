package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.ApplicationCreateResponse;
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

    public static String create(LinkedHashMap<String, String> parameters, PlivoRestConf conf)  throws PlivoException{
		Gson gson = new Gson();
		ApplicationCreateResponse acr =  gson.fromJson(request("POST", "/Application/", parameters, conf), 
				ApplicationCreateResponse.class);
		if (acr.isSuccessful()) {
			return acr.getApplicationId();
		}else {
			return null;
		}
	}
    
    public static Application get(String appId, PlivoRestConf conf) throws PlivoException{
    	Gson gson = new Gson();
		Application app =  gson.fromJson(request("GET", String.format("/Application/%s/", appId), 
	                new LinkedHashMap<String, String>(), conf), Application.class);
		if (app.isGetOK()) {
			app.setOK(true);
			app.conf = conf;
			return app;
		} else {
			return null;
		}
    }
    /**
     * Delete this application.
     * @return true if successful.
     * @throws PlivoException
     */
    public boolean delete() throws PlivoException {
    	DeleteResponse dr;
    	Gson gson = new Gson();
    	dr = gson.fromJson(request("DELETE", String.format("/Application/%s/", this.applicationID), 
    			new LinkedHashMap<String, String>(), this.conf), 
    			DeleteResponse.class);
    	return dr.isSuccessful();
    }
    
    public static boolean delete(String appId, PlivoRestConf conf) throws PlivoException {
    	DeleteResponse dr;
    	Gson gson = new Gson();
    	dr = gson.fromJson(request("DELETE", String.format("/Application/%s/", appId), 
    			new LinkedHashMap<String, String>(), conf), 
    			DeleteResponse.class);
    	return dr.isSuccessful();
    }
    
    public boolean modify(LinkedHashMap<String, String> parameters)  throws PlivoException{
    	Gson gson = new Gson();
    	ModifyResponse mr = gson.fromJson(request("POST", String.format("/Application/%s/", this.applicationID),
    			parameters, this.conf), 
    			ModifyResponse.class);
    	return mr.isSuccessful();
    }
    
    public static boolean modify(String appId, LinkedHashMap<String, String> parameters, PlivoRestConf conf)  throws PlivoException{
    	Gson gson = new Gson();
    	ModifyResponse mr = gson.fromJson(request("POST", String.format("/Application/%s/", appId),
    			parameters, conf), 
    			ModifyResponse.class);
    	return mr.isSuccessful();
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
