package com.plivo.api;

import com.plivo.api.models.powerpack.*;
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
    String uuid = "86bbb125-97bb-4d72-89fd-81d5c515b015";

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
    String fixtureName = "numberPoolPowerPack.json";
    String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();
    Powerpack powerpack = Powerpack.getter(uuid).get();
    server.takeRequest();

    fixtureName = "numberpoolListResponse.json";
    expectResponse(fixtureName, 200);

    Iterator<Numbers> iter = powerpack.list_numbers().client(client).iterator();
    iter.hasNext();
    iter.next();

    params.put("limit", "20");
    params.put("offset", "0");
    params.put("id", "2b3aae01-22ae-4137-8730-8e0cd057f944");
    assertRequest("GET", "NumberPool/2b3aae01-22ae-4137-8730-8e0cd057f944/Number/", params);
  }

  @Test
  public void powerpackFindNumberShouldSucceed() throws Exception {
    String fixtureName = "numberPoolPowerPack.json";
    String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
    expectResponse(fixtureName, 200);

    Powerpack powerpack = Powerpack.getter(uuid).get();
    server.takeRequest();

    fixtureName = "numberpoolResponse.json";
    expectResponse(fixtureName, 200);

    Numbers response = powerpack.find_number().number("15799140348").client(client).get();

    assertEquals(response.getNumber(), "15799140348");
  }

  @Test
  public void powerpackAddNumberShouldSucceed() throws Exception {
    String fixtureName = "numberPoolPowerPack.json";
    String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
    expectResponse(fixtureName, 200);

    Powerpack powerpack = Powerpack.getter(uuid).get();
    server.takeRequest();

    fixtureName = "numberpoolResponse.json";
    expectResponse(fixtureName, 200);

    Numbers response = powerpack.add_number().number("15799140348").client(client).get();
    assertEquals(response.getNumber(), "15799140348");
  }
  

   @Test
   public void powerpackFindTollfreeShouldSucceed() throws Exception {
     String fixtureName = "numberPoolPowerPack.json";
     String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
     expectResponse(fixtureName, 200);

     Powerpack powerpack = Powerpack.getter(uuid).get();
     server.takeRequest();

     fixtureName = "tollfreeResponse.json";

     expectResponse(fixtureName, 200);
     Tollfree response = powerpack.find_tollfree().tollfree("18772209942").client(client).get();
     assertEquals(response.getNumber(), "18889140579");
   }

   @Test
   public void powerpackAddTollfreeShouldSucceed() throws Exception {
     String fixtureName = "numberPoolPowerPack.json";
     String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
     expectResponse(fixtureName, 200);

     Powerpack powerpack = Powerpack.getter(uuid).get();
     server.takeRequest();

     fixtureName = "tollfreeResponse.json";

     expectResponse(fixtureName, 200);
     Tollfree response = powerpack.add_tollfree().tollfree("18772209942").client(client).get();
     assertEquals(response.getNumber(), "18889140579");
   }

   @Test
   public void powerpackListTollfreeShouldSucceed() throws Exception {
     String fixtureName = "numberPoolPowerPack.json";
     String uuid = "d5125688-7c1a-43b5-b522-bbe70b54490a";
     expectResponse(fixtureName, 200);

     Powerpack powerpack = Powerpack.getter(uuid).get();
     server.takeRequest();

     fixtureName = "tollfreeListResponse.json";
     expectResponse(fixtureName, 200);

     Iterator<Tollfree> response = powerpack.list_tollfree().client(client).iterator();
     response.hasNext();
     response.next();

     Map<String, String> params = new LinkedHashMap<>();
     params.put("limit", "20");
     params.put("offset", "0");
     params.put("id", "2b3aae01-22ae-4137-8730-8e0cd057f944");
     assertRequest("GET", "NumberPool/2b3aae01-22ae-4137-8730-8e0cd057f944/Tollfree/", params);
   }



}
