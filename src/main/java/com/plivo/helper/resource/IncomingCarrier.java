package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.IncomingCarrierCreateResponse;
import com.plivo.helper.response.Response;

public class IncomingCarrier extends Resource {
	@SerializedName("carrier_id")
	private String carrierId;

	@SerializedName("ip_set")
	private String ipSet;

	@SerializedName("name")
	private String name;

	@SerializedName("resource_uri")
	private String resourceUri;

	@SerializedName("sms")
	private Boolean sms;

	@SerializedName("voice")
	private Boolean voice;

	private static String baseLoc = "/IncomingCarrier/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Get details of an Incoming Carrier
	 * 
	 * @see http://plivo.com/docs/api/incomingcarrier/#carrier_detail
	 * @param id
	 *            carrier id
	 * @param conf
	 *            Plivo REST Config
	 * @return Incoming Carrier details
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static IncomingCarrier get(String id, PlivoRestConf conf)
			throws PlivoException, APIException {
		IncomingCarrier ic = getRequest(getIdLoc(id),
				new LinkedHashMap<String, String>(), IncomingCarrier.class,
				conf);
		ic.conf = conf;
		return ic;
	}

	/**
	 * List all incoming carriers
	 * 
	 * @see http://plivo.com/docs/api/incomingcarrier/#carrier_list
	 * @param params
	 *            optional parameters
	 * @param conf
	 *            Plivo REST config
	 * @return Incoming Carrier list
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static IncomingCarrierList getList(
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		IncomingCarrierList icl = getRequest(baseLoc, params,
				IncomingCarrierList.class, conf);
		icl.conf = conf;
		return icl;
	}

	/**
	 * Add new incoming carrier
	 * 
	 * @see http://plivo.com/docs/api/incomingcarrier/#carrier_add
	 * @param params
	 *            incoming carrier parameters
	 * @param conf
	 *            Plivo REST config
	 * @return Carrier ID
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static String create(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		IncomingCarrierCreateResponse icr = postRequest(baseLoc, params,
				IncomingCarrierCreateResponse.class, conf);
		return icr.getCarrierId();
	}

	/**
	 * Modify an existing incoming carrier
	 * 
	 * @see http://plivo.com/docs/api/incomingcarrier/#carrier_edit
	 * @param carrierId
	 *            carrier id
	 * @param params
	 *            optional parameters
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void modify(String carrierId,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(getIdLoc(carrierId), params,
				IncomingCarrierCreateResponse.class, conf, 202);
	}

	/**
	 * Remove a carrier
	 * 
	 * @see http://plivo.com/docs/api/incomingcarrier/#carrier_remove
	 * @param carrierId
	 *            carrier id
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void delete(String carrierId, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(getIdLoc(carrierId),
				new LinkedHashMap<String, String>(), Response.class, conf, 204);
	}

	public String getCarrierId() {
		return carrierId;
	}

	public String getIpSet() {
		return ipSet;
	}

	public String getName() {
		return name;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public Boolean getSms() {
		return sms;
	}

	public Boolean getVoice() {
		return voice;
	}

}
