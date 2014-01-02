package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.ApplicationCreateResponse;
import com.plivo.helper.response.Response;

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

	/**
	 * Create an Application
	 * 
	 * @see http://plivo.com/docs/api/application/#create
	 * @param parameters
	 *            Application parameters
	 * @param conf
	 *            Plivo REST config
	 * @return application id
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static String create(LinkedHashMap<String, String> parameters,
			PlivoRestConf conf) throws PlivoException, APIException {
		ApplicationCreateResponse acr = postRequest(baseLoc, parameters,
				ApplicationCreateResponse.class, conf);
		return acr.getApplicationId();
	}

	/**
	 * Get Details of a Single Application
	 * 
	 * @see http://plivo.com/docs/api/application/#application
	 * @param appId
	 *            application id
	 * @param conf
	 *            Plivo REST config
	 * @return application details
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static Application get(String appId, PlivoRestConf conf)
			throws PlivoException, APIException {
		Application app = getRequest(String.format(baseLoc + "%s/", appId),
				new LinkedHashMap<String, String>(), Application.class, conf);
		app.conf = conf;
		return app;

	}

	/**
	 * Get Details of All Applications
	 * 
	 * @param params
	 *            list params
	 * @param conf
	 *            Plivo REST config
	 * @return application list that match passed params
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static ApplicationList getList(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		ApplicationList al = getRequest(baseLoc, params, ApplicationList.class,
				conf);
		al.conf = conf;
		return al;
	}

	/**
	 * Delete an application
	 * 
	 * @see http://plivo.com/docs/api/application/#delete
	 * @param appId
	 *            application id
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void delete(String appId, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(getIdLoc(appId),
				new LinkedHashMap<String, String>(), Response.class, conf, 204);
	}

	/**
	 * Modify an application
	 * 
	 * @see http://plivo.com/docs/api/application/#modify
	 * @param appId
	 *            application ID
	 * @param parameters
	 *            parameters to modify
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void modify(String appId,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(getIdLoc(appId), parameters, Response.class, conf,
				202);
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
