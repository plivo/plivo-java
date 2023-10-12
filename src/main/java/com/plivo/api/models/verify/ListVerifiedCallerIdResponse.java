package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

import java.util.List;

public class ListVerifiedCallerIdResponse extends BaseResource {

  private String apiId;

  private String meta;

  private List<ListVerifyResponse> objects;

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }
}
