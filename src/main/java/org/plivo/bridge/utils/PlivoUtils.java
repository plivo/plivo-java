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

import org.plivo.bridge.to.command.ApplicationResponse;
import org.plivo.bridge.to.command.Conference;
import org.plivo.bridge.to.command.Dial;
import org.plivo.bridge.to.command.GetDigits;
import org.plivo.bridge.to.command.GetSpeech;
import org.plivo.bridge.to.command.Hangup;
import org.plivo.bridge.to.command.Number;
import org.plivo.bridge.to.command.Play;
import org.plivo.bridge.to.command.PreAnswer;
import org.plivo.bridge.to.command.Record;
import org.plivo.bridge.to.command.Redirect;
import org.plivo.bridge.to.command.SIPTransfer;
import org.plivo.bridge.to.command.Speak;
import org.plivo.bridge.to.command.Wait;

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
			if(null == parameters) return formData;
			
			for (String key : parameters.keySet())
				formData.add(key, parameters.get(key));

			return formData;
		}
	}

	public static class JAXBContext {

		@SuppressWarnings("rawtypes")
		private static final Class[] classes = new Class[]{
			ApplicationResponse.class,
			Conference.class,
			Dial.class,
			GetDigits.class,
			GetSpeech.class,
			Hangup.class,
			Number.class,
			Play.class,
			PreAnswer.class,
			Record.class,
			Redirect.class,
			SIPTransfer.class,
			Speak.class,
			Wait.class			
		};

		public static javax.xml.bind.JAXBContext createContext( ) throws JAXBException {
			javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(classes);

			return context;
		}
	}
}
