package com.plivo.bridge.feature.conference;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.plivo.bridge.client.PlivoClient;
import com.plivo.bridge.exception.PlivoClientException;
import com.plivo.bridge.feature.base.BaseFeature;
import com.plivo.bridge.to.response.conference.ConferenceDeafResponse;
import com.plivo.bridge.to.response.conference.ConferenceHangupResponse;
import com.plivo.bridge.to.response.conference.ConferenceKickResponse;
import com.plivo.bridge.to.response.conference.ConferenceListResponse;
import com.plivo.bridge.to.response.conference.ConferenceMuteResponse;
import com.plivo.bridge.to.response.conference.ConferencePlayResponse;
import com.plivo.bridge.to.response.conference.ConferenceRecordStartResponse;
import com.plivo.bridge.to.response.conference.ConferenceRecordStopResponse;
import com.plivo.bridge.to.response.conference.ConferenceSpeakResponse;
import com.plivo.bridge.to.response.conference.ConferenceUndeafResponse;
import com.plivo.bridge.to.response.conference.ConferenceUnmuteResponse;
import com.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class ConferenceFeature extends BaseFeature {

	public ConferenceFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
		this.setBaseResource(this.getBaseResource());
	}

	// /v1/Account/{auth_id}/Conference/
	public String getAll() 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.get(String.class);

					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_name}/
	public String getOne(String ConferenceName) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.get(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	//  /v1/Account/{auth_id}/Conference/
	public String hangupAll() 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.delete(String.class);

					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_name}/
	public String hangupOne(String ConferenceName) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/
	public String hangupOneMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}		


	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Play/
	public String playToMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Play/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Play/
	public String stopPlayToMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Play/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Speak/
	public String speakToMember(String ConferenceName, String MemberId, Map<String, String> parameters) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Speak/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Deaf/
	public String deafMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Deaf/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Deaf/
	public String unDeafMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Deaf/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Mute/
	public String muteMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Mute/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Mute/
	public String unMuteMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Mute/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}
	
	// /v1/Account/{auth_id}/Conference/{conference_name}/Member/{member_id}/Kick/

	public String kickMember(String ConferenceName, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceName+"/Member"+MemberId+"/Kick/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}
}
