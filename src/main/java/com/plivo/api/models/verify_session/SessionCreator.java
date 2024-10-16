package com.plivo.api.models.verify_session;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

import java.net.URL;

public class SessionCreator extends Creator < SessionCreateResponse > {
  @JsonProperty("app_uuid")
  private String appUUID;
  @JsonProperty("recipient")
  private String recipient;
  @JsonProperty("channel")
  private String channel;
  @JsonProperty("locale")
  private String locale;
  @JsonProperty("brand_name")
  private String brand_name;
  @JsonProperty("app_hash")
  private String app_hash;
  @JsonProperty("code_length")
  private Integer code_length;
  @JsonProperty("url")
  private String url;
  private String method = "POST";
  @JsonProperty("dtmf")
  private Integer dtmf;
  @JsonProperty("fraud_check")
  private String fraud_check;

  SessionCreator(String appUUID,String recipient, String channel, String url, String method, String locale, String brand_name, String app_hash, Integer code_length, Integer dtmf, String fraud_check) {
    if (!Utils.allNotNull(recipient)) {
      throw new IllegalArgumentException("recipient should not be null");
    }
    this.appUUID = appUUID;
    this.recipient = recipient;
    this.channel = channel;
    this.locale = locale;
    this.url = url;
    this.method = method;
    this.brand_name = brand_name;
    this.app_hash = app_hash;
    this.code_length = code_length;
    this.dtmf = dtmf;
    this.fraud_check = fraud_check;
  }

  public String appUUID() {
    return this.appUUID;
  }
  public String recipient() {
    return this.recipient;
  }
  public String channel() {
    return this.channel;
  }
  public String locale() {
    return this.locale;
  }
  public String url() {
    return this.url;
  }
  public String method() {
    return this.method;
  }
  public String brand_name() {
    return this.brand_name;
  }
  public String app_hash() {
    return this.app_hash;
  }
  public Integer code_length(){
    return this.code_length;
  }
   public Integer dtmf(){
    return this.dtmf;
  }
  public String fraud_check(){
    return this.fraud_check;
  }

  @Override
  protected Call<SessionCreateResponse> obtainCall() {
    return client().getApiService().sessionSend(client().getAuthId(), this);
  }

}
