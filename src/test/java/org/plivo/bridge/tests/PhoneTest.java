package com.plivo.bridge.tests;
/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2011-08-28
 * .
 */

import java.util.HashMap;
import java.util.Map;

import com.plivo.bridge.base.BasePlivoTest;
import com.plivo.bridge.to.response.CallResponse;
import com.plivo.bridge.util.PlivoTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=false)
public class PhoneTest extends BasePlivoTest {
	
	@Test(enabled=false)
	public void testSearch( ) throws Exception {
		
		Map<String, String> parameters = 
				new HashMap<String, String>();
		
		parameters.put("AreaCode", "312");
		parameters.put("ExchangeCode", "312");
	    parameters.put("Quantity", "5");
	    
		CallResponse result = client.phone().search(parameters);
		
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.isSuccess(), true);
	}
	
	@Test(enabled=false)
	public void testOrder( ) throws Exception {
		
		Map<String, String> parameters = 
				new HashMap<String, String>();
		
		parameters.put("AreaCode", "312");
		parameters.put("ExchangeCode", "312");
		parameters.put("AnswerUrl", PlivoTestUtils.getCallbackUrl()+"/answer");
		parameters.put("HangupUrl", PlivoTestUtils.getCallbackUrl()+"/hangup");
		parameters.put("Description", " Phone Order");
		parameters.put("Method", "POST");
	    
		CallResponse result = client.phone().order(parameters);
		
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.isSuccess(), true);
	}
}
