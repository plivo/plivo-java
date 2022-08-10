package com.plivo.api.models.token;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;
//import org.json.simple.JSONObject;
import retrofit2.Call;

public class Token extends BaseResource {

  private String iss;

  private String sub;

  private Integer nbf;

  private Integer exp;

  private Boolean incoming_allow;

  private Boolean outgoing_allow;

  private String app;
//  private JSONObject per;

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
  public Boolean getIncoming_allow() {
    return incoming_allow;
  }
  public Boolean getOutgoing_allow() {
    return outgoing_allow;
  }
  public String getApp() {
    return app;
  }
//  public JSONObject getPer() {
//    return per;
//  }

  public String getId() {
    return null;
  }
}