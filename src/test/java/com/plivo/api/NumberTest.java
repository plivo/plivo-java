package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.number.Number;
import com.plivo.api.models.number.PhoneNumber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class NumberTest extends BaseTest {

  @Test
  public void numberListShouldSucceed() throws Exception {
    expectResponse("numberListResponse.json", 200);

    Number.lister()
      .list();

    assertRequest("GET", "Number/");
  }

  @Test
  public void numberCreateShouldSucceed() throws Exception {
    expectResponse("numberCreateResponse.json", 202);

    Number.creator(Collections.singletonList("1231231231"), "carrier", "region")
      .create();

    assertRequest("POST", "Number/");
  }


  @Test
  public void numberUpdateShouldSucceed() throws Exception {
    expectResponse("numberUpdateResponse.json", 202);

    final String number = "1231231231";

    Number.updater(number)
      .alias("test")
      .update();

    assertRequest("POST", "Number/%s/", number);
  }

  @Test
  public void numberGetShouldSucceed() throws Exception {
    expectResponse("numberGetResponse.json", 202);

    final String numberNumber = "1231231231";

    Number number = Number.getter(numberNumber)
      .get();


    assertEquals(number.getId(), number.getNumber());

    assertRequest("GET", "Number/%s/", numberNumber);
  }

  @Test
  public void phoneNumberListShouldSucceed() throws Exception {
    expectResponse("phoneNumberListResponse.json", 200);

    PhoneNumber.lister("US")
      .list();

    Map<String, String> params = new LinkedHashMap<>();
    params.put("country_iso", "US");
    assertRequest("GET", "PhoneNumber/", params);
  }

  @Test
  public void phoneNumberCreateShouldSucceed() throws Exception {
    expectResponse("phoneNumberCreateResponse.json", 201);

    final String number = "1231231231";

    PhoneNumber.creator(number)
      .create();

    assertRequest("POST", "PhoneNumber/%s/", number);
  }

}
