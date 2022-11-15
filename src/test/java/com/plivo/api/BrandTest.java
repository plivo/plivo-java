package com.plivo.api;

import com.plivo.api.models.brand.*;
import com.plivo.api.models.base.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class BrandTest extends BaseTest {
    private PlivoClient client;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Test
    public void brandCreateShouldSucceed() throws Exception {
        String fixtureName = "brandCreateResponse.json";

        expectResponse(fixtureName, 202);
        BrandCreateResponse response = Brand.creator("brand create", "42946d40-33de-4b7d-8421-45e3acc63eed", "STARTER", false, null, null).create();

        assertRequest("POST", "10dlc/Brand/");
    }

    @Test
    public void brandGetShouldSucceed() throws Exception {
        String fixtureName = "brandGetResponse.json";

        expectResponse(fixtureName, 202);
        String brandID = "BOZ5T2X";
        Brand response = Brand.getter(brandID).get();

        assertRequest("GET", "10dlc/Brand/%s/", brandID);
        assertEquals(brandID, response.getBrand().getBrandID());
    }

    @Test
    public void brandListShouldSucceed() throws Exception {
        String fixtureName = "brandListResponse.json";

        expectResponse(fixtureName, 202);
        ListResponse<Brand> response = Brand.lister().limit(2).offset(0).list();

        assertRequest("GET", "10dlc/Brand/");
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
