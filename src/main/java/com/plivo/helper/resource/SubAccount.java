package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;
import com.plivo.helper.response.SubAccountCreateResponse;

public class SubAccount extends Resource {
	private String account;

	@SerializedName("auth_id")
	private String authId;

	@SerializedName("auth_token")
	private String authToken;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("created")
	private String createdOn;

	@SerializedName("enabled")
	private Boolean isEnabled;

	@SerializedName("modified")
	private String lastModifiedOn;

	private String name;

	private static String baseLoc = "/Subaccount/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Get Details Of a Specific Subaccount
	 * 
	 * @see http://plivo.com/docs/api/account/#details_subaccount
	 * @param subauthId
	 *            sub account id
	 * @param conf
	 *            Plivo REST config
	 * @return Sub Account details
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static SubAccount get(String subauthId, PlivoRestConf conf)
			throws PlivoException, APIException {
		SubAccount sa = getRequest(getIdLoc(subauthId),
				new LinkedHashMap<String, String>(), SubAccount.class, conf);

		sa.conf = conf;
		return sa;
	}

	/**
	 * Get details of all sub account
	 * 
	 * @see http://plivo.com/docs/api/account/#subaccount
	 * @param parameters
	 *            optional params
	 * @param conf
	 *            Plivo REST config
	 * @return Sub Account list
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static SubAccountList getList(
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {
		SubAccountList sal = getRequest(baseLoc, parameters,
				SubAccountList.class, conf);
		sal.conf = conf;
		return sal;
	}

	/**
	 * Create a sub account
	 * 
	 * @see http://plivo.com/docs/api/account/#create_subaccount
	 * @param parameters
	 *            Sub account parameters
	 * @param conf
	 *            Plivo REST config
	 * @return sub account id
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static String create(LinkedHashMap<String, String> parameters,
			PlivoRestConf conf) throws PlivoException, APIException {
		SubAccountCreateResponse scr = postRequest(baseLoc, parameters,
				SubAccountCreateResponse.class, conf);

		return scr.getAuthId();
	}

	/**
	 * Modify a sub account
	 * 
	 * @see http://plivo.com/docs/api/account/#modify_subaccount
	 * @param subAuthId
	 *            sub account id
	 * @param parameters
	 *            modified parameters
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void modify(String subAuthId,
			LinkedHashMap<String, String> parameters, PlivoRestConf conf)
			throws PlivoException, APIException {

		postRequestExpect(getIdLoc(subAuthId), parameters,
				ModifyResponse.class, conf, 202);
	}

	/**
	 * Delete a sub account
	 * 
	 * @see http://plivo.com/docs/api/account/#delete_subaccount
	 * @param subAuthId
	 *            sub account id
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void delete(String subAuthId, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequest(getIdLoc(subAuthId), new LinkedHashMap<String, String>(),
				DeleteResponse.class, conf);
	}

	public String getAccount() {
		return account;
	}

	public String getAuthId() {
		return authId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public String getLastModifiedOn() {
		return lastModifiedOn;
	}

	public String getName() {
		return name;
	}
}
