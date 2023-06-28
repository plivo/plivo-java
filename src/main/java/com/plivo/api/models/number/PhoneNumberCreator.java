package com.plivo.api.models.number;

import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class PhoneNumberCreator extends Creator<PhoneNumberCreateResponse> {

  private String number;
  private String appId;
  private String cnamLookup;

  public PhoneNumberCreator(String number) {
    if (number == null) {
      throw new IllegalArgumentException("number cannot be null");
    }

    this.number = number;
  }

  public String appId() {
    return this.appId;
  }

  public String cnamLookup() {
    return this.cnamLookup;
  }

  public PhoneNumberCreator appId(final String appId) {
    this.appId = appId;
    return this;
  }

  public PhoneNumberCreator cnamLookup(final String cnamLookup) {
    this.cnamLookup = cnamLookup;
    return this;
  }

  @Override
  protected Call<PhoneNumberCreateResponse> obtainCall() {
    return client().getApiService().phoneNumberCreate(client().getAuthId(), number, this);
  }
}
