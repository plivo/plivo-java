package com.plivo.bridge.utils;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBException;

import com.plivo.bridge.to.command.ApplicationResponse;
import com.plivo.bridge.to.command.Conference;
import com.plivo.bridge.to.command.Dial;
import com.plivo.bridge.to.command.GetDigits;
import com.plivo.bridge.to.command.Hangup;
import com.plivo.bridge.to.command.Number;
import com.plivo.bridge.to.command.Play;
import com.plivo.bridge.to.command.PreAnswer;
import com.plivo.bridge.to.command.Record;
import com.plivo.bridge.to.command.Redirect;
import com.plivo.bridge.to.command.Speak;
import com.plivo.bridge.to.command.Wait;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import org.json.JSONObject;

public abstract class PlivoUtils {

	public static class ParameterUtils {
		
		public static String getSingleParameter(Map<?, ?> parameters, String key) {
			Object object = parameters.get(key);
			if(null == object) return null;
			
			if(object instanceof Object[])
				return (String) Array.get(object, 0);
			
			return object.toString();
		}

		public static String mapToJSON(Map<String, String> parameters)	{
			JSONObject jsonObject = new JSONObject(parameters);

			return jsonObject.toString();
		}
		
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
			Hangup.class,
			Number.class,
			Play.class,
			PreAnswer.class,
			Record.class,
			Redirect.class,
			Speak.class,
			Wait.class			
		};

		public static javax.xml.bind.JAXBContext createContext( ) throws JAXBException {
			javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(classes);

			return context;
		}
	}
}
