package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.ApplicationCreateResponse;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;

public class Application extends Resource {
	@SerializedName("fallback_method")
	private String fallbackMethod;

	@SerializedName("default_app")
	private Boolean isDefaultApplication;

	@SerializedName("app_name")
	private String applicationName;

	@SerializedName("production_app")
	private Boolean isProductionApplication;

	@SerializedName("app_id")
	private String applicationID;

	@SerializedName("hangup_url")
	private String hangupUrl;

	@SerializedName("answer_url")
	private String answerUrl;

	@SerializedName("message_url")
	private String messageUrl;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("answer_method")
	private String answerMethod;

	@SerializedName("hangup_method")
	private String hangupMethod;

	@SerializedName("message_method")
	private String messageMethod;

	@SerializedName("fallback_answer_url")
	private String fallbackAnswerUrl;

	private static String baseLoc = "/Application/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	public static String create(LinkedHashMap<String, String> parameters,
			PlivoRestConf conf) throws PlivoException, APIException {
		ApplicationCreateResponse acr = postRequest(baseLoc, parameters,
				ApplicationCreateResponse.class, conf);
		return acr.getApplicationId();
	}

	public static Application get(String appId, PlivoRestConf conf)
			throws PlivoException, APIException {
		Application app = getRequest(String.format(baseLoc + "%s/", appId),
				new LinkedHashMap<String, String>(), Application.class, conf);
		app.conf = conf;
		return app;

	}

	public static ApplicationList getList(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		ApplicationList al = getRequest(baseLoc, params, ApplicationList.class,
				conf);
		al.conf = conf;
		return al;
	}

	public static boolean delete(String appId, PlivoRestConf conf)
			throws PlivoException, APIException {
		DeleteResponse dr;
		dr = deleteRequest(getIdLoc(appId),
				new LinkedHashMap<String, String>(), DeleteResponse.class, conf);
		return dr.isSuccessful();
	}

	public static boolean modify(String appId,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {
		ModifyResponse mr = postRequestExpect(getIdLoc(appId), parameters,
				ModifyResponse.class, conf, 202);
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
