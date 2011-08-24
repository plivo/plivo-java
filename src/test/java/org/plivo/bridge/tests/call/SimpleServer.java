package org.plivo.bridge.tests.call;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Servlet;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.plivo.bridge.tests.call.servlets.AnsweredServlet;
import org.plivo.bridge.tests.call.servlets.HangupServlet;
import org.plivo.bridge.tests.call.servlets.RingingServlet;
import org.plivo.bridge.tests.call.servlets.TransferedServlet;

public class SimpleServer {
	private Server server;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	private ServletContainer[] containers;
	private int port;
	
	public SimpleServer(int port, ServletContainer... containers) {
		this.containers = containers;
		this.port = port;
	}
	
	public void start( ) {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				server = new Server(port);
				Context root = new Context(server, "/", Context.SESSIONS);
				for(ServletContainer c: containers)
					try {
						System.out.println("Adding clazz '"+c.getClazz()+"' on path '/"+c.getPath()+"' ...");
						root.addServlet(new ServletHolder(c.getClazz().newInstance()), 
								"/"+c.getPath());
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				System.out.println("Starting server ... type 'exit' to kill");
				try {
					server.start();
				} catch(Exception e) {
					
				}
				
				BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
				
				try {
					while(!buff.readLine().equals("exit"));
				} catch (IOException e) {
				}
				
				SimpleServer.this.stop();
			}
		});
	}

	public void stop() {
		System.out.println("Killing server ...");
		
		try {
			server.stop();
		} catch (Exception e) {
		}
		
		executor.shutdown();
	}

	public static void main(String[] args) throws Exception {
		SimpleServer ss = new SimpleServer(5151,
				new SimpleServer.ServletContainer(AnsweredServlet.class, "answered"),
				new SimpleServer.ServletContainer(RingingServlet.class, "ringing"),
				new SimpleServer.ServletContainer(HangupServlet.class, "hangup"),
				new SimpleServer.ServletContainer(TransferedServlet.class, "transfered"));
		
		ss.start();
		
		while(!ss.executor.isShutdown()) Thread.sleep(5000);
	}
	
	public static final class ServletContainer implements Serializable {
		private static final long serialVersionUID = 3582803487610937062L;
		
		private Class<? extends Servlet> clazz;
		private String path;
		
		public ServletContainer(Class<? extends Servlet> clazz, String path) {
			this.setClazz(clazz);
			this.setPath(path);
		}
		
		public Class<? extends Servlet> getClazz() {
			return clazz;
		}
		public void setClazz(Class<? extends Servlet> clazz) {
			this.clazz = clazz;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
	}
}
