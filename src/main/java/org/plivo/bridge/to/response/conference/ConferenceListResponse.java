package com.plivo.bridge.to.response.conference;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.plivo.bridge.to.response.BasePlivoResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConferenceListResponse extends BasePlivoResponse {

	private static final long serialVersionUID = -3932736705691661318L;
	
	private Collection<ConferenceRoom> List;
	
	public Collection<ConferenceRoom> getList() {
		return List;
	}

	public void setList(Collection<ConferenceRoom> list) {
		List = list;
	}
	
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ConferenceMember implements Serializable {

		private static final long serialVersionUID = 4391999441061843188L;
		
		private boolean Muted;
		private boolean Deaf;
		private String MemberID;
		private String CallNumber;
		private String CallName;
		private String CallUUID;
		private int JoinTime;
		
		public ConferenceMember() {
			
		}
		
		public boolean isMuted() {
			return Muted;
		}
		public void setMuted(boolean muted) {
			Muted = muted;
		}
		public boolean isDeaf() {
			return Deaf;
		}
		public void setDeaf(boolean deaf) {
			Deaf = deaf;
		}
		public String getMemberID() {
			return MemberID;
		}
		public void setMemberID(String memberID) {
			MemberID = memberID;
		}
		public String getCallNumber() {
			return CallNumber;
		}
		public void setCallNumber(String callNumber) {
			CallNumber = callNumber;
		}
		public String getCallName() {
			return CallName;
		}
		public void setCallName(String callName) {
			CallName = callName;
		}
		public String getCallUUID() {
			return CallUUID;
		}
		public void setCallUUID(String callUUID) {
			CallUUID = callUUID;
		}
		public int getJoinTime() {
			return JoinTime;
		}
		public void setJoinTime(int joinTime) {
			JoinTime = joinTime;
		}
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ConferenceRoom implements Serializable {
		
		private static final long serialVersionUID = -7074520939205568270L;
		
		private String conferenceName;
		private int ConferenceRunTime;
		private int ConferenceMemberCount;
		private String ConferenceUUID;
		
		private Collection<ConferenceMember> Members;
		public String getConferenceName() {
			return conferenceName;
		}
		public void setConferenceName(String conferenceName) {
			this.conferenceName = conferenceName;
		}
		public int getConferenceRunTime() {
			return ConferenceRunTime;
		}
		public void setConferenceRunTime(int conferenceRunTime) {
			ConferenceRunTime = conferenceRunTime;
		}
		public int getConferenceMemberCount() {
			return ConferenceMemberCount;
		}
		public void setConferenceMemberCount(int conferenceMemberCount) {
			ConferenceMemberCount = conferenceMemberCount;
		}
		public String getConferenceUUID() {
			return ConferenceUUID;
		}
		public void setConferenceUUID(String conferenceUUID) {
			ConferenceUUID = conferenceUUID;
		}
		public Collection<ConferenceMember> getMembers() {
			return Members;
		}
		public void setMembers(Collection<ConferenceMember> members) {
			Members = members;
		}
	}
}
