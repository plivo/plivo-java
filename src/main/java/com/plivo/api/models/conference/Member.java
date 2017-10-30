package com.plivo.api.models.conference;

import com.plivo.api.models.call.CallDirection;

public class Member {

  private Boolean muted;
  private String memberId;
  private Boolean deaf;
  private String from;
  private String to;
  private String callerName;
  private CallDirection direction;
  private String callUuid;
  private String joinTime;

  /**
   * @return Lets you know if the member is muted. If this value id true then the member is
   * currently muted.
   */
  public Boolean getMuted() {
    return muted;
  }

  /**
   * @return The ID of the member with respect to this conference. This is unique to a particular
   * conference.
   */
  public String getMemberId() {
    return memberId;
  }

  /**
   * @return Denotes whether the member is currently deaf. If this value is true, then the member
   * will not be able to hear the conversation taking place on the conference.
   */
  public Boolean getDeaf() {
    return deaf;
  }

  /**
   * @return The number from which the call was made to the conference. This can either be a PSTN
   * number or a SIP endpoint.
   */
  public String getFrom() {
    return from;
  }

  /**
   * @return The conference bridge number. This can either be a Plivo number of a application URL
   */
  public String getTo() {
    return to;
  }

  /**
   * @return The name of the caller in case the call was made from a SIP endpoint. This field would
   * be empty if no caller name was specified while making the call.
   */
  public String getCallerName() {
    return callerName;
  }

  /**
   * @return The direction of the call. The values can be 'inbound' or 'outbound'.
   */
  public CallDirection getDirection() {
    return direction;
  }

  /**
   * @return The call_uuid of the call. This can be used to uniquely identify the call made to the
   * conference.
   */
  public String getCallUuid() {
    return callUuid;
  }

  /**
   * @return The time in seconds since this call has joined the conference
   */
  public String getJoinTime() {
    return joinTime;
  }
}
