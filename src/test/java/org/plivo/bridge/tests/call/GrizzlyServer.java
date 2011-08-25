package org.plivo.bridge.tests.call;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.plivo.bridge.to.command.ApplicationResponse;
import org.plivo.bridge.to.command.Dial;
import org.plivo.bridge.to.command.Speak;
import org.plivo.bridge.utils.PlivoUtils;

public class GrizzlyServer {
	
	HttpServer server;
	String address;
	int port;
	ExecutorService executor;
	
	public GrizzlyServer(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void start( ServiceHandler... handlers ) throws IOException {
		server = HttpServer.createSimpleServer();
		NetworkListener networkListener = new NetworkListener("main-listener", address, port);
		server.addListener(networkListener);
		
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
	
	public static void main(String[] args) throws Exception {
		GrizzlyServer server = new GrizzlyServer("0.0.0.0", 5151);
		
		ServiceHandler[] handlers = new ServiceHandler[]{
			new ServiceHandler("/ringing/*", 
					new HttpHandler() {
						@Override
						public void service(Request request, Response response) throws Exception {
							System.out.println("gotcha hinging!");
							response.setContentType("text/html");
							response.getWriter().write("ringing");
							response.getWriter().flush();
						}
					}),
			new ServiceHandler("/answered/*", 
					new HttpHandler() {
						@Override
						public void service(Request request, Response response) throws Exception {
							System.out.println("gotcha answered!");
							ApplicationResponse resp = new ApplicationResponse();
							Speak speak = new Speak();
							speak.setValue("Dial Test");
							Dial dial = new Dial();
							
							org.plivo.bridge.to.command.Number number = new org.plivo.bridge.to.command.Number();
							number.setNumber("1001");
							number.setGateways("user/,user/");
							number.setGatewayTimeouts(30);
							dial.setNumber(number);
							resp.setDial(dial);
							
							PlivoUtils.JAXBContext.createContext().createMarshaller().marshal(resp, response.getWriter());
							response.getWriter().flush();
						}
					}),				
			new ServiceHandler("/hangup/*", 
					new HttpHandler() {
						@Override
						public void service(Request request, Response response) throws Exception {
							System.out.println("gotcha hangup!");
							response.setContentType("text/html");
							response.getWriter().write("hangup");
							response.getWriter().flush();
						}
					})				
		};
		
		server.start(handlers);
	}

	public void stop() {
		server.stop();
	}
}
