package com.plivo.api.models.multipartycall;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class MultiPartyCallParticipantList extends VoiceLister<MultiPartyCallParticipant> {

  @JsonIgnore
  private final String mpcId;
  private String callUuid;

  public MultiPartyCallParticipantList(String mpcId) {
    this.mpcId = mpcId;
  }

  public String callUuid() {
    return callUuid;
  }

  public MultiPartyCallParticipantList callUuid(String callUuid) {
    this.callUuid = callUuid;
    return this;
  }

  @Override
  protected Call<ListResponse<MultiPartyCallParticipant>> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(mpcId);
    return client().getVoiceApiService().mpcListParticipants(client().getAuthId(), mpcId, toMap());
  }

  @Override
  protected Call<ListResponse<MultiPartyCallParticipant>> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(mpcId);
    return client().getVoiceFallback1Service().mpcListParticipants(client().getAuthId(), mpcId, toMap());
  }

  @Override
  protected Call<ListResponse<MultiPartyCallParticipant>> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(mpcId);
    return client().getVoiceFallback2Service().mpcListParticipants(client().getAuthId(), mpcId, toMap());
  }
}