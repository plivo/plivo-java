package com.plivo.api.models.call;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;
import okhttp3.ResponseBody;

public class RequestDeleter extends Deleter<Call> {
  public RequestDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().requestDelete(client().getAuthId(), id);
  }

  public void cancel() throws IOException, PlivoRestException {
    delete();
  }
}
