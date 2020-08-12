package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class LiveCallListGetter extends VoiceGetter<LiveCallListResponse> {

  private CallDirection callDirection;
  private String fromNumber;
  private String toNumber;

  public LiveCallListGetter() {
    super(""); // Special case where we don't care about the id
  }

  public CallDirection callDirection() {
    return this.callDirection;
  }

  public String fromNumber() {
    return this.fromNumber;
  }

  public String toNumber() {
    return this.toNumber;
  }

  /**
   * @param callDirection Filter the results by call direction. The valid inputs are inbound and
   * outbound.
   */
  public LiveCallListGetter callDirection(final CallDirection callDirection) {
    this.callDirection = callDirection;
    return this;
  }

  /**
   * @param fromNumber Filter the results by the number from where the call originated.
   */
  public LiveCallListGetter fromNumber(final String fromNumber) {
    this.fromNumber = fromNumber;
    return this;
  }

  /**
   * @param toNumber Filter the results by the number to which the call was made.
   */
  public LiveCallListGetter toNumber(final String toNumber) {
    this.toNumber = toNumber;
    return this;
  }

  @Override
  protected Call<LiveCallListResponse> obtainCall() {
    return client().getVoiceApiService().liveCallListGet(client().getAuthId(), toMap());
  }

  @Override
  protected Call<LiveCallListResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().liveCallListGet(client().getAuthId(), toMap());
  }

  @Override
  protected Call<LiveCallListResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().liveCallListGet(client().getAuthId(), toMap());
  }
}
