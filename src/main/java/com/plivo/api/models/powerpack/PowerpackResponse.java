package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResponse;
public class PowerpackResponse extends BaseResponse {

  private String createdOn;
  private String name;
  private String applicationType;
  private String applicationID;
  private Boolean stickySender;
  private Boolean localConnect;
  private String numberPool;
  private String uuid;
  public NumberPriority[] numberPriority;

  public String getCreatedOn() {
    return createdOn;
  }

  public String getName() {
    return name;
  }

  public String getApplicationType() {
    return applicationType;
  }

  public String getApplicationID() {
    return applicationID;
  }

  public Boolean getStickySender() {
    return stickySender;
  }

  public Boolean getLocalConnect() {
    return localConnect;
  }

  public String getNumberPool() {
    return numberPool;
  }

  public NumberPriority[] getNumberPriority() {
    return numberPriority;
  }

  public String getUuid() {
    return uuid;
  }

}