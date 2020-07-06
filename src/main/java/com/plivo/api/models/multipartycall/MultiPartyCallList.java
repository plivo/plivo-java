package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.PropertyFilter;
import com.plivo.api.validators.OneOf;
import com.plivo.api.validators.SubAccount;
import com.plivo.api.validators.Validate;
import retrofit2.Call;

public class MultiPartyCallList extends Lister<MultiPartyCall> {

  @SubAccount
  private String subAccount;
  private String friendlyName;
  @OneOf(message = "should be one of [initialized, active, ended]", options = {"initialized", "active", "ended"})
  private String status;
  private Integer terminationCauseCode;
  private PropertyFilter<String> creationTime;
  private PropertyFilter<String> endTime;

  public String getSubAccount() {
    return subAccount;
  }

  public String getFriendlyName() {
    return friendlyName;
  }

  public String getStatus() {
    return status;
  }

  public Integer getTerminationCauseCode() {
    return terminationCauseCode;
  }

  public PropertyFilter<String> getCreationTime() {
    return creationTime;
  }

  public PropertyFilter<String> getEndTime() {
    return endTime;
  }

  public MultiPartyCallList subAccount(String subAccount) {
    this.subAccount = subAccount;
    return this;
  }

  public MultiPartyCallList friendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
    return this;
  }

  public MultiPartyCallList status(String status) {
    this.status = status;
    return this;
  }

  public MultiPartyCallList terminationCauseCode(Integer terminationCauseCode) {
    this.terminationCauseCode = terminationCauseCode;
    return this;
  }

  public MultiPartyCallList creationTime(PropertyFilter<String> creationTime) throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyTime("creationTime", creationTime);
    this.creationTime = creationTime;
    return this;
  }

  public MultiPartyCallList endTime(PropertyFilter<String> endTime) throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyTime("endTime", endTime);
    this.endTime = endTime;
    return this;
  }

  @Override
  protected Call<ListResponse<MultiPartyCall>> obtainCall() throws InvalidRequestException {
    Validate.check(this);
    return client().getApiService().mpcList(client().getAuthId(), toMap());
  }
}
