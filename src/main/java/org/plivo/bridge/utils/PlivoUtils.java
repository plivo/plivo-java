package org.plivo.bridge.utils;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBException;

import org.plivo.bridge.to.response.Conference;
import org.plivo.bridge.to.response.Dial;
import org.plivo.bridge.to.response.GetDigits;
import org.plivo.bridge.to.response.Hangup;
import org.plivo.bridge.to.response.Number;
import org.plivo.bridge.to.response.Play;
import org.plivo.bridge.to.response.PreAnswer;
import org.plivo.bridge.to.response.Record;
import org.plivo.bridge.to.response.RecordSession;
import org.plivo.bridge.to.response.Redirect;
import org.plivo.bridge.to.response.Reject;
import org.plivo.bridge.to.response.Response;
import org.plivo.bridge.to.response.ScheduleHangup;
import org.plivo.bridge.to.response.Speak;
import org.plivo.bridge.to.response.Wait;

import com.sun.jersey.core.util.MultivaluedMapImpl;

public abstract class PlivoUtils {

	public static class ParameterUtils {
		public static String mapToString(Map<String, String> parameters) {
			String encoded = "";
			for (String key : parameters.keySet()) {
				try {
					encoded += "&" + key + "="
					+ URLEncoder.encode(parameters.get(key), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

			encoded = encoded.substring(1);

			return encoded;
		}

		public static MultivaluedMap<String, String> mapToForm(
				Map<String, String> parameters) {
			MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
			for (String key : parameters.keySet())
				formData.add(key, parameters.get(key));

			return formData;
		}
	}

	public static class JAXBContext {

		@SuppressWarnings("rawtypes")
		private static final Class[] classes = new Class[]{
			Response.class,
			Conference.class,
			Dial.class,
			GetDigits.class,
			Hangup.class,
			Number.class,
			Play.class,
			PreAnswer.class,
			Record.class,
			RecordSession.class,
			Redirect.class,
			Reject.class,
			ScheduleHangup.class,
			Speak.class,
			Wait.class
		};

		public static javax.xml.bind.JAXBContext createContext( ) throws JAXBException {
			javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(classes);

			return context;
		}
	}
}
