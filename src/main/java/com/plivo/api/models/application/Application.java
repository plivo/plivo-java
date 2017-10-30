package com.plivo.api.models.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application extends BaseResource {

  private String answerUrl;
  private String answerMethod;
  private String appId;
  private String appName;
  private Boolean defaultApp;
  private Boolean defaultEndpointApp;
  private Boolean enabled;
  private String fallbackAnswerUrl;
  private String fallbackMethod;
  private String hangupUrl;
  private String hangupMethod;
  private String messageMethod;
  private String messageUrl;
  private Boolean publicUri;
  private String resourceUri;
  private String sipUri;
  private String subAccount;

  public static ApplicationCreator creator(String appName) {
    return new ApplicationCreator(appName);
  }

  public static ApplicationUpdater updater(String id) {
    return new ApplicationUpdater(id);
  }

  public static ApplicationGetter getter(String id) {
    return new ApplicationGetter(id);
  }

  public static ApplicationDeleter deleter(String id) {
    return new ApplicationDeleter(id);
  }

  public static ApplicationLister lister() {
    return new ApplicationLister();
  }

  // FIXME DOCS
  public Boolean getDefaultEndpointApp() {
    return defaultEndpointApp;
  }

  /**
   * @return The url returning Plivo XML to be requested when a call is answered.
   */
  public String getAnswerUrl() {
    return answerUrl;
  }

  /**
   * @return The HTTP method which will be used to request the answer_url when an incoming call is
   * answered on the number or the endpoint attached to the application.
   */
  public String getAnswerMethod() {
    return answerMethod;
  }

  public String getAppId() {
    return appId;
  }

  /**
   * @return A friendly name for your Plivo application.
   */
  public String getAppName() {
    return appName;
  }

  // FIXME DOCS

  /**
   * @return Default app.
   */
  public Boolean getDefaultApp() {
    return defaultApp;
  }

  /**
   * @return Set to true if the application is enabled.
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * @return Plivo will request this URL with the same parameters sent to the answer_url if the
   * answer_url returns a non 200 HTTP status code.
   */
  public String getFallbackAnswerUrl() {
    return fallbackAnswerUrl;
  }

  /**
   * @return The HTTP method which will be used to request the fallback_answer_url when the
   * answer_url returns a non 200 HTTP status code.
   */
  public String getFallbackMethod() {
    return fallbackMethod;
  }

  /**
   * @return When the incoming call is hung up on a number or an endpoint attached to the
   * application, Plivo will send a request to the hangup_url with the attributes of the call.
   */
  public String getHangupUrl() {
    return hangupUrl;
  }

  /**
   * @return The HTTP method which will be used to request the hangup_url when an incoming call is
   * hung up on the number or the endpoint attached to the application.
   */
  public String getHangupMethod() {
    return hangupMethod;
  }

  /**
   * @return The HTTP method which will be used to request the message_url when an incoming message
   * (SMS) is received on the number attached to the application
   */
  public String getMessageMethod() {
    return messageMethod;
  }

  /**
   * @return When an incoming message (SMS) is received to a number attached to the application,
   * Plivo will make a request to the message_url with the parameters documented here.
   */
  public String getMessageUrl() {
    return messageUrl;
  }

  /**
   * @return Set to true is the application can be called from an external SIP service. By default
   * the application is not public, and external SIP services cannot call your application SIP URI.
   */
  public Boolean getPublicUri() {
    return publicUri;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  /**
   * @return The SIP URI of the application. All Plivo applications can be called directly without
   * attaching them to a number or an endpoint. When an incoming call is received on this URI, Plivo
   * will follow the same flow as it does with a number or an endpoint.
   */
  public String getSipUri() {
    return sipUri;
  }

  /**
   * @return The subaccount associated with the application. If the application belongs to the main
   * account, this field will be null.
   */
  public String getSubAccount() {
    return subAccount;
  }

  public ApplicationUpdater updater() {
    return Application.updater(appId);
  }

  public ApplicationDeleter deleter() {
    return Application.deleter(appId);
  }

  @Override
  public String getId() {
    return getAppId();
  }
}
