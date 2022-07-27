package com.plivo.api.models.token;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.call.CallCreator;

import java.util.List;

public class Token extends BaseResource {

  private String iss;

  private String sub;

  private Integer nbf;

  private Integer exp;

  private Boolean incoming_allow;

  private Boolean outgoing_allow;

  private String app;

  public static TokenCreator creator(String iss, String sub, Integer nbf, Integer exp, Boolean incoming_allow, Boolean outgoing_allow, String app) {
    return new TokenCreator(iss, sub, nbf, exp, incoming_allow, outgoing_allow, app);
  }
}