package org.plivo.bridge.server;
/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-28
 * @author Paulo reis
 */

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;

public class GrizzlyServer {

	HttpServer server;
	int port;
	ExecutorService executor;

	public GrizzlyServer(int port) {
		this.port = port;
	}

	public void start( ServiceHandler... handlers ) throws IOException {
		server = HttpServer.createSimpleServer("/plivoCallbackServer", port);

		for(ServiceHandler handler: handlers)
			server.getServerConfiguration().addHttpHandler(handler.getHandler(), handler.getContext());

				executor = Executors.newSingleThreadExecutor();
				executor.submit(new Runnable() {
					@Override
					public void run() {
						try {
							server.start();
							System.out.println("Waiting some input to kill the server ...");
							System.in.read();
							server.stop();
							executor.shutdown();
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				});	
	}

	public boolean isShutdown( ) {
		return executor.isShutdown();
	}

	public static final class ServiceHandler {
		private String context;
		private HttpHandler handler;

		public ServiceHandler(String context, HttpHandler handler) {
			this.setContext(context);
			this.setHandler(handler);
		}

		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public HttpHandler getHandler() {
			return handler;
		}
		public void setHandler(HttpHandler handler) {
			this.handler = handler;
		}
	}

	public void stop() {
		server.stop();
	}
}
