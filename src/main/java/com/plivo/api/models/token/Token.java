package com.plivo.api.models.token;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;
import org.json.simple.JSONObject;
import retrofit2.Call;

public class Token extends BaseResource {

  private String iss;

  public static TokenCreator creator(String iss) {
    if(!Utils.allNotNull(iss)){
      throw new IllegalArgumentException("iss cannot be null");
    }

    return new TokenCreator(iss);
  }

  public String getIss() {
    return iss;
  }

  public String getId() {
    return null;
  }
}