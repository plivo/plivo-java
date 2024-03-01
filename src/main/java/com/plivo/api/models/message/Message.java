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
  private String powerpackID;
  private String tendlcCampaignID;
  private String tendlcRegistrationStatus;
  private String destinationCountryIso2;
  private String destinationNetwork;
  private String carrierFeesRate;
  private String carrierFees;
  private String requesterIP;
  private Boolean isDomestic;
  private String replacedSender;
  private String dltEntityID;
  private String dltTemplateID;
  private String dltTemplateCategory;
  private String conversationID;
  private String conversationOrigin;
  private String conversationExpirationTimestamp;
  private String log;

  public static MessageCreator creator(String source, String destination) {
    return new MessageCreator(source, destination);
  }

  public static MessageCreator creator(String source, List<String> destination, String text) {
    return new MessageCreator(source, destination, text);
  }

  public static MessageCreator creator(String source, String destination, String text) {
    return new MessageCreator(source, destination, text);
  }

  public static MessageCreator creator(List<String> destination, String text, String powerpackUUID) {
    return new MessageCreator(destination, text, powerpackUUID);
  }

  public static MessageGetter getter(String id) {
    return new MessageGetter(id);
  }

  public static MessageLister lister() {
    return new MessageLister();
  }


  public MmsMediaGetter getMedia(String media_id){return  new MmsMediaGetter(getId(), media_id);}

  public MmsMediaLister listMedia(){return new MmsMediaLister(getId());}


  public String getErrorCode() {
    return errorCode;
  }

  public String getTendlcRegistrationStatus() {
    return tendlcRegistrationStatus;
    }

  public String getRequesterIP() {
    return requesterIP;
  }

  public String getReplacedSender() {
    return replacedSender;
  }
  
  public String getPowerpackID() {
    return powerpackID;
  }
  
  public String getTendlcCampaignID() {
    return tendlcCampaignID;
  }
   public String getDestinationCountryIso2() {
    return destinationCountryIso2;
  }

  public String getDestinationNetwork() {
    return destinationNetwork;
  }

  public String getCarrierFeesRate() {
    return carrierFeesRate;
  }

  public String getCarrierFees() {
    return carrierFees;
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

  public Boolean getIsDomestic() {
    return isDomestic;
  }

  public String getDltEntityID() {
    return dltEntityID;
  }

  public String getDltTemplateID() {
    return dltTemplateID;
  }

  public String getDltTemplateCategory() {
    return dltTemplateCategory;
  }

  public String getConversationID() {
    return conversationID;
  }

  public String getConversationOrigin() {
    return conversationOrigin;
  }

  public String getConversationExpirationTimestamp() {
    return conversationExpirationTimestamp;
  }

  public String getLog() {
    return log;
  }
  
  @Override
  public String getId() {
    return getMessageUuid();
  }
}
