package com.plivo.api.models.number;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class NumberDeleter extends Deleter<Number> {

  private final String number;

  NumberDeleter(final String number) {
    super(number);
    if (number == null) {
      throw new IllegalArgumentException("number cannot be null");
    }

    this.number = number;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().numberDelete(client().getAuthId(), number);
  }

  public void unrent() throws IOException, PlivoRestException {
    delete();
  }
}
