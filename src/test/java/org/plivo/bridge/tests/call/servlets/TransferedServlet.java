package org.plivo.bridge.tests.call.servlets;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TransferedServlet extends HttpServlet {
	private static final long serialVersionUID = 6099116728365114314L;
	
	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("transfered POST!");
		
		Enumeration<String> names = req.getParameterNames();
		String name = null;
		while(names.hasMoreElements()) {
			name = names.nextElement();
			System.out.println(name+" = "+req.getParameter(name));
		}
	}
}