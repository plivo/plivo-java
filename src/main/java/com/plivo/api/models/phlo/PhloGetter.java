package com.plivo.api.models.phlo;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PhloGetter extends Getter<Phlo> {

  public PhloGetter(final String phloId) {
    super(phloId);
  }

  @Override
  protected Call<Phlo> obtainCall() {
    return client().getPhloRestClient().getApiService().phloGet(this.id);
  }

}
