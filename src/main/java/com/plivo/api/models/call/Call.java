package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.call.actions.CallDtmfCreator;
import com.plivo.api.models.call.actions.CallPlayCreator;
import com.plivo.api.models.call.actions.CallPlayDeleter;
import com.plivo.api.models.call.actions.CallRecordCreator;
import com.plivo.api.models.call.actions.CallRecordDeleter;
import com.plivo.api.models.call.actions.CallSpeakCreator;
import com.plivo.api.models.call.actions.CallSpeakDeleter;
import java.util.List;

// TODO Date
public class Call extends BaseResource {

  private String answerTime;
  private Long billDuration;
  private Long billedDuration;
  private CallDirection callDirection;
  private Long callDuration;
  private String callState;
  private String callUuid;
  private String endTime;
  private String fromNumber;
  private String initiationTime;
  private String parentCallUuid;
  private String resourceUri;
  private String toNumber;
  private String totalAmount;
  private String totalRate;

  public static CallCreator creator(String from, List<String> to, String answerUrl) {
    return new CallCreator(from, to, answerUrl);
  }

  public static CallDeleter deleter(String id) {
    return new CallDeleter(id);
  }

  public static CallUpdater updater(String id) {
    return new CallUpdater(id);
  }

  public static CallUpdater transferrer(String id) {
    return new CallUpdater(id);
  }

  public static CallLister lister() {
    return new CallLister();
  }

  public static CallRecordCreator recorder(String callUuid) {
    return new CallRecordCreator(callUuid);
  }

  public static CallRecordDeleter recordStopper(String callUuid) {
    return new CallRecordDeleter(callUuid);
  }

  public static CallPlayCreator player(String callUuid, List<String> urls) {
    return new CallPlayCreator(callUuid, urls);
  }

  public static CallPlayDeleter playStopper(String callUuid) {
    return new CallPlayDeleter(callUuid);
  }

  public static CallSpeakCreator speaker(String callUuid, String text) {
    return new CallSpeakCreator(callUuid, text);
  }

  public static CallSpeakDeleter speakStopper(String callUuid) {
    return new CallSpeakDeleter(callUuid);
  }

  public static CallDtmfCreator digitSender(String callUuid, String digits) {
    return new CallDtmfCreator(callUuid, digits);
  }

  public static CallGetter getter(String id) {
    return new CallGetter(id);
  }

  public String getAnswerTime() {
    return answerTime;
  }

  public Long getBillDuration() {
    return billDuration;
  }

  public Long getBilledDuration() {
    return billedDuration;
  }

  public CallDirection getCallDirection() {
    return callDirection;
  }

  public Long getCallDuration() {
    return callDuration;
  }

  public String getcallState() {
    return callState;
  }

  public String getCallUuid() {
    return callUuid;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getFromNumber() {
    return fromNumber;
  }

  public String getInitiationTime() {
    return initiationTime;
  }

  public String getParentCallUuid() {
    return parentCallUuid;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public String getToNumber() {
    return toNumber;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public String getTotalRate() {
    return totalRate;
  }

  public CallDeleter deleter() {
    return Call.deleter(callUuid);
  }

  public CallUpdater updater() {
    return Call.updater(callUuid);
  }

  public CallUpdater transferrer() {
    return Call.updater(callUuid);
  }

  public CallRecordCreator recorder() {
    return new CallRecordCreator(callUuid);
  }

  public CallRecordDeleter recordStopper() {
    return new CallRecordDeleter(callUuid);
  }

  public CallPlayCreator player(List<String> urls) {
    return new CallPlayCreator(callUuid, urls);
  }

  public CallPlayDeleter playStopper() {
    return new CallPlayDeleter(callUuid);
  }

  public CallSpeakCreator speaker(String text) {
    return new CallSpeakCreator(callUuid, text);
  }

  public RequestDeleter canceller() {
    return Call.canceller(callUuid);
  }

  public static RequestDeleter canceller(String callUuid) {
    return new RequestDeleter(callUuid);
  }

  public CallSpeakDeleter speakStopper() {
    return new CallSpeakDeleter(callUuid);
  }

  public CallDtmfCreator digitSender(String digits) {
    return new CallDtmfCreator(callUuid, digits);
  }

  @Override
  public String getId() {
    return getCallUuid();
  }
}
