package com.plivo.api.models.maskingsession;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;

public class MaskingSession extends BaseResource {
  private String sessionUuid;
  private Object response;
  public Object getResponse() {
    return response;
  }
  public static MaskingSessionCreator creator(String firstParty, String secondParty) {
    if (!Utils.allNotNull(firstParty, secondParty)) {
      throw new IllegalArgumentException("firstParty and secondParty cannot be null");
    }

    return new MaskingSessionCreator(firstParty, secondParty);
  }
  public static MaskingSessionCreator creator(String firstParty) {
    if (!Utils.allNotNull(firstParty)) {
      throw new IllegalArgumentException("firstParty cannot be null");
    }

    return new MaskingSessionCreator(firstParty);
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
