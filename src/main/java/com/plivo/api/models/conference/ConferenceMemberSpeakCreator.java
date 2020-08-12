package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberSpeakCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  private final String text;
  private String voice;
  private String language;

  public ConferenceMemberSpeakCreator(String conferenceName, String memberId, String text) {
    super(conferenceName, memberId);
    this.text = text;
  }

  public String text() {
    return this.text;
  }

  public String voice() {
    return this.voice;
  }

  public String language() {
    return this.language;
  }

  public ConferenceMemberSpeakCreator voice(final String voice) {
    this.voice = voice;
    return this;
  }

  public ConferenceMemberSpeakCreator language(final String language) {
    this.language = language;
    return this;
  }


  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberSpeakCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberSpeakCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberSpeakCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  public ConferenceMemberActionResponse speak() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public ConferenceMemberSpeakCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
