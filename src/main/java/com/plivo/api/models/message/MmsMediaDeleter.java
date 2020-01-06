package com.plivo.api.models.message;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;

import java.io.IOException;

import okhttp3.ResponseBody;

public class MmsMediaDeleter extends Deleter<MmsMedia> {

  public MmsMediaDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().mmsMediaDelete(client().getAuthId(), id);
  }

}
