package com.plivo.api.models.maskingsession;
import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class MaskingSessionCreator extends VoiceCreator<MaskingSessionCreateResponse> {
  private final String firstParty;
  private final String secondParty;
  private String recordFileFormat;
  private String recordingCallbackUrl;
  private String callbackUrl;
  private String callbackMethod;
  private String firstPartyPlayUrl;
  private String secondPartyPlayUrl;
  private String recordingCallbackMethod;
  private String firstPartyPin;
  private String secondPartyPin;
  private String pinPromptPlay;
  private String incorrectPinPlay;
  private String unknownCallerPlay;
  private String subaccount;
  private boolean initiateCallToFirstParty;
  private boolean isPinAuthenticationRequired;
  private boolean geomatch = true;
  private boolean generatePin;
  private boolean record;
  private int ringTimeout;
  private Integer generatePinLength = null;
  private int pinRetry;
  private int pinRetryWait;
  private int sessionExpiry;
  private int callTimeLimit;
  private boolean createSessionWithSingleParty;
  private boolean forcePinAuthentication;
  private int virtualNumberCooloffPeriod;

  public MaskingSessionCreator(String firstParty, String secondParty) {
    this.firstParty = firstParty;
    this.secondParty = secondParty;
  }
  @Override
  protected Call<MaskingSessionCreateResponse> obtainCall() {
    return client().getVoiceApiService().maskingSessionCreate(client().getAuthId(), this);
  }
  @Override
  protected Call<MaskingSessionCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().maskingSessionCreate(client().getAuthId(), this);
  }
  @Override
  protected Call<MaskingSessionCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().maskingSessionCreate(client().getAuthId(), this);
  }
  public String callbackUrl() {
    return this.callbackUrl;
  }
  public MaskingSessionCreator callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }
  public String callbackMethod() {
    return this.callbackMethod;
  }
  public MaskingSessionCreator callbackMethod(String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }
  public String firstPartyPlayUrl() {
    return this.firstPartyPlayUrl;
  }
  public MaskingSessionCreator firstPartyPlayUrl(String firstPartyPlayUrl) {
    this.firstPartyPlayUrl = firstPartyPlayUrl;
    return this;
  }
  public String secondPartyPlayUrl() {
    return this.secondPartyPlayUrl;
  }
  public MaskingSessionCreator secondPartyPlayUrl(String secondPartyPlayUrl) {
    this.secondPartyPlayUrl = secondPartyPlayUrl;
    return this;
  }
  public String recordingCallbackMethod() {
    return this.recordingCallbackMethod;
  }
  public MaskingSessionCreator recordingCallbackMethod(String recordingCallbackMethod) {
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }
  public String firstPartyPin() {
    return this.firstPartyPin;
  }
  public MaskingSessionCreator firstPartyPin(String firstPartyPin) {
    this.firstPartyPin = firstPartyPin;
    return this;
  }
  public String secondPartyPin() {
    return this.secondPartyPin;
  }
  public MaskingSessionCreator secondPartyPin(String secondPartyPin) {
    this.secondPartyPin = secondPartyPin;
    return this;
  }
  public String pinPromptPlay() {
    return this.pinPromptPlay;
  }
  public MaskingSessionCreator pinPromptPlay(String pinPromptPlay) {
    this.pinPromptPlay = pinPromptPlay;
    return this;
  }
  public String incorrectPinPlay() {
    return this.incorrectPinPlay;
  }
  public MaskingSessionCreator incorrectPinPlay(String incorrectPinPlay) {
    this.incorrectPinPlay = incorrectPinPlay;
    return this;
  }
  public String unknownCallerPlay() {
    return this.unknownCallerPlay;
  }
  public MaskingSessionCreator unknownCallerPlay(String unknownCallerPlay) {
    this.unknownCallerPlay = unknownCallerPlay;
    return this;
  }
  public String subaccount() {
    return this.subaccount;
  }
  public MaskingSessionCreator subaccount(String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public String recordingCallbackUrl() {
    return this.recordingCallbackUrl;
  }
  public MaskingSessionCreator recordingCallbackUrl(String recordingCallbackUrl) {
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }
  public String recordFileFormat() {
    return this.recordFileFormat;
  }
  public MaskingSessionCreator recordFileFormat(String recordFileFormat) {
    this.recordFileFormat = recordFileFormat;
    return this;
  }
  public int sessionExpiry() {
    return this.sessionExpiry;
  }
  public MaskingSessionCreator sessionExpiry(final int sessionExpiry) {
    this.sessionExpiry = sessionExpiry;
    return this;
  }
  public int callTimeLimit() {
    return this.callTimeLimit;
  }
  public MaskingSessionCreator callTimeLimit(final int callTimeLimit) {
    this.callTimeLimit = callTimeLimit;
    return this;
  }
  public boolean record() {
    return this.record;
  }
  public MaskingSessionCreator record(final boolean record) {
    this.record = record;
    return this;
  }
  public boolean initiateCallToFirstParty() {
    return this.initiateCallToFirstParty;
  }
  public MaskingSessionCreator initiateCallToFirstParty(final boolean initiateCallToFirstParty) {
    this.initiateCallToFirstParty = initiateCallToFirstParty;
    return this;
  }
  public boolean isPinAuthenticationRequired() {
    return this.isPinAuthenticationRequired;
  }
  public MaskingSessionCreator isPinAuthenticationRequired(final boolean isPinAuthenticationRequired) {
    this.isPinAuthenticationRequired = isPinAuthenticationRequired;
    return this;
  }
  public int ringTimeout() {
    return this.ringTimeout;
  }
  public MaskingSessionCreator ringTimeout(final int ringTimeout) {
    this.ringTimeout = ringTimeout;
    return this;
  }
  public Integer generatePinLength() {
    return this.generatePinLength;
  }
  public MaskingSessionCreator generatePinLength(final Integer generatePinLength) {
    this.generatePinLength = generatePinLength;
    return this;
  }
  public int pinRetry() {
    return this.pinRetry;
  }
  public MaskingSessionCreator pinRetry(final int pinRetry) {
    this.pinRetry = pinRetry;
    return this;
  }
  public int pinRetryWait() {
    return this.pinRetryWait;
  }
  public MaskingSessionCreator pinRetryWait(final int pinRetryWait) {
    this.pinRetryWait = pinRetryWait;
    return this;
  }
  public boolean generatePin() {
    return this.generatePin;
  }
  public MaskingSessionCreator generatePin(final boolean generatePin) {
    this.generatePin = generatePin;
    return this;
  }
  public boolean geomatch() {
    return this.geomatch;
  }
  public MaskingSessionCreator geomatch(final boolean geomatch) {
    this.geomatch = geomatch;
    return this;
  }
  public boolean createSessionWithSingleParty() {
    return this.createSessionWithSingleParty;
  }
  public MaskingSessionCreator createSessionWithSingleParty(final boolean createSessionWithSingleParty) {
    this.createSessionWithSingleParty = createSessionWithSingleParty;
    return this;
  }
  public boolean forcePinAuthentication() {
    return this.forcePinAuthentication;
  }
  public MaskingSessionCreator forcePinAuthentication(final boolean forcePinAuthentication) {
    this.forcePinAuthentication = forcePinAuthentication;
    return this;
  }
  public int virtualNumberCooloffPeriod() {
    return this.virtualNumberCooloffPeriod;
  }
  public MaskingSessionCreator virtualNumberCooloffPeriod(final int virtualNumberCooloffPeriod) {
    this.virtualNumberCooloffPeriod = virtualNumberCooloffPeriod;
    return this;
  }
}
