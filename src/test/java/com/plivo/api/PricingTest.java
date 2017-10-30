package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.pricing.Pricing;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class PricingTest extends BaseTest {

  @Test
  public void pricingGetShouldSucceed() throws Exception {
    expectResponse("pricingGetResponse.json", 200);

    Pricing pricing = Pricing.getter("US")
      .get();


    assertEquals(pricing.getId(), pricing.getCountryIso());

    Map<String, String> params = new LinkedHashMap<>();
    params.put("country_iso", "US");

    assertRequest("GET", "Pricing/", params);
  }
}
