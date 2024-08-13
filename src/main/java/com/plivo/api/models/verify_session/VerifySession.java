package com.plivo.api.models.verify_session;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.message.MessageLister;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.xml.S;

public class VerifySession extends BaseResource {
  @JsonIgnore
  private String id;

  private String sessionUuid;
  private String appUuid;
  private String alias;
  private String recipient;
  private String channel;
  private String locale;
  private String status;
  private String count;
  private String requestorIP;
  private String destinationCountryIso2;
  private String destinationNetwork;
  private List<AttemptDetail> attemptDetails;
  private Charges charges;
  private String createdAt;
  private String updatedAt;
  public static SessionCreator creator(String appUUID, String recipient, String channel, String url, String method, String locale, String brand_name, String app_hash, Integer code_length) {
    return new SessionCreator(appUUID, recipient, channel, url, method, locale, brand_name, app_hash, code_length);
  }
  public static ValidateSession validation(String sessionUUID, String otp) {
    return new ValidateSession(sessionUUID, otp);
  }
  public static SessionGetter getter(String sessionUUID) {
    return new SessionGetter(sessionUUID);
  }

  public static SessionLister lister() {
    return new SessionLister();
  }

  public String getAppUuid() {
    return appUuid;
  }
  public String getAlias() {
    return alias;
  }
  public String getRecipient() {
    return recipient;
  }
  public String getChannel() {
    return channel;
  }
  public String getLocale() {
    return locale;
  }
  public String getStatus() {
    return status;
  }
  public String getCount() {
    return count;
  }
  public String getRequestorIP() {
    return requestorIP;
  }
  public String getDestinationCountryIso2() {
    return destinationCountryIso2;
  }
  public String getDestinationNetwork() {
    return destinationNetwork;
  }
  public List<AttemptDetail> getAttemptDetails() {
    return attemptDetails;
  }
  public Charges getCharges() {
    return charges;
  }
  public String getCreatedAt() {
    return createdAt;
  }
  public String getUpdatedAt() {
    return updatedAt;
  }
  public String getSessionUuid() {
    return sessionUuid;
  }

  @Override
  public String getId() {
    return getSessionUuid();
  }
}
