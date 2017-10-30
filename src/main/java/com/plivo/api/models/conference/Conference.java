package com.plivo.api.models.conference;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Conference extends BaseResource {

  private String conferenceName;
  private String conferenceRunTime;
  private String conferenceMemberCount;
  private List<Member> members;

  public static ConferenceListGetter listGetter() {
    return new ConferenceListGetter();
  }

  public static ConferenceDeleter deleter(String conferenceName) {
    return new ConferenceDeleter(conferenceName);
  }

  public static ConferenceAllDeleter allDeleter() {
    return new ConferenceAllDeleter();
  }

  public static ConferenceGetter getter(String id) {
    return new ConferenceGetter(id);
  }

  public static ConferenceMemberDeleter memberHangupper(String conferenceName, String memberId) {
    return new ConferenceMemberDeleter(conferenceName, memberId);
  }

  public static ConferenceMemberKickCreator memberKicker(String conferenceName, String memberId) {
    return new ConferenceMemberKickCreator(conferenceName, memberId);
  }

  public static ConferenceMemberSpeakCreator memberSpeaker(String conferenceName, String memberId,
    String text) {
    return new ConferenceMemberSpeakCreator(conferenceName, memberId, text);
  }

  public static ConferenceMemberPlayCreator memberPlayer(String conferenceName, String memberId,
    String url) {
    return new ConferenceMemberPlayCreator(conferenceName, memberId, url);
  }

  public static ConferenceMemberDeafCreator memberDeafer(String conferenceName, String memberId) {
    return new ConferenceMemberDeafCreator(conferenceName, memberId);
  }

  public static ConferenceMemberMuteCreator memberMuter(String conferenceName, String memberId) {
    return new ConferenceMemberMuteCreator(conferenceName, memberId);
  }

  public static ConferenceMemberSpeakDeleter memberSpeakStopper(String conferenceName,
    String memberId) {
    return new ConferenceMemberSpeakDeleter(conferenceName, memberId);
  }

  public static ConferenceMemberPlayDeleter memberPlayStopper(String conferenceName,
    String memberId) {
    return new ConferenceMemberPlayDeleter(conferenceName, memberId);
  }

  public static ConferenceMemberMuteDeleter memberMuteStopper(String conferenceName,
    String memberId) {
    return new ConferenceMemberMuteDeleter(conferenceName, memberId);
  }

  public static ConferenceMemberDeafDeleter memberDeafStopper(String conferenceName,
    String memberId) {
    return new ConferenceMemberDeafDeleter(conferenceName, memberId);
  }

  public static ConferenceRecordCreator recorder(String conferenceName) {
    return new ConferenceRecordCreator(conferenceName);
  }

  public static ConferenceRecordDeleter recordStopper(String conferenceName) {
    return new ConferenceRecordDeleter(conferenceName);
  }

  /**
   * @return The name of the conference.
   */
  public String getConferenceName() {
    return conferenceName;
  }

  /**
   * @return Time in seconds since the conference has been initiated.
   */
  public String getConferenceRunTime() {
    return conferenceRunTime;
  }

  /**
   * @return Number of members in the conference.
   */
  public String getConferenceMemberCount() {
    return conferenceMemberCount;
  }

  /**
   * @return List of members of the conference.
   */
  public List<Member> getMembers() {
    return members;
  }

  public ConferenceDeleter deleter() {
    return Conference.deleter(conferenceName);
  }

  public ConferenceRecordCreator recorder() {
    return Conference.recorder(conferenceName);
  }

  public ConferenceRecordDeleter recordStopper() {
    return Conference.recordStopper(conferenceName);
  }

  @Override
  public String getId() {
    return getConferenceName();
  }
}
