package com.plivo.api;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.phonenumbercompliance.*;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberComplianceTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  // =========================================================================
  // Test 1: RequirementLister - success, verify fields
  // =========================================================================
  @Test
  public void requirementListerShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceRequirementListResponse.json", 200);

    PhoneNumberComplianceRequirement req = PhoneNumberComplianceRequirement.lister()
      .countryIso("IN")
      .numberType("local")
      .userType("business")
      .list();

    assertNotNull(req);
    assertEquals("IN", req.getCountryIso());
    assertEquals("local", req.getNumberType());
    assertEquals("business", req.getUserType());
    assertNotNull(req.getDocumentTypes());
    assertEquals(2, req.getDocumentTypes().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertTrue(recordedRequest.getPath().contains("PhoneNumber/Compliance/Requirements/"));
  }

  // =========================================================================
  // Test 2: RequirementLister - empty document_types
  // =========================================================================
  @Test
  public void requirementListerEmptyDocumentTypesShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceRequirementEmptyResponse.json", 200);

    PhoneNumberComplianceRequirement req = PhoneNumberComplianceRequirement.lister()
      .countryIso("ZZ")
      .numberType("local")
      .userType("business")
      .list();

    assertNotNull(req);
    assertEquals("ZZ", req.getCountryIso());
    assertNotNull(req.getDocumentTypes());
    assertEquals(0, req.getDocumentTypes().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
  }

  // =========================================================================
  // Test 3: Creator - success with compliance_id
  // =========================================================================
  @Test
  public void createShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceCreateResponse.json", 201);

    String dataJson = "{\"country_iso\":\"IN\",\"number_type\":\"local\",\"user_type\":\"business\"}";
    PhoneNumberComplianceCreator creator = PhoneNumberCompliance.creator(dataJson);
    PhoneNumberComplianceCreateResponse resp = creator.create();

    assertNotNull(resp);
    assertEquals("comp-uuid-12345678", resp.getComplianceId());
    assertEquals("Compliance application created successfully", resp.getMessage());
    assertNotNull(resp.getApiId());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertTrue(recordedRequest.getPath().contains("PhoneNumber/Compliance/"));
  }

  // =========================================================================
  // Test 4: Creator - verify multipart body construction
  // =========================================================================
  @Test
  public void createShouldSendMultipartBody() throws Exception {
    expectResponse("phoneNumberComplianceCreateResponse.json", 201);

    String dataJson = "{\"country_iso\":\"IN\",\"number_type\":\"local\"}";
    PhoneNumberComplianceCreator creator = PhoneNumberCompliance.creator(dataJson);
    PhoneNumberComplianceCreateResponse resp = creator.create();

    assertNotNull(resp);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    String contentType = recordedRequest.getHeader("Content-Type");
    assertNotNull(contentType);
    assertTrue(contentType.contains("multipart/form-data"));
    // Verify the body contains the data part
    String body = recordedRequest.getBody().readUtf8();
    assertTrue(body.contains("data"));
    assertTrue(body.contains("country_iso"));
  }

  // =========================================================================
  // Test 5: Lister - success with compliances
  // =========================================================================
  @Test
  public void listShouldSucceed() throws Exception {
    String fixtureName = "phoneNumberComplianceListResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    ListResponse<PhoneNumberCompliance> resp = PhoneNumberCompliance.lister().list();

    assertNotNull(resp);
    assertNotNull(resp.getCompliances());
    assertEquals(2, resp.getCompliances().size());
    assertNotNull(resp.getMeta());

    PhoneNumberCompliance first = resp.getCompliances().get(0);
    assertEquals("comp-uuid-11111111", first.getComplianceId());
    assertEquals("submitted", first.getStatus());
    assertEquals("IN", first.getCountryIso());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/PhoneNumber/Compliance/", authId),
      recordedRequest.getPath());
  }

  // =========================================================================
  // Test 6: Lister - with filters (status, countryIso, etc.)
  // =========================================================================
  @Test
  public void listWithFiltersShouldSucceed() throws Exception {
    String fixtureName = "phoneNumberComplianceListResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    ListResponse<PhoneNumberCompliance> resp = PhoneNumberCompliance.lister()
      .status("submitted")
      .countryIso("IN")
      .numberType("local")
      .userType("business")
      .list();

    assertNotNull(resp);
    assertNotNull(resp.getCompliances());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    String path = recordedRequest.getPath();
    assertTrue(path.contains("PhoneNumber/Compliance/"));
    assertTrue(path.contains("status=submitted"));
    assertTrue(path.contains("country_iso=IN"));
  }

  // =========================================================================
  // Test 7: Lister - empty results
  // =========================================================================
  @Test
  public void listEmptyResultsShouldSucceed() throws Exception {
    String fixtureName = "phoneNumberComplianceListEmptyResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    ListResponse<PhoneNumberCompliance> resp = PhoneNumberCompliance.lister().list();

    assertNotNull(resp);
    assertNotNull(resp.getCompliances());
    assertEquals(0, resp.getCompliances().size());
    assertNotNull(resp.getMeta());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
  }

  // =========================================================================
  // Test 8: Getter - success with compliance wrapper
  // =========================================================================
  @Test
  public void getShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-12345678";
    expectResponse("phoneNumberComplianceGetResponse.json", 200);

    PhoneNumberComplianceGetResponse resp = PhoneNumberCompliance.getter(complianceId).get();

    assertNotNull(resp);
    assertNotNull(resp.getCompliance());
    assertEquals("comp-uuid-12345678", resp.getCompliance().getComplianceId());
    assertEquals("submitted", resp.getCompliance().getStatus());
    assertEquals("IN", resp.getCompliance().getCountryIso());
    assertEquals("test-compliance-app", resp.getCompliance().getAlias());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertTrue(recordedRequest.getPath().contains(
      String.format("PhoneNumber/Compliance/%s/", complianceId)));
  }

  // =========================================================================
  // Test 9: Getter - with expand
  // =========================================================================
  @Test
  public void getWithExpandShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-12345678";
    expectResponse("phoneNumberComplianceGetExpandedResponse.json", 200);

    PhoneNumberComplianceGetResponse resp = PhoneNumberCompliance.getter(complianceId)
      .expand("end_user,documents")
      .get();

    assertNotNull(resp);
    assertNotNull(resp.getCompliance());
    PhoneNumberCompliance compliance = resp.getCompliance();
    assertEquals("comp-uuid-12345678", compliance.getComplianceId());
    assertEquals("approved", compliance.getStatus());
    assertNotNull(compliance.getEndUser());
    assertNotNull(compliance.getDocuments());
    assertEquals(1, compliance.getDocuments().size());
    assertNotNull(compliance.getLinkedNumbers());
    assertEquals(1, compliance.getLinkedNumbers().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    String path = recordedRequest.getPath();
    assertTrue(path.contains("expand=end_user") || path.contains("expand=end_user%2Cdocuments"));
  }

  // =========================================================================
  // Test 10: Getter - all optional fields (rejection_reason, end_user, documents, linked_numbers)
  // =========================================================================
  @Test
  public void getWithAllOptionalFieldsShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-99999999";
    expectResponse("phoneNumberComplianceGetAllFieldsResponse.json", 200);

    PhoneNumberComplianceGetResponse resp = PhoneNumberCompliance.getter(complianceId).get();

    assertNotNull(resp);
    assertNotNull(resp.getCompliance());
    PhoneNumberCompliance compliance = resp.getCompliance();
    assertEquals("comp-uuid-99999999", compliance.getComplianceId());
    assertEquals("rejected", compliance.getStatus());
    assertEquals("rejected-compliance-app", compliance.getAlias());
    assertEquals("DE", compliance.getCountryIso());
    assertEquals("local", compliance.getNumberType());
    assertEquals("individual", compliance.getUserType());
    assertEquals("Document is expired. Please provide a valid document.", compliance.getRejectionReason());
    assertNotNull(compliance.getEndUser());
    assertNotNull(compliance.getDocuments());
    assertEquals(2, compliance.getDocuments().size());
    assertNotNull(compliance.getLinkedNumbers());
    assertEquals(2, compliance.getLinkedNumbers().size());
    assertNotNull(compliance.getCreatedAt());
    assertNotNull(compliance.getUpdatedAt());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
  }

  // =========================================================================
  // Test 11: Updater - success
  // =========================================================================
  @Test
  public void updateShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-12345678";
    expectResponse("phoneNumberComplianceUpdateResponse.json", 200);

    PhoneNumberComplianceUpdater updater = PhoneNumberCompliance.updater(complianceId);
    updater.setData("{\"alias\":\"updated-alias\"}");
    PhoneNumberComplianceUpdateResponse resp = updater.update();

    assertNotNull(resp);
    assertEquals("comp-uuid-12345678", resp.getComplianceId());
    assertEquals("Compliance application updated successfully", resp.getMessage());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("PATCH", recordedRequest.getMethod());
    assertTrue(recordedRequest.getPath().contains(
      String.format("PhoneNumber/Compliance/%s/", complianceId)));
  }

  // =========================================================================
  // Test 12: Updater - verify PATCH method and multipart
  // =========================================================================
  @Test
  public void updateShouldUsePatchMethod() throws Exception {
    String complianceId = "comp-uuid-12345678";
    expectResponse("phoneNumberComplianceUpdateResponse.json", 200);

    PhoneNumberComplianceUpdater updater = PhoneNumberCompliance.updater(complianceId);
    updater.setData("{\"callback_url\":\"https://example.com/new-callback\"}");
    PhoneNumberComplianceUpdateResponse resp = updater.update();

    assertNotNull(resp);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("PATCH", recordedRequest.getMethod());
    String contentType = recordedRequest.getHeader("Content-Type");
    assertNotNull(contentType);
    assertTrue(contentType.contains("multipart/form-data"));
    String body = recordedRequest.getBody().readUtf8();
    assertTrue(body.contains("data"));
    assertTrue(body.contains("callback_url"));
  }

  // =========================================================================
  // Test 13: Deleter - success
  // =========================================================================
  @Test
  public void deleteShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-12345678";

    server.enqueue(new MockResponse()
      .setResponseCode(204)
    );

    PhoneNumberCompliance.deleter(complianceId).delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/PhoneNumber/Compliance/%s/", authId, complianceId),
      recordedRequest.getPath());
  }

  // =========================================================================
  // Test 14: LinkCreator - success with report
  // =========================================================================
  @Test
  public void linkCreateShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceLinkResponse.json", 200);

    PhoneNumberComplianceLinkNumber linkNum1 = new PhoneNumberComplianceLinkNumber();
    linkNum1.setNumber("+911234567890");
    linkNum1.setComplianceApplicationId("comp-uuid-12345678");

    PhoneNumberComplianceLinkNumber linkNum2 = new PhoneNumberComplianceLinkNumber();
    linkNum2.setNumber("+911234567891");
    linkNum2.setComplianceApplicationId("comp-uuid-12345678");

    List<PhoneNumberComplianceLinkNumber> numbers = new ArrayList<>();
    numbers.add(linkNum1);
    numbers.add(linkNum2);

    PhoneNumberComplianceLinkCreator linkCreator = new PhoneNumberComplianceLinkCreator();
    linkCreator.numbers(numbers);
    PhoneNumberComplianceLinkResponse resp = linkCreator.create();

    assertNotNull(resp);
    assertEquals(Integer.valueOf(2), resp.getTotalCount());
    assertEquals(Integer.valueOf(2), resp.getUpdatedCount());
    assertNotNull(resp.getReport());
    assertEquals(2, resp.getReport().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertTrue(recordedRequest.getPath().contains("PhoneNumber/Compliance/Link/"));
  }

  // =========================================================================
  // Test 15: LinkCreator - empty report
  // =========================================================================
  @Test
  public void linkCreateEmptyReportShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceLinkEmptyResponse.json", 200);

    List<PhoneNumberComplianceLinkNumber> numbers = new ArrayList<>();

    PhoneNumberComplianceLinkCreator linkCreator = new PhoneNumberComplianceLinkCreator();
    linkCreator.numbers(numbers);
    PhoneNumberComplianceLinkResponse resp = linkCreator.create();

    assertNotNull(resp);
    assertEquals(Integer.valueOf(0), resp.getTotalCount());
    assertEquals(Integer.valueOf(0), resp.getUpdatedCount());
    assertNotNull(resp.getReport());
    assertEquals(0, resp.getReport().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
  }

  // =========================================================================
  // Test 16: Getter - 404 error
  // =========================================================================
  @Test(expected = ResourceNotFoundException.class)
  public void getNotFoundShouldThrowException() throws Exception {
    String complianceId = "nonexistent-id";

    server.enqueue(new MockResponse()
      .setResponseCode(404)
      .setBody(loadFixture("phoneNumberComplianceNotFoundResponse.json"))
    );

    PhoneNumberCompliance.getter(complianceId).get();
  }

  // =========================================================================
  // Test 17: List - pagination meta fields
  // =========================================================================
  @Test
  public void listPaginatedShouldReturnMetaFields() throws Exception {
    String fixtureName = "phoneNumberComplianceListPaginatedResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    ListResponse<PhoneNumberCompliance> resp = PhoneNumberCompliance.lister()
      .limit(2)
      .list();

    assertNotNull(resp);
    assertNotNull(resp.getMeta());
    assertEquals(Long.valueOf(2), resp.getMeta().getLimit());
    assertEquals(Long.valueOf(0), resp.getMeta().getOffset());
    assertEquals(Long.valueOf(5), resp.getMeta().getTotalCount());
    assertNotNull(resp.getMeta().getNext());
    assertNull(resp.getMeta().getPrevious());
    assertNotNull(resp.getCompliances());
    assertEquals(2, resp.getCompliances().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
  }

  // =========================================================================
  // Test 18: Requirements - different country (DE/local/individual)
  // =========================================================================
  @Test
  public void requirementListerDifferentCountryShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceRequirementDEResponse.json", 200);

    PhoneNumberComplianceRequirement req = PhoneNumberComplianceRequirement.lister()
      .countryIso("DE")
      .numberType("local")
      .userType("individual")
      .list();

    assertNotNull(req);
    assertEquals("DE", req.getCountryIso());
    assertEquals("local", req.getNumberType());
    assertEquals("individual", req.getUserType());
    assertNotNull(req.getDocumentTypes());
    assertEquals(1, req.getDocumentTypes().size());

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    String path = recordedRequest.getPath();
    assertTrue(path.contains("PhoneNumber/Compliance/Requirements/"));
  }

  // =========================================================================
  // Test 19: Get - verify URL path construction
  // =========================================================================
  @Test
  public void getVerifyUrlPathShouldSucceed() throws Exception {
    String complianceId = "comp-uuid-path-test";
    expectResponse("phoneNumberComplianceGetResponse.json", 200);

    PhoneNumberCompliance.getter(complianceId).get();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(
      String.format("/Account/%s/PhoneNumber/Compliance/%s/", authId, complianceId),
      recordedRequest.getPath().split("\\?")[0]
    );
  }

  // =========================================================================
  // Test 20: Link - verify request body structure
  // =========================================================================
  @Test
  public void linkCreateVerifyRequestBodyShouldSucceed() throws Exception {
    expectResponse("phoneNumberComplianceLinkResponse.json", 200);

    PhoneNumberComplianceLinkNumber linkNum = new PhoneNumberComplianceLinkNumber();
    linkNum.setNumber("+911234567890");
    linkNum.setComplianceApplicationId("comp-uuid-12345678");

    assertEquals("+911234567890", linkNum.getNumber());
    assertEquals("comp-uuid-12345678", linkNum.getComplianceApplicationId());

    List<PhoneNumberComplianceLinkNumber> numbers = new ArrayList<>();
    numbers.add(linkNum);

    PhoneNumberComplianceLinkCreator linkCreator = new PhoneNumberComplianceLinkCreator();
    linkCreator.numbers(numbers);

    assertEquals(1, linkCreator.getNumbers().size());
    assertEquals("+911234567890", linkCreator.getNumbers().get(0).getNumber());
    assertEquals("comp-uuid-12345678", linkCreator.getNumbers().get(0).getComplianceApplicationId());

    PhoneNumberComplianceLinkResponse resp = linkCreator.create();
    assertNotNull(resp);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(
      String.format("/Account/%s/PhoneNumber/Compliance/Link/", authId),
      recordedRequest.getPath()
    );
  }
}
