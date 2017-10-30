package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;

//@JsonIgnoreProperties(value = {"api_id"})
public abstract class BaseResource {
  private String apiId;

  public String getApiId() {
    return apiId;
  }

  public abstract String getId();

  protected PlivoClient plivoClient = Plivo.getClient();

  @JsonIgnore
  public PlivoClient getPlivoClient() {
    return plivoClient;
  }

  public void setPlivoClient(PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
  }

  @Override
  public String toString() {
    try {
      return getClass().getCanonicalName() + ": " + PlivoClient.getObjectMapper()
        .writeValueAsString(this);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
