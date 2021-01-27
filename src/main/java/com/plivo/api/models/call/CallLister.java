package com.plivo.api.models.call;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import com.plivo.api.util.PropertyFilter;
import okhttp3.ResponseBody;

public class CallLister extends VoiceLister<Call> {

  private String subaccount;
  private CallDirection callDirection;
  private String fromNumber;
  private String toNumber;
  private String parentCallUuid;
  private String hangupSource;
  private Integer hangupCauseCode;
  // TODO XXX PropertyFilter
  private PropertyFilter<Long> billDuration;
  private PropertyFilter<Long> endTime;

  public String subaccount() {
    return this.subaccount;
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

  public String parentCallUuid(){
    return this.parentCallUuid;
  }

  public String hangupSource() {
    return hangupSource;
  }

  public Integer hangupCauseCode() {
    return hangupCauseCode;
  }

  public PropertyFilter<Long> billDuration() {
    return this.billDuration;
  }

  public PropertyFilter<Long> endTime() {
    return this.endTime;
  }

  /**
   * @param subaccount The id of the subaccount, if call details of the subaccount are needed.
   */
  public CallLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  /**
   * @param callDirection Filter the results by call direction. The valid inputs are inbound and
   * outbound.
   */
  public CallLister callDirection(final CallDirection callDirection) {
    this.callDirection = callDirection;
    return this;
  }

  /**
   * @param fromNumber Filter the results by the number from where the call originated.
   */
  public CallLister fromNumber(final String fromNumber) {
    this.fromNumber = fromNumber;
    return this;
  }

  /**
   * @param toNumber Filter the results by the number to which the call was made.
   */
  public CallLister toNumber(final String toNumber) {
    this.toNumber = toNumber;
    return this;
  }

  /**
   * @param parentCallUuid Filter the results by the number to which the call was made.
   */
  public CallLister parentCallUuid(final String parentCallUuid) {
    this.parentCallUuid = parentCallUuid;
    return this;
  }

  /**
   * @param hangupSource Filter the results by hangup source.
   */
  public CallLister hangupSource(String hangupSource) {
    this.hangupSource = hangupSource;
    return this;
  }

  /**
   * @param hangupCauseCode Filter the results by hangup cause code.
   */
  public CallLister hangupCauseCode(Integer hangupCauseCode) {
    this.hangupCauseCode = hangupCauseCode;
    return this;
  }

  /**
   * @param billDuration Filter the results according to billed duration.
   */
  public CallLister billDuration(
    final PropertyFilter<Long> billDuration) {
    this.billDuration = billDuration;
    return this;
  }

  /**
   * @param endTime Filter out calls according to the time of completion.
   */
  public CallLister endTime(final PropertyFilter<Long> endTime) {
    this.endTime = endTime;
    return this;
  }

  @Override
  protected retrofit2.Call<ListResponse<Call>> obtainCall() {
    return client().getVoiceApiService().callList(client().getAuthId(), toMap());
  }

  @Override
  protected retrofit2.Call<ListResponse<Call>> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callList(client().getAuthId(), toMap());
  }

  @Override
  protected retrofit2.Call<ListResponse<Call>> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callList(client().getAuthId(), toMap());
  }
}