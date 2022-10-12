package com.plivo.api;

import com.plivo.api.models.brand.BrandUsecase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BrandUsecaseTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void brandUsecaseShouldSucceed() throws Exception {
    
    String code = "ACCOUNT_NOTIFICATION";
    
    expectResponse("brandUsecaseGetResponse.json", 200);
    BrandUsecase response = BrandUsecase.getter("BFJXXXX").client(client).get();
    assertRequest("GET", "10dlc/Brand/BFJXXXX/usecases/");
    assertEquals(code, response.getUseCases().get(0).getCode());
  }

}
