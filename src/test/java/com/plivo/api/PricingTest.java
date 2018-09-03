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
  @Test

  public void pricingGetWithClientShouldSucceed() throws Exception {
    expectResponse("pricingGetResponse.json", 200);
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Pricing pricing = Pricing.getter("US").client(client)
      .get();


    assertEquals(pricing.getId(), pricing.getCountryIso());

    Map<String, String> params = new LinkedHashMap<>();
    params.put("country_iso", "US");

    assertRequest("GET", "Pricing/", params);
  }
}
