package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;
import com.plivo.api.models.call.LegSpecifier;
import java.io.IOException;
import retrofit2.Call;

public class CallDtmfCreator extends VoiceCreator<CallDtmfCreateResponse> {

  private final String digits;
  private final String id;
  private LegSpecifier leg;

  public CallDtmfCreator(String id, String digits) {
    this.id = id;
    this.digits = digits;
  }

  public String digits() {
    return digits;
  }

  public LegSpecifier leg() {
    return this.leg;
  }

  public CallDtmfCreator leg(final LegSpecifier leg) {
    this.leg = leg;
    return this;
  }


  @Override
  protected Call<CallDtmfCreateResponse> obtainCall() {
    return client().getVoiceApiService().callDtmfCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallDtmfCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callDtmfCreate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallDtmfCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callDtmfCreate(client().getAuthId(), id, this);
  }

  public CallDtmfCreateResponse sendDigits() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallDtmfCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
