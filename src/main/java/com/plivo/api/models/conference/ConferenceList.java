package com.plivo.api.models.conference;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class ConferenceList extends BaseResource {

  private List<String> conferences;

  public List<String> getConferences() {
    return conferences;
  }

  @Override
  public String getId() {
    return getApiId();
  }
}
