package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class MaskingSessionUpdater extends VoiceUpdater<MaskingSessionUpdateResponse> {

  private int sessionExpiry;
  private int callTimeLimit;
  private int ringTimeout;
  private String subaccount;
  private String recordingCallbackMethod;
  private String secondPartyPlayUrl;
  private String firstPartyPlayUrl;
  private String callbackMethod;
  private String callbackUrl;
  private String recordingCallbackUrl;
  private String recordFileFormat;
  private Boolean geomatch = null;
  private boolean record;

  public MaskingSessionUpdater(String id) {
    super(id);
  }
  @Override
  protected Call<MaskingSessionUpdateResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionUpdate(client().getAuthId(), id, this);
  }
  @Override
  protected Call<MaskingSessionUpdateResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionUpdate(client().getAuthId(), id, this);
  }
  @Override
  protected Call<MaskingSessionUpdateResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionUpdate(client().getAuthId(), id, this);
  }

  public int callTimeLimit() {
    return this.callTimeLimit;
  }
  public MaskingSessionUpdater callTimeLimit(final int callTimeLimit) {
    this.callTimeLimit = callTimeLimit;
    return this;
  }
  public int ringTimeout() {
    return this.ringTimeout;
  }
  public MaskingSessionUpdater ringTimeout(final int ringTimeout) {
    this.ringTimeout = ringTimeout;
    return this;
  }
  public boolean record() {
    return this.record;
  }
  public MaskingSessionUpdater record(final boolean record){
    this.record = record;
    return this;
  }
  public Boolean geomatch() {
    return this.geomatch;
  }
  public MaskingSessionUpdater geomatch(final Boolean geomatch){
    this.geomatch = geomatch;
    return this;
  }
  public String recordFileFormat() {
    return this.recordFileFormat;
  }
  public MaskingSessionUpdater recordFileFormat(final String recordFileFormat){
    this.recordFileFormat = recordFileFormat;
    return this;
  }
  public String recordingCallbackUrl() {
    return this.recordingCallbackUrl;
  }
  public MaskingSessionUpdater recordingCallbackUrl(final String recordingCallbackUrl){
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }
  public String callbackUrl() {
    return this.callbackUrl;
  }
  public MaskingSessionUpdater callbackUrl(final String callbackUrl){
    this.callbackUrl = callbackUrl;
    return this;
  }
  public String callbackMethod() {
    return this.callbackMethod;
  }
  public MaskingSessionUpdater callbackMethod(final String callbackMethod){
    this.callbackMethod = callbackMethod;
    return this;
  }
  public String firstPartyPlayUrl() {
    return this.firstPartyPlayUrl;
  }
  public MaskingSessionUpdater firstPartyPlayUrl(final String firstPartyPlayUrl){
    this.firstPartyPlayUrl = firstPartyPlayUrl;
    return this;
  }
  public String secondPartyPlayUrl() {
    return this.secondPartyPlayUrl;
  }
  public MaskingSessionUpdater secondPartyPlayUrl(final String secondPartyPlayUrl){
    this.secondPartyPlayUrl = secondPartyPlayUrl;
    return this;
  }
  public String recordingCallbackMethod() {
    return this.recordingCallbackMethod;
  }
  public MaskingSessionUpdater recordingCallbackMethod(final String recordingCallbackMethod){
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }
  public String subaccount() {
    return this.subaccount;
  }
  public MaskingSessionUpdater subaccount(final String subaccount){
    this.subaccount = subaccount;
    return this;
  }
  public int sessionExpiry() {
    return this.sessionExpiry;
  }
  public MaskingSessionUpdater sessionExpiry(final int sessionExpiry) {
    this.sessionExpiry = sessionExpiry;
    return this;
  }
}

