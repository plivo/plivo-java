package org.plivo.bridge.server;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.plivo.bridge.to.callback.AnsweredCallback;
import org.plivo.bridge.to.callback.CallbackStatus;
import org.plivo.bridge.to.callback.HangupCallback;
import org.plivo.bridge.to.callback.RingingCallback;
import org.plivo.bridge.to.command.ApplicationResponse;
import org.plivo.bridge.to.command.Dial;
import org.plivo.bridge.to.command.Speak;
import org.plivo.bridge.util.PlivoTestUtils;
import org.plivo.bridge.utils.PlivoUtils;

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

	public static void main(String[] args) throws Exception {
		GrizzlyServer server = new GrizzlyServer(5151);

		ServiceHandler[] handlers = new ServiceHandler[]{
				new ServiceHandler("/ringing/*", 
						new HttpHandler() {
					@Override
					public void service(Request request, Response response) throws Exception {
						dumpRequestParameters("ringing", request);
						response.setContentType("text/html");
						response.getWriter().write("ringing");
						
						RingingCallback callback = RingingCallback.create(PlivoTestUtils.mapToSingleValue(request.getParameterMap()));
						System.out.println(callback.getStatus());
						
						response.getWriter().flush();
					}
				}),
				new ServiceHandler("/answered/*", 
						new HttpHandler() {
					@Override
					public void service(Request request, Response response) throws Exception {
						dumpRequestParameters("answered", request);
						
						AnsweredCallback callback = AnsweredCallback.create(PlivoTestUtils.mapToSingleValue(request.getParameterMap()));
						System.out.println(callback.getStatus());
						
						ApplicationResponse resp = new ApplicationResponse();
						Speak speak = new Speak();
						speak.setValue("Dial Test");
						Dial dial = new Dial();
						dial.setAction("http://186.210.225.112:5151/callbackStatus/");

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
						dumpRequestParameters("hangup", request);
						response.setContentType("text/html");
						response.getWriter().write("hangup");
						
						HangupCallback callback = HangupCallback.create(PlivoTestUtils.mapToSingleValue(request.getParameterMap()));

						System.out.println(callback.getStatus());
						
						response.getWriter().flush();
					}
				}),				
				new ServiceHandler("/callbackStatus/*", 
						new HttpHandler() {
					@Override
					public void service(Request request, Response response) throws Exception {
						dumpRequestParameters("callback", request);
						response.setContentType("text/html");
						response.getWriter().write("callback");
						
						CallbackStatus callback = CallbackStatus.create(PlivoTestUtils.mapToSingleValue(request.getParameterMap()));
						System.out.println(callback.getStatus());
						
						response.getWriter().flush();
					}
				})				
		};

		server.start(handlers);
	}
	
	private static synchronized void dumpRequestParameters(String info, Request request) {
		System.out.println("INFO IS => "+info);
		Iterator<String> iterator = request.getParameterNames().iterator();
		String parameter = null;
		while(iterator.hasNext()) {
			parameter = iterator.next();
			System.out.println("["+parameter+"] => "+request.getParameter(parameter));
		}
	}

	public void stop() {
		server.stop();
	}
}
