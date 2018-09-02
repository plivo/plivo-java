package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.endpoint.Endpoint;
import org.junit.Before;
import org.junit.Test;

public class EndpointTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoRestClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
  }

  @Test
  public void endpointCreateShouldWork() throws Exception {
    expectResponse("endpointCreateResponse.json", 201);

    Endpoint.creator("username", "password", "alias")
      .create();

    assertRequest("POST", "Endpoint/");
  }

  @Test
  public void endpointCreateWithClientShouldWork() throws Exception {
    expectResponse("endpointCreateResponse.json", 201);

    Endpoint.creator("username", "password", "alias")
      .client(client)
      .create();

    assertRequest("POST", "Endpoint/");
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointCreateShouldFailWithoutAllParams() throws Exception {
    Endpoint.creator(null, null, null)
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointCreateWithClientShouldFailWithoutAllParams() throws Exception {
    Endpoint.creator(null, null, null)
      .client(client)
      .create();
  }

  @Test
  public void endpointGetShouldWork() throws Exception {
    expectResponse("endpointGetResponse.json", 200);
    final String endpointId = "endpointId";

    Endpoint endpoint = Endpoint.getter(endpointId)
      .get();

    assertEquals(endpoint.getId(), endpoint.getEndpointId());

    assertRequest("GET", "Endpoint/%s/", endpointId);
  }

  @Test
  public void endpointGetWithClientShouldWork() throws Exception {
    expectResponse("endpointGetResponse.json", 200);
    final String endpointId = "endpointId";

    Endpoint endpoint = Endpoint.getter(endpointId)
      .client(client)
      .get();

    assertEquals(endpoint.getId(), endpoint.getEndpointId());

    assertRequest("GET", "Endpoint/%s/", endpointId);
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointGetNullIdShouldThrow() throws Exception {
    expectResponse("endpointGetResponse.json", 200);

    Endpoint.getter(null)
      .get();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointGetNullIdWithClientShouldThrow() throws Exception {
    expectResponse("endpointGetResponse.json", 200);

    Endpoint.getter(null)
      .client(client)
      .get();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointUpdateNullIdShouldThrow() throws Exception {
    expectResponse("endpointUpdateResponse.json", 202);

    Endpoint.updater(null)
      .update();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointUpdateNullIdWithClientShouldThrow() throws Exception {
    expectResponse("endpointUpdateResponse.json", 202);

    Endpoint.updater(null)
      .client(client)
      .update();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointDeleteNullIdShouldThrow() throws Exception {
    expectResponse(null, 204);

    Endpoint.deleter(null)
      .delete();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointDeleteNullIdWithClientShouldThrow() throws Exception {
    expectResponse(null, 204);

    Endpoint.deleter(null)
      .client(client)
      .delete();
  }

  @Test
  public void endpointListShouldWork() throws Exception {
    expectResponse("endpointListResponse.json", 200);

    Endpoint.lister()
      .list();

    assertRequest("GET", "Endpoint/");
  }

  @Test
  public void endpointListWithClientShouldWork() throws Exception {
    expectResponse("endpointListResponse.json", 200);

    Endpoint.lister()
      .client(client)
      .list();

    assertRequest("GET", "Endpoint/");
  }

  @Test
  public void endpointUpdateShouldWork() throws Exception {
    expectResponse("endpointUpdateResponse.json", 200);
    final String endpointId = "endpointId";

    Endpoint.updater(endpointId)
      .alias("test")
      .update();

    assertRequest("POST", "Endpoint/%s/", endpointId);
  }

  @Test
  public void endpointUpdateWithClientShouldWork() throws Exception {
    expectResponse("endpointUpdateResponse.json", 200);
    final String endpointId = "endpointId";

    Endpoint.updater(endpointId)
      .alias("test")
      .client(client)
      .update();

    assertRequest("POST", "Endpoint/%s/", endpointId);
  }

  @Test
  public void endpointDeleteWithClientShouldWork() throws Exception {
    expectResponse(null, 204);
    final String endpointId = "endpointId";

    Endpoint.deleter(endpointId)
      .delete();

    assertRequest("DELETE", "Endpoint/%s/", endpointId);
  }

  @Test
  public void endpointDeleteShouldWork() throws Exception {
    expectResponse(null, 204);
    final String endpointId = "endpointId";

    Endpoint.deleter(endpointId)
      .client(client)
      .delete();

    assertRequest("DELETE", "Endpoint/%s/", endpointId);
  }
}
