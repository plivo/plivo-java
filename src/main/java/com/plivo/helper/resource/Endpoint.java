package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.EndpointCreateResponse;
import com.plivo.helper.response.ModifyResponse;

public class Endpoint extends Resource {
	private String username;

	@SerializedName("sip_uri")
	private String sipUri;

	private String alias;

	@SerializedName("endpoint_id")
	private String endpointId;

	private String password;

	private static String baseLoc = "/Endpoint/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Get details of an endpoint
	 * 
	 * @see http://plivo.com/docs/api/endpoint/#get
	 * @param endpointId
	 *            Endpoint id
	 * @param conf
	 *            Plivo rest config
	 * @return endpoint object
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static Endpoint get(String endpointId, PlivoRestConf conf)
			throws PlivoException, APIException {
		Endpoint e = getRequest(getIdLoc(endpointId),
				new LinkedHashMap<String, String>(), Endpoint.class, conf, 200);
		e.conf = conf;
		return e;
	}

	/**
	 * Get lisf of endpoint
	 * 
	 * @see http://plivo.com/docs/api/endpoint/#getall
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static EndpointList getList(PlivoRestConf conf)
			throws PlivoException, APIException {

		EndpointList el = getRequest(baseLoc,
				new LinkedHashMap<String, String>(), EndpointList.class, conf,
				200);
		el.conf = conf;
		return el;
	}

	/**
	 * Create an endpoint
	 * 
	 * @see http://plivo.com/docs/api/endpoint/#create
	 * @param params
	 *            endpoint params
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static EndpointCreateResponse create(
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		EndpointCreateResponse er = postRequest(baseLoc, params,
				EndpointCreateResponse.class, conf);
		return er;
	}

	/**
	 * Delete an endpoint
	 * 
	 * @see http://plivo.com/docs/api/endpoint/#delete
	 * @param id
	 *            endpoint id
	 * @param conf
	 *            Plivo REST Config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void delete(String id, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequest(getIdLoc(id), new LinkedHashMap<String, String>(),
				DeleteResponse.class, conf);
	}

	/**
	 * Modify and endpoint.
	 * 
	 * @param id
	 *            endpoint id
	 * @param params
	 *            params to modify
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void modify(String id, LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		postRequestExpect(getIdLoc(id), params, ModifyResponse.class, conf, 202);
	}

	public String getUsername() {
		return username;
	}

	public String getSipUri() {
		return sipUri;
	}

	public String getAlias() {
		return alias;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getPassword() {
		return password;
	}
}
