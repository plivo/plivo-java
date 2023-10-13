package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class ListVerifiedCallerId extends VoiceGetter<ListVerifiedCallerIdResponse> {

  private String country;
  private String subaccount;
  private String alias;
  private int limit;
  private int offset;

  public String getCountry() {
    return country;
  }

  public String getSubaccount() {
    return subaccount;
  }

  public String getAlias() {
    return alias;
  }

  public int getLimit() {
    return limit;
  }

  public int getOffset() {
    return offset;
  }

  public ListVerifiedCallerId country(final String country) {
    this.country = country;
    return this;
  }
  public ListVerifiedCallerId subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public ListVerifiedCallerId alias(final String alias) {
    this.alias = alias;
    return this;
  }
  public ListVerifiedCallerId limit(final int limit) {
    this.limit = limit;
    return this;
  }
  public ListVerifiedCallerId offset(final int offset) {
    this.offset = offset;
    return this;
  }

  public ListVerifiedCallerId() {
    super("");
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().listVerifiedCallerID(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().listVerifiedCallerID(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().listVerifiedCallerID(client().getAuthId(), toMap());
  }
}
