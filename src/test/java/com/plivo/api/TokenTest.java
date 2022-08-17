package com.plivo.api;

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
  public void tokenCreateWithClientShouldWork() throws Exception {
    expectResponse("tokenCreateResponse.json", 201);

    Token.creator("MA123456789012345678")
      .client(client)
      .create();

    assertRequest("POST", "JWT/Token/");
  }

  @Test(expected = IllegalArgumentException.class)
  public void tokenCreateShouldFailWithoutAllParams() throws Exception {
    Token.creator(null)
      .create();
  }
}
