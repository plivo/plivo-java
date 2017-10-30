package com.plivo.api.models.recording;

import com.plivo.api.models.base.BaseResource;

public class Recording extends BaseResource {

  private String addTime;
  private String callUuid;
  private String conferenceName;
  private String recordingDurationMs;
  private String recordingEndMs;
  private String recordingFormat;
  private String recordingStartMs;
  private String recordingType;
  private String recordingUrl;
  private String resourceUri;
  private String recordingId;

  public static RecordingGetter getter(String id) {
    return new RecordingGetter(id);
  }

  public static RecordingLister lister() {
    return new RecordingLister();
  }

  public static RecordingDeleter deleter(String id) {
    return new RecordingDeleter(id);
  }

  /**
   * @return The ID of the recording.
   */
  public String getRecordingId() {
    return recordingId;
  }

  /**
   * @return The datetime string on which the recording was created on your account.
   */
  public String getAddTime() {
    return addTime;
  }

  /**
   * @return The ID of the call on Plivo which was recorded.
   */
  public String getCallUuid() {
    return callUuid;
  }

  /**
   * @return The name of the conference room which was recorded. This value will be null if it was a
   * regular recording.
   */
  public String getConferenceName() {
    return conferenceName;
  }

  /**
   * @return The duration of the recording in milliseconds.
   */
  public String getRecordingDurationMs() {
    return recordingDurationMs;
  }

  public String getRecordingEndMs() {
    return recordingEndMs;
  }

  /**
   * @return The format of the recording file. This can be either 'wav' or 'mp3'.
   */
  public String getRecordingFormat() {
    return recordingFormat;
  }

  public String getRecordingStartMs() {
    return recordingStartMs;
  }

  /**
   * @return The type of the recording. In the case where a conference was recorded, this value will
   * be 'conference' or it will be 'normal' in case of a regular call.
   */
  public String getRecordingType() {
    return recordingType;
  }

  /**
   * @return The URL of the recorded file. All our recordings are hosted on Amazon S3.
   */
  public String getRecordingUrl() {
    return recordingUrl;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public RecordingDeleter deleter() {
    return Recording.deleter(recordingId);
  }

  @Override
  public String getId() {
    return getRecordingId();
  }
}
