package com.plivo.api;

import java.util.LinkedHashMap;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.plivo.api.exceptions.ResourceNotFoundException;


public class LookupTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void lookupGetShouldSucceed() throws Exception {
    String fixtureName = "lookupGetResponse.json";
    expectResponse(fixtureName, 200);

    String numberInput = "+14154305555";
    String infoInput = "service_provider";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, infoInput)
        .get();

    assertBaseRequest("GET",
        "/Lookup/Number/%s?info=%s",
        Collections.singletonMap("info", infoInput),
        numberInput, infoInput);

    assertEquals(number.getId(), number.getApiId());
    assertEquals("United States", number.getCountry().getName());
    assertEquals("US", number.getCountry().getCodeISO2());
    assertEquals("USA", number.getCountry().getCodeISO3());
    assertEquals("+14154305555", number.getNumberFormat().getE164());
    assertEquals("+1 415-430-5555", number.getNumberFormat().getInternational());
    assertEquals("(415) 430-5555", number.getNumberFormat().getNational());
    assertEquals("tel:+1-415-430-5555", number.getNumberFormat().getRFC3966());
    assertEquals("Cingular Wireless", number.getServiceProvider().getName());
    assertEquals("mobile", number.getServiceProvider().getType());
    assertEquals("310", number.getServiceProvider().getMobileCountryCode());
    assertEquals("160", number.getServiceProvider().getMobileNetworkCode());
    assertEquals(true, number.getServiceProvider().isPorted());
  }

  @Test
  public void lookupGetWithClientShouldSucceed() throws Exception {
    String fixtureName = "lookupGetResponse.json";
    expectResponse(fixtureName, 200);

    String numberInput = "+14154305555";
    String infoInput = "service_provider";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, infoInput)
        .client(client)
        .get();

    assertBaseRequest("GET",
        "/Lookup/Number/%s?info=%s",
        Collections.singletonMap("info", infoInput),
        numberInput, infoInput);

    assertEquals(number.getId(), number.getApiId());
    assertEquals("United States", number.getCountry().getName());
    assertEquals("US", number.getCountry().getCodeISO2());
    assertEquals("USA", number.getCountry().getCodeISO3());
    assertEquals("+14154305555", number.getNumberFormat().getE164());
    assertEquals("+1 415-430-5555", number.getNumberFormat().getInternational());
    assertEquals("(415) 430-5555", number.getNumberFormat().getNational());
    assertEquals("tel:+1-415-430-5555", number.getNumberFormat().getRFC3966());
    assertEquals("Cingular Wireless", number.getServiceProvider().getName());
    assertEquals("mobile", number.getServiceProvider().getType());
    assertEquals("310", number.getServiceProvider().getMobileCountryCode());
    assertEquals("160", number.getServiceProvider().getMobileNetworkCode());
    assertEquals(true, number.getServiceProvider().isPorted());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void lookupGetWithInvalidNumber() throws Exception {
    String fixtureName = "lookupGetResponse404.json";
    expectResponse(fixtureName, 404);

    // invalid phone number
    String numberInput = "+14154305555xxxxxxxxxxxxx";
    String infoInput = "service_provider";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, infoInput)
        .client(client)
        .get();
  }
}
