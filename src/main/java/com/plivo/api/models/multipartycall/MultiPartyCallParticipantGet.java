package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class MultiPartyCallParticipantGet extends Getter<MultiPartyCallParticipant> {

  public MultiPartyCallParticipantGet(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  @Override
  protected Call<MultiPartyCallParticipant> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcMemberGet(client().getAuthId(), id, secondaryId);
  }
}
