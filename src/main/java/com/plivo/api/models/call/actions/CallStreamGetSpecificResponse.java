package com.plivo.api.models.call.actions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

@JsonIgnoreProperties({"id"})
public class CallStreamGetSpecificResponse extends BaseResource {

  private String callUuid;
  private String endTime;
  private String serviceUrl;
  private String startTime;
  private String status;
  private String statusCallbackUrl;
  private String streamId;

  public String getCallUuid() {
    return callUuid;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getServiceUrl() {
    return serviceUrl;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusCallbackUrl() {
    return statusCallbackUrl;
  }

  public String getStreamId() {
    return streamId;
  }

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }
}