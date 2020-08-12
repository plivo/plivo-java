package com.plivo.api.models.call;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.util.Utils;
import java.io.IOException;
import retrofit2.Call;

public class CallUpdater extends VoiceUpdater<CallUpdateResponse> {

  LegSpecifier legs;
  String alegUrl;
  String alegMethod;
  String blegUrl;
  String blegMethod;

  public CallUpdater(String id) {
    super(id);
  }

  public LegSpecifier legs() {
    return this.legs;
  }

  public String alegUrl() {
    return this.alegUrl;
  }

  public String alegMethod() {
    return this.alegMethod;
  }

  public String blegUrl() {
    return this.blegUrl;
  }

  public String blegMethod() {
    return this.blegMethod;
  }

  /**
   * @param legs Which leg to transfer.
   */
  public CallUpdater legs(final LegSpecifier legs) {
    this.legs = legs;
    return this;
  }

  /**
   * @param alegUrl URL to transfer for aleg, if legs is aleg or both, then aleg_url has to be
   * specified.
   */
  public CallUpdater alegUrl(final String alegUrl) {
    this.alegUrl = alegUrl;
    return this;
  }

  /**
   * @param alegMethod HTTP method to invoke aleg_url. Defaults to POST.
   */
  public CallUpdater alegMethod(final String alegMethod) {
    this.alegMethod = alegMethod;
    return this;
  }

  /**
   * @param blegUrl URL to transfer for bridged leg, if legs is bleg or both, then bleg_url has to
   * be specified.
   */
  public CallUpdater blegUrl(final String blegUrl) {
    this.blegUrl = blegUrl;
    return this;
  }

  /**
   * @param blegMethod HTTP method to invoke bleg_url. Defaults to POST.
   */
  public CallUpdater blegMethod(final String blegMethod) {
    this.blegMethod = blegMethod;
    return this;
  }

  @Override
  protected void validate() {
    super.validate();

    if (!Utils.anyNotNull(alegMethod, alegUrl, blegMethod, blegUrl, legs)) {
      throw new IllegalStateException("at least one param should be non null");
    }
  }

  @Override
  protected Call<CallUpdateResponse> obtainCall() {
    return client().getVoiceApiService().callUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallUpdateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<CallUpdateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callUpdate(client().getAuthId(), id, this);
  }

  public CallUpdateResponse transfer() throws IOException, PlivoRestException {
    return update();
  }
}
