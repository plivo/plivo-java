package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Client;
import com.plivo.api.Plivo;
import com.plivo.api.models.base.BaseRequest;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PhloGetter extends Getter<Phlo> {

  public PhloGetter(final String phloId) {
    super(phloId);
  }

  @Override
  public Client client() {
    return this.plivoClient;
  }
  
  @Override
  public PhloGetter client(final Client plivoClient) {
	super.client(plivoClient);
    this.plivoClient = plivoClient;
    return this;
  }

  @JsonIgnore
  protected Client plivoClient = Plivo.getPhloClient();

  @Override
  protected Call<Phlo> obtainCall() {
    return client().getApiService().phloGet(this.id);
  }

}
