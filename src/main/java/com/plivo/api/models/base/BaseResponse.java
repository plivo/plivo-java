package com.plivo.api.models.base;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

  private String message;
  private String apiId;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getApiId() {
    return apiId;
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
