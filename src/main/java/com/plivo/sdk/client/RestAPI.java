package com.plivo.sdk.client;

//Exceptions
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import com.plivo.sdk.exception.PlivoException;

// Plivo resources
import com.plivo.sdk.response.account.Account;
import com.plivo.sdk.response.account.SubAccount;
import com.plivo.sdk.response.account.SubAccountFactory;
import com.plivo.sdk.response.application.Application;
import com.plivo.sdk.response.application.ApplicationFactory;
import com.plivo.sdk.response.call.CDR;
import com.plivo.sdk.response.call.CDRFactory;
import com.plivo.sdk.response.call.Call;
import com.plivo.sdk.response.call.LiveCall;
import com.plivo.sdk.response.call.LiveCallFactory;
import com.plivo.sdk.response.conference.Conference;
import com.plivo.sdk.response.conference.LiveConferenceList;
import com.plivo.sdk.response.endpoint.Endpoint;
import com.plivo.sdk.response.endpoint.EndpointFactory;
import com.plivo.sdk.response.message.Message;
import com.plivo.sdk.response.response.GenericResponse;
import com.plivo.sdk.response.response.Record;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

// Authentication for HTTP resources
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;

// Handle HTTP requests
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

// Add pay load to POST request 
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;

import org.apache.http.protocol.HTTP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RestAPI {
	public String AUTH_ID;
	private String AUTH_TOKEN;
	private final String PLIVO_URL = "https://api.plivo.com";
	public String PLIVO_VERSION = "v1";
	private String BaseURI;
	private DefaultHttpClient Client;
	private Gson gson;
	
	public RestAPI(String auth_id, String auth_token, String version)
	{
		AUTH_ID = auth_id;
		AUTH_TOKEN = auth_token;
		PLIVO_VERSION = version;
		BaseURI = String.format("%s/%s/Account/%s", PLIVO_URL, PLIVO_VERSION, AUTH_ID);
		Client = new DefaultHttpClient();
		Client.getCredentialsProvider().setCredentials(
                new AuthScope("api.plivo.com", 443),
                new UsernamePasswordCredentials(AUTH_ID, AUTH_TOKEN)
                );
		gson = new Gson();
	}
	
	public String request(String resource, LinkedHashMap<String, String> parameters, String method) 
	        throws PlivoException
	{
	    HttpResponse response = new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1),
	            HttpStatus.SC_OK, "OK");
	    String json = "";
	    try {
    	    if ( method == "GET" ) {
    	        // Prepare a String with GET parameters
    	        String getparams = "?";
    	        for ( Entry<String, String> pair : parameters.entrySet() )
    	            getparams += pair.getKey() + "=" + pair.getValue() + "&";
    	        // remove the trailing '&'
    	        getparams = getparams.substring(0, getparams.length() - 1);
    	        
    	        HttpGet httpget = new HttpGet(this.BaseURI + resource + getparams);
    	        response = this.Client.execute(httpget);
    	    }
    	    else if ( method == "POST" ) {
    	        HttpPost httpost = new HttpPost(this.BaseURI + resource);
    	        Gson gson = new GsonBuilder().serializeNulls().create();
                // Create a String entity with the POST parameters
    	        StringEntity se = new StringEntity(gson.toJson(parameters));
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                // Now, attach the pay load to the request 
                httpost.setEntity(se);
                response = this.Client.execute(httpost);
    	    }
    	    else if ( method == "DELETE" ) {
    	        HttpDelete httpdelete = new HttpDelete(this.BaseURI + resource);
    	        response = this.Client.execute(httpdelete);
    	    }
    	    json = this.convertStreamToString(response.getEntity().getContent());
	    }
	    catch (ClientProtocolException e) {
	        throw new PlivoException(e.getLocalizedMessage());
	    } catch (IOException e) {
	        throw new PlivoException(e.getLocalizedMessage());
	    } catch (IllegalStateException e) {
            throw new PlivoException(e.getLocalizedMessage());
        } finally {
            this.Client.getConnectionManager().shutdown();
        }
	    
	    if ( response.getStatusLine().getStatusCode() >= 400 )
	        throw new PlivoException(response.getStatusLine().getReasonPhrase());
	    
	    return json;
	}
	
	private String convertStreamToString(InputStream istream) 
	        throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(istream));
        StringBuilder responseStr = new StringBuilder();
        String line = "";
        while ((line = breader.readLine()) != null) {
            responseStr.append(line);
        }
        breader.close();
        return responseStr.toString();
	}
	
	private String get_key_value(LinkedHashMap<String, String> params, String key) throws PlivoException {
        String value = "";
        if (params.containsKey(key)) {
            value = params.get(key);
            params.remove(key);
        } else {
            throw new PlivoException("Missing mandatory parameter " + key);
        }
        return value;
    }
	
	// Account
	public Account get_account() throws PlivoException {
	    return this.gson.fromJson(request("/", new LinkedHashMap<String, String>(), "GET"), Account.class);
	}
	
	public GenericResponse modify_account(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/", parameters, "GET"), GenericResponse.class);	    
	}
	
	public SubAccountFactory get_subaccounts() throws PlivoException {
	    return this.gson.fromJson(request("/Subaccount/", new LinkedHashMap<String, String>(), "GET"), SubAccountFactory.class);
    }
	
	public SubAccount get_subaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
      String subauth_id = this.get_key_value(parameters, "subauth_id");
      return this.gson.fromJson(request(String.format("/Subaccount/%s/", subauth_id), parameters, "GET"), SubAccount.class);
	}
	
	public GenericResponse create_subaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("/Subaccount/", parameters, "POST"), GenericResponse.class);
    }
	
	public GenericResponse modify_subaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Subaccount/", parameters, "POST"), GenericResponse.class);
    }
	
	public GenericResponse delete_subaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String subauth_id = this.get_key_value(parameters, "subauth_id");
        return this.gson.fromJson(request(String.format("/Subaccount/%s/", subauth_id), parameters, "DELETE"), GenericResponse.class);
    }
	
	// Application
	public ApplicationFactory get_applications(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("/Application/", new LinkedHashMap<String, String>(), "GET"), ApplicationFactory.class);
    }
	
	public Application get_application(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.get_key_value(parameters, "app_id");
	    return this.gson.fromJson(request(String.format("/Application/%s/", app_id), 
	            new LinkedHashMap<String, String>(), "GET"), Application.class);
    }
	
	public GenericResponse create_application(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("/Application/", parameters, "POST"), GenericResponse.class);
    }
	
	public GenericResponse modify_application(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.get_key_value(parameters, "app_id");
        return this.gson.fromJson(request(String.format("/Application/%s/", app_id), parameters, "POST"), GenericResponse.class);
    }
	
	public GenericResponse delete_application(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.get_key_value(parameters, "app_id");
	    return this.gson.fromJson(request(String.format("/Application/%s/", app_id), parameters, "DELETE"), GenericResponse.class);
	}
	
	// Call
    public CDRFactory get_cdrs(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Call/", parameters, "GET"), CDRFactory.class);
    }

    public CDR get_cdr(LinkedHashMap<String, String> parameters) throws PlivoException {
        String record_id = get_key_value(parameters, "record_id");
        return this.gson.fromJson(request(String.format("/Call/%s/", record_id), 
                new LinkedHashMap<String, String>(), "GET"), CDR.class);
    }

    public LiveCallFactory get_live_calls() throws PlivoException {
        LinkedHashMap<String, String> parameters= new LinkedHashMap<String, String>();
        parameters.put("status", "live");
        return this.gson.fromJson(request("/Call/", parameters, "GET"), LiveCallFactory.class);
    }

    public LiveCall get_live_call(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        parameters.put("status", "live");
        return this.gson.fromJson(request(String.format("/Call/%s/", call_uuid), parameters, "GET"), LiveCall.class);
    }

    public Call make_call(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Call/", parameters, "POST"), Call.class);
    }

    public GenericResponse hangup_all_calls() throws PlivoException {
        return this.gson.fromJson(request("/Call/", new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse hangup_call(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/", call_uuid), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse transfer_call(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/", call_uuid), parameters, "POST"), GenericResponse.class);
    }

    public Record record(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/Record/", call_uuid), parameters, "POST"), Record.class);
    }

    public GenericResponse stop_record(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/Record/", call_uuid), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse play(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/Play/", call_uuid), parameters, "POST"), GenericResponse.class);
    }

    public GenericResponse stop_play(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/Play/", call_uuid), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse speak(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/Speak/", call_uuid), parameters, "POST"), GenericResponse.class);
    }

    public GenericResponse send_digits(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = get_key_value(parameters, "call_uuid");
        return this.gson.fromJson(request(String.format("/Call/%s/DTMF/", call_uuid), parameters, "POST"), GenericResponse.class);
    }
    
    // Conference
    public LiveConferenceList get_live_conferences() throws PlivoException {
        return this.gson.fromJson(request("/Conference/", new LinkedHashMap<String, String>(), "GET"), LiveConferenceList.class);
    }

    public GenericResponse hangup_all_conferences() throws PlivoException {
        return this.gson.fromJson(request("/Conference/", new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public Conference get_live_conference(LinkedHashMap<String, String> parameters) throws PlivoException{
        String conference_name = get_key_value(parameters, "conference_name");
        return this.gson.fromJson(request(String.format("/Conference/%s/", conference_name), 
                new LinkedHashMap<String, String>(), "GET"), Conference.class);
    }

    public GenericResponse hangup_conference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        return this.gson.fromJson(request(String.format("/Conference/%s/", conference_name), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse hangup_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse play_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "POST"), GenericResponse.class);
    }

    public GenericResponse stop_play_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse speak_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Speak/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "POST"), GenericResponse.class);
    }

    public GenericResponse deaf_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Deaf/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "POST"), GenericResponse.class);
    }

    public GenericResponse undeaf_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Deaf/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse mute_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "POST"), GenericResponse.class);
    }

    public GenericResponse unmute_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }

    public GenericResponse kick_member(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        String member_id = get_key_value(parameters, "member_id");
        return this.gson.fromJson(request(String.format("/Conference/%s/Member/{1}/Kick/", conference_name, member_id), 
                new LinkedHashMap<String, String>(), "POST"), GenericResponse.class);
    }

    public Record record_conference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        return this.gson.fromJson(request(String.format("/Conference/%s/Record/", conference_name), parameters, "POST"), Record.class);
    }

    public GenericResponse stop_record_conference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = get_key_value(parameters, "conference_name");
        return this.gson.fromJson(request(String.format("/Conference/%s/Record/", conference_name), 
                new LinkedHashMap<String, String>(), "DELETE"),GenericResponse.class);
    }
    
    // Endpoint
    public EndpointFactory get_endpoints(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Endpoint/", parameters, "GET"), EndpointFactory.class);
    }

    public GenericResponse create_endpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Endpoint/", parameters, "POST"),GenericResponse.class);
    }

    public Endpoint get_endpoint(LinkedHashMap<String, String> parameters) throws PlivoException { 
        String endpoint_id = get_key_value(parameters, "endpoint_id");
        return this.gson.fromJson(request(String.format("/Endpoint/%s/", endpoint_id), 
                new LinkedHashMap<String, String>(), "GET"), Endpoint.class);
    }

    public GenericResponse modify_endpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        String endpoint_id = get_key_value(parameters, "endpoint_id");
        return this.gson.fromJson(request(String.format("/Endpoint/%s/", endpoint_id), parameters, "POST"), GenericResponse.class);
    }

    public GenericResponse delete_endpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        String endpoint_id = get_key_value(parameters, "endpoint_id");
        return this.gson.fromJson(request(String.format("/Endpoint/%s/", endpoint_id), 
                new LinkedHashMap<String, String>(), "DELETE"), GenericResponse.class);
    }
    
    // Message
    public Message send_message(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("/Message/", parameters, "POST"), Message.class);
    }
}