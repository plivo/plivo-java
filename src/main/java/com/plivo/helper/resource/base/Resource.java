package com.plivo.helper.resource.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HTTP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.GenericResponse;
import com.plivo.helper.response.Response;

public class Resource extends Response {
	private PlivoRestConf conf;

	@SerializedName("resource_uri")
	private String resourceUri;

	public String getResourceUri() {
		return this.resourceUri;
	}

	@Deprecated
	protected static synchronized String request(String method,
			String resource, LinkedHashMap<String, String> parameters,
			PlivoRestConf conf) throws PlivoException {
		HttpResponse response = new BasicHttpResponse(new ProtocolVersion(
				"HTTP", 1, 1), HttpStatus.SC_OK, "OK");
		String baseURI = String.format("%s/%s/Account/%s", conf.getApiURL(),
				conf.getVersion(), conf.getAuthId());
		DefaultHttpClient client = new DefaultHttpClient();
		client.getCredentialsProvider().setCredentials(
				new AuthScope("api.plivo.com", 443),
				new UsernamePasswordCredentials(conf.getAuthId(), conf
						.getAuthToken()));
		String json = "";
		try {
			if (method == "GET") {
				// Prepare a String with GET parameters
				String getparams = "?";
				for (Entry<String, String> pair : parameters.entrySet())
					getparams += pair.getKey() + "=" + pair.getValue() + "&";
				// remove the trailing '&'
				getparams = getparams.substring(0, getparams.length() - 1);

				HttpGet httpget = new HttpGet(baseURI + resource + getparams);
				response = client.execute(httpget);
			} else if (method == "POST") {
				HttpPost httpost = new HttpPost(baseURI + resource);
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),
						"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
						"application/json"));
				// Now, attach the pay load to the request
				httpost.setEntity(se);
				response = client.execute(httpost);
			} else if (method == "DELETE") {
				HttpDelete httpdelete = new HttpDelete(baseURI + resource);
				response = client.execute(httpdelete);
			}

			Integer serverCode = response.getStatusLine().getStatusCode();

			if (response.getEntity() != null) {
				json = convertStreamToString(response.getEntity().getContent())
						.replaceFirst(
								"\\{",
								String.format("{ \"server_code\": %s, ",
										serverCode.toString()));
			} else {
				// dummy response
				json = String
						.format("{\"message\":\"no response\",\"api_id\":\"unknown\", \"server_code\":%s}",
								serverCode.toString());
			}

		} catch (ClientProtocolException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} catch (IOException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} catch (IllegalStateException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} finally {
			client.getConnectionManager().shutdown();
		}

		return json;
	}

	protected static synchronized String requestExpect(String method,
			String resource, LinkedHashMap<String, String> parameters,
			PlivoRestConf conf, int expectedCode) throws PlivoException,
			APIException {
		HttpResponse response = new BasicHttpResponse(new ProtocolVersion(
				"HTTP", 1, 1), HttpStatus.SC_OK, "OK");
		String baseURI = String.format("%s/%s/Account/%s", conf.getApiURL(),
				conf.getVersion(), conf.getAuthId());
		DefaultHttpClient client = new DefaultHttpClient();
		client.getCredentialsProvider().setCredentials(
				new AuthScope("api.plivo.com", 443),
				new UsernamePasswordCredentials(conf.getAuthId(), conf
						.getAuthToken()));
		String json = "";
		try {
			if (method == "GET") {
				// Prepare a String with GET parameters
				String getparams = "?";
				for (Entry<String, String> pair : parameters.entrySet())
					getparams += pair.getKey() + "=" + pair.getValue() + "&";
				// remove the trailing '&'
				getparams = getparams.substring(0, getparams.length() - 1);

				HttpGet httpget = new HttpGet(baseURI + resource + getparams);
				response = client.execute(httpget);
			} else if (method == "POST") {
				HttpPost httpost = new HttpPost(baseURI + resource);
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),
						"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
						"application/json"));
				// Now, attach the pay load to the request
				httpost.setEntity(se);
				response = client.execute(httpost);
			} else if (method == "DELETE") {
				HttpDelete httpdelete = new HttpDelete(baseURI + resource);
				response = client.execute(httpdelete);
			}

			int serverCode = response.getStatusLine().getStatusCode();

			if (response.getEntity() != null) {
				json = convertStreamToString(response.getEntity().getContent())
						.replaceFirst(
								"\\{",
								String.format("{ \"server_code\": %s, ",
										serverCode));
			} else {
				// dummy response
				json = String
						.format("{\"message\":\"no response\",\"api_id\":\"unknown\", \"server_code\":%s}",
								serverCode);
			}

			if (serverCode != expectedCode) {
				handleAPIError(json);
			}

		} catch (ClientProtocolException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} catch (IOException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} catch (IllegalStateException e) {
			throw new PlivoException(e.getLocalizedMessage());
		} finally {
			client.getConnectionManager().shutdown();
		}

		return json;
	}

	private static void handleAPIError(String resp) throws APIException {
		Gson gson = new Gson();
		GenericResponse gr = gson.fromJson(resp, GenericResponse.class);
		throw new APIException(gr.getServerCode(), gr.getMessage(),
				gr.getError());
	}

	protected static <T> T getRequest(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf, int expectedCode) throws PlivoException,
			APIException {
		Gson gson = new Gson();
		return gson.fromJson(
				requestExpect("GET", location, params, restConf, expectedCode),
				classOfT);
	}

	protected static <T> T getRequest(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf) throws PlivoException, APIException {
		return getRequest(location, params, classOfT, restConf, 200);
	}

	protected static <T> T postRequestExpect(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf, int expectedCode) throws PlivoException,
			APIException {
		Gson gson = new Gson();
		return gson
				.fromJson(
						requestExpect("POST", location, params, restConf,
								expectedCode), classOfT);
	}

	protected static <T> T postRequest(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf) throws PlivoException, APIException {
		return postRequestExpect(location, params, classOfT, restConf, 201);
	}

	protected static <T> T deleteRequestExpect(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf, int expectedCode) throws PlivoException,
			APIException {
		Gson gson = new Gson();
		return gson.fromJson(
				requestExpect("DELETE", location, params, restConf,
						expectedCode), classOfT);
	}

	protected static <T> T deleteRequest(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf) throws PlivoException, APIException {
		return deleteRequestExpect(location, params, classOfT, restConf, 204);
	}

	protected static <T> T putRequestExpect(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf, int expectedCode) throws PlivoException,
			APIException {
		Gson gson = new Gson();
		return gson.fromJson(
				requestExpect("PUT", location, params, restConf, expectedCode),
				classOfT);
	}

	protected static <T> T putRequest(String location,
			LinkedHashMap<String, String> params, Class<T> classOfT,
			PlivoRestConf restConf) throws PlivoException, APIException {
		return putRequestExpect(location, params, classOfT, restConf, 202);
	}

	protected static String convertStreamToString(InputStream istream)
			throws IOException {
		BufferedReader breader = new BufferedReader(new InputStreamReader(
				istream));
		StringBuilder responseString = new StringBuilder();
		String line = "";
		while ((line = breader.readLine()) != null) {
			responseString.append(line);
		}
		breader.close();
		return responseString.toString();
	}

	protected static String getKeyValue(LinkedHashMap<String, String> params,
			String key) throws PlivoException {
		String value = "";
		if (params.containsKey(key)) {
			value = params.get(key);
			params.remove(key);
		} else {
			throw new PlivoException(String.format(
					"Missing mandatory parameter %s.", key));
		}
		return value;
	}

	public PlivoRestConf getConf() {
		return conf;
	}

	public void setConf(PlivoRestConf conf) {
		this.conf = conf;
	}

	/**
	 * Check if GET operation is OK.
	 * 
	 * @return
	 */
	public boolean isGetOK() {
		return this.getServerCode() == 200 && this.getError() == null;
	}
}
