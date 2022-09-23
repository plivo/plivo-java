package com.plivo.api.models.call.actions;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

public class CallStreamGetSpecificResponse extends BaseResource {

  private String callUuid;
  private String endTime;
  private String serviceUrl;
  private String startTime;
  private String status;
  private String statusCallbackUrl;
  private String streamId;

  @Override
  public String getId() throws PlivoValidationException {
    return callUuid;
  }
}
