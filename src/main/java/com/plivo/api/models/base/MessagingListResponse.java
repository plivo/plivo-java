package com.plivo.api.models.base;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * A generic container for all list responses.
 *
 * @param <T> The type of the contained resource.
 */
public class MessagingListResponse<T> extends BaseResponse {

  private MessagingMeta meta;
  @JsonIgnore
  private List<T> objects;
  @JsonIgnore
  private List<T> brands;
  @JsonIgnore
  private List<T> profiles;
  @JsonIgnore
  private List<T> campaigns;

  /**
   * @return The pagination-related metadata for this list response.
   */
  public MessagingMeta getMeta() {
    return meta;
  }

  /**
   * @return The actual list of objects.
   */
  public List<T> getObjects() {
    return objects;
  }


  public List<T> getBrands() {
    return brands;
  }

  public List<T> getProfiles() {
    return profiles;
  }

  public List<T> getCampaigns() {
    return campaigns;
  }
}