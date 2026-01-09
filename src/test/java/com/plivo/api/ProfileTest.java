package com.plivo.api;

import com.plivo.api.models.profile.*;
import com.plivo.api.models.base.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ProfileTest extends BaseTest {
    private PlivoClient client;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Test
    public void profileCreateShouldSucceed() throws Exception {
        String fixtureName = "profileCreateResponse.json";

        expectResponse(fixtureName, 202);
        ProfileAddress address = new ProfileAddress("123 Main Street", "San Francisco", "CA", "94105", "US");
        ProfileAuthorizedContact authContact =  new ProfileAuthorizedContact("John", "Doe", "+14155551234", "test@example.com", "CEO", "C_LEVEL");
        ProfileAddResponse response = Profile.creator("Test Profile", "DIRECT", "PUBLIC", "Test Company Inc", "12-3456789", "US", address, "TEST", "NASDAQ", "https://testcompany.com", "TECHNOLOGY", "", "NONE", "", authContact, "employee@company.com").create();
    
        assertRequest("POST", "Profile/");
    }

    @Test
    public void profileGetShouldSucceed() throws Exception {
        String fixtureName = "profileGetResponse.json";

        expectResponse(fixtureName, 202);
        String profileUUID = "201faedc-7df9-4840-9ab1-3997ce3f7cf4";
        Profile response = Profile.getter(profileUUID).get();

        assertRequest("GET", "Profile/%s/", profileUUID);
        assertEquals(profileUUID, response.getProfile().getProfileUUID());
    }

    @Test
    public void profileListShouldSucceed() throws Exception {
        String fixtureName = "profileListResponse.json";

        expectResponse(fixtureName, 202);
        ListResponse<Profile> response = Profile.lister().limit(20).offset(0).list();

        assertRequest("GET", "Profile/");
    }

    @Test
    public void profileUpdateShouldSucceed() throws Exception {
        String fixtureName = "profileUpdateResponse.json";

        expectResponse(fixtureName, 202);
        ProfileAddress address = new ProfileAddress("123 Main Street", "San Francisco", "CA", "94105", "US");
        ProfileAuthorizedContact authContact =  new ProfileAuthorizedContact("John", "Doe", "+14155551234", "test@example.com", "CEO", "C_LEVEL");
        Profile response = Profile.update("8abd0935-fd17-4876-9b40-5855488ac5b5").entityType("PUBLIC").address(address).authorizedContact(authContact).businessContactEmail("employee@company.com").update();

        assertRequest("POST", "Profile/8abd0935-fd17-4876-9b40-5855488ac5b5/");
    }

    @Test
    public void profileDeleteShouldSucceed() throws Exception {
        String fixtureName = "profileDeleteResponse.json";

        expectResponse(fixtureName, 202);
        Profile response = Profile.delete("c88652e9-79ac-4ff1-a816-4982616ac919").delete();
        assertRequest("DELETE", "Profile/c88652e9-79ac-4ff1-a816-4982616ac919/");
    }
}