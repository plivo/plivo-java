package com.plivo.api.models.callfeedback;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

import java.util.List;

public class CallFeedbackCreator extends Creator<CallFeedbackCreateResponse> {

  private String callUUID;
  private Float rating;
  private List<String> issues;
  private String notes;

  CallFeedbackCreator(String callUUID, Float rating) {
    if (!Utils.allNotNull(callUUID, rating)) {
      throw new IllegalArgumentException("from, to and answerUrl must not be null");
    }
    this.callUUID = callUUID;
    this.rating = rating;
  }

  public CallFeedbackCreator issues(final List<String> issues){
    this.issues = issues;
    return this;
  }

  public CallFeedbackCreator notes(final String notes){
    this.notes = notes;
    return this;
  }

  @Override
  protected Call<CallFeedbackCreateResponse> obtainCall() {
    return client().getCallInsightsAPIService().callFeedbackCreate(callUUID, this);
  }

}
