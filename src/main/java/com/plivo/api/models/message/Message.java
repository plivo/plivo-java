package com.plivo.api.models.message;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Message extends BaseResource {

  private String errorCode;
  private String fromNumber;
  private String messageDirection;
  private String messageState;
  private String messageTime;
  private String messageType;
  private String messageUuid;
  private String resourceUri;
  private String toNumber;
  private String totalAmount;
  private String totalRate;
  private Long units;

  public static MessageCreator creator(String source, List<String> destination, String text) {
    return new MessageCreator(source, destination, text);
  }

  public static MessageGetter getter(String id) {
    return new MessageGetter(id);
  }

  public static MessageLister lister() {
    return new MessageLister();
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getFromNumber() {
    return fromNumber;
  }

  public String getMessageDirection() {
    return messageDirection;
  }

  public String getMessageState() {
    return messageState;
  }

  public String getMessageTime() {
    return messageTime;
  }

  public String getMessageType() {
    return messageType;
  }

  public String getMessageUuid() {
    return messageUuid;
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

  public Long getUnits() {
    return units;
  }

  @Override
  public String getId() {
    return getMessageUuid();
  }
}
