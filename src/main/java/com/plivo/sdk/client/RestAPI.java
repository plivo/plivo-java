package com.plivo.sdk.client;

//Exceptions
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import com.plivo.sdk.exception.PlivoException;

// Plivo resources
import com.plivo.sdk.response.account.*;
import com.plivo.sdk.response.application.*;
import com.plivo.sdk.response.call.*;
import com.plivo.sdk.response.conference.*;
import com.plivo.sdk.response.endpoint.*;
import com.plivo.sdk.response.message.*;
import com.plivo.sdk.response.number.*;
import com.plivo.sdk.response.response.*;

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

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;

import org.apache.http.protocol.HTTP;

//Add pay load to POST request 
import org.apache.http.entity.StringEntity;

// handling json
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

	public String request(String method, String resource, LinkedHashMap<String, String> parameters) 
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
	
	private String getKeyValue(LinkedHashMap<String, String> params, String key) throws PlivoException {
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
	public Account getAccount() throws PlivoException {
	    return this.gson.fromJson(request("GET", "/", new LinkedHashMap<String, String>()), Account.class);
	}
	
	public GenericResponse modifyAccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/", parameters), GenericResponse.class);	    
	}
	
	public SubAccountFactory getSubaccounts() throws PlivoException {
	    return this.gson.fromJson(request("GET", "/Subaccount/", new LinkedHashMap<String, String>()), SubAccountFactory.class);
    }
	
	public SubAccount getSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
      String subauth_id = this.getKeyValue(parameters, "subauth_id");
      return this.gson.fromJson(request("GET", String.format("/Subaccount/%s/", subauth_id), parameters), SubAccount.class);
	}
	
	public GenericResponse createSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("POST", "/Subaccount/", parameters), GenericResponse.class);
    }
	
	public GenericResponse modifySubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Subaccount/", parameters), GenericResponse.class);
    }
	
	public GenericResponse deleteSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String subauth_id = this.getKeyValue(parameters, "subauth_id");
        return this.gson.fromJson(request("DELETE", String.format("/Subaccount/%s/", subauth_id), parameters), GenericResponse.class);
    }
	
	// Application
	public ApplicationFactory getApplications(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("GET", "/Application/", new LinkedHashMap<String, String>()), ApplicationFactory.class);
    }
	
	public Application getApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.getKeyValue(parameters, "app_id");
	    return this.gson.fromJson(request("GET", String.format("/Application/%s/", app_id), 
	            new LinkedHashMap<String, String>()), Application.class);
    }
	
	public GenericResponse createApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
	    return this.gson.fromJson(request("POST", "/Application/", parameters), GenericResponse.class);
    }
	
	public GenericResponse modifyApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.getKeyValue(parameters, "app_id");
        return this.gson.fromJson(request("POST", String.format("/Application/%s/", app_id), parameters), GenericResponse.class);
    }
	
	public GenericResponse deleteApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String app_id = this.getKeyValue(parameters, "app_id");
	    return this.gson.fromJson(request("DELETE", String.format("/Application/%s/", app_id), parameters), GenericResponse.class);
	}
	
	// Call
    public CDRFactory getCDRs(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Call/", parameters), CDRFactory.class);
    }

    public CDR getCDR(LinkedHashMap<String, String> parameters) throws PlivoException {
        String record_id = getKeyValue(parameters, "record_id");
        return this.gson.fromJson(request("GET", String.format("/Call/%s/", record_id), 
                new LinkedHashMap<String, String>()), CDR.class);
    }

    public LiveCallFactory getLiveCalls() throws PlivoException {
        LinkedHashMap<String, String> parameters= new LinkedHashMap<String, String>();
        parameters.put("status", "live");
        return this.gson.fromJson(request("GET", "/Call/", parameters), LiveCallFactory.class);
    }

    public LiveCall getLiveCall(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        parameters.put("status", "live");
        return this.gson.fromJson(request("GET", String.format("/Call/%s/", call_uuid), parameters), LiveCall.class);
    }

    public Call makeCall(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Call/", parameters), Call.class);
    }

    public GenericResponse hangupAllCalls() throws PlivoException {
        return this.gson.fromJson(request("DELETE", "/Call/", new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse hangupCall(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("DELETE", String.format("/Call/%s/", call_uuid), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse transferCall(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/", call_uuid), parameters), GenericResponse.class);
    }

    public Record record(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/Record/", call_uuid), parameters), Record.class);
    }

    public GenericResponse stopRecord(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("DELETE", String.format("/Call/%s/Record/", call_uuid), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse play(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/Play/", call_uuid), parameters), GenericResponse.class);
    }

    public GenericResponse stopPlay(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("DELETE", String.format("/Call/%s/Play/", call_uuid), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse speak(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/Speak/", call_uuid), parameters), GenericResponse.class);
    }

    public GenericResponse sendDigits(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/DTMF/", call_uuid), parameters), GenericResponse.class);
    }
    
    // Conference
    public LiveConferenceList getLiveConferences() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Conference/", new LinkedHashMap<String, String>()), LiveConferenceList.class);
    }

    public GenericResponse hangupAllConferences() throws PlivoException {
        return this.gson.fromJson(request("DELETE", "/Conference/", new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public Conference getLiveConference(LinkedHashMap<String, String> parameters) throws PlivoException{
        String conference_name = getKeyValue(parameters, "conference_name");
        return this.gson.fromJson(request("GET", String.format("/Conference/%s/", conference_name), 
                new LinkedHashMap<String, String>()), Conference.class);
    }

    public GenericResponse hangupConference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/", conference_name), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse hangupMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/Member/{1}/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse playMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Member/{1}/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse stopPlayMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/Member/{1}/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse speakMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Member/{1}/Speak/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse deafMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String memberId = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Member/{1}/Deaf/", conference_name, memberId), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse undeafMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String memberId = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/Member/{1}/Deaf/", conference_name, memberId), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse muteMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Member/{1}/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse unmuteMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/Member/{1}/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse kickMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Member/{1}/Kick/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public Record recordConference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        return this.gson.fromJson(request("POST", String.format("/Conference/%s/Record/", conference_name), parameters), Record.class);
    }

    public GenericResponse stopRecordConference(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%s/Record/", conference_name), 
                new LinkedHashMap<String, String>()),GenericResponse.class);
    }
    

    // Endpoint
    public EndpointFactory getEndpoints(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Endpoint/", parameters), EndpointFactory.class);
    }

    public GenericResponse createEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Endpoint/", parameters),GenericResponse.class);
    }

    public Endpoint getEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException { 
        String endpoint_id = getKeyValue(parameters, "endpoint_id");
        return this.gson.fromJson(request("GET", String.format("/Endpoint/%s/", endpoint_id), 
                new LinkedHashMap<String, String>()), Endpoint.class);
    }

    public GenericResponse modifyEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        String endpoint_id = getKeyValue(parameters, "endpoint_id");
        return this.gson.fromJson(request("POST", String.format("/Endpoint/%s/", endpoint_id), parameters), GenericResponse.class);
    }

    public GenericResponse deleteEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        String endpoint_id = getKeyValue(parameters, "endpoint_id");
        return this.gson.fromJson(request("DELETE", String.format("/Endpoint/%s/", endpoint_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }
    
    
    // Number
    public NumberSearchFactory getNumbers() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Number/", new LinkedHashMap<String, String>()), NumberSearchFactory.class);
    }
    
    public NumberSearchFactory getNumbers(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Number/", parameters), NumberSearchFactory.class);
    }
    
    @Deprecated
    public NumberSearchFactory searchNumbers(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/AvailableNumber/", parameters), NumberSearchFactory.class);
    }
    
    public NumberSearchFactory searchNumberGroups(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/AvailableNumberGroup/", parameters), NumberSearchFactory.class);
    }
    
    public GenericResponse rentNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("POST", String.format("/AvailableNumber/{0}/", number), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }
    
    public NumberResponse rentNumbers(LinkedHashMap<String, String> parameters) throws PlivoException {
        String groupId = getKeyValue(parameters, "group_id");
        return this.gson.fromJson(request("POST", String.format("/AvailableNumberGroup/{0}/", groupId), 
                new LinkedHashMap<String, String>()), NumberResponse.class);
    }

    public GenericResponse unRentNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("DELETE", String.format("/Number/{0}/", number), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse linkApplicationNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("POST", String.format("/Number/{0}/", number), parameters), GenericResponse.class);
    }

    public GenericResponse unlinkApplicationNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        parameters.put("app_id", "");
        return this.gson.fromJson(request("POST", String.format("/Number/{0}/", number), parameters), GenericResponse.class);
    }
    
    
    // Message
    public MessageResponse sendMessage(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Message/", parameters), MessageResponse.class);
    }
    
    public Message getMessage(LinkedHashMap<String, String> parameters) throws PlivoException {
        String record_id = getKeyValue(parameters, "record_id");
        return this.gson.fromJson(request("GET", String.format("/Message/{0}/", record_id), 
                new LinkedHashMap<String, String>()), Message.class);
    }

    public MessageList getMessages() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Message/", new LinkedHashMap<String, String>()), MessageList.class);
    }

    public MessageList getMessages(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Message/", parameters), MessageList.class);
    }
}