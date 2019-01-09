package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.plivo.api.Client;
import com.plivo.api.Plivo;

//@JsonIgnoreProperties(value = {"api_id"})
public abstract class BaseResource {
  private String apiId;

  public String getApiId() {
    return apiId;
  }

  public abstract String getId();

  protected Client plivoClient = Plivo.getClient();

  @JsonIgnore
  public Client getPlivoClient() {
    return plivoClient;
  }

  public void setPlivoClient(Client plivoClient) {
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
