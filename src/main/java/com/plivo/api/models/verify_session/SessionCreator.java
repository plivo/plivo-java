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
  @JsonProperty("url")
  private String url;
  private String method = "POST";

  SessionCreator(String appUUID,String recipient, String channel, String url, String method) {
    if (!Utils.allNotNull(recipient)) {
      throw new IllegalArgumentException("recipient should not be null");
    }
    this.appUUID = appUUID;
    this.recipient = recipient;
    this.channel = channel;
    this.url = url;
    this.method = method;
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
  public String url() {
    return this.url;
  }
  public String method() {
    return this.method;
  }

  @Override
  protected Call<SessionCreateResponse> obtainCall() {
    return client().getApiService().sessionSend(client().getAuthId(), this);
  }

}
