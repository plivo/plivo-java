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
    String typeInput = "carrier";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, typeInput)
        .get();

    assertBaseRequest("GET",
        "/Lookup/Number/%s?type=%s",
        Collections.singletonMap("type", typeInput),
        numberInput, typeInput);

    assertEquals(number.getId(), number.getApiId());
    assertEquals("/v1/Lookup/Number/+14154305555?type=carrier", number.getResourceURI());
    assertEquals("United States", number.getCountry().getName());
    assertEquals("US", number.getCountry().getCodeISO2());
    assertEquals("USA", number.getCountry().getCodeISO3());
    assertEquals("+14154305555", number.getFormat().getE164());
    assertEquals("+1 415-430-5555", number.getFormat().getInternational());
    assertEquals("(415) 430-5555", number.getFormat().getNational());
    assertEquals("tel:+1-415-430-5555", number.getFormat().getRFC3966());
    assertEquals("Cingular Wireless", number.getCarrier().getName());
    assertEquals("mobile", number.getCarrier().getType());
    assertEquals("310", number.getCarrier().getMobileCountryCode());
    assertEquals("150", number.getCarrier().getMobileNetworkCode());
    assertEquals(true, number.getCarrier().isPorted());
  }

  @Test
  public void lookupGetWithClientShouldSucceed() throws Exception {
    String fixtureName = "lookupGetResponse.json";
    expectResponse(fixtureName, 200);

    String numberInput = "+14154305555";
    String typeInput = "carrier";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, typeInput)
        .client(client)
        .get();

    assertBaseRequest("GET",
        "/Lookup/Number/%s?type=%s",
        Collections.singletonMap("type", typeInput),
        numberInput, typeInput);

    assertEquals(number.getId(), number.getApiId());
    assertEquals("/v1/Lookup/Number/+14154305555?type=carrier", number.getResourceURI());
    assertEquals("United States", number.getCountry().getName());
    assertEquals("US", number.getCountry().getCodeISO2());
    assertEquals("USA", number.getCountry().getCodeISO3());
    assertEquals("+14154305555", number.getPhoneNumber());
    assertEquals("+14154305555", number.getFormat().getE164());
    assertEquals("+1 415-430-5555", number.getFormat().getInternational());
    assertEquals("(415) 430-5555", number.getFormat().getNational());
    assertEquals("tel:+1-415-430-5555", number.getFormat().getRFC3966());
    assertEquals("Cingular Wireless", number.getCarrier().getName());
    assertEquals("mobile", number.getCarrier().getType());
    assertEquals("310", number.getCarrier().getMobileCountryCode());
    assertEquals("150", number.getCarrier().getMobileNetworkCode());
    assertEquals(true, number.getCarrier().isPorted());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void lookupGetWithInvalidNumber() throws Exception {
    String fixtureName = "lookupGetResponse404.json";
    expectResponse(fixtureName, 404);

    // invalid phone number
    String numberInput = "+14154305555xxxxxxxxxxxxx";
    String typeInput = "carrier";

    com.plivo.api.models.lookup.Number number =
        com.plivo.api.models.lookup.Number.getter(numberInput, typeInput)
        .client(client)
        .get();
  }
}
