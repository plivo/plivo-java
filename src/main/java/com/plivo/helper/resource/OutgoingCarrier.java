package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.response.OutgoingCarrierCreateResponse;
import com.plivo.helper.response.Response;

public class OutgoingCarrier extends Resource {
	@SerializedName("carrier_id")
	private String carrierId;

	private String ips;

	private String name;

	private String address;

	private String prefix;

	@SerializedName("failover_address")
	private String failoverAddress;

	@SerializedName("failover_prefix")
	private String failoverPrefix;

	private String suffix;

	private boolean enabled;

	private int retries;

	@SerializedName("retry_seconds")
	private int retrySeconds;

	private static String baseLoc = "/OutgoingCarrier/";

	private static String getIdLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Retrieve Specific Outgoing Carrier
	 * 
	 * @see http://plivo.com/docs/api/outgoingcarrier/#specific_carrier
	 * @param id
	 *            carrier id
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static OutgoingCarrier get(String id, PlivoRestConf conf)
			throws PlivoException, APIException {
		OutgoingCarrier oc = getRequest(getIdLoc(id),
				new LinkedHashMap<String, String>(), OutgoingCarrier.class,
				conf);
		oc.setConf(conf);
		return oc;
	}

	/**
	 * Retrieve All Outgoing Carriers
	 * 
	 * @param params
	 *            optional params, unused for now.
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static OutgoingCarrierList getList(
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		OutgoingCarrierList ocl = getRequest(baseLoc, params,
				OutgoingCarrierList.class, conf);
		ocl.setConf(conf);
		return ocl;
	}

	/**
	 * Create an Outgoing Carrier.
	 * 
	 * @see http://plivo.com/docs/api/outgoingcarrier/#create_outgoing
	 * @param params
	 *            outgoing carrier parameters
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static String create(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		OutgoingCarrierCreateResponse r = postRequest(baseLoc, params,
				OutgoingCarrierCreateResponse.class, conf);
		return r.getCarrierId();
	}

	/**
	 * Modify an Outgoing Carrier
	 * 
	 * @see http://plivo.com/docs/api/outgoingcarrier/#modify_carrier
	 * @param carrierId
	 *            carrier id
	 * @param params
	 *            modified params
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void modify(String carrierId,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(getIdLoc(carrierId), params, Response.class, conf,
				202);
	}

	/**
	 * Delete an Outgoing Carrier
	 * 
	 * @see http://plivo.com/docs/api/outgoingcarrier/#delete_carrier
	 * @param carrierId
	 *            carrier id
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static void delete(String carrierId, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequest(getIdLoc(carrierId), new LinkedHashMap<String, String>(),
				Response.class, conf);
	}

	public String getCarrierId() {
		return carrierId;
	}

	public String getIps() {
		return ips;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getFailoverAddress() {
		return failoverAddress;
	}

	public String getFailoverPrefix() {
		return failoverPrefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public int getRetries() {
		return retries;
	}

	public int getRetrySeconds() {
		return retrySeconds;
	}
}
