package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;

import java.io.IOException;

public class CallRecordCreator extends Creator<CallRecordCreateResponse> {

  private final String id;
  private String callbackUrl;
  private String callbackMethod;

  public CallRecordCreator(String id) {
    this.id = id;
  }

  @Override
  protected retrofit2.Call<CallRecordCreateResponse> obtainCall() {
    return client().getApiService().callRecordCreate(client().getAuthId(), id, this);
  }

  public CallRecordCreateResponse record() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallRecordCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  public CallRecordCreator callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public CallRecordCreator callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }
}
