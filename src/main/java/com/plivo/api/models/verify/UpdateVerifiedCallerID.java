package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class UpdateVerifiedCallerID extends VoiceUpdater<UpdateVerifiedCallerIdResponse> {

  private String alias;
  private String subaccount;

  public UpdateVerifiedCallerID(String id) {
    super(id);
  }

  public String getAlias() {
    return alias;
  }

  public String getSubaccount() {
    return subaccount;
  }

  public UpdateVerifiedCallerID alias(final String otp) {
    this.alias = alias;
    return this;
  }

  public UpdateVerifiedCallerID subaccount(final String otp) {
    this.subaccount = subaccount;
    return this;
  }

  @Override
  protected Call<UpdateVerifiedCallerIdResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().updateVerifiedCallerID(client().getAuthId(), id, this);
  }

  @Override
  protected Call<UpdateVerifiedCallerIdResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().updateVerifiedCallerID(client().getAuthId(), id, this);
  }

  @Override
  protected Call<UpdateVerifiedCallerIdResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().updateVerifiedCallerID(client().getAuthId(), id, this);
  }
}
