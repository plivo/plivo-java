package com.plivo.api.models.account;

import com.plivo.api.models.base.BaseResource;

public class Account extends BaseResource {

  private AccountType accountType;
  private String address;
  private String authId;
  private Boolean autoRecharge;
  private BillingMode billingMode;
  private String cashCredits;
  private String city;
  private String name;
  private String resourceUri;
  private String state;
  private String timezone;

  public static AccountGetter getter() {
    return new AccountGetter();
  }

  public static AccountUpdater updater() {
    return new AccountUpdater();
  }

  /**
   * @return The type of your Plivo account. All accounts with funds are standard accounts. If your
   * account is on free trial, this attribute will return {@link AccountType#DEVELOPER}.
   */
  public AccountType getAccountType() {
    return accountType;
  }

  /**
   * @return The postal address of the account which will be reflected in the invoices.
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return The auth id of the account.
   */
  public String getAuthId() {
    return authId;
  }

  /**
   * @return Auto recharge settings associated with the account. If this value is true, we will
   * recharge your account if the credits fall below a certain threshold.
   */
  public Boolean getAutoRecharge() {
    return autoRecharge;
  }

  /**
   * @return The billing mode of the account.
   * @see BillingMode
   */
  public BillingMode getBillingMode() {
    return billingMode;
  }

  /**
   * @return Credits of the account.
   */
  public String getCashCredits() {
    return cashCredits;
  }

  /**
   * @return The city of the account.
   */
  public String getCity() {
    return city;
  }

  /**
   * @return The name of the account holder.
   */
  public String getName() {
    return name;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  /**
   * @return The state of the account holder.
   */
  public String getState() {
    return state;
  }

  /**
   * @return The timezone of the account.
   * @see <a href="http://en.wikipedia.org/wiki/List_of_IANA_time_zones">IANA Timezones</a>
   */
  public String getTimezone() {
    return timezone;
  }

  @Override
  public String getId() {
    return getAuthId();
  }
}
