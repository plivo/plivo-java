package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResponse;

public class PowerpackUpdateResponse extends BaseResponse {
private String createdOn;
  private String name;
  private String application_type;
  private String application_id;
  private Boolean sticky_sender;
  private Boolean local_connect;
  private String number_pool;
  private String uuid;
  public NumberPriority[] number_priority;

  public String getCreatedOn() {
    return createdOn;
  }

  public String getName() {
    return name;
  }

  public String getApplication_type() {
    return application_type;
  }

  public String getApplication_id() {
    return application_id;
  }

  public Boolean getSticky_sender() {
    return sticky_sender;
  }

  public Boolean getLocal_connect() {
    return local_connect;
  }

  public String getNumber_pool() {
    return number_pool;
  }

  public NumberPriority[] getNumber_priority() {
    return number_priority;
  }

  public String getUuid() {
    return uuid;
  }
}