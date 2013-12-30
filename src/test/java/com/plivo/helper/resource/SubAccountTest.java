package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class SubAccountTest {
	PlivoRestConf restConf;
	private final String authId = "MAMJFLMZJKMZE0OTZHNT";
	private final String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}

	@Test
	public void testGet() throws PlivoException {
		try {
			SubAccount sa = SubAccount.get("SAODDKMDVLMJCWNDG5OT", restConf);

			assertNotNull(sa);
			assertEquals("SAODDKMDVLMJCWNDG5OT", sa.getAuthId());
			assertEquals(true, sa.getIsEnabled());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testCreateEditDelete() {
		try {
			String subAuthId;
			// create
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("name", "unittest");
			params.put("enabled", "false");

			subAuthId = SubAccount.create(params, restConf);

			assertNotNull(subAuthId);
			// edit
			params = new LinkedHashMap<String, String>();

			params.put("name", "unittest_edited");
			params.put("enabled", "true");

			SubAccount.modify(subAuthId, params, restConf);

			// verify our changes
			SubAccount sa = SubAccount.get(subAuthId, restConf);

			assertNotNull(sa);
			assertEquals(true, sa.getIsEnabled());
			assertEquals("unittest_edited", sa.getName());

			// delete it
			SubAccount.delete(subAuthId, restConf);

		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			SubAccountList sal = SubAccount.getList(params, restConf);
			String subAuthIdToFind = "SAODDKMDVLMJCWNDG5OT";
			boolean found = false;

			assertNotNull(sal);
			assertTrue(sal.getList().size() >= 5);
			for (SubAccount sa : sal.getList()) {
				if (sa.getAuthId().equals(subAuthIdToFind)) {
					found = true;
					break;
				}
			}
			if (found == false) {
				fail("Couldn't find our subAuthId");
			}
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetListWithLimit() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("limit", "2");

			SubAccountList sal = SubAccount.getList(params, restConf);

			assertNotNull(sal);
			System.out
					.println("total count = " + sal.getMeta().getTotalCount());
			assertTrue(sal.getMeta().getLimit() == 2);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
