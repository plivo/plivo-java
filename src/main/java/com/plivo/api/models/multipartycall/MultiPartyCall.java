package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.base.BaseResponse;

import java.io.IOException;
import java.util.List;

public class MultiPartyCall extends BaseResource {
  private String billedAmount;
  private Long billedDuration;
  private String creationTime;
  private Long duration;
  private String endTime;
  private String friendlyName;
  private String mpcUuid;
  private String participants;
  private String recording;
  private String resourceUri;
  private String startTime;
  private String status;
  private String stayAlone;
  private String subAccount;
  private String terminationCause;
  private Long terminationCauseCode;

  public static MultiPartyCallList lister() {
    return new MultiPartyCallList();
  }

  public static MultiPartyCallGet getter(String mpcId) {
    return new MultiPartyCallGet(mpcId);
  }

  public MultiPartyCall get() throws IOException, PlivoRestException {
    MultiPartyCallGet getter = MultiPartyCall.getter(getId());
    return getter.get();
  }

  public static MultiPartyCallStart starter(String mpcId) {
    return new MultiPartyCallStart(mpcId);
  }

  public BaseResponse start() throws IOException, PlivoRestException {
    MultiPartyCallStart start = MultiPartyCall.starter(getId());
    return start.update();
  }

  public static MultiPartyCallStop stopper(String mpcId) {
    return new MultiPartyCallStop(mpcId);
  }

  public void stop() throws IOException, PlivoRestException {
    MultiPartyCallStop stop = MultiPartyCall.stopper(getId());
    stop.delete();
  }

  public static MultiPartyCallParticipantAdd addParticipant(String mpcId, String role, String from, List<String> to) throws InvalidRequestException {
    return new MultiPartyCallParticipantAdd(mpcId, role, from, to);
  }

  public static MultiPartyCallParticipantAdd addParticipant(String mpcId, String role, String callUuid) {
    return new MultiPartyCallParticipantAdd(mpcId, role, callUuid);
  }

  public MultiPartyCallParticipantAdd addParticipant(String role, String from, List<String> to) throws InvalidRequestException {
    return new MultiPartyCallParticipantAdd(getId(), role, from, to);
  }

  public MultiPartyCallParticipantAdd addParticipant(String role, String callUuid) throws InvalidRequestException {
    return new MultiPartyCallParticipantAdd(getId(), role, callUuid);
  }

  public static MultiPartyCallParticipantList participantList(String mpcId) {
    return new MultiPartyCallParticipantList(mpcId);
  }

  public MultiPartyCallParticipantList participantList() throws InvalidRequestException {
    return new MultiPartyCallParticipantList(getId());
  }

  public static MultiPartyCallRecordingStart recordStarter(String mpcId) {
    return new MultiPartyCallRecordingStart(mpcId);
  }

  public MultiPartyCallRecordingStart recordStarter() throws InvalidRequestException {
    return new MultiPartyCallRecordingStart(getId());
  }

  public static MultiPartyCallRecordingStop recordStopper(String mpcId) {
    return new MultiPartyCallRecordingStop(mpcId);
  }

  public void recordStop() throws IOException, PlivoRestException {
    MultiPartyCallRecordingStop recordStopper = new MultiPartyCallRecordingStop(getId());
    recordStopper.delete();
  }

  public static MultiPartyCallRecordingPause recordPause(String mpcId) {
    return new MultiPartyCallRecordingPause(mpcId);
  }

  public static BaseResponse recordPause(String mpcId, Boolean trimSilence) throws IOException, PlivoRestException {
    MultiPartyCallRecordingPause pause = new MultiPartyCallRecordingPause(mpcId).trimSilence(trimSilence);
    return pause.update();
  }

  public MultiPartyCallRecordingPause recordPause() throws InvalidRequestException {
    return new MultiPartyCallRecordingPause(getId());
  }

  public BaseResponse recordPause(Boolean trimSilence) throws IOException, PlivoRestException {
    MultiPartyCallRecordingPause recordPause = new MultiPartyCallRecordingPause(getId()).trimSilence(trimSilence);
    return recordPause.update();
  }

  public MultiPartyCallParticipantGet participantGetter(String mpcId, String participantId) {
    return new MultiPartyCallParticipantGet(mpcId, participantId);
  }

  public MultiPartyCallParticipant participantGet(String participantId) throws PlivoRestException, IOException {
    MultiPartyCallParticipantGet getter = new MultiPartyCallParticipantGet(getId(), participantId);
    return getter.get();
  }

  public MultiPartyCallParticipantUpdate participantUpdater(String mpcId, String participantId) {
    return new MultiPartyCallParticipantUpdate(mpcId, participantId);
  }

  public MultiPartyCallParticipantUpdate participantUpdate(String participantId) throws InvalidRequestException {
    return new MultiPartyCallParticipantUpdate(getId(), participantId);
  }

  public MultiPartyCallParticipantKick participantKicker(String mpcId, String participantId) {
    return new MultiPartyCallParticipantKick(mpcId, participantId);
  }

  public void participantKick(String participantId) throws PlivoRestException, IOException {
    MultiPartyCallParticipantKick kicker = new MultiPartyCallParticipantKick(getId(), participantId);
    kicker.delete();
  }

  public String getBilledAmount() {
    return billedAmount;
  }

  public Long getBilledDuration() {
    return billedDuration;
  }

  public String getCreationTime() {
    return creationTime;
  }

  public Long getDuration() {
    return duration;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getFriendlyName() {
    return friendlyName;
  }

  public String getMpcUuid() {
    return mpcUuid;
  }

  public String getParticipants() {
    return participants;
  }

  public String getRecording() {
    return recording;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getStatus() {
    return status;
  }

  public String getStayAlone() {
    return stayAlone;
  }

  public String getSubAccount() {
    return subAccount;
  }

  public String getTerminationCause() {
    return terminationCause;
  }

  public Long getTerminationCauseCode() {
    return terminationCauseCode;
  }

  @Override
  public String getId() throws InvalidRequestException {
    return MultiPartyCallUtils.mpcUuid(getMpcUuid());
  }
}
