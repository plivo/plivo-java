package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.InvalidRequestException;

//@JsonIgnoreProperties(value = {"api_id"})
public abstract class BaseResource {
  private String apiId;

  public String getApiId() {
    return apiId;
  }

  public abstract String getId() throws InvalidRequestException;

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
      return getClass().getCanonicalName() + ": " + plivoClient.getObjectMapper()
        .writeValueAsString(this);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
