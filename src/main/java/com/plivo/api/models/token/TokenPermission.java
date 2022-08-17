package com.plivo.api.models.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenPermission {
  @JsonProperty("voice")
  VoicePermission voice;

  public TokenPermission() {
    this.voice = new VoicePermission();
  }
}

class VoicePermission {
  @JsonProperty("incoming_allow")
  Boolean incomingAllow;

  @JsonProperty("outgoing_allow")
  Boolean outgoingAllow;

  public VoicePermission() {
    this.incomingAllow = false;
    this.outgoingAllow = false;
  }
}
