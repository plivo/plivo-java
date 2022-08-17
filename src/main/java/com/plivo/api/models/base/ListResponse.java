package com.plivo.api.models.base;

import java.util.List;

/**
 * A generic container for all list responses.
 *
 * @param <T> The type of the contained resource.
 */
public class ListResponse<T> extends BaseResponse {

  private Meta meta;
  private List<T> objects;
  private List<T> brands;
  private List<T> profiles;
  private List<T> campaigns;

  /**
   * @return The pagination-related metadata for this list response.
   */
  public Meta getMeta() {
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