package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallStop extends Deleter<MultiPartyCall> {

  public MultiPartyCallStop(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcStop(client().getAuthId(), id);
  }
}
