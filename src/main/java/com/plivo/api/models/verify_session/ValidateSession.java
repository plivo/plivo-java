package com.plivo.api.models.verify_session;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plivo.api.models.base.Creator;
import com.plivo.api.models.base.Getter;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ValidateSession extends Creator< SessionCreateResponse > {
  @JsonProperty("otp")
  private String otp;

  private String id;

  public ValidateSession(String id, String otp) {
    if (!Utils.allNotNull(id, otp)) {
      throw new IllegalArgumentException("session_uuid or otp cannot be null");
    }
    this.otp = otp;
    this.id = id;
  }

  public String otp() {
    return this.otp;
  }

  @Override
  protected Call<SessionCreateResponse> obtainCall() {
    return client().getApiService().validateSession(client().getAuthId(), this.id, this);
  }

}
