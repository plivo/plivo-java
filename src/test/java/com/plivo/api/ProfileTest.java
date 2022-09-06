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
        ProfileAddress address = new ProfileAddress("1234", "New York", "NY", "12345", "US");
        ProfileAuthorizedContact authContact =  new ProfileAuthorizedContact("john", "Deo", "12345467987", "123j@plivo.com", "MTR", "admin");
        ProfileAddResponse response = Profile.creator("java profile", "DIRECT", "PRIVATE", "Plivo", "12345678", "IN", address, "ABC", "NSE", "google.com", "ENERGY", "", "", "", authContact).create();
    
        assertRequest("POST", "Profile/");
    }

    @Test
    public void profileGetShouldSucceed() throws Exception {
        String fixtureName = "profileGetResponse.json";

        expectResponse(fixtureName, 202);
        String profileUUID = "201faedc-7df9-4840-9ab1-3997ce3f7cf4"
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
        ProfileAddress address = new ProfileAddress("12345", "New York", "NJ", "12345", "US");
        ProfileAuthorizedContact authContact =  new ProfileAuthorizedContact("john", "Deo", "12345467987", "123j@plivo.com", "MTR1", "admin");
        Profile response = Profile.update("8abd0935-fd17-4876-9b40-5855488ac5b5").entityType("PRIVATE").address(address).authorizedContact(authContact).update();

        assertRequest("Post", "Profile/8abd0935-fd17-4876-9b40-5855488ac5b5/");
    }

    @Test
    public void profileDeleteShouldSucceed() throws Exception {
        String fixtureName = "profileDeleteResponse.json";

        expectResponse(fixtureName, 202);
        Profile response = Profile.delete("c88652e9-79ac-4ff1-a816-4982616ac919").delete();
        assertRequest("DELETE", "Profile/c88652e9-79ac-4ff1-a816-4982616ac919/");
    }
}