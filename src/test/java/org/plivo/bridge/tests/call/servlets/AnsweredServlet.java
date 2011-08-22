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
import javax.xml.bind.JAXBException;

import org.plivo.bridge.to.callback.AnsweredCallback;
import org.plivo.bridge.to.command.GetDigits;
import org.plivo.bridge.to.command.ApplicationResponse;
import org.plivo.bridge.utils.PlivoUtils;
public class AnsweredServlet extends HttpServlet {
	private static final long serialVersionUID = 6099116728365114314L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("answered POST!");
		
		AnsweredCallback callback = AnsweredCallback.create(req);
		
		System.out.println(callback.getCallUUID());
		
		ApplicationResponse r = new ApplicationResponse();
		GetDigits digits = new GetDigits();
		digits.setNumDigits(1);
		digits.setValidDigits("123");
		digits.setPlayBeep(true);
		digits.setRetries(2);
		r.setGetDigits(digits);
		
		try {
			PlivoUtils.JAXBContext.createContext().createMarshaller().marshal(r, resp.getOutputStream());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}