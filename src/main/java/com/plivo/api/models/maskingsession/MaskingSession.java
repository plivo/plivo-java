package com.plivo.api.models.maskingsession;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;

public class MaskingSession extends BaseResource {

  private String sessionUuid;

  private String firstParty;

  public String getFirstParty() {
    return firstParty;
  }

  public String getSecondParty() {
    return secondParty;
  }

  private String secondParty;

  public static MaskingSessionCreator creator(String firstParty, String secondParty) {
    if (!Utils.allNotNull(firstParty, secondParty)) {
      throw new IllegalArgumentException("firstParty and secondParty cannot be null");
    }

    return new MaskingSessionCreator(firstParty, secondParty);
  }

  public static MaskingSessionLister lister() {
    return new MaskingSessionLister();
  }

  public static MaskingSessionGetter getter(String sessionUuid) {
    return new MaskingSessionGetter(sessionUuid);
  }

  public static MaskingSessionUpdater updater(String sessionUuid) {
    return new MaskingSessionUpdater(sessionUuid);
  }

  public static MaskingSessionDeleter deleter(String sessionUuid) {
    return new MaskingSessionDeleter(sessionUuid);
  }

  public String getMaskingSessionId() {
    return sessionUuid;
  }

  @Override
  public String getId() {
    return getMaskingSessionId();
  }
}
