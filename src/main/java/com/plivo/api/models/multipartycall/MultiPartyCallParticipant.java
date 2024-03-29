package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.SecondaryResource;

import java.io.IOException;

public class MultiPartyCallParticipant extends SecondaryResource {

  private String billedAmount;
  private Long billedDuration;
  private String callUuid;
  private Boolean coachMode;
  private Long duration;
  private Boolean endMpcOnExit;
  private String exitCause;
  private String exitTime;
  private Boolean hold;
  private String joinTime;
  private String memberId;
  private String memberAddress;
  private String mpcUuid;
  private Boolean mute;
  private String resourceUri;
  private String role;
  private Boolean startMpcOnEnter;

  public static MultiPartyCallParticipantGet getter(String mpcId, String participantId) {
    return new MultiPartyCallParticipantGet(mpcId, participantId);
  }

  public MultiPartyCallParticipant get() throws IOException, PlivoRestException, PlivoValidationException {
    MultiPartyCallParticipantGet getter = new MultiPartyCallParticipantGet(getId(), getSecondaryId());
    return getter.get();
  }

  public static MultiPartyCallParticipantUpdate updater(String mpcId, String participantId) {
    return new MultiPartyCallParticipantUpdate(mpcId, participantId);
  }

  public MultiPartyCallParticipantUpdate update() throws PlivoValidationException {
    return new MultiPartyCallParticipantUpdate(getId(), getSecondaryId());
  }

  public static MultiPartyCallParticipantKick kicker(String mpcId, String participantId) {
    return new MultiPartyCallParticipantKick(mpcId, participantId);
  }

  public void kick() throws PlivoRestException, IOException, PlivoValidationException {
    MultiPartyCallParticipantKick kicker = new MultiPartyCallParticipantKick(getId(), getSecondaryId());
    kicker.delete();
  }

  public static MultiPartyCallParticipantRecordingStart recordStarter(String mpcId, String participantId) {
    return new MultiPartyCallParticipantRecordingStart(mpcId, participantId);
  }

  public MultiPartyCallParticipantRecordingStart recordStarter(String participantId) throws PlivoValidationException {
    return new MultiPartyCallParticipantRecordingStart(getId(), getSecondaryId());
  }

  public static MultiPartyCallParticipantRecordingStop recordStopper(String mpcId, String participantId) {
    return new MultiPartyCallParticipantRecordingStop(mpcId, participantId);
  }

  public void recordStop(String participantId) throws IOException, PlivoRestException, PlivoValidationException {
    MultiPartyCallParticipantRecordingStop recordStopper = new MultiPartyCallParticipantRecordingStop(getId(), getSecondaryId());
    recordStopper.delete();
  }

  public static MultiPartyCallParticipantRecordingPause recordPause(String mpcId, String participantId) {
    return new MultiPartyCallParticipantRecordingPause(mpcId, participantId);
  }

  public BaseResponse recordPause(String participantId) throws IOException, PlivoRestException, PlivoValidationException {
    return new MultiPartyCallParticipantRecordingPause(getId(), getSecondaryId()).update();
  }

  public static MultiPartyCallParticipantRecordingResume recordResume(String mpcId, String participantId) {
    return new MultiPartyCallParticipantRecordingResume(mpcId, participantId);
  }

  public BaseResponse recordResume(String participantId) throws IOException, PlivoRestException, PlivoValidationException {
    return new MultiPartyCallParticipantRecordingPause(getId(), getSecondaryId()).update();
  }

  public String getBilledAmount() {
    return billedAmount;
  }

  public Long getBilledDuration() {
    return billedDuration;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public Boolean getCoachMode() {
    return coachMode;
  }

  public Long getDuration() {
    return duration;
  }

  public Boolean getEndMpcOnExit() {
    return endMpcOnExit;
  }

  public String getExitCause() {
    return exitCause;
  }

  public String getExitTime() {
    return exitTime;
  }

  public Boolean getHold() {
    return hold;
  }

  public String getJoinTime() {
    return joinTime;
  }

  public String getMemberId() {
    return memberId;
  }
  public String getmemberAddress() { return memberAddress; }

  public String getMpcUuid() {
    return mpcUuid;
  }

  public Boolean getMute() {
    return mute;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public String getRole() {
    return role;
  }

  public Boolean getStartMpcOnEnter() {
    return startMpcOnEnter;
  }

  @Override
  public String getSecondaryId() {
    return getMemberId();
  }

  @Override
  public String getId() throws PlivoValidationException {
    return MultiPartyCallUtils.mpcUuid(getMpcUuid());
  }
}
