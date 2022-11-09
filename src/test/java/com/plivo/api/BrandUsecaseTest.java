package com.plivo.api;

import com.plivo.api.models.brand.*;
import com.plivo.api.models.base.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

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
        String fixtureName = "brandUsecaseGetResponse.json";
        String code = "ACCOUNT_NOTIFICATION";

        expectResponse(fixtureName, 202);
        String brandID = "BFJXXXX";
        BrandUsecase response = Brand.get_usecases(brandID).get();

        assertRequest("GET", "10dlc/Brand/BFJXXXX/usecases/");
        assertEquals(code, response.getUseCases().get(0).getCode());
    }
}
