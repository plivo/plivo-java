package com.plivo.bridge.base;
/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2011-08-28
 * .
 */

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.plivo.bridge.client.PlivoClient;
import com.plivo.bridge.server.GrizzlyServer;
import com.plivo.bridge.server.GrizzlyServer.ServerShutdownCallback;
import com.plivo.bridge.server.GrizzlyServer.ServiceHandler;
import com.plivo.bridge.util.PlivoTestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
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
						true);
	}
	
	@BeforeMethod
	public void startExecutor( ) {
		executor = Executors.newSingleThreadExecutor();
		server = new GrizzlyServer(5151, new ServerShutdownCallback() {
			@Override
			public void terminated() {
				executor.shutdownNow();
			}
		});
	}
	
	@AfterMethod
	public void stopExecutor( ) throws InterruptedException {
		executor.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("Killing server and executor!");
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
