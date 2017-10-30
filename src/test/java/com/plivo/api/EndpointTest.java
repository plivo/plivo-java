package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.endpoint.Endpoint;
import org.junit.Test;

public class EndpointTest extends BaseTest {

  @Test
  public void endpointCreateShouldWork() throws Exception {
    expectResponse("endpointCreateResponse.json", 201);

    Endpoint.creator("username", "password", "alias")
      .create();

    assertRequest("POST", "Endpoint/");
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointCreateShouldFailWithoutAllParams() throws Exception {
    Endpoint.creator(null, null, null)
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

  @Test(expected = IllegalArgumentException.class)
  public void endpointGetNullIdShouldThrow() throws Exception {
    expectResponse("endpointGetResponse.json", 200);

    Endpoint.getter(null)
      .get();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointUpdateNullIdShouldThrow() throws Exception {
    expectResponse("endpointUpdateResponse.json", 202);

    Endpoint.updater(null)
      .update();
  }

  @Test(expected = IllegalArgumentException.class)
  public void endpointDeleteNullIdShouldThrow() throws Exception {
    expectResponse(null, 204);

    Endpoint.deleter(null)
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
  public void endpointUpdateShouldWork() throws Exception {
    expectResponse("endpointUpdateResponse.json", 200);
    final String endpointId = "endpointId";

    Endpoint.updater(endpointId)
      .alias("test")
      .update();

    assertRequest("POST", "Endpoint/%s/", endpointId);
  }

  @Test
  public void endpointDeleteShouldWork() throws Exception {
    expectResponse(null, 204);
    final String endpointId = "endpointId";

    Endpoint.deleter(endpointId)
      .delete();

    assertRequest("DELETE", "Endpoint/%s/", endpointId);
  }
}
