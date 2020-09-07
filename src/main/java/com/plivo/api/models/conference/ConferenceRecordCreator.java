package com.plivo.api.models.conference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceRecordCreator extends VoiceCreator<ConferenceRecordCreateResponse> {

  @JsonIgnore
  private final String conferenceName;
  private String fileFormat;
  private String transcriptionType;
  private String transcriptionUrl;
  private String transcriptionMethod;
  private String callbackUrl;
  private String callbackMethod;

  public ConferenceRecordCreator(String conferenceName) {
    this.conferenceName = conferenceName;
  }

  public String fileFormat() {
    return this.fileFormat;
  }

  public String transcriptionType() {
    return this.transcriptionType;
  }

  public String transcriptionUrl() {
    return this.transcriptionUrl;
  }

  public String transcriptionMethod() {
    return this.transcriptionMethod;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public ConferenceRecordCreator fileFormat(final String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  public ConferenceRecordCreator transcriptionType(final String transcriptionType) {
    this.transcriptionType = transcriptionType;
    return this;
  }

  public ConferenceRecordCreator transcriptionUrl(final String transcriptionUrl) {
    this.transcriptionUrl = transcriptionUrl;
    return this;
  }

  public ConferenceRecordCreator transcriptionMethod(final String transcriptionMethod) {
    this.transcriptionMethod = transcriptionMethod;
    return this;
  }

  public ConferenceRecordCreator callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public ConferenceRecordCreator callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  @Override
  protected Call<ConferenceRecordCreateResponse> obtainCall() {
    return client().getVoiceApiService().conferenceRecordCreate(client().getAuthId(), conferenceName);
  }

  @Override
  protected Call<ConferenceRecordCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceRecordCreate(client().getAuthId(), conferenceName);
  }

  @Override
  protected Call<ConferenceRecordCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceRecordCreate(client().getAuthId(), conferenceName);
  }

  public ConferenceRecordCreateResponse record() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public ConferenceRecordCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


}