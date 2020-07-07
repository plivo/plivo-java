package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class MultiPartyCallRecordingResume extends Updater<BaseResponse> {

  public MultiPartyCallRecordingResume(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcResumeRecording(client().getAuthId(), id);
  }
}
