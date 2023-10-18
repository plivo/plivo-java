package com.plivo.api.models.verify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

import java.util.List;

@JsonIgnoreProperties("id")
public class ListVerifiedCallerIdResponse extends BaseResource {

  private String apiId;

  private VerifyMeta meta;

  private List<ListVerifiedCallerIdStructure> objects;

  public VerifyMeta getMeta() {
    return meta;
  }

  public List<ListVerifiedCallerIdStructure> getObjects() {
    return objects;
  }

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }

  @Override
  public String getApiId() {
    return apiId;
  }
}
