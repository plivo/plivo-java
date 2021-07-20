package com.plivo.api.models.multipartycall;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.serializers.CommaDelimitedListSerializer;
import com.plivo.api.serializers.DelimitedListSerializer;
import com.plivo.api.serializers.MapToCommaListSerializer;
import com.plivo.api.validators.*;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MultiPartyCallParticipantAdd extends VoiceUpdater<MultiPartyCallParticipantAddResponse> {

  @OneOf(message = "should be one of [agent, customer, supervisor]", options = {"agent", "customer", "supervisor"})
  private final String role;
  private final String from;
  @JsonSerialize(using = DelimitedListSerializer.class)
  private final List<String> to;
  private final String callUuid;
  private String callerName;
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
  @MultipleValidIntegers(message = "values must be either integer or string containing integers separated by delimiter '<' ")
  private Object ringTimeout = 45;
  @MultipleValidIntegers(message = "values must be either integer or string containing integers separated by delimiter '<' ")
  private Object delayDial = 0;
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
  private String statusCallbackMethod ="POST";
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

  public MultiPartyCallParticipantAdd(String mpcId, String role, String from, List<String> to) throws PlivoValidationException {
    super(mpcId);
    if (to.size() > 20) {
      throw new PlivoValidationException("max of 20 destination numbers are allowed for bulk dialing");
    }
    if (to.size() > 1 && !role.equalsIgnoreCase(MultiPartyCallUtils.agent)) {
      throw new PlivoValidationException("bulk dialing is allowed for role agent only");
    }
    this.role = role;
    this.from = from;
    this.to = to;
    this.callUuid = null;
    if(this.callerName==null){
      this.callerName = this.from;
    }
  }

  public MultiPartyCallParticipantAdd(String mpcId, String role, String callUuid) {
    super(mpcId);
    this.role = role;
    this.callUuid = callUuid;
    this.from = null;
    this.to = null;
  }

  public String role() {
    return role;
  }

  public String from() {
    return from;
  }

  public List<String> to() {
    return to;
  }

  public String callUuid() {
    return callUuid;
  }

  public String callerName(){ return callerName;}

  public String callStatusCallbackUrl() {
    return callStatusCallbackUrl;
  }

  public String callStatusCallbackMethod() {
    return callStatusCallbackMethod;
  }

  public Map<String, String> sipHeaders() {
    return sipHeaders;
  }

  public String confirmKey() {
    return confirmKey;
  }

  public String confirmKeySoundUrl() {
    return confirmKeySoundUrl;
  }

  public String confirmKeySoundMethod() {
    return confirmKeySoundMethod;
  }

  public String dialMusic() {
    return dialMusic;
  }

  public Object ringTimeout() {
    return ringTimeout;
  }

  public  Object delayDial() {
    return delayDial;
  }

  public Integer maxDuration() {
    return maxDuration;
  }

  public Integer maxParticipants() {
    return maxParticipants;
  }

  public String waitMusicUrl() {
    return waitMusicUrl;
  }

  public String waitMusicMethod() {
    return waitMusicMethod;
  }

  public String agentHoldMusicUrl() {
    return agentHoldMusicUrl;
  }

  public String agentHoldMusicMethod() {
    return agentHoldMusicMethod;
  }

  public String customerHoldMusicUrl() {
    return customerHoldMusicUrl;
  }

  public String customerHoldMusicMethod() {
    return customerHoldMusicMethod;
  }

  public String recordingCallbackUrl() {
    return recordingCallbackUrl;
  }

  public String recordingCallbackMethod() {
    return recordingCallbackMethod;
  }

  public String statusCallbackUrl() {
    return statusCallbackUrl;
  }

  public String statusCallbackMethod() {
    return statusCallbackMethod;
  }

  public String onExitActionUrl() {
    return onExitActionUrl;
  }

  public String onExitActionMethod() {
    return onExitActionMethod;
  }

  public Boolean record() {
    return record;
  }

  public String recordFileFormat() {
    return recordFileFormat;
  }

  public List<String> statusCallbackEvents() {
    return statusCallbackEvents;
  }

  public Boolean stayAlone() {
    return stayAlone;
  }

  public Boolean coachMode() {
    return coachMode;
  }

  public Boolean mute() {
    return mute;
  }

  public Boolean hold() {
    return hold;
  }

  public Boolean startMpcOnEnter() {
    return startMpcOnEnter;
  }

  public Boolean endMpcOnExit() {
    return endMpcOnExit;
  }

  public Boolean relayDtmfInputs() {
    return relayDtmfInputs;
  }

  public String enterSound() {
    return enterSound;
  }

  public String enterSoundMethod() {
    return enterSoundMethod;
  }

  public String exitSound() {
    return exitSound;
  }

  public String exitSoundMethod() {
    return exitSoundMethod;
  }

  public MultiPartyCallParticipantAdd callerName( String callerName) throws PlivoValidationException {
    this.callerName = callerName;
    if (callerName.length() > 50){
      throw new PlivoValidationException("CallerName Length must be in range [0,50]");
    }
    return this;
  }

  public MultiPartyCallParticipantAdd callStatusCallbackUrl(String callStatusCallbackUrl) {
    this.callStatusCallbackUrl = callStatusCallbackUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd callStatusCallbackMethod(String callStatusCallbackMethod) {
    this.callStatusCallbackMethod = callStatusCallbackMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd sipHeaders(Map<String, String> sipHeaders) {
    this.sipHeaders = sipHeaders;
    return this;
  }

  public MultiPartyCallParticipantAdd confirmKey(String confirmKey) {
    this.confirmKey = confirmKey;
    return this;
  }

  public MultiPartyCallParticipantAdd confirmKeySoundUrl(String confirmKeySoundUrl) {
    this.confirmKeySoundUrl = confirmKeySoundUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd confirmKeySoundMethod(String confirmKeySoundMethod) {
    this.confirmKeySoundMethod = confirmKeySoundMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd dialMusic(String dialMusic) {
    this.dialMusic = dialMusic;
    return this;
  }

  public MultiPartyCallParticipantAdd ringTimeout(Object ringTimeout) {
    this.ringTimeout = ringTimeout;
    return this;
  }

  public MultiPartyCallParticipantAdd delayDial(Object delayDial) {
    this.delayDial = delayDial;
    return this;
  }

  public MultiPartyCallParticipantAdd maxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    return this;
  }

  public MultiPartyCallParticipantAdd maxParticipants(Integer maxParticipants) {
    this.maxParticipants = maxParticipants;
    return this;
  }

  public MultiPartyCallParticipantAdd waitMusicUrl(String waitMusicUrl) {
    this.waitMusicUrl = waitMusicUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd waitMusicMethod(String waitMusicMethod) {
    this.waitMusicMethod = waitMusicMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd agentHoldMusicUrl(String agentHoldMusicUrl) {
    this.agentHoldMusicUrl = agentHoldMusicUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd agentHoldMusicMethod(String agentHoldMusicMethod) {
    this.agentHoldMusicMethod = agentHoldMusicMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd customerHoldMusicUrl(String customerHoldMusicUrl) {
    this.customerHoldMusicUrl = customerHoldMusicUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd customerHoldMusicMethod(String customerHoldMusicMethod) {
    this.customerHoldMusicMethod = customerHoldMusicMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd recordingCallbackUrl(String recordingCallbackUrl) {
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd recordingCallbackMethod(String recordingCallbackMethod) {
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd statusCallbackUrl(String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd statusCallbackMethod(String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd onExitActionUrl(String onExitActionUrl) {
    this.onExitActionUrl = onExitActionUrl;
    return this;
  }

  public MultiPartyCallParticipantAdd onExitActionMethod(String onExitActionMethod) {
    this.onExitActionMethod = onExitActionMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd record(Boolean record) {
    this.record = record;
    return this;
  }

  public MultiPartyCallParticipantAdd recordFileFormat(String recordFileFormat) {
    this.recordFileFormat = recordFileFormat;
    return this;
  }

  public MultiPartyCallParticipantAdd statusCallbackEvents(List<String> statusCallbackEvents) {
    this.statusCallbackEvents = statusCallbackEvents;
    return this;
  }

  public MultiPartyCallParticipantAdd stayAlone(Boolean stayAlone) {
    this.stayAlone = stayAlone;
    return this;
  }

  public MultiPartyCallParticipantAdd coachMode(Boolean coachMode) {
    this.coachMode = coachMode;
    return this;
  }

  public MultiPartyCallParticipantAdd mute(Boolean mute) {
    this.mute = mute;
    return this;
  }

  public MultiPartyCallParticipantAdd hold(Boolean hold) {
    this.hold = hold;
    return this;
  }

  public MultiPartyCallParticipantAdd startMpcOnEnter(Boolean startMpcOnEnter) {
    this.startMpcOnEnter = startMpcOnEnter;
    return this;
  }

  public MultiPartyCallParticipantAdd endMpcOnExit(Boolean endMpcOnExit) {
    this.endMpcOnExit = endMpcOnExit;
    return this;
  }

  public MultiPartyCallParticipantAdd relayDtmfInputs(Boolean relayDtmfInputs) {
    this.relayDtmfInputs = relayDtmfInputs;
    return this;
  }

  public MultiPartyCallParticipantAdd enterSound(String enterSound) {
    this.enterSound = enterSound;
    return this;
  }

  public MultiPartyCallParticipantAdd enterSoundMethod(String enterSoundMethod) {
    this.enterSoundMethod = enterSoundMethod;
    return this;
  }

  public MultiPartyCallParticipantAdd exitSound(String exitSound) {
    this.exitSound = exitSound;
    return this;
  }

  public MultiPartyCallParticipantAdd exitSoundMethod(String exitSoundMethod) {
    this.exitSoundMethod = exitSoundMethod;
    return this;
  }

  @Override
  protected Call<MultiPartyCallParticipantAddResponse> obtainCall() throws PlivoValidationException {
    Validate.check(this);
    return client().getVoiceApiService().mpcAddParticipant(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MultiPartyCallParticipantAddResponse> obtainFallback1Call() throws PlivoValidationException {
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcAddParticipant(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MultiPartyCallParticipantAddResponse> obtainFallback2Call() throws PlivoValidationException {
    Validate.check(this);
    return client().getVoiceFallback2Service().mpcAddParticipant(client().getAuthId(), id, this);
  }
}