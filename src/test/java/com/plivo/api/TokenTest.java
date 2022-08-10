package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.token.Token;
import com.plivo.api.models.token.Token;
import org.junit.Before;
import org.junit.Test;

public class TokenTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "ZTJiODc5MTM1ODA3MzMyYmY4NTAwYzA3Mjc2OWNh");
  }

  @Test
  public void tokenCreateShouldWork() throws Exception {
    expectResponse("TokenCreateResponse.json", 200);

    Token.creator("MAMDVLZJY2ZGY5MWU1ZJ")
      .create();

    assertRequest("POST", "JWT/Token/");
  }

  @Test
  public void tokenCreateWithClientShouldWork() throws Exception {
    expectResponse("tokenCreateResponse.json", 200);

    Token.creator("MAMDVLZJY2ZGY5MWU1ZJ")
      .client(client)
      .create();

    assertRequest("POST", "JWT/Token/");
  }

  @Test(expected = IllegalArgumentException.class)
  public void tokenCreateShouldFailWithoutAllParams() throws Exception {
    Token.creator(null)
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void tokenCreateWithClientShouldFailWithoutAllParams() throws Exception {
    Token.creator(null)
      .client(client)
      .create();
  }
}