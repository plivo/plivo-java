package com.plivo.api.xml;

import com.plivo.api.serializers.DelimitedListXMLSerializer;
import com.plivo.api.validators.InRange;
import com.plivo.api.validators.MultiOf;
import com.plivo.api.validators.OneOf;
import com.plivo.api.validators.UrlValues;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "MultiPartyCall")
public class MultiPartyCall extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String role;

  @XmlAttribute
  @InRange(message = "must be in range [300-28800]", min = 300, max = 28800)
  private Integer maxDuration = 14400;

  @XmlAttribute
  @InRange(message = "must be in range [2-10]", min = 2, max = 10)
  private Integer maxParticipants = 10;

  @XmlAttribute
  @UrlValues
  private String waitMusicUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String waitMusicMethod = "GET";

  @XmlAttribute
  @UrlValues
  private String agentHoldMusicUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String agentHoldMusicMethod = "GET";

  @XmlAttribute
  @UrlValues
  private String customerHoldMusicUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String customerHoldMusicMethod = "GET";

  @XmlAttribute
  private Boolean record = false;

  @XmlAttribute
  @OneOf(message = "should be one of [mp3, wav]", options = {"mp3", "wav"})
  private String recordFileFormat = "mp3";

  @XmlAttribute
  @UrlValues
  private String recordingCallbackUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String recordingCallbackMethod = "POST";

  @XmlAttribute
  @XmlJavaTypeAdapter(DelimitedListXMLSerializer.class)
  @MultiOf(message = "should be among [mpc-state-changes, participant-state-changes, participant-speak-events, participant-digit-input-events, add-participant-api-events]", options = {"mpc-state-changes", "participant-state-changes", "participant-speak-events", "participant-digit-input-events", "add-participant-api-events"})
  private List<String> statusCallbackEvents = Arrays.asList("mpc-state-changes", "participant-state-changes");

  @XmlAttribute
  @UrlValues
  private String statusCallbackUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String statusCallbackMethod ="POST";

  @XmlAttribute
  private Boolean stayAlone = false;

  @XmlAttribute
  private Boolean coachMode = true;

  @XmlAttribute
  private Boolean mute = false;

  @XmlAttribute
  private Boolean hold = false;

  @XmlAttribute
  private Boolean startMpcOnEnter = true;

  @XmlAttribute
  private Boolean endMpcOnExit = false;

  @XmlAttribute
  @UrlValues(message = "should be a valid URL or one of ['beep:1', 'beep:2', 'none']", options = {"beep:1", "beep:2", "none"})
  private String enterSound = "beep:1";

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String enterSoundMethod = "GET";

  @XmlAttribute
  @UrlValues(message = "should be a valid URL or one of ['beep:1', 'beep:2', 'none']", options = {"beep:1", "beep:2", "none"})
  private String exitSound = "beep:2";

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String exitSoundMethod = "GET";

  @XmlAttribute
  @UrlValues
  private String onExitActionUrl;

  @XmlAttribute
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String onExitActionMethod ="POST";

  @XmlAttribute
  private Boolean relayDtmfInputs = false;

  @XmlValue
  private String name;

  private MultiPartyCall() {

  }

  public MultiPartyCall(String name, String role) {
    if (name == null) {
      throw new IllegalArgumentException("multiPartyCall name cannot be null");
    }

    if (role == null) {
      throw new IllegalArgumentException("multiPartyCall participant role cannot be null");
    }

    this.name = name;
    this.role = role;
  }

  public String role() {
    return role;
  }

  public Integer maxDuration() {
    return maxDuration;
  }

  public Integer maxParticipants() {
    return maxParticipants;
  }

  public String waitMusicUrl() {
    return waitMusicUrl;
  }

  public String waitMusicMethod() {
    return waitMusicMethod;
  }

  public String agentHoldMusicUrl() {
    return agentHoldMusicUrl;
  }

  public String agentHoldMusicMethod() {
    return agentHoldMusicMethod;
  }

  public String customerHoldMusicUrl() {
    return customerHoldMusicUrl;
  }

  public String customerHoldMusicMethod() {
    return customerHoldMusicMethod;
  }

  public Boolean record() {
    return record;
  }

  public String recordFileFormat() {
    return recordFileFormat;
  }

  public String recordingCallbackUrl() {
    return recordingCallbackUrl;
  }

  public String recordingCallbackMethod() {
    return recordingCallbackMethod;
  }

  public List<String> statusCallbackEvents() {
    return statusCallbackEvents;
  }

  public String statusCallbackUrl() {
    return statusCallbackUrl;
  }

  public String statusCallbackMethod() {
    return statusCallbackMethod;
  }

  public Boolean stayAlone() {
    return stayAlone;
  }

  public Boolean coachMode() {
    return coachMode;
  }

  public Boolean mute() {
    return mute;
  }

  public Boolean hold() {
    return hold;
  }

  public Boolean startMpcOnEnter() {
    return startMpcOnEnter;
  }

  public Boolean endMpcOnExit() {
    return endMpcOnExit;
  }

  public String enterSound() {
    return enterSound;
  }

  public String enterSoundMethod() {
    return enterSoundMethod;
  }

  public String exitSound() {
    return exitSound;
  }

  public String exitSoundMethod() {
    return exitSoundMethod;
  }

  public String onExitActionUrl() {
    return onExitActionUrl;
  }

  public String onExitActionMethod() {
    return onExitActionMethod;
  }

  public Boolean relayDtmfInputs() {
    return relayDtmfInputs;
  }

  public String name() {
    return name;
  }

  public MultiPartyCall role(String role) {
    this.role = role;
    return this;
  }

  public MultiPartyCall maxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    return this;
  }

  public MultiPartyCall maxParticipants(Integer maxParticipants) {
    this.maxParticipants = maxParticipants;
    return this;
  }

  public MultiPartyCall waitMusicUrl(String waitMusicUrl) {
    this.waitMusicUrl = waitMusicUrl;
    return this;
  }

  public MultiPartyCall waitMusicMethod(String waitMusicMethod) {
    this.waitMusicMethod = waitMusicMethod;
    return this;
  }

  public MultiPartyCall agentHoldMusicUrl(String agentHoldMusicUrl) {
    this.agentHoldMusicUrl = agentHoldMusicUrl;
    return this;
  }

  public MultiPartyCall agentHoldMusicMethod(String agentHoldMusicMethod) {
    this.agentHoldMusicMethod = agentHoldMusicMethod;
    return this;
  }

  public MultiPartyCall customerHoldMusicUrl(String customerHoldMusicUrl) {
    this.customerHoldMusicUrl = customerHoldMusicUrl;
    return this;
  }

  public MultiPartyCall customerHoldMusicMethod(String customerHoldMusicMethod) {
    this.customerHoldMusicMethod = customerHoldMusicMethod;
    return this;
  }

  public MultiPartyCall record(Boolean record) {
    this.record = record;
    return this;
  }

  public MultiPartyCall recordFileFormat(String recordFileFormat) {
    this.recordFileFormat = recordFileFormat;
    return this;
  }

  public MultiPartyCall recordingCallbackUrl(String recordingCallbackUrl) {
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }

  public MultiPartyCall recordingCallbackMethod(String recordingCallbackMethod) {
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }

  public MultiPartyCall statusCallbackEvents(List<String> statusCallbackEvents) {
    this.statusCallbackEvents = statusCallbackEvents;
    return this;
  }

  public MultiPartyCall statusCallbackUrl(String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }

  public MultiPartyCall statusCallbackMethod(String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  public MultiPartyCall stayAlone(Boolean stayAlone) {
    this.stayAlone = stayAlone;
    return this;
  }

  public MultiPartyCall coachMode(Boolean coachMode) {
    this.coachMode = coachMode;
    return this;
  }

  public MultiPartyCall mute(Boolean mute) {
    this.mute = mute;
    return this;
  }

  public MultiPartyCall hold(Boolean hold) {
    this.hold = hold;
    return this;
  }

  public MultiPartyCall startMpcOnEnter(Boolean startMpcOnEnter) {
    this.startMpcOnEnter = startMpcOnEnter;
    return this;
  }

  public MultiPartyCall endMpcOnExit(Boolean endMpcOnExit) {
    this.endMpcOnExit = endMpcOnExit;
    return this;
  }

  public MultiPartyCall enterSound(String enterSound) {
    this.enterSound = enterSound;
    return this;
  }

  public MultiPartyCall enterSoundMethod(String enterSoundMethod) {
    this.enterSoundMethod = enterSoundMethod;
    return this;
  }

  public MultiPartyCall exitSound(String exitSound) {
    this.exitSound = exitSound;
    return this;
  }

  public MultiPartyCall exitSoundMethod(String exitSoundMethod) {
    this.exitSoundMethod = exitSoundMethod;
    return this;
  }

  public MultiPartyCall onExitActionUrl(String onExitActionUrl) {
    this.onExitActionUrl = onExitActionUrl;
    return this;
  }

  public MultiPartyCall onExitActionMethod(String onExitActionMethod) {
    this.onExitActionMethod = onExitActionMethod;
    return this;
  }

  public MultiPartyCall relayDtmfInputs(Boolean relayDtmfInputs) {
    this.relayDtmfInputs = relayDtmfInputs;
    return this;
  }

  public MultiPartyCall name(String name) {
    this.name = name;
    return this;
  }
}