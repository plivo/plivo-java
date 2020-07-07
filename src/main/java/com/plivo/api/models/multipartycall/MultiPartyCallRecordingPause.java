package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class MultiPartyCallRecordingPause extends Updater<BaseResponse> {

  private Boolean trimSilence;

  public MultiPartyCallRecordingPause(String mpcId) {
    super(mpcId);
  }

  public Boolean getTrimSilence() {
    return trimSilence;
  }

  public MultiPartyCallRecordingPause trimSilence(Boolean trimSilence) {
    this.trimSilence = trimSilence;
    return this;
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcPauseRecording(client().getAuthId(), id, this);
  }
}
