package com.plivo.api.models.verify_session;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.util.PropertyFilter;
import retrofit2.Call;
import retrofit2.Response;

import com.plivo.api.models.base.Lister;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

public class SessionLister extends  Lister<VerifySession> {
  private String subaccount = null;
  private PropertyFilter<Date> sessionTime = null;
  private String status = null;
  private String country = null;
  private String alias =  null;
  private String appUuid = null;
  private String recipient = null;
  public String subaccount() {
    return this.subaccount;
  }
  public String status() {
    return this.status;
  }
  public String country() {
    return this.country;
  }
  public String alias() {
    return this.alias;
  }
  public String appUuid() {
    return this.appUuid;
  }
  public String recipient() {
    return this.recipient;
  }
  public PropertyFilter<Date> sessionTime() {
    return this.sessionTime;
  }
  public SessionLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public SessionLister status(final String status) {
    this.status = status;
    return this;
  }
  public SessionLister country(final String country) {
    this.country = country;
    return this;
  }
  public SessionLister alias(final String alias) {
    this.alias = alias;
    return this;
  }
  public SessionLister appUuid(final String appUuid) {
    this.appUuid = appUuid;
    return this;
  }
  public SessionLister recipient(final String recipient) {
    this.recipient = recipient;
    return this;
  }
  public SessionLister sessionTime(final PropertyFilter<Date> sessionTime) {
    this.sessionTime = sessionTime;
    return this;
  }
  @Override
  /**
   * Actually list instances of the resource.
   */
  public ListResponse<VerifySession> list() throws IOException, PlivoRestException {
    validate();
    Response<ListResponse<VerifySession>> response = obtainCall().execute();

    handleResponse(response);

    try
    {
      Field meta = response.body().getClass().getDeclaredField("meta");
      meta.setAccessible(true);
      meta.set(response.body(), new SessionMeta(response.body().getMeta()));
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return response.body();
  }

  @Override
  protected Call<ListResponse<VerifySession>> obtainCall() {
    return client().getApiService().sessionList(client().getAuthId(), toMap());
  }

}
