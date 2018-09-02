package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.conference.Conference;
import org.junit.Test;

public class ConferenceTest extends BaseTest {

  @Test
  public void conferenceListShouldSucceed() throws Exception {
    expectResponse("conferenceListResponse.json", 200);

    Conference.listGetter()
      .get();

    assertRequest("GET", "Conference/");
  }

  @Test
  public void conferenceListWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceListResponse.json", 200);
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Conference.listGetter()
      .client(client)
      .get();

    assertRequest("GET", "Conference/");
  }

  @Test
  public void conferenceGetShouldSucceed() throws Exception {
    expectResponse("conferenceGetResponse.json", 200);
    final String conferenceId = "conferenceId";

    Conference conference = Conference.getter(conferenceId)
      .get();


    assertEquals(conference.getId(), conference.getConferenceName());

    assertRequest("GET", "Conference/%s/", conferenceId);
  }

  @Test
  public void conferenceGetWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceGetResponse.json", 200);
    final String conferenceId = "conferenceId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference conference = Conference.getter(conferenceId)
      .client(client)
      .get();


    assertEquals(conference.getId(), conference.getConferenceName());

    assertRequest("GET", "Conference/%s/", conferenceId);
  }

  @Test
  public void conferenceDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceDeleteResponse.json", 204);
    final String conferenceId = "conferenceId";

    Conference.deleter(conferenceId)
      .delete();

    assertRequest("DELETE", "Conference/%s/", conferenceId);
  }

  @Test
  public void conferenceDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceDeleteResponse.json", 204);
    final String conferenceId = "conferenceId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.deleter(conferenceId)
      .client(client)
      .delete();

    assertRequest("DELETE", "Conference/%s/", conferenceId);
  }

  @Test
  public void conferenceDeleteAllShouldSucceed() throws Exception {
    expectResponse("conferenceDeleteAllResponse.json", 204);
    final String conferenceId = "conferenceId";

    Conference.allDeleter()
      .delete();

    assertRequest("DELETE", "Conference/");
  }

  @Test
  public void conferenceDeleteAllWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceDeleteAllResponse.json", 204);
    final String conferenceId = "conferenceId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.allDeleter().client(client)
      .delete();

    assertRequest("DELETE", "Conference/");
  }

  @Test
  public void conferenceMemberDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberHangupper(confId, memberId)
      .hangup();

    assertRequest("DELETE", "Conference/%s/Member/%s/", confId, memberId);
  }

  @Test
  public void conferenceMemberDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberHangupper(confId, memberId)
      .client(client)
      .hangup();

    assertRequest("DELETE", "Conference/%s/Member/%s/", confId, memberId);
  }

  @Test
  public void conferenceMemberKickCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberKickCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberKicker(confId, memberId)
      .kick();

    assertRequest("POST", "Conference/%s/Member/%s/Kick/", confId, memberId);
  }

  @Test
  public void conferenceMemberKickCreateWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberKickCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberKicker(confId, memberId).client(client)
      .kick();

    assertRequest("POST", "Conference/%s/Member/%s/Kick/", confId, memberId);
  }

  @Test
  public void conferenceMemberSpeakCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberSpeakCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberSpeaker(confId, memberId, "test")
      .speak();

    assertRequest("POST", "Conference/%s/Member/%s/Speak/", confId, memberId);
  }

  @Test
  public void conferenceMemberSpeakCreateWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberSpeakCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberSpeaker(confId, memberId, "test").client(client)
      .speak();

    assertRequest("POST", "Conference/%s/Member/%s/Speak/", confId, memberId);
  }

  @Test
  public void conferenceMemberPlayCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberPlayCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";
    Conference.memberPlayer(confId, memberId, "http://www.example.com/")
      .play();
    assertRequest("POST", "Conference/%s/Member/%s/Play/", confId, memberId);
  }

  @Test
  public void conferenceMemberPlayCreateWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberPlayCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberPlayer(confId, memberId, "http://www.example.com/")
      .client(client)
      .play();
    assertRequest("POST", "Conference/%s/Member/%s/Play/", confId, memberId);
  }

  @Test
  public void conferenceMemberMuteCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberMuteCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberMuter(confId, memberId)
      .mute();

    assertRequest("POST", "Conference/%s/Member/%s/Mute/", confId, memberId);
  }

  @Test
  public void conferenceMemberMuteCreateWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberMuteCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberMuter(confId, memberId)
      .client(client)
      .mute();

    assertRequest("POST", "Conference/%s/Member/%s/Mute/", confId, memberId);
  }

  @Test
  public void conferenceMemberDeafCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeafCreateResponse.json", 202);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberDeafer(confId, memberId)
      .deaf();

    assertRequest("POST", "Conference/%s/Member/%s/Deaf/", confId, memberId);
  }

  @Test
  public void conferenceMemberDeafWithClientCreateShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeafCreateResponse.json", 202);
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberDeafer(confId, memberId).client(client)
      .deaf();

    assertRequest("POST", "Conference/%s/Member/%s/Deaf/", confId, memberId);
  }

  @Test
  public void conferenceMemberSpeakDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceMemberSpeakDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberSpeakStopper(confId, memberId)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Speak/", confId, memberId);
  }

  @Test
  public void conferenceMemberSpeakDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberSpeakDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberSpeakStopper(confId, memberId)
      .client(client)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Speak/", confId, memberId);
  }

  @Test
  public void conferenceMemberPlayDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceMemberPlayDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberPlayStopper(confId, memberId)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Play/", confId, memberId);
  }

  @Test
  public void conferenceMemberPlayDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberPlayDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberPlayStopper(confId, memberId)
      .client(client)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Play/", confId, memberId);
  }

  @Test
  public void conferenceMemberMuteDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceMemberMuteDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberMuteStopper(confId, memberId)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Mute/", confId, memberId);
  }

  @Test
  public void conferenceMemberMuteDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberMuteDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.memberMuteStopper(confId, memberId)
      .client(client)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Mute/", confId, memberId);
  }

  @Test
  public void conferenceMemberDeafDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeafDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";

    Conference.memberDeafStopper(confId, memberId)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Deaf/", confId, memberId);
  }

  @Test
  public void conferenceMemberDeafDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceMemberDeafDeleteResponse.json", 204);
    final String confId = "confId";
    final String memberId = "memberId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Conference.memberDeafStopper(confId, memberId).client(client)
      .stop();

    assertRequest("DELETE", "Conference/%s/Member/%s/Deaf/", confId, memberId);
  }

  @Test
  public void conferenceRecordCreateShouldSucceed() throws Exception {
    expectResponse("conferenceRecordCreateResponse.json", 202);
    final String confId = "confId";

    Conference.recorder(confId)
      .record();

    assertRequest("POST", "Conference/%s/Record/", confId);
  }

  @Test
  public void conferenceRecordCreateWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceRecordCreateResponse.json", 202);
    final String confId = "confId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.recorder(confId)
      .client(client)
      .record();

    assertRequest("POST", "Conference/%s/Record/", confId);
  }

  @Test
  public void conferenceRecordDeleteShouldSucceed() throws Exception {
    expectResponse("conferenceRecordDeleteResponse.json", 204);
    final String confId = "confId";

    Conference.recordStopper(confId)
      .stop();

    assertRequest("DELETE", "Conference/%s/Record/", confId);
  }

  @Test
  public void conferenceRecordDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("conferenceRecordDeleteResponse.json", 204);
    final String confId = "confId";
    PlivoClient client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Conference.recordStopper(confId)
      .client(client)
      .stop();

    assertRequest("DELETE", "Conference/%s/Record/", confId);
  }
}
