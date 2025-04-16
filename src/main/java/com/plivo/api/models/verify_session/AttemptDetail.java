package com.plivo.api.models.verify_session;

public class AttemptDetail {
  private String channel;
  private String attemptUuid;
  private String status;
  private String time;
  private String brandName;
  private String appHash;
  private Integer codeLength;
  private Integer dtmf;
  private String fraudCheck;

  public AttemptDetail(String channel, String attemptUuid, String status, String time, String brandName, String appHash, Integer codeLength, Integer dtmf, String fraudCheck) {
    this.channel = channel;
    this.attemptUuid = attemptUuid;
    this.status = status;
    this.time = time;
    this.brandName = brandName;
    this.appHash = appHash;
    this.codeLength = codeLength;
    this.dtmf = dtmf;
    this.fraudCheck = fraudCheck;
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
  public Integer getCodeLength(){
    return codeLength;
  }
  public Integer getDtmf(){
    return dtmf;
  }
  public String getFraudCheck(){
    return fraudCheck;
  }
}
