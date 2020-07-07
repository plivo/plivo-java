package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class MultiPartyCallGet extends Getter<MultiPartyCall> {

  public MultiPartyCallGet(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<MultiPartyCall> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcGet(client().getAuthId(), id);
  }
}
