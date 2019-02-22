package com.plivo.examples;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.account.Account;

import com.plivo.api.Plivo;
import com.plivo.api.models.account.AccountUpdateResponse;
import com.plivo.api.models.account.Subaccount;
import com.plivo.api.models.account.SubaccountCreateResponse;
import com.plivo.api.models.base.ListResponse;

import java.io.IOException;

public class Accounts {

//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createSubAccount();
	}

	// Example to get Account details
	// Client is set by Plivo.init helper method in main()
	private static void getAccountInfo() {
		try {
			Account response = Account.getter()
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get Account details with client
	// Client is set explicitly as shown below 
	private static void getAccountWithClient() {
		try {
			Account response = Account.getter()
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to update Account details
	// Client is set by Plivo.init helper method in main()

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

	// Example to update Account details with client
	// Client is set explicitly as shown below 

	private static void modifyAccountWithClient() {
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

	// Example to create a sub-account 
	//Client is set by Plivo.init helper method in main()

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
	
	// Example to create a sub-account
	// Client is set explicitly as shown below 
	
	private static void createSubAccountWithClient() {
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


	// Example to list all sub-accounts
	// Client is set by Plivo.init helper method in main()

	private static void listAllSubAccount() {
		try {
			ListResponse<Subaccount> response  = Subaccount.lister()
					.limit(5)
          .offset(0)
          .list();
		
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// Example to list all sub accounts with client
	// Client is set explicitly as shown below 

	private static void listAllSubAccountWithClient() {
		try {
			ListResponse<Subaccount> response  = Subaccount.lister()
					.client(client)
					.limit(5)
          .offset(0)
          .list();
		
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
	


	// Example to delete a sub-account
	//Client is set by Plivo.init helper method in main()

	private static void deleteSubAccount() {
		try {
			Subaccount.deleter("sub_account_id").delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete sub-account with client
	// Client is set explicitly as shown below 

	private static void deleteSubAccountWithClient() {
		try {
			Subaccount.deleter("sub_account_id").client(client).delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

}
