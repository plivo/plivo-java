package com.plivo.api.models.call.actions;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;
import com.plivo.api.models.call.LegSpecifier;
import java.io.IOException;
import retrofit2.Call;

public class CallSpeakCreator extends Creator<CallSpeakCreateResponse> {

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
    return client().getApiService().callSpeakCreate(client().getAuthId(), id, this);
  }

  public CallSpeakCreateResponse speak() throws IOException, PlivoRestException {
    return create();
  }
}
