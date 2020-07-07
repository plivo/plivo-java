package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallParticipantKick extends Deleter<MultiPartyCallParticipant> {

  public MultiPartyCallParticipantKick(String mpcId, String participantId) {
    super(mpcId, participantId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcMemberKick(client().getAuthId(), id, secondaryId);
  }
}
