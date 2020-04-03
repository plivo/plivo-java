package com.plivo.api;

import com.plivo.api.models.powerpack.Numbers;
import com.plivo.api.models.powerpack.Powerpack;
import com.plivo.api.models.powerpack.Shortcode;
import com.plivo.api.models.powerpack.Tollfree;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class PowerpackTest extends BaseTest {
  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }
  @Test
  public void powerpackCreateShouldSucceed() throws Exception {
    String fixtureName = "powerpackCreateResponse.json";

    expectResponse(fixtureName, 202);

    Powerpack.creator("PPK test")
      .create();

    assertRequest("POST", "Powerpack/");
  }

  @Test
  public void powerpackGetShouldSucceed() throws Exception {
    String fixtureName = "powerpackCreateResponse.json";
    String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

    expectResponse(fixtureName, 200);

    Powerpack response = Powerpack.getter(uuid).get();

    assertEquals(response.getId(), response.getUuid());

    assertRequest("GET", "Powerpack/%s/", uuid);
    assertEquals(uuid, response.getUuid());
  }

  @Test
  public void powerpackIteratorWithClientShouldSucceed() throws Exception {
    String fixtureName = "powerpackListResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();

    Iterator<Powerpack> iter = Powerpack.lister().client(client).iterator();
    iter.hasNext();
    iter.next();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Powerpack/", params);
  }
  @Test
  public void numberpoolIteratorWithClientShouldSucceed() throws Exception {
    String fixtureName = "numberpoolListResponse.json";
    String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";
    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();
    Powerpack powerpack = Powerpack.getter(uuid).get();
    Iterator<Numbers> iter = powerpack.list_numbers().client(client).iterator();
    iter.hasNext();
    iter.next();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Numberpool/xxxxxxx/Number/", params);
  }

  @Test
  public void powerpackFindNumberShouldSucceed() throws Exception {
    String fixtureName = "numberpoolResponse.json";
    String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

    expectResponse(fixtureName, 200);

    Numbers response = Powerpack.getter(uuid).get().find_number().number("15799140348").get();


    assertEquals(response.getNumber(), "15799140348");
  }
  @Test
  public void powerpackAddNumberShouldSucceed() throws Exception {
    String fixtureName = "numberpoolResponse.json";
    String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

    expectResponse(fixtureName, 200);

    Numbers response = Powerpack.getter(uuid).get().add_number().number("15799140348").get();
    assertEquals(response.getNumber(), "15799140348");
  }

  @Test
  public void powerpackFindShortcodeShouldSucceed() throws Exception {
    String fixtureName = "numberpoolResponse.json";
    String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

    expectResponse(fixtureName, 200);

    Shortcode response = Powerpack.getter(uuid).get().find_shortcode().shortcode("444444").get();
    assertEquals(response.getShortcode(), "444444");
  }

  // @Test
  // public void powerpackFindTollfreeShouldSucceed() throws Exception {
  //   String fixtureName = "tollfreeResponse.json";
  //   String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

  //   expectResponse(fixtureName, 200);

  //   Tollfree response = Powerpack.getter(uuid).get().find_tollfree().tollfree("18772209942").get();
  //   assertEquals(response.getNumber(), "18889140579");
  // }

  // @Test
  // public void powerpackAddTollfreeShouldSucceed() throws Exception {
  //   String fixtureName = "tollfreeResponse.json";
  //   String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

  //   expectResponse(fixtureName, 200);

  //   Tollfree response = Powerpack.getter(uuid).get().add_tollfree().tollfree("18772209942").get();
  //   assertEquals(response.getNumber(), "18889140579");
  // }

  // @Test
  // public void powerpackListTollfreeShouldSucceed() throws Exception {
  //   String fixtureName = "tollfreeListResponse.json";
  //   String uuid = "c5d77bad-b0b8-4cad-97bf-f97aa82ff7fe";

  //   expectResponse(fixtureName, 200);

  //   Tollfree response = Powerpack.getter(uuid).get().list_tollfree().list();
  //   assertEquals(response.getNumber(), "18889140579");
  // }

  

}
