package com.plivo.helper.resource;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public class SubAccountTest {
	PlivoRestClient restClient;
	PlivoRestConf restConf;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new PlivoRestClient(this.authId, this.authToken, "v1");
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}
	
	/*@Test
	public void testGetSubAccounts() {
		try {
			SubAccountFactory saf = restClient.getSubaccounts();

			assertTrue(200 == saf.serverCode);
			assertTrue(saf.subAccountList.size() >= 0);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
*/
	@Test
	public void testGetSubAccount() throws PlivoException {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("subauth_id", "SAODDKMDVLMJCWNDG5OT");

			SubAccount sa = SubAccount.get("SAODDKMDVLMJCWNDG5OT", restConf);

			assertNotNull(sa);
			assertEquals("SAODDKMDVLMJCWNDG5OT", sa.getAuthId());
			assertEquals(true, sa.getIsEnabled());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testCreateEditDeleteSubAccount() {
		try {
			String subAuthId;
			//create
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("name", "unittest");
			params.put("enabled", "false");

			subAuthId = SubAccount.create(params, restConf);

			assertNotNull(subAuthId);

			//edit
			params = new LinkedHashMap<String, String>();

			params.put("name", "unittest_edited");
			params.put("enabled", "true");

			boolean modifResult = SubAccount.modify(subAuthId, params, restConf);

			assertTrue(modifResult);

			//verify our changes
			SubAccount sa = SubAccount.get(subAuthId, restConf);

			assertNotNull(sa);
			assertEquals(true, sa.getIsEnabled());
			assertEquals("unittest_edited", sa.getName());

			//delete
			boolean delResult = SubAccount.delete(subAuthId, restConf);
			
			assertTrue(delResult);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

}
