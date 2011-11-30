package org.plivo.bridge.feature.conference;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-22
 * @author Paulo reis
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.feature.base.BaseFeature;
import org.plivo.bridge.to.response.conference.ConferenceDeafResponse;
import org.plivo.bridge.to.response.conference.ConferenceHangupResponse;
import org.plivo.bridge.to.response.conference.ConferenceKickResponse;
import org.plivo.bridge.to.response.conference.ConferenceListResponse;
import org.plivo.bridge.to.response.conference.ConferenceMuteResponse;
import org.plivo.bridge.to.response.conference.ConferencePlayResponse;
import org.plivo.bridge.to.response.conference.ConferenceRecordStartResponse;
import org.plivo.bridge.to.response.conference.ConferenceRecordStopResponse;
import org.plivo.bridge.to.response.conference.ConferenceSpeakResponse;
import org.plivo.bridge.to.response.conference.ConferenceUndeafResponse;
import org.plivo.bridge.to.response.conference.ConferenceUnmuteResponse;
import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class ConferenceFeature extends BaseFeature {

	public ConferenceFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
		this.setBaseResource(this.getBaseResource());
	}

	public ConferenceMuteResponse mute(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceMuteResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Mute/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceMuteResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceUnmuteResponse unmute(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceUnmuteResponse response = this.getBaseResource()
					.path("Conferente/")
					.path("Unmute/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceUnmuteResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceKickResponse kick(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceKickResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Kick/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceKickResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceHangupResponse hangup(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceHangupResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Hangup")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceHangupResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceDeafResponse deaf(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceDeafResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Deaf/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceDeafResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceUndeafResponse undeaf(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceUndeafResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Undeaf/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceUndeafResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceRecordStartResponse recordStart(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceRecordStartResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Record/")
					.path("Start/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceRecordStartResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceRecordStopResponse recordStop(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceRecordStopResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Record/")
					.path("Stop/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceRecordStopResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferencePlayResponse play(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferencePlayResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Play/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferencePlayResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceSpeakResponse speak(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceSpeakResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Speak/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceSpeakResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceListResponse listMembers(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceListResponse response = this.getBaseResource()
					.path("Conference/")
					.path("Member/")
					.path("List/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceListResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ConferenceListResponse list(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			ConferenceListResponse response = this.getBaseResource()
					.path("Conference/")
					.path("List/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ConferenceListResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
}
