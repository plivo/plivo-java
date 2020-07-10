package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallRecordingStop extends Deleter<MultiPartyCall> {

  public MultiPartyCallRecordingStop(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcRecordStop(client().getAuthId(), id);
  }
}
