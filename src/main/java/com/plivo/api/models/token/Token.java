package com.plivo.api.models.token;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;

public class Token extends BaseResource {

  private String iss;

  private String sub;

  private Integer nbf;

  private Integer exp;

  private String app;

  private TokenPermission per;

  public static TokenCreator creator(String iss) {
    if(!Utils.allNotNull(iss)){
      throw new IllegalArgumentException("iss cannot be null");
    }
    return new TokenCreator(iss);
  }

  public String getIss() {
    return iss;
  }

  public String getSub() {
    return sub;
  }

  public Integer getNbf() {
    return nbf;
  }

  public Integer getExp() {
    return exp;
  }

  public String getApp() {
    return app;
  }

  public TokenPermission getPer() {
    return per;
  }

  public String getId() {
    return null;
  }
}