package com.plivo.api.models.number;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class NumberGetter extends Getter<Number> {

  NumberGetter(String number) {
    super(number);
  }

  @Override
  protected Call<Number> obtainCall() {
    return client().getApiService().numberGet(client().getAuthId(), id);
  }
}
