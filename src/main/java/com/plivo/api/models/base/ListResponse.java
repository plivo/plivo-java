package com.plivo.api.models.base;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * A generic container for all list responses.
 *
 * @param <T> The type of the contained resource.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse<T> extends BaseResponse {

  private Meta meta;
  private List<T> objects;
  private List<T> brands;
  private List<T> profiles;
  private List<T> campaigns;
  private List<T> sessions;
  private Response response;

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
  public List<T> getSessions() {
    return sessions;
  }
  public Response getResponse() {
    return response;
  }
}