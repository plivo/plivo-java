package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

import java.util.Collections;

public class MultiPartyCallStart extends Updater<BaseResponse> {

  public MultiPartyCallStart(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcStart(client().getAuthId(), id, Collections.singletonMap("status", "active"));
  }
}
