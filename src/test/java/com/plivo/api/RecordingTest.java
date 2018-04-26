package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.recording.Recording;
import com.plivo.api.util.PropertyFilter;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RecordingTest extends BaseTest {

  @Test
  public void recordingListShouldWork() throws Exception {
    expectResponse("recordingListResponse.json", 200);

    Date date = Date.from(Instant.EPOCH);
    String stringDate = PlivoClient.getObjectMapper().readValue(PlivoClient.getObjectMapper().writeValueAsString(date), String.class);

    Recording.lister()
      .addTime(new PropertyFilter<Date>()
        .greaterOrEqual(date)
        .greaterThan(date)
        .equalTo(date)
        .lessThan(date)
        .lessOrEqual(date)
      )
      .list();

    Map<String, String> params = new HashMap<>();
    params.put("add_time__gt", stringDate);
    params.put("add_time__gte", stringDate);
    params.put("add_time__lt", stringDate);
    params.put("add_time__lte", stringDate);
    params.put("add_time", stringDate);

    assertRequest("GET", "Recording/", params);
  }

  @Test
  public void recordingListWithClientShouldWork() throws Exception {
    expectResponse("recordingListResponse.json", 200);

    Date date = Date.from(Instant.EPOCH);
    String stringDate = PlivoClient.getObjectMapper().readValue(PlivoClient.getObjectMapper().writeValueAsString(date), String.class);
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Recording.lister()
      .addTime(new PropertyFilter<Date>()
        .greaterOrEqual(date)
        .greaterThan(date)
        .equalTo(date)
        .lessThan(date)
        .lessOrEqual(date)
      ).client(client)
      .list();

    Map<String, String> params = new HashMap<>();
    params.put("add_time__gt", stringDate);
    params.put("add_time__gte", stringDate);
    params.put("add_time__lt", stringDate);
    params.put("add_time__lte", stringDate);
    params.put("add_time", stringDate);

    assertRequest("GET", "Recording/", params);
  }

  @Test
  public void recordingGetShouldWork() throws Exception {
    expectResponse("recordingGetResponse.json", 200);
    final String recordingId = "recordingId";

    Recording recording = Recording.getter(recordingId)
      .get();


    assertEquals(recording.getId(), recording.getRecordingId());

    assertRequest("GET", "Recording/%s/", recordingId);
  }

  @Test
  public void recordingGetWithClientShouldWork() throws Exception {
    expectResponse("recordingGetResponse.json", 200);
    final String recordingId = "recordingId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Recording recording = Recording.getter(recordingId).client(client)
      .get();


    assertEquals(recording.getId(), recording.getRecordingId());

    assertRequest("GET", "Recording/%s/", recordingId);
  }

  @Test
  public void recordingDeleteShouldWork() throws Exception {
    expectResponse(null, 204);
    final String recordingId = "recordingId";

    Recording.deleter(recordingId)
      .delete();

    assertRequest("DELETE", "Recording/%s/", recordingId);
  }

  @Test
  public void recordingDeleteWithClientShouldWork() throws Exception {
    expectResponse(null, 204);
    final String recordingId = "recordingId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Recording.deleter(recordingId).client(client)
      .delete();

    assertRequest("DELETE", "Recording/%s/", recordingId);
  }
}
