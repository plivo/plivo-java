package com.plivo.api.models.verify_session;

public class AttemptDetail {
  private String channel;
  private String attemptUuid;
  private String status;
  private String time;
  private String brandName;
  private String appHash;

  public AttemptDetail(String channel, String attemptUuid, String status, String time, String brandName, String appHash) {
    this.channel = channel;
    this.attemptUuid = attemptUuid;
    this.status = status;
    this.time = time;
    this.brandName = brandName;
    this.appHash = appHash;
  }

  public AttemptDetail(){}

  public String getChannel(){
    return channel;
  }
  public String getAttemptUuid(){
    return attemptUuid;
  }
  public String getStatus(){
    return status;
  }
  public String getTime(){
    return time;
  }
  public String getBrandName() {
    return brandName;
  }
  public String getAppHash() {
    return appHash;
  }
}
