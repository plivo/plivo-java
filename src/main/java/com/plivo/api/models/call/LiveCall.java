package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResource;

// TODO Date
public class LiveCall extends BaseResource {

  private CallDirection direction;
  private String from;
  private String to;
  private CallStatus callStatus;
  private String callerName;
  private String callUuid;
  private String requestUuid;
  private String sessionStart;

  public static LiveCallGetter getter(String id) {
    return new LiveCallGetter(id);
  }

  public static LiveCallListGetter listGetter() {
    return new LiveCallListGetter();
  }

  public String getRequestUuid() {
    return requestUuid;
  }

  public CallDirection getDirection() {
    return direction;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public CallStatus getCallStatus() {
    return callStatus;
  }

  public String getCallerName() {
    return callerName;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public String getSessionStart() {
    return sessionStart;
  }

  @Override
  public String getId() {
    return getCallUuid();
  }
}
