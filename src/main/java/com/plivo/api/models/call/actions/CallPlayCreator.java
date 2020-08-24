package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;
import com.plivo.api.models.call.LegSpecifier;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;

public class CallPlayCreator extends VoiceCreator<CallPlayCreateResponse> {

  private List<String> urls;
  private Long length;
  private LegSpecifier legs;
  private Boolean loop;
  private Boolean mix;
  private String id;

  public CallPlayCreator(String id, List<String> urls) {
    this.id = id;
    this.urls = urls;
  }

  public List<String> urls() {
    return this.urls;
  }

  public Long length() {
    return this.length;
  }

  public LegSpecifier legs() {
    return this.legs;
  }

  public Boolean loop() {
    return this.loop;
  }

  public Boolean mix() {
    return this.mix;
  }

  public CallPlayCreator urls(final List<String> urls) {
    this.urls = urls;
    return this;
  }

  public CallPlayCreator length(final Long length) {
    this.length = length;
    return this;
  }

  public CallPlayCreator legs(final LegSpecifier legs) {
    this.legs = legs;
    return this;
  }

  public CallPlayCreator loop(final Boolean loop) {
    this.loop = loop;
    return this;
  }

  public CallPlayCreator mix(final Boolean mix) {
    this.mix = mix;
    return this;
  }


  @Override
  protected Call<CallPlayCreateResponse> obtainCall() {
    return client().getVoiceApiService().callPlayCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallPlayCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callPlayCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallPlayCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callPlayCreate(client().getAuthId(), id, this);
  }

  public CallPlayCreateResponse play() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallPlayCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


}