package com.plivo.api.models.multipartycall;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class MultiPartyCallParticipantList extends Lister<MultiPartyCallParticipant> {

  @JsonIgnoreProperties
  private final String mpcId;
  private String callUuid;

  public MultiPartyCallParticipantList(String mpcId) {
    this.mpcId = mpcId;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public MultiPartyCallParticipantList callUuid(String callUuid) {
    this.callUuid = callUuid;
    return this;
  }

  @Override
  protected Call<ListResponse<MultiPartyCallParticipant>> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(mpcId);
    return client().getApiService().mpcListParticipants(client().getAuthId(), mpcId, toMap());
  }
}
