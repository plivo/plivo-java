package com.plivo.helper.resource;

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
import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public abstract class Resource {
	protected PlivoRestClient client;
	@SerializedName("server_code")
	protected Integer serverCode ;
	protected String error;
	private boolean isOK;
	PlivoRestConf conf;

	public Resource(PlivoRestClient client) {
		this.client = client;
		this.isOK = true;
	}
	
	public Resource() {
		this.isOK = true;
	}
	
	protected static synchronized String request(String method, String resource, LinkedHashMap<String, String> parameters, PlivoRestConf conf) 
			throws PlivoException
	{
		HttpResponse response = new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1),
				HttpStatus.SC_OK, "OK");
		String baseURI = String.format("%s/%s/Account/%s", conf.getApiURL(), conf.getVersion(), conf.getAuthId());
		DefaultHttpClient client = new DefaultHttpClient();
		client.getCredentialsProvider().setCredentials(
				new AuthScope("api.plivo.com", 443),
				new UsernamePasswordCredentials(conf.getAuthId(), conf.getAuthToken())
				);
		String json = "";
		try {
			if ( method == "GET" ) {
				// Prepare a String with GET parameters
				String getparams = "?";
				for ( Entry<String, String> pair : parameters.entrySet() )
					getparams += pair.getKey() + "=" + pair.getValue() + "&";
				// remove the trailing '&'
				getparams = getparams.substring(0, getparams.length() - 1);
				
				HttpGet httpget = new HttpGet(baseURI + resource + getparams);
				response = client.execute(httpget);
			}
			else if ( method == "POST" ) {
				HttpPost httpost = new HttpPost(baseURI + resource);
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				// Now, attach the pay load to the request 
				httpost.setEntity(se);
				response = client.execute(httpost);
			}
			else if ( method == "DELETE" ) {
				HttpDelete httpdelete = new HttpDelete(baseURI + resource);
				response = client.execute(httpdelete);
			}

			Integer serverCode = response.getStatusLine().getStatusCode();

	        if ( response.getEntity() != null ) {
	        	json = convertStreamToString(response.getEntity().getContent()).replaceFirst("\\{", String.format("{ \"server_code\": %s, ", serverCode.toString()));
	        } else {
	                // dummy response
	            json = String.format("{\"message\":\"no response\",\"api_id\":\"unknown\", \"server_code\":%s}", serverCode.toString());
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
	protected static String convertStreamToString(InputStream istream) 
            throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(istream));
        StringBuilder responseString = new StringBuilder();
        String line = "";
        while ((line = breader.readLine()) != null) {
            responseString.append(line);
        }
        breader.close();
        return responseString.toString();
    }
	
	/**
	 * Check if GET operation is OK.
	 * @return
	 */
	public boolean isGetOK() {
		return serverCode == 200 && error == null;
	}
	
	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}
	
	public boolean isValid() {
		return isOK;
	}
}
