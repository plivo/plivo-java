package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class PowerpackCreator extends Creator<PowerpackResponse> {
  private String name;
  private String application_type = null;
  private String application_id = null;
  private Boolean sticky_sender = Boolean.TRUE;
  private Boolean local_connect = Boolean.TRUE;
  private NumberPriority[] number_priority;
  
  PowerpackCreator(String name) {
    if (!Utils.allNotNull(name)) {
      throw new IllegalStateException("powerpack name is required");
    }
    this.name = name;
  }

  public String name() {
    return this.name;
  }

  public String application_type() {
    return this.application_type;
  }

  public String application_id() {
    return this.application_id;
  }

  public Boolean sticky_sender() {
    return this.sticky_sender;
  }

  public Boolean local_connect() {
    return this.local_connect;
  }

  public NumberPriority[] number_priority() {
	    return number_priority;
	  }

  public PowerpackCreator number_priority(final NumberPriority[] numberPriorities) {
	    this.number_priority = numberPriorities;
	    return this;
	  }
  
  @Override
  protected Call<PowerpackResponse> obtainCall() {
    return client().getApiService().createPowerpack(client().getAuthId(), this);
  }
}
