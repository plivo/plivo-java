package com.plivo.examples;

import com.plivo.api.PlivoClient;
import com.plivo.api.PlivoRestClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.account.Account;

import com.plivo.api.Plivo;
import com.plivo.api.models.account.AccountUpdateResponse;
import com.plivo.api.models.account.Subaccount;
import com.plivo.api.models.account.SubaccountCreateResponse;

import java.io.IOException;

public class Accounts {
  private static final String authId = "MANTXXXXXXXXXXXXXXXX";
  private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  private static PlivoClient client = new PlivoRestClient(authId, authToken).getClient();

  public static void main(String[] args) {
    Plivo.init(authId, authToken);
//    getAccountInfo();
//    getAccountInfoBySettingClient();
//    modifyAccount();
//    modifyAccountBySettingClient();
    createSubAccount();
//    createSubAccountBySettingClient();

  }

  // trying to get account info without setting the client
  private static void getAccountInfo() {
    try {
      Account response = Account.getter()
        .get();
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // trying to get account info by setting the client
  private static void getAccountInfoBySettingClient() {
    try {
      Account response = Account.getter()
        .client(client)
        .get();
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // update account
  private static void modifyAccount() {
    try {
      AccountUpdateResponse response = Account.updater()
        .address("Test Address")
        .update();
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // update account with different client settings
  private static void modifyAccountBySettingClient() {
    try {
      AccountUpdateResponse response = Account.updater()
        .city("Test city")
        .client(client)
        .update();
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // create subaccount
  private static void createSubAccount() {
    try {
      SubaccountCreateResponse subaccount = Subaccount.creator("Test")
        .enabled(true)
        .create();
      System.out.println(subaccount);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // create subaccount with different client settings
  private static void createSubAccountBySettingClient() {
    try {
      SubaccountCreateResponse subaccount = Subaccount.creator("Test 2")
        .enabled(true)
        .client(client)
        .create();
      System.out.println(subaccount);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

}
