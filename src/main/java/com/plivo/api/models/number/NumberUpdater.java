package com.plivo.api.models.number;

import com.plivo.api.models.base.Updater;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class NumberUpdater extends Updater<NumberUpdateResponse> {

  private String appId;
  private String subaccount;
  private String alias;
  private String cnamLookup;

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

  @Override
  protected void validate() {
    if (!Utils.anyNotNull(alias, subaccount, appId, cnamLookup)) {
      throw new IllegalStateException("one of alias, subaccount, appId, cnamLookup must be non-null");
    }
    super.validate();
  }

  @Override
  protected Call<NumberUpdateResponse> obtainCall() {
    return client().getApiService().numberUpdate(client().getAuthId(), id, this);
  }
}
