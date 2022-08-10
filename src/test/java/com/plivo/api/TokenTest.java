package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.endpoint.Endpoint;
import com.plivo.api.models.token.Token;
import org.junit.Before;
import org.junit.Test;

public class TokenTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void tokenCreateShouldWork() throws Exception {
    expectResponse("TokenCreateResponse.json", 201);

    Token.creator("MA123456789012345678")
      .create();

    assertRequest("POST", "JWT/Token/");
  }
}