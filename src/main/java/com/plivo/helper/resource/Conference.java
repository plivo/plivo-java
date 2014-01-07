package com.plivo.helper.resource;

import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.response.GenericResponse;
import com.plivo.helper.util.HtmlEntity;

public class Conference extends Resource {
	@SerializedName("conference_name")
	private String conferenceName;

	@SerializedName("conference_run_time")
	private String conferenceRunTime;

	@SerializedName("conference_member_count")
	private String conferenceMemberCount;

	private List<ConferenceMember> members;

	private static String baseLoc = "/Conference/";

	private static String getNameLoc(String name) {
		return baseLoc + name + "/";
	}

	private String getLoc() {
		return baseLoc + this.conferenceName + "/";
	}

	/**
	 * Get details of particular conference
	 * 
	 * @param name
	 *            conference name
	 * @param conf
	 *            Plivo REST config
	 * @return
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static Conference get(String name, PlivoRestConf conf)
			throws PlivoException, APIException {
		Conference c = getRequest(getNameLoc(name),
				new LinkedHashMap<String, String>(), Conference.class, conf);
		c.setConf(conf);
		return c;
	}

	/**
	 * Get list of all conferences
	 * 
	 * @param conf
	 *            Plivo REST config
	 * @return Conference list
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static ConferenceList getList(PlivoRestConf conf)
			throws PlivoException, APIException {
		ConferenceList cl = getRequest(baseLoc,
				new LinkedHashMap<String, String>(), ConferenceList.class, conf);
		cl.setConf(conf);
		return cl;
	}

	/**
	 * Hangup a conference
	 * 
	 * @see http://plivo.com/docs/api/conference/#hangup_one
	 * @param name
	 *            conference name
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void hangup(String name, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequest(getNameLoc(name), new LinkedHashMap<String, String>(),
				GenericResponse.class, conf);
	}

	/**
	 * Hangup conference
	 * 
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public void hangup(PlivoRestConf conf) throws PlivoException, APIException {
		deleteRequest(getLoc(), new LinkedHashMap<String, String>(),
				GenericResponse.class, conf);
	}

	/**
	 * Hangup all conferences
	 * 
	 * @see http://plivo.com/docs/api/conference/#hangup_all
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void hangupAll(PlivoRestConf conf) throws PlivoException,
			APIException {
		deleteRequest(baseLoc, new LinkedHashMap<String, String>(),
				GenericResponse.class, conf);
	}

	/**
	 * Start recording a conference
	 * 
	 * @see http://plivo.com/docs/api/conference/record/#start_rec
	 * @param name
	 *            conference name
	 * @param params
	 *            optional params
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void startRecord(String name,
			LinkedHashMap<String, String> params, PlivoRestConf conf)
			throws PlivoException, APIException {
		postRequestExpect(getNameLoc(name) + "/Record/", params,
				GenericResponse.class, conf, 202);
	}

	/**
	 * Start recording this conference
	 * 
	 * @param params
	 *            recording params
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void startRecord(LinkedHashMap<String, String> params,
			PlivoRestConf conf) throws PlivoException, APIException {
		postRequestExpect(getLoc() + "/Record/", params, GenericResponse.class,
				conf, 202);
	}

	/**
	 * Stop recording a conference
	 * 
	 * @see http://plivo.com/docs/api/conference/record/#stop_rec
	 * @param name
	 *            conference name
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public static void stopRecord(String name, PlivoRestConf conf)
			throws PlivoException, APIException {
		deleteRequestExpect(getNameLoc(name) + "/Record/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				conf, 204);
	}

	/**
	 * Stop recording this conference
	 * 
	 * @param conf
	 *            Plivo REST config
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public void stopRecord(PlivoRestConf conf) throws PlivoException,
			APIException {
		deleteRequestExpect(getLoc() + "/Record/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				conf, 204);
	}

	/**
	 * Hangup a member
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#hangup_member
	 * @param memberId
	 *            member id
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void hangupMember(String memberId) throws PlivoException,
			APIException {
		deleteRequest(getLoc() + memberId + "/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf());
	}

	/**
	 * Kick a member from conference.
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#kick
	 * @param memberId
	 * @throws PlivoException
	 * @throws APIException
	 */
	public void kickMember(String memberId) throws PlivoException, APIException {
		postRequestExpect(getLoc() + memberId + "/Kick/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 202);
	}

	/**
	 * Mute a member
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#mute
	 * @param memberId
	 *            member id
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void muteMember(String memberId) throws PlivoException, APIException {
		postRequestExpect(getLoc() + memberId + "/Mute/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 202);
	}

	/**
	 * Unmute a member
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#unmute
	 * @param memberId
	 *            member id
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public void unmuteMember(String memberId) throws PlivoException,
			APIException {
		deleteRequestExpect(getLoc() + memberId + "/Mute/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 204);
	}

	/**
	 * Start playing sound to member(s)
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#start_play
	 * @param memberId
	 *            String member id
	 * @param params
	 *            parameter
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public void playMember(String memberId, LinkedHashMap<String, String> params)
			throws PlivoException, APIException {
		postRequestExpect(getLoc() + memberId + "/Play/", params,
				GenericResponse.class, this.getConf(), 202);
	}

	/**
	 * Stop playing sound to member(s)
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#stop_play
	 * @param memberId
	 *            Member ID(s)
	 * @param params
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void stopPlayMember(String memberId) throws PlivoException,
			APIException {
		deleteRequestExpect(getLoc() + memberId + "/Play/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 204);
	}

	/**
	 * Make Member(s) Listen to a Speech
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#speak_in_conf
	 * @param memberId
	 *            Member id(s)
	 * @param params
	 *            parameters
	 * @throws PlivoException
	 * @throws APIException
	 *             error details from server
	 */
	public void speakMember(String memberId,
			LinkedHashMap<String, String> params) throws PlivoException,
			APIException {
		String text = HtmlEntity.convert(getKeyValue(params, "text"));
		params.put("text", text);
		postRequestExpect(getLoc() + memberId + "/Speak/", params,
				GenericResponse.class, this.getConf(), 202);
	}

	/**
	 * Make member(s) deaf
	 * 
	 * @see http://plivo.com/docs/api/conference/member/#make_deaf
	 * @param memberId
	 *            member id
	 * @param params
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void deafMember(String memberId) throws PlivoException, APIException {
		postRequestExpect(getLoc() + memberId + "/Deaf/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 202);
	}

	/**
	 * Enable Hearing For Member(s)
	 * 
	 * @param memberId
	 *            member id
	 * @throws PlivoException
	 * @throws APIException
	 *             error details
	 */
	public void undeafMember(String memberId) throws PlivoException,
			APIException {
		deleteRequestExpect(getLoc() + memberId + "/Deaf/",
				new LinkedHashMap<String, String>(), GenericResponse.class,
				this.getConf(), 204);
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public String getConferenceRunTime() {
		return conferenceRunTime;
	}

	public String getConferenceMemberCount() {
		return conferenceMemberCount;
	}

	public List<ConferenceMember> getMembers() {
		return members;
	}

}
