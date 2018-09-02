package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import com.plivo.api.models.call.Call;
import java.io.IOException;
import okhttp3.ResponseBody;

public class CallPlayDeleter extends Deleter<Call> {

  public CallPlayDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService().callPlayDelete(client().getPlivoRestClient().getAuthId(), id);
  }

  public void playStop() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public CallPlayDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
