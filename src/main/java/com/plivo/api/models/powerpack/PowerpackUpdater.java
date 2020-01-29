package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class PowerpackUpdater extends Updater<PowerpackUpdateResponse> {

  private String name;
  private String application_type;
  private String application_id;
  private Boolean sticky_sender;
  private Boolean local_connect;

  public PowerpackUpdater(String id) {
    super(id);
  }

  public String getName() {
    return name;
  }

  public String getApplicationType() {
    return application_type;
  }

  public String getApplicationID() {
    return application_id;
  }

  public Boolean getStickySender() {
    return sticky_sender;
  }

  public Boolean getLocalConnect() {
    return local_connect;
  }


  public PowerpackUpdater name(final String name) {
    this.name = name;
    return this;
  }

  public PowerpackUpdater sticky_sender(final Boolean sticky_sender) {
    this.sticky_sender = sticky_sender;
    return this;
  }

  public PowerpackUpdater local_connect(final Boolean local_connect) {
    this.local_connect = local_connect;
    return this;
  }

  public PowerpackUpdater application_id(final String application_id) {
    this.application_id = application_id;
    return this;
  }

  public PowerpackUpdater application_type(final String application_type) {
    this.application_type = application_type;
    return this;
  }

  @Override
  protected Call<PowerpackUpdateResponse> obtainCall() {
    return client().getApiService().powerpackUpdate(client().getAuthId(), id, this);
  }
}
