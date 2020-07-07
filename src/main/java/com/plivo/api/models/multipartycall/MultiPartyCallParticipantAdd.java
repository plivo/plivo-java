package com.plivo.api.models.multipartycall;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Updater;
import com.plivo.api.serializers.CommaDelimitedListSerializer;
import com.plivo.api.serializers.DelimitedListSerializer;
import com.plivo.api.serializers.MapToCommaListSerializer;
import com.plivo.api.validators.*;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MultiPartyCallParticipantAdd extends Updater<MultiPartyCallParticipantAddResponse> {

  @OneOf(message = "should be one of [agent, customer, supervisor]", options = {"agent", "customer", "supervisor"})
  private String role;
  private String from;
  @JsonSerialize(using = DelimitedListSerializer.class)
  private List<String> to;
  private String callUuid;
  @UrlValues
  private String callStatusCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String callStatusCallbackMethod = "POST";
  @JsonSerialize(using = MapToCommaListSerializer.class)
  private Map<String, String> sipHeaders;
  @OneOf(message = "should be one of [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, #, *]", options = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "*"})
  private String confirmKey;
  @UrlValues
  private String confirmKeySoundUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String confirmKeySoundMethod = "GET";
  @UrlValues(message = "should be a valid URL or one of ['Real', 'None']", options = {"Real", "None"})
  private String dialMusic = "Real";
  @InRange(message = "must be in range [15-120]", min = 15, max = 120)
  private Integer ringTimeout = 45;
  @InRange(message = "must be in range [300-28800]", min = 300, max = 28800)
  private Integer maxDuration = 14400;
  @InRange(message = "must be in range [2-10]", min = 2, max = 10)
  private Integer maxParticipants = 10;
  @UrlValues
  private String waitMusicUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String waitMusicMethod = "GET";
  @UrlValues
  private String agentHoldMusicUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String agentHoldMusicMethod = "GET";
  @UrlValues
  private String customerHoldMusicUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String customerHoldMusicMethod ="GET";
  @UrlValues
  private String recordingCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String recordingCallbackMethod ="GET";
  @UrlValues
  private String statusCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String statusCallbackMethod ="GET";
  @UrlValues
  private String onExitActionUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String onExitActionMethod ="POST";
  private Boolean record = false;
  @OneOf(message = "should be one of [mp3, wav]", options = {"mp3", "wav"})
  private String recordFileFormat ="mp3";
  @JsonSerialize(using = CommaDelimitedListSerializer.class)
  @MultiOf(message = "should be among [mpc-state-changes, participant-state-changes, participant-speak-events, participant-digit-input-events, add-participant-api-events]", options = {"mpc-state-changes", "participant-state-changes", "participant-speak-events", "participant-digit-input-events", "add-participant-api-events"})
  private List<String> statusCallbackEvents = Arrays.asList("mpc-state-changes", "participant-state-changes");
  private Boolean stayAlone = false;
  private Boolean coachMode = true;
  private Boolean mute = false;
  private Boolean hold = false;
  private Boolean startMpcOnEnter = true;
  private Boolean endMpcOnExit = false;
  private Boolean relayDtmfInputs = false;
  @UrlValues(message = "should be a valid URL or one of ['beep:1', 'beep:2', 'none']", options = {"beep:1", "beep:2", "none"})
  private String enterSound = "beep:1";
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String enterSoundMethod = "GET";
  @UrlValues(message = "should be a valid URL or one of ['beep:1', 'beep:2', 'none']", options = {"beep:1", "beep:2", "none"})
  private String exitSound = "beep:2";
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String exitSoundMethod = "GET";

  public MultiPartyCallParticipantAdd(String mpcId, String role, String from, List<String> to) throws InvalidRequestException {
    super(mpcId);
    if (to.size() > 20) {
      throw new InvalidRequestException("max of 20 destination numbers are allowed for bulk dialing");
    }
    if (to.size() > 1 && !role.equalsIgnoreCase(MultiPartyCallUtils.agent)) {
      throw new InvalidRequestException("bulk dialing is allowed for role agent only");
    }
    this.role = role;
    this.from = from;
    this.to = to;
  }

  public MultiPartyCallParticipantAdd(String mpcId, String role, String callUuid) {
    super(mpcId);
    this.role = role;
    this.callUuid = callUuid;
  }

  public String getRole() {
    return role;
  }

  public String getFrom() {
    return from;
  }

  public List<String> getTo() {
    return to;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public String getCallStatusCallbackUrl() {
    return callStatusCallbackUrl;
  }

  public MultiPartyCallParticipantAdd callStatusCallbackUrl(String callStatusCallbackUrl) {
    this.callStatusCallbackUrl = callStatusCallbackUrl;
    return this;
  }

  public String getCallStatusCallbackMethod() {
    return callStatusCallbackMethod;
  }

  public MultiPartyCallParticipantAdd callStatusCallbackMethod(String callStatusCallbackMethod) {
    this.callStatusCallbackMethod = callStatusCallbackMethod;
    return this;
  }

  public Map<String, String> getSipHeaders() {
    return sipHeaders;
  }

  public MultiPartyCallParticipantAdd sipHeaders(Map<String, String> sipHeaders) {
    this.sipHeaders = sipHeaders;
    return this;
  }

  public String getConfirmKey() {
    return confirmKey;
  }

  public MultiPartyCallParticipantAdd confirmKey(String confirmKey) {
    this.confirmKey = confirmKey;
    return this;
  }

  public String getConfirmKeySoundUrl() {
    return confirmKeySoundUrl;
  }

  public MultiPartyCallParticipantAdd confirmKeySoundUrl(String confirmKeySoundUrl) {
    this.confirmKeySoundUrl = confirmKeySoundUrl;
    return this;
  }

  public String getConfirmKeySoundMethod() {
    return confirmKeySoundMethod;
  }

  public MultiPartyCallParticipantAdd confirmKeySoundMethod(String confirmKeySoundMethod) {
    this.confirmKeySoundMethod = confirmKeySoundMethod;
    return this;
  }

  public String getDialMusic() {
    return dialMusic;
  }

  public MultiPartyCallParticipantAdd dialMusic(String dialMusic) {
    this.dialMusic = dialMusic;
    return this;
  }

  public Integer getRingTimeout() {
    return ringTimeout;
  }

  public MultiPartyCallParticipantAdd ringTimeout(Integer ringTimeout) {
    this.ringTimeout = ringTimeout;
    return this;
  }

  public Integer getMaxDuration() {
    return maxDuration;
  }

  public MultiPartyCallParticipantAdd maxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    return this;
  }

  public Integer getMaxParticipants() {
    return maxParticipants;
  }

  public MultiPartyCallParticipantAdd maxParticipants(Integer maxParticipants) {
    this.maxParticipants = maxParticipants;
    return this;
  }

  public String getWaitMusicUrl() {
    return waitMusicUrl;
  }

  public MultiPartyCallParticipantAdd waitMusicUrl(String waitMusicUrl) {
    this.waitMusicUrl = waitMusicUrl;
    return this;
  }

  public String getWaitMusicMethod() {
    return waitMusicMethod;
  }

  public MultiPartyCallParticipantAdd waitMusicMethod(String waitMusicMethod) {
    this.waitMusicMethod = waitMusicMethod;
    return this;
  }

  public String getAgentHoldMusicUrl() {
    return agentHoldMusicUrl;
  }

  public MultiPartyCallParticipantAdd agentHoldMusicUrl(String agentHoldMusicUrl) {
    this.agentHoldMusicUrl = agentHoldMusicUrl;
    return this;
  }

  public String getAgentHoldMusicMethod() {
    return agentHoldMusicMethod;
  }

  public MultiPartyCallParticipantAdd agentHoldMusicMethod(String agentHoldMusicMethod) {
    this.agentHoldMusicMethod = agentHoldMusicMethod;
    return this;
  }

  public String getCustomerHoldMusicUrl() {
    return customerHoldMusicUrl;
  }

  public MultiPartyCallParticipantAdd customerHoldMusicUrl(String customerHoldMusicUrl) {
    this.customerHoldMusicUrl = customerHoldMusicUrl;
    return this;
  }

  public String getCustomerHoldMusicMethod() {
    return customerHoldMusicMethod;
  }

  public MultiPartyCallParticipantAdd customerHoldMusicMethod(String customerHoldMusicMethod) {
    this.customerHoldMusicMethod = customerHoldMusicMethod;
    return this;
  }

  public String getRecordingCallbackUrl() {
    return recordingCallbackUrl;
  }

  public MultiPartyCallParticipantAdd recordingCallbackUrl(String recordingCallbackUrl) {
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }

  public String getRecordingCallbackMethod() {
    return recordingCallbackMethod;
  }

  public MultiPartyCallParticipantAdd recordingCallbackMethod(String recordingCallbackMethod) {
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }

  public String getStatusCallbackUrl() {
    return statusCallbackUrl;
  }

  public MultiPartyCallParticipantAdd statusCallbackUrl(String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }

  public String getStatusCallbackMethod() {
    return statusCallbackMethod;
  }

  public MultiPartyCallParticipantAdd statusCallbackMethod(String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  public String getOnExitActionUrl() {
    return onExitActionUrl;
  }

  public MultiPartyCallParticipantAdd onExitActionUrl(String onExitActionUrl) {
    this.onExitActionUrl = onExitActionUrl;
    return this;
  }

  public String getOnExitActionMethod() {
    return onExitActionMethod;
  }

  public MultiPartyCallParticipantAdd onExitActionMethod(String onExitActionMethod) {
    this.onExitActionMethod = onExitActionMethod;
    return this;
  }

  public Boolean getRecord() {
    return record;
  }

  public MultiPartyCallParticipantAdd record(Boolean record) {
    this.record = record;
    return this;
  }

  public String getRecordFileFormat() {
    return recordFileFormat;
  }

  public MultiPartyCallParticipantAdd recordFileFormat(String recordFileFormat) {
    this.recordFileFormat = recordFileFormat;
    return this;
  }

  public List<String> getStatusCallbackEvents() {
    return statusCallbackEvents;
  }

  public MultiPartyCallParticipantAdd statusCallbackEvents(List<String> statusCallbackEvents) {
    this.statusCallbackEvents = statusCallbackEvents;
    return this;
  }

  public Boolean getStayAlone() {
    return stayAlone;
  }

  public MultiPartyCallParticipantAdd stayAlone(Boolean stayAlone) {
    this.stayAlone = stayAlone;
    return this;
  }

  public Boolean getCoachMode() {
    return coachMode;
  }

  public MultiPartyCallParticipantAdd coachMode(Boolean coachMode) throws InvalidRequestException {
    if (coachMode && !this.role.equals(MultiPartyCallUtils.supervisor)) {
      throw new InvalidRequestException("cannot set coach mode for non-supervisor roles");
    }
    this.coachMode = coachMode;
    return this;
  }

  public Boolean getMute() {
    return mute;
  }

  public MultiPartyCallParticipantAdd mute(Boolean mute) {
    this.mute = mute;
    return this;
  }

  public Boolean getHold() {
    return hold;
  }

  public MultiPartyCallParticipantAdd hold(Boolean hold) {
    this.hold = hold;
    return this;
  }

  public Boolean getStartMpcOnEnter() {
    return startMpcOnEnter;
  }

  public MultiPartyCallParticipantAdd startMpcOnEnter(Boolean startMpcOnEnter) {
    this.startMpcOnEnter = startMpcOnEnter;
    return this;
  }

  public Boolean getEndMpcOnExit() {
    return endMpcOnExit;
  }

  public MultiPartyCallParticipantAdd endMpcOnExit(Boolean endMpcOnExit) {
    this.endMpcOnExit = endMpcOnExit;
    return this;
  }

  public Boolean getRelayDtmfInputs() {
    return relayDtmfInputs;
  }

  public MultiPartyCallParticipantAdd relayDtmfInputs(Boolean relayDtmfInputs) {
    this.relayDtmfInputs = relayDtmfInputs;
    return this;
  }

  public String getEnterSound() {
    return enterSound;
  }

  public MultiPartyCallParticipantAdd enterSound(String enterSound) {
    this.enterSound = enterSound;
    return this;
  }

  public String getEnterSoundMethod() {
    return enterSoundMethod;
  }

  public MultiPartyCallParticipantAdd enterSoundMethod(String enterSoundMethod) {
    this.enterSoundMethod = enterSoundMethod;
    return this;
  }

  public String getExitSound() {
    return exitSound;
  }

  public MultiPartyCallParticipantAdd exitSound(String exitSound) {
    this.exitSound = exitSound;
    return this;
  }

  public String getExitSoundMethod() {
    return exitSoundMethod;
  }

  public MultiPartyCallParticipantAdd exitSoundMethod(String exitSoundMethod) {
    this.exitSoundMethod = exitSoundMethod;
    return this;
  }

  @Override
  protected Call<MultiPartyCallParticipantAddResponse> obtainCall() throws InvalidRequestException {
    Validate.check(this);
    return client().getApiService().mpcAddParticipant(client().getAuthId(), id, this);
  }
}
