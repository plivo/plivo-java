package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;
import com.plivo.api.models.call.LegSpecifier;
import java.io.IOException;
import retrofit2.Call;

public class CallSpeakCreator extends VoiceCreator<CallSpeakCreateResponse> {

  private final String id;
  private final String text;
  private String voice;
  private String language;
  private LegSpecifier legs;
  private Boolean loop;
  private Boolean mix;

  public CallSpeakCreator(String id, String text) {
    this.id = id;
    this.text = text;
  }

  @Override
  protected Call<CallSpeakCreateResponse> obtainCall() {
    return client().getVoiceApiService().callSpeakCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallSpeakCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callSpeakCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallSpeakCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callSpeakCreate(client().getAuthId(), id, this);
  }

  public CallSpeakCreateResponse speak() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallSpeakCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


}