package com.plivo.api.models.verify_session;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VerifySessionList extends VerifySession{
  @JsonIgnore
  private String apiId;
}
