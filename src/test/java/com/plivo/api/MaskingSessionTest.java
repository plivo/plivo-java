package com.plivo.api;

import com.plivo.api.models.maskingsession.MaskingSession;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class MaskingSessionTest extends BaseTest {
  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void maskingSessionCreate() throws Exception {
    expectResponse("maskingSessionCreateResponse.json", 201);

    MaskingSession.creator("917708772011", "918220568648").create();

    assertRequest("POST", "Masking/Session/");
  }

  @Test
  public void maskingSessionCreateWithClient() throws Exception {
    expectResponse("maskingSessionCreateResponse.json", 201);

    MaskingSession.creator("917708772011", "918220568648").client(client).create();

    assertRequest("POST", "Masking/Session/");
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionCreateFail() throws Exception {
    MaskingSession.creator(null, null).create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionCreateClientFail() throws Exception {
    MaskingSession.creator(null, null).client(client).create();
  }

  @Test
  public void maskingSessionGet() throws Exception {
    expectResponse("maskingSessionGetResponse.json", 200);

    final String sessionUuid = "83a7e48c-88c7-4a8e-b349-08dc311fbe04";

    String maskingSession = MaskingSession.getter(sessionUuid).get();

    assertRequest("GET", "Masking/Session/%s/", sessionUuid);
  }

  @Test
  public void maskingSessionGetClient() throws Exception {
    expectResponse("maskingSessionGetResponse.json", 200);
    final String sessionUuid = "83a7e48c-88c7-4a8e-b349-08dc311fbe04";

    String maskingSession = MaskingSession.getter(sessionUuid).client(client).get();

    assertRequest("GET", "Masking/Session/%s/", sessionUuid);
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionGetNull() throws Exception {
    expectResponse("maskingSessionGetResponse.json", 200);

    MaskingSession.getter(null).get();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionGetNullClient() throws Exception {
    expectResponse("maskingSessionGetResponse.json", 200);
    MaskingSession.getter(null).client(client).get();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionUpdateNull() throws Exception {
    expectResponse("maskingSessionUpdateResponse.json", 200);

    MaskingSession.updater(null).update();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionUpdateNullClient() throws Exception {
    expectResponse("maskingSessionUpdateResponse.json", 202);

    MaskingSession.updater(null).client(client).update();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionDeleteNull() throws Exception {
    expectResponse(null, 204);

    MaskingSession.deleter(null).delete();
  }

  @Test(expected = IllegalArgumentException.class)
  public void maskingSessionDeleteNullClient() throws Exception {
    expectResponse(null, 204);

    MaskingSession.deleter(null).client(client).delete();
  }

  @Test
  public void maskingSessionDeleteClient() throws Exception {
    expectResponse("maskingSessionDeleteResponse.json", 200);
    final String sessionUuid = "83a7e48c-88c7-4a8e-b349-08dc311fbe04";

    MaskingSession.deleter(sessionUuid).client(client).delete();

    assertRequest("DELETE", "Masking/Session/%s/", sessionUuid);
  }

  @Test
  public void maskingSessionDelete() throws Exception {
    expectResponse("maskingSessionDeleteResponse.json", 200);
    final String sessionUuid = "83a7e48c-88c7-4a8e-b349-08dc311fbe04";

    MaskingSession.deleter(sessionUuid).delete();

    assertRequest("DELETE", "Masking/Session/%s/", sessionUuid);
  }
}
