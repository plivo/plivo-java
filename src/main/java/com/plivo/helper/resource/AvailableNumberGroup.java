package com.plivo.helper.resource;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.response.RentNumberGroupResponse;

public class AvailableNumberGroup extends Resource {
	@SerializedName("group_id")
	private String groupId;

	@SerializedName("number_type")
	private String numberType;

	@SerializedName("rental_rate")
	private String rentalRate;

	@SerializedName("setup_rate")
	private String setupRate;

	@SerializedName("sms_enabled")
	private Boolean isSmsEnabled;

	@SerializedName("sms_rate")
	private String smsRate;

	@SerializedName("voice_enabled")
	private Boolean isVoiceEnabled;

	@SerializedName("voice_rate")
	private String voiceRate;

	@SerializedName("stock")
	private Integer inStock;

	@SerializedName("prefix")
	private String numberPrefix;

	private String region;

	private static String baseLoc = "/AvailableNumberGroup/";

	private static String getGroupLoc(String id) {
		return baseLoc + id + "/";
	}

	/**
	 * Search for New Numbers
	 * 
	 * @see http
	 *      ://plivo.com/docs/api/numbers/availablenumbergroup/#number_search
	 * @param params
	 *            search parameters
	 * @param conf
	 *            Plivo REST config
	 * @return available number group list
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static AvailableNumberGroupList search(Map<String, Object> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		AvailableNumberGroupList a = getRequest(baseLoc, params,
				AvailableNumberGroupList.class, conf);
		a.setConf(conf);
		return a;
	}

	/**
	 * Rent a number group
	 * 
	 * @see http://plivo.com/docs/api/numbers/availablenumbergroup/#rent_number
	 * @param groupId
	 *            group ID
	 * @param params
	 *            parameters
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 */
	public static RentNumberGroupResponse rent(String groupId,
			Map<String, Object> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		RentNumberGroupResponse r = postRequestExpect(getGroupLoc(groupId),
				params, RentNumberGroupResponse.class, conf, 201);
		return r;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getNumberType() {
		return numberType;
	}

	public String getRentalRate() {
		return rentalRate;
	}

	public String getSetupRate() {
		return setupRate;
	}

	public Boolean getIsSmsEnabled() {
		return isSmsEnabled;
	}

	public String getSmsRate() {
		return smsRate;
	}

	public Boolean getIsVoiceEnabled() {
		return isVoiceEnabled;
	}

	public String getVoiceRate() {
		return voiceRate;
	}

	public Integer getInStock() {
		return inStock;
	}

	public String getNumberPrefix() {
		return numberPrefix;
	}

	public String getRegion() {
		return region;
	}

}
