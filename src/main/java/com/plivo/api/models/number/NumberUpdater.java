package com.plivo.api.models.number;

import com.plivo.api.models.base.Updater;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class NumberUpdater extends Updater<NumberUpdateResponse> {

  private String appId;
  private String subaccount;
  private String alias;
  private String cnamLookup;
  private String cnam;
  private String callbackUrl;
  private String callbackMethod;

  NumberUpdater(final String number) {
    super(number);
  }

  public String appId() {
    return this.appId;
  }

  public String subaccount() {
    return this.subaccount;
  }

  public String alias() {
    return this.alias;
  }

  public String cnamLookup() {
    return this.cnamLookup;
  }

  public String cnam() {
    return this.cnam;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public NumberUpdater appId(final String appId) {
    this.appId = appId;
    return this;
  }

  public NumberUpdater subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  public NumberUpdater alias(final String alias) {
    this.alias = alias;
    return this;
  }
  public NumberUpdater cnamLookup(final String cnamLookup) {
    this.cnamLookup = cnamLookup;
    return this;
  }

  public NumberUpdater cnam(final String cnam) {
    this.cnam = cnam;
    return this;
  }

  public NumberUpdater callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public NumberUpdater callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  @Override
  protected void validate() {
    if (!Utils.anyNotNull(alias, subaccount, appId, cnamLookup)) {
      throw new IllegalStateException("one of alias, subaccount, appId, cnamLookup, cnam must be non-null");
    }
    super.validate();
  }

  @Override
  protected Call<NumberUpdateResponse> obtainCall() {
    return client().getApiService().numberUpdate(client().getAuthId(), id, this);
  }
}
