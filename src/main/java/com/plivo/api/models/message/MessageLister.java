package com.plivo.api.models.message;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.PropertyFilter;

import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;

import java.lang.reflect.Field;

import java.util.Date;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Pending list request that can be executed by calling list();
 */
public class MessageLister extends Lister<Message> {

  private String subaccount = null;
  private MessageDirection messageDirection = null;
  private PropertyFilter<Date> messageTime = null;
  private MessageState messageState = null;
  private Long errorCode = null;
  private String powerpackID = null;
  private String tendlcCampaignID = null;
  private String tendlcRegistrationStatus =  null;
  private String destinationCountryIso2 = null;
  private String destinationNetwork = null;
  private String carrierFeesRate = null;
  private String carrierFees = null;

  public String subaccount() {
    return this.subaccount;
  }

  public MessageDirection messageDirection() {
    return this.messageDirection;
  }

  public PropertyFilter<Date> messageTime() {
    return this.messageTime;
  }

  public MessageState messageState() {
    return this.messageState;
  }

  public Long errorCode() {
    return this.errorCode;
  }

  public String powerpackID() {
    return this.powerpackID;
  }
  public String tendlcCampaignID() {
    return this.tendlcCampaignID;
  }
  public String tendlcRegistrationStatus() {
    return this.tendlcRegistrationStatus;
  }
  public String destinationCountryIso2() {
    return this.destinationCountryIso2;
  }

  public MessageLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  public MessageLister messageDirection(
    final MessageDirection messageDirection) {
    this.messageDirection = messageDirection;
    return this;
  }

  public MessageLister messageTime(final PropertyFilter<Date> messageTime) {
    this.messageTime = messageTime;
    return this;
  }

  public MessageLister messageState(final MessageState messageState) {
    this.messageState = messageState;
    return this;
  }

  public MessageLister errorCode(final Long errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  public MessageLister tendlcCampaignID(final String tendlcCampaignID) {
     this.tendlcCampaignID = tendlcCampaignID;
     return this;
  }

  public MessageLister tendlcRegistrationStatus(final String tendlcRegistrationStatus) {
     this.tendlcRegistrationStatus = tendlcRegistrationStatus;
     return this;
  }

  public MessageLister destinationCountryIso2(final String destinationCountryIso2) {
     this.destinationCountryIso2 = destinationCountryIso2;
     return this;
  }

  public MessageLister powerpackID(final String powerpackID) {
     this.powerpackID = powerpackID;
     return this;
  }

  @Override  
  /**
  * Actually list instances of the resource.
  */
  public ListResponse<Message> list() throws IOException, PlivoRestException {
    validate();
    Response<ListResponse<Message>> response = obtainCall().execute();

    handleResponse(response);
    
    try 
    {
      Field meta = response.body().getClass().getDeclaredField("meta");
      meta.setAccessible(true);
      meta.set(response.body(), new MessageMeta(response.body().getMeta()));
    }
    catch(Exception e) 
    {
      e.printStackTrace();
    }
    
    return response.body();
  }

  @Override
  protected Call<ListResponse<Message>> obtainCall() {
    return client().getApiService().messageList(client().getAuthId(), toMap());
  }
}
