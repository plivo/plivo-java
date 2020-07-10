package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class MultiPartyCallRecordingPause extends Updater<BaseResponse> {

  public MultiPartyCallRecordingPause(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcPauseRecording(client().getAuthId(), id);
  }
}
