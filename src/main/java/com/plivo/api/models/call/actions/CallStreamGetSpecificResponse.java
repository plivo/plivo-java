package com.plivo.api.models.call.actions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

@JsonIgnoreProperties({"id"})
public class CallStreamGetSpecificResponse extends BaseResource {

  private String audioTrack;
  private String bidirectional;
  private String billedAmount;
  private String billedDuration;
  private String callUuid;
  private String createdAt;
  private String endTime;
  private String plivoAuthId;
  private String resourceUri;
  private String serviceUrl;
  private String startTime;
  private String status;
  private String statusCallbackUrl;
  private String streamId;

  public String getAudioTrack() {
    return audioTrack;
  }

  public String getBidirectional() {
    return bidirectional;
  }

  public String getBilledAmount() {
    return billedAmount;
  }

  public String getBilledDuration() {
    return billedDuration;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getPlivoAuthId() {
    return plivoAuthId;
  }

  public String getResourceUri() {
    return resourceUri;
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