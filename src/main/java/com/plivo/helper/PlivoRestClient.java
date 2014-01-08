package com.plivo.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
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
import com.plivo.helper.exception.PlivoException;

public class PlivoRestClient {
	private final String AUTH_ID;
	private final String AUTH_TOKEN;
	private final String PLIVO_URL = "https://api.plivo.com";
	private String PLIVO_VERSION = "v1";
	private final String BaseURI;
	private DefaultHttpClient Client;
	public Gson gson;

	public PlivoRestClient(String auth_id, String auth_token, String version) {
		if (!version.equals("v1")) {
			throw new IllegalArgumentException("Version '" + version
					+ "' is not valid. Only API version v1 is supported now");
		}

		if (auth_id == null || auth_id.length() != 20
				|| !(auth_id.startsWith("MA") || auth_id.startsWith("SA"))) {
			throw new IllegalArgumentException(
					"Auth ID '"
							+ auth_id
							+ "' is not valid. It should be contain 20 characters starting with 'MA' or 'SA'");
		}

		if (auth_token == null || auth_token.length() != 40) {
			throw new IllegalArgumentException("Auth Token '" + auth_token
					+ "' is not valid. It should be containt 40 characters");
		}

		AUTH_ID = auth_id;
		AUTH_TOKEN = auth_token;
		PLIVO_VERSION = version;
		BaseURI = String.format("%s/%s/Account/%s", PLIVO_URL, PLIVO_VERSION,
				AUTH_ID);
		gson = new Gson();
	}

	public String request(String method, String resource,
			Map<String, String> parameters) throws PlivoException {
		HttpResponse response = new BasicHttpResponse(new ProtocolVersion(
				"HTTP", 1, 1), HttpStatus.SC_OK, "OK");
		Client = new DefaultHttpClient();
		Client.getCredentialsProvider().setCredentials(
				new AuthScope("api.plivo.com", 443),
				new UsernamePasswordCredentials(AUTH_ID, AUTH_TOKEN));
		String json = "";
		try {
			if (method == "GET") {
				// Prepare a String with GET parameters
				String getparams = "?";
				for (Entry<String, String> pair : parameters.entrySet())
					getparams += pair.getKey() + "=" + pair.getValue() + "&";
				// remove the trailing '&'
				getparams = getparams.substring(0, getparams.length() - 1);

				HttpGet httpget = new HttpGet(this.BaseURI + resource
						+ getparams);
				response = this.Client.execute(httpget);
			} else if (method == "POST") {
				HttpPost httpost = new HttpPost(this.BaseURI + resource);
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),
						"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
						"application/json"));
				// Now, attach the pay load to the request
				httpost.setEntity(se);
				response = this.Client.execute(httpost);
			} else if (method == "DELETE") {
				HttpDelete httpdelete = new HttpDelete(this.BaseURI + resource);
				response = this.Client.execute(httpdelete);
			}

			Integer serverCode = response.getStatusLine().getStatusCode();

			if (response.getEntity() != null) {
				json = this.convertStreamToString(
						response.getEntity().getContent()).replaceFirst(
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
			this.Client.getConnectionManager().shutdown();
		}

		return json;
	}

	private String convertStreamToString(InputStream istream)
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

	public String get(String location, Map<String, String> params)
			throws PlivoException {
		return request("GET", location, params);
	}

	public Object getFromJson(String location,
			Map<String, String> params, Class<Object> classOfT)
			throws PlivoException {
		String json = request("GET", location, params);
		return this.gson.fromJson(json, classOfT);
	}
}
