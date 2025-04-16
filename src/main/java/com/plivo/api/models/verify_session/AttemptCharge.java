package com.plivo.api.models.verify_session;

public class AttemptCharge {
  private String attemptUuid;
  private String channel;
  private String charge;

  public AttemptCharge( String attemptUuid, String channel, String charge) {
    this.attemptUuid = attemptUuid;
    this.channel = channel;
    this.charge = charge;
  }

  public AttemptCharge(){}

  public String getAttemptUuid(){
    return attemptUuid;
  }
  public String getChannel(){
    return channel;
  }
  public String getCharge(){
    return charge;
  }

}
