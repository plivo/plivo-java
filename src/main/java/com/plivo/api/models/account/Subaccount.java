package com.plivo.api.models.account;

import com.plivo.api.models.base.BaseResource;

public class Subaccount extends BaseResource {

  private String account;
  private String apiId;
  private String authId;
  private String authToken;
  private String newAuthToken;
  private String created;
  private Boolean enabled;
  private String modified;
  private String name;
  private String resourceUri;

  public static SubaccountCreator creator(String name) {
    return new SubaccountCreator(name);
  }

  public static SubaccountDeleter deleter(String id) {
    return new SubaccountDeleter(id);
  }

  public static SubaccountUpdater updater(String id, String name) {
    return new SubaccountUpdater(id, name);
  }

  public static SubaccountLister lister() {
    return new SubaccountLister();
  }

  public static SubaccountGetter getter(String id) {
    return new SubaccountGetter(id);
  }

  public String getNewAuthToken() {
    return newAuthToken;
  }

  public String getAccount() {
    return account;
  }

  public String getApiId() {
    return apiId;
  }

  @Override
  public String getId() {
    return getAuthId();
  }

  /**
   * @return The auth ID of the subaccount.
   */
  public String getAuthId() {
    return authId;
  }

  /**
   * @return The auth token of the subaccount.
   */
  public String getAuthToken() {
    return authToken;
  }

  /**
   * @return The date on which the subaccount was created.
   */
  public String getCreated() {
    return created;
  }

  /**
   * @return Status of the account if it is available.
   */
  public Boolean getEnabled() {
    return enabled;
  }

  public String getModified() {
    return modified;
  }

  /**
   * @return Name of the subaccount.
   */
  public String getName() {
    return name;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public SubaccountDeleter deleter() {
    return Subaccount.deleter(authId);
  }

  public SubaccountUpdater updater(String name) {
    return Subaccount.updater(authId, name);
  }
}
