package com.plivo.api.models.call;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.plivo.api.models.base.Creator;
import com.plivo.api.serializers.MapToCommaListSerializer;
import com.plivo.api.util.Utils;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CallCreator extends Creator<CallCreateResponse> {

  private String from;
  private List<String> to;
  private String answerUrl;
  private String answerMethod;
  private String ringUrl;
  private String ringMethod;
  private String hangupUrl;
  private String hangupMethod;
  private String fallbackUrl;
  private String fallbackMethod;
  private String callerName;
  private String sendDigits;
  private Boolean sendOnPreanswer;
  private Long timeLimit;
  private Long hangupOnRing;
  private String machineDetection;
  private Long machineDetectionTime;
  private String machineDetectionUrl;
  private String machineDetectionMethod;
  @JsonSerialize(using = MapToCommaListSerializer.class)
  private Map<String, String> sipHeaders;
  private Long ringTimeout;
  private String parentCallUuid;
  private Boolean errorIfParentNotFound;

  CallCreator(String from, List<String> to, String answerUrl) {
    if (!Utils.allNotNull(from, to, answerUrl)) {
      throw new IllegalArgumentException("from, to and answerUrl must not be null");
    }

    if (to.isEmpty()) {
      throw new IllegalArgumentException("to cannot be empty");
    }

    this.from = from;
    this.to = to;
    this.answerUrl = answerUrl;
  }

  /**
   * @return The phone number to be used as the caller id (with the country code).
   */
  public String from() {
    return from;
  }

  /**
   * @return The regular number(s) or sip endpoint(s) to call. Regular number must be prefixed with
   * country code but without the + sign).
   */
  public List<String> to() {
    return to;
  }

  /**
   * @return The URL invoked by Plivo when the outbound call is answered.
   */
  public String answerUrl() {
    return answerUrl;
  }

  /**
   * @return The method used to call the answer_url. Defaults to POST.
   */
  public String answerMethod() {
    return this.answerMethod;
  }

  /**
   * @return The URL that is notified by Plivo when the call is ringing. Defaults not set.
   */
  public String ringUrl() {
    return this.ringUrl;
  }

  /**
   * @return The method used to call the ring_url. Defaults to POST.
   */
  public String ringMethod() {
    return this.ringMethod;
  }

  /**
   * @return The URL that is notified by Plivo when the call hangs up. Defaults to answer_url.
   */
  public String hangupUrl() {
    return this.hangupUrl;
  }

  /**
   * @return The method used to call the hangup_url. Defaults to POST.
   */
  public String hangupMethod() {
    return this.hangupMethod;
  }

  /**
   * @return Invoked by Plivo only if answer_url is unavailable or the XML response is invalid.
   * Should contain a XML response.
   */
  public String fallbackUrl() {
    return this.fallbackUrl;
  }

  /**
   * @return The method used to call the fallback_url. Defaults to POST.
   */
  public String fallbackMethod() {
    return this.fallbackMethod;
  }

  /**
   * @return Caller name to use with the call.
   */
  public String callerName() {
    return this.callerName;
  }

  /**
   * Plivo plays DTMF tones when the call is answered. This is useful when dialing a phone number
   * and an extension. Plivo will dial the number, and when the automated system picks up, sends the
   * DTMF tones to connect to the extension. E.g. If you want to dial the 2410 extension after the
   * call is connected, and you want to wait for a few seconds before sending the extension, add a
   * few leading 'w' characters. Each 'w' character waits 0.5 second before sending a digit. Each
   * 'W' character waits 1 second before sending a digit. You can also add the tone duration in ms
   * by appending @duration after the string (default duration is 2000 ms). For example, 1w2w3@1000
   * See the DTMF API for additional information.
   *
   * @return DTMF tones to play
   */
  public String sendDigits() {
    return this.sendDigits;
  }

  /**
   * @return If set to true and send_digits is also set, digits are sent when the call is in
   * preanswer state. Defaults to false.
   */
  public Boolean sendOnPreanswer() {
    return this.sendOnPreanswer;
  }

  /**
   * @return Schedules the call for hangup at a specified time after the call is answered.
   */
  public Long timeLimit() {
    return this.timeLimit;
  }

  /**
   * @return Schedules the call for hangup at a specified time after the call starts ringing.
   */
  public Long hangupOnRing() {
    return this.hangupOnRing;
  }

  /**
   * Used to detect if the call has been answered by a machine. The valid values are true and
   * hangup. Default time to analyze is 5000 milliseconds (or 5 seconds). You can change it with the
   * machine_detection_time parameter. Note that no XML is processed during the analysis phase. If a
   * machine is detected during the call and machine_detection is set to true, the Machine parameter
   * will be set to true and will be sent to the answer_url, hangup_url, or any other URL that is
   * invoked by the call. If a machine is detected during the call and machine_detection is set to
   * hangup, the call hangs up immediately and a request is made to the hangup_url with the Machine
   * parameter set to true
   */
  public String machineDetection() {
    return this.machineDetection;
  }

  /**
   * @return Time allotted to analyze if the call has been answered by a machine.
   */
  public Long machineDetectionTime() {
    return this.machineDetectionTime;
  }

  /**
   * @return A URL where machine detection parameters will be sent by Plivo.
   */
  public String machineDetectionUrl() {
    return this.machineDetectionUrl;
  }

  /**
   * @return The HTTP method which will be used by Plivo to request the machine_detection_url.
   * Defaults to POST.
   */
  public String machineDetectionMethod() {
    return this.machineDetectionMethod;
  }

  /**
   * @return List of SIP headers in the form of 'key=value' pairs, separated by commas.
   */
  public Map<String, String> sipHeaders() {
    return this.sipHeaders;
  }

  /**
   * @return Determines the time in seconds the call should ring.
   */
  public Long ringTimeout() {
    return this.ringTimeout;
  }

  /**
   * @return The call_uuid of the first leg in an ongoing conference call.
   */
  public String parentCallUuid() {
    return this.parentCallUuid;
  }

  /**
   * @return If set to true and the parent_call_uuid cannot be found, the API request would return
   * an error.
   */
  public Boolean errorIfParentNotFound() {
    return this.errorIfParentNotFound;
  }

  public CallCreator answerMethod(final String answerMethod) {
    this.answerMethod = answerMethod;
    return this;
  }

  public CallCreator ringUrl(final String ringUrl) {
    this.ringUrl = ringUrl;
    return this;
  }

  public CallCreator ringMethod(final String ringMethod) {
    this.ringMethod = ringMethod;
    return this;
  }

  public CallCreator hangupUrl(final String hangupUrl) {
    this.hangupUrl = hangupUrl;
    return this;
  }

  public CallCreator hangupMethod(final String hangupMethod) {
    this.hangupMethod = hangupMethod;
    return this;
  }

  public CallCreator fallbackUrl(final String fallbackUrl) {
    this.fallbackUrl = fallbackUrl;
    return this;
  }

  public CallCreator fallbackMethod(final String fallbackMethod) {
    this.fallbackMethod = fallbackMethod;
    return this;
  }

  public CallCreator callerName(final String callerName) {
    this.callerName = callerName;
    return this;
  }

  public CallCreator sendDigits(final String sendDigits) {
    this.sendDigits = sendDigits;
    return this;
  }

  public CallCreator sendOnPreanswer(final Boolean sendOnPreanswer) {
    this.sendOnPreanswer = sendOnPreanswer;
    return this;
  }

  public CallCreator timeLimit(final Long timeLimit) {
    this.timeLimit = timeLimit;
    return this;
  }

  public CallCreator hangupOnRing(final Long hangupOnRing) {
    this.hangupOnRing = hangupOnRing;
    return this;
  }

  public CallCreator machineDetection(final String machineDetection) {
    this.machineDetection = machineDetection;
    return this;
  }

  public CallCreator machineDetectionTime(final Long machineDetectionTime) {
    this.machineDetectionTime = machineDetectionTime;
    return this;
  }

  public CallCreator machineDetectionUrl(final String machineDetectionUrl) {
    this.machineDetectionUrl = machineDetectionUrl;
    return this;
  }

  public CallCreator machineDetectionMethod(final String machineDetectionMethod) {
    this.machineDetectionMethod = machineDetectionMethod;
    return this;
  }

  public CallCreator sipHeaders(final Map<String, String> sipHeaders) {
    this.sipHeaders = sipHeaders;
    return this;
  }

  public CallCreator ringTimeout(final Long ringTimeout) {
    this.ringTimeout = ringTimeout;
    return this;
  }

  public CallCreator parentCallUuid(final String parentCallUuid) {
    this.parentCallUuid = parentCallUuid;
    return this;
  }

  public CallCreator errorIfParentNotFound(final Boolean errorIfParentNotFound) {
    this.errorIfParentNotFound = errorIfParentNotFound;
    return this;
  }


  @Override
  protected Call<CallCreateResponse> obtainCall() {
    return client().getApiService().callCreate(client().getAuthId(), this);
  }
}
