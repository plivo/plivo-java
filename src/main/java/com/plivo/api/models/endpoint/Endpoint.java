package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;

public class Endpoint extends BaseResource {

  private String alias;
  private String application;
  private String endpointId;
  private String resourceUri;
  private String sipExpires;
  private String sipRegistered;
  private String sipUri;
  private String sipContact;
  private String sipUserAgent;
  private String subAccount;
  private String username;
  private String password;

  public static EndpointCreator creator(String username, String password, String alias) {
    if (!Utils.allNotNull(username, password, alias)) {
      throw new IllegalArgumentException("username, password and alias cannot be null");
    }

    return new EndpointCreator(username, password, alias);
  }

  public static EndpointLister lister() {
    return new EndpointLister();
  }

  public static EndpointGetter getter(String id) {
    return new EndpointGetter(id);
  }

  public static EndpointUpdater updater(String id) {
    return new EndpointUpdater(id);
  }

  public static EndpointDeleter deleter(String id) {
    return new EndpointDeleter(id);
  }

  /**
   * @return The contact field contains the address at which the callee can reach the caller for
   * future requests. It is the IP on which the SIP client is registered.
   */
  public String getSipContact() {
    return sipContact;
  }

  /**
   * @return Friendly name for your endpoint.
   */
  public String getAlias() {
    return alias;
  }

  public String getApplication() {
    return application;
  }

  /**
   * @return A unique ID for your endpoint. All API operations will be performed with this ID.
   */
  public String getEndpointId() {
    return endpointId;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  /**
   * @return Time when the SIP registration will expire. Major SIP clients, Plivo WebSDK and Plivo
   * mobile SDKs will re-register the endpoint before the registration expires.
   */
  public String getSipExpires() {
    return sipExpires;
  }

  /**
   * @return true if the SIP endpoint is registered on a SIP client.
   */
  public String getSipRegistered() {
    return sipRegistered;
  }

  /**
   * @return The SIP URI of the endpoint. External users will be able to call this endpoint on this
   * SIP URI.
   */
  public String getSipUri() {
    return sipUri;
  }

  /**
   * @return The User Agent of SIP client used to register this endpoint. In the case of WebSDK this
   * field will be plivo-websdk.
   */
  public String getSipUserAgent() {
    return sipUserAgent;
  }

  /**
   * @return The sub account in your Plivo account, if this endpoint belongs to a Plivo sub account.
   */
  public String getSubAccount() {
    return subAccount;
  }

  /**
   * @return Username of your endpoint. Plivo appends a 12 digit code in front your username.
   */
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public EndpointUpdater updater() {
    return Endpoint.updater(endpointId);
  }

  public EndpointDeleter deleter() {
    return Endpoint.deleter(endpointId);
  }

  @Override
  public String getId() {
    return getEndpointId();
  }
}
