package com.plivo.api.models.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;

public class MessagingBaseResponse {

  @JsonIgnore
  private String message;
  private String apiId;
  @JsonIgnore
  private String error;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getApiId() {
    return apiId;
  }
  public String getError(){
    return error;
  }
  public void setError(String error){
    this.error = error;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  protected PlivoClient plivoClient = Plivo.getClient();

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
