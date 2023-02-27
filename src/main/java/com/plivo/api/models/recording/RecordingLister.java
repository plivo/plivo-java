package com.plivo.api.models.recording;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import com.plivo.api.util.PropertyFilter;
import java.util.Date;
import retrofit2.Call;

public class RecordingLister extends VoiceLister<Recording> {

  private String subaccount;
  private String callUuid;
  private String fromNumber;
  private String toNumber;
  private String conferenceName;
  private String mpcName;
  private String conferenceUuid;
  private String mpcUuid;
  private String roundedDuration;
  private PropertyFilter<Date> addTime;

  public String subaccount() {
    return this.subaccount;
  }

  public String callUuid() {
    return this.callUuid;
  }

  public String fromNumber() {
    return this.fromNumber;
  }

  public String toNumber() {
    return this.toNumber;
  }

  public String conferenceName() {
    return this.conferenceName;
  }

  public String mpcName() {
    return this.mpcName;
  }

  public String conferenceUuid() {
    return this.conferenceUuid;
  }

  public String mpcUuid() {
    return this.mpcUuid;
  }

  public PropertyFilter<Date> addTime() {
    return this.addTime;
  }

  public String roundedDuration() {
    return roundedDuration;
  }

  /**
   * @param subaccount auth_id of the subaccount. Lists only those recordings of the main accounts
   * which are tied to the specified subaccount.
   */
  public RecordingLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  /**
   * @param fromNumber Used to filter recordings for a specific fromNumber.
   */
  public RecordingLister fromNumber(final String fromNumber) {
    this.fromNumber = fromNumber;
    return this;
  }

  /**
   * @param toNumber Used to filter recordings for a specific toNumber.
   */
  public RecordingLister toNumber(final String toNumber) {
    this.toNumber = toNumber;
    return this;
  }

  /**
   * @param conferenceName Used to filter recordings for a specific conferenceName.
   */
  public RecordingLister conferenceName(final String conferenceName) {
    this.conferenceName = conferenceName;
    return this;
  }

  /**
   * @param mpcName Used to filter recordings for a specific mpcName.
   */
  public RecordingLister mpcName(final String mpcName) {
    this.mpcName = mpcName;
    return this;
  }

  /**
   * @param conferenceUuid Used to filter recordings for a specific conferenceUuid.
   */
  public RecordingLister conferenceUuid(final String conferenceUuid) {
    this.conferenceUuid = conferenceUuid;
    return this;
  }

  /**
   * @param mpcUuid Used to filter recordings for a specific mpcUuid.
   */
  public RecordingLister mpcUuid(final String mpcUuid) {
    this.mpcUuid = mpcUuid;
    return this;
  }

  /**
   * @param callUuid Used to filter recordings for a specific call.
   */
  public RecordingLister callUuid(final String callUuid) {
    this.callUuid = callUuid;
    return this;
  }

  /**
   * @param addTime Used to filter out recordings according to the time they were added.
   */
  public RecordingLister addTime(final PropertyFilter<Date> addTime) {
    this.addTime = addTime;
    return this;
  }

  /**
   * @param roundedDuration Used to filter out recordings according to their rounded duration as multiples of 60 seconds.
   */
  public RecordingLister roundedDuration(final String roundedDuration) {
    this.roundedDuration = roundedDuration;
    return this;
  }

  @Override
  protected Call<ListResponse<Recording>> obtainCall() {
    return client().getVoiceApiService().recordingList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Recording>> obtainFallback1Call() {
    return client().getVoiceFallback1Service().recordingList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Recording>> obtainFallback2Call() {
    return client().getVoiceFallback2Service().recordingList(client().getAuthId(), toMap());
  }
}