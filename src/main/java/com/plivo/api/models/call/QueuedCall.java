package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResource;

// TODO Date
public class QueuedCall extends BaseResource {

  private CallDirection direction;
  private String from;
  private String to;
  private CallStatus callStatus;
  private String callerName;
  private String callUuid;
  pricate String apiId;


  public static QueuedCallGetter getter(String id) {
    return new QueuedCallGetter(id);
  }

  public static QueuedCallListGetter listGetter() {
    return new QueuedCallListGetter();
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

  public String getApiID() {
    return apiId;
  }

  @Override
  public String getId() {
    return getCallUuid();
  }
}
