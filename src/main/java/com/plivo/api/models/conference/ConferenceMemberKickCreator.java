package com.plivo.api.models.conference;

import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberKickCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  public ConferenceMemberKickCreator(String conferenceName, String memberId) {
    super(conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getApiService()
      .conferenceMemberKickCreate(client().getAuthId(), conferenceName, memberId);
  }

  public ConferenceMemberActionResponse kick() throws IOException, PlivoRestException {
    return create();
  }
}
