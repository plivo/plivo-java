package com.plivo.api.models.message;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.PropertyFilter;
import java.util.Date;
import retrofit2.Call;

/**
 * Pending list request that can be executed by calling list();
 */
public class MessageLister extends Lister<Message> {

  private String subaccount = null;
  private MessageDirection messageDirection = null;
  private PropertyFilter<Date> messageTime = null;
  private MessageState messageState = null;
  private Long errorCode = null;

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


  @Override
  protected Call<ListResponse<Message>> obtainCall() {
    return client().getApiService().messageList(client().getAuthId(), toMap());
  }
}
