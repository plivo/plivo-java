package org.plivo.bridge.base;
/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-28
 * @author Paulo reis
 */

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.server.GrizzlyServer;
import org.plivo.bridge.server.GrizzlyServer.ServiceHandler;
import org.plivo.bridge.util.PlivoTestUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BasePlivoTest {
	
	protected PlivoClient client;
	ExecutorService executor;
	GrizzlyServer server;
	
	@BeforeClass
	public void createClient( ) {
		client = 
				PlivoClient.create(
						PlivoTestUtils.getAccountId(), 
						PlivoTestUtils.getAuthToken(), 
						PlivoTestUtils.getPlivoUrl(), 
						true);
	}
	
	@BeforeTest
	public void startExecutor( ) {
		executor = Executors.newSingleThreadExecutor();
		server = new GrizzlyServer(5151);
	}
	
	@AfterTest
	public void stopExecutor( ) throws InterruptedException {
		executor.awaitTermination(10, TimeUnit.MINUTES);
		server.stop();
		server = null;
	}
		
	protected void startServer(final ServiceHandler... handlers) {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				try {
					server.start(handlers);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected void stop( ) throws InterruptedException {
		server.stop();
		executor.shutdown();
	}
}
