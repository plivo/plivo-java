package com.plivo.api.models.conference;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;

public abstract class ConferenceMemberDeleterAction<T extends BaseResource> extends Deleter<T> {

  protected final String conferenceName;

  public ConferenceMemberDeleterAction(String conferenceName, String id) {
    super(id);
    this.conferenceName = conferenceName;
  }

  public void stop() throws IOException, PlivoRestException {
    delete();
  }
}
