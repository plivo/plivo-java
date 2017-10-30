package com.plivo.api.models.pricing;

import com.plivo.api.models.base.Getter;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class PricingGetter extends Getter<Pricing> {

  public PricingGetter(String countryIso) {
    super(countryIso);

    if (!Utils.allNotNull(countryIso)) {
      throw new IllegalArgumentException("countryIso cannot be null");
    }
  }

  @Override
  protected Call<Pricing> obtainCall() {
    return client().getApiService().pricingGet(client().getAuthId(), id);
  }
}
