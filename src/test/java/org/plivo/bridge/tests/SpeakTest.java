package org.plivo.bridge.tests;
/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-28
 * @author Paulo reis
 */

import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.plivo.bridge.base.BasePlivoTest;
import org.plivo.bridge.server.GrizzlyServer.ServiceHandler;
import org.plivo.bridge.to.callback.AnsweredCallback;
import org.plivo.bridge.to.callback.HangupCallback;
import org.plivo.bridge.to.command.ApplicationResponse;
import org.plivo.bridge.to.command.Speak;
import org.plivo.bridge.to.response.CallResponse;
import org.plivo.bridge.util.PlivoTestUtils;
import org.plivo.bridge.utils.PlivoUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=false)
public class SpeakTest extends BasePlivoTest {
	
	@Test(enabled=false)
	public void testSpeak( ) throws Exception {
		
		ServiceHandler ringHandler = new ServiceHandler("/ringing/*", 
				new HttpHandler() {
					@Override
					public void service(Request req, Response resp) throws Exception {
						System.out.println("got ringing!");
						resp.getWriter().write("Ok");
						resp.getWriter().flush();
						resp.getWriter().close();
					}
				});
		
		ServiceHandler answerHandler = new ServiceHandler("/answered/*", 
				new HttpHandler() {
					@Override
					public void service(Request req, Response resp) throws Exception {
						System.out.println("got answered!");
						
						AnsweredCallback callback = AnsweredCallback.create(PlivoTestUtils.mapToSingleValue(req.getParameterMap()));
						System.out.println(callback);
						
						Assert.assertNotNull(callback);
						Assert.assertNotNull(callback.getCallUUID());
						
						ApplicationResponse ar = new ApplicationResponse();
						Speak s = new Speak();
						s.setValue("Hello World");
						ar.setSpeak(s);
						
						PlivoUtils.JAXBContext.createContext().createMarshaller().marshal(ar, resp.getWriter());
					}
				});
		
		ServiceHandler hangupHandler = new ServiceHandler("/hangup/*", 
				new HttpHandler() {
					@Override
					public void service(Request req, Response resp) throws Exception {
						System.out.println("got hangup!");
						
						HangupCallback callback = HangupCallback.create(PlivoTestUtils.mapToSingleValue(req.getParameterMap()));
						System.out.println(callback);
						
						Assert.assertNotNull(callback);
						Assert.assertNotNull(callback.getCallUUID());
						
						resp.getWriter().write("Ok");
						resp.getWriter().flush();
						resp.getWriter().close();
						
						stop();
					}
				});
		
		startServer(ringHandler, answerHandler, hangupHandler);
		
		Map<String, String> parameters = 
				new HashMap<String, String>();
		
		parameters.put("From", "9999");
		parameters.put("To", "1001");

		parameters.put("Gateways", PlivoTestUtils.GATEWAYS);
		parameters.put("GatewayCodecs", PlivoTestUtils.GATEWAY_CODECS);
		parameters.put("GatewayTimeouts", PlivoTestUtils.GATEWAY_TIMEOUTS);
		parameters.put("GatewayRetries", PlivoTestUtils.GATEWAY_RETRIES);
		parameters.put("ExtraDialString", PlivoTestUtils.EXTRA_DIAL_STRING);
		
		parameters.put("HangupUrl", PlivoTestUtils.getCallbackUrl()+"/hangup/");
		parameters.put("RingUrl", PlivoTestUtils.getCallbackUrl()+"/ringing/");
		parameters.put("AnswerUrl", PlivoTestUtils.getCallbackUrl()+"/answered/");
		
		CallResponse result = client.call().single(parameters);
		
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getRequestUUID());
		Assert.assertEquals(result.isSuccess(), true);
	}
}
