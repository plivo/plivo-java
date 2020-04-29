package com.plivo.api.models.callfeedback;

import com.plivo.api.models.base.BaseResource;

public class CallFeedback extends BaseResource {

  private String callUUID;

  public static CallFeedbackCreator creator(String callUUID, Float rating){
    return new CallFeedbackCreator(callUUID, rating);
  }

  public String getCallUUID(){
    return callUUID;
  }

  @Override
  public String getId() {
    return getCallUUID();
  }

}
