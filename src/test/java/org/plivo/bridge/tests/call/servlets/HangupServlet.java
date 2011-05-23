package org.plivo.bridge.tests.call.servlets;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.plivo.bridge.to.callback.HangupCallback;
public class HangupServlet extends HttpServlet {
	private static final long serialVersionUID = 6099116728365114314L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hangup POST!");
		
		HangupCallback callback = HangupCallback.create(req);
		
		System.out.println(callback.getReason());
	}
}