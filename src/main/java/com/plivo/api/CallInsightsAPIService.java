package com.plivo.api;

import com.plivo.api.models.callfeedback.CallFeedbackCreateResponse;
import com.plivo.api.models.callfeedback.CallFeedbackCreator;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CallInsightsAPIService {
  //Address
  @Headers("Content-Type: application/json")
  @POST("Call/{callUUID}/Feedback/")
  Call<CallFeedbackCreateResponse> callFeedbackCreate(@Path("callUUID") String callUUID, @Body CallFeedbackCreator callFeedbackCreator);
}