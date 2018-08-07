package com.plivo.helper.api.client;

//Exceptions
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;

import com.plivo.helper.api.response.account.*;
import com.plivo.helper.api.response.application.*;
import com.plivo.helper.api.response.call.*;
import com.plivo.helper.api.response.conference.*;
import com.plivo.helper.api.response.endpoint.*;
import com.plivo.helper.api.response.message.*;
import com.plivo.helper.api.response.number.*;
import com.plivo.helper.api.response.number.Number;
import com.plivo.helper.api.response.carrier.*;
import com.plivo.helper.api.response.response.*;
import com.plivo.helper.api.response.pricing.PlivoPricing;
import com.plivo.helper.exception.PlivoException;

import org.apache.http.HttpHost;
// Plivo resources
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
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HTTP;

//Add pay load to POST request 
import org.apache.http.entity.StringEntity;



// Handle JSON response
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// Handle unicode characters
import com.plivo.helper.util.HtmlEntity;

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
	
	public RestAPI setProxy(HttpHost proxy) {
		Client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);
		return this;
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
					getparams += pair.getKey() + "=" + URLEncoder.encode(pair.getValue(), "UTF-8") + "&";
				// remove the trailing '&'
				getparams = getparams.substring(0, getparams.length() - 1);
				
				HttpGet httpget = new HttpGet(this.BaseURI + resource + getparams);
				response = this.Client.execute(httpget);
			}
			else if ( method == "POST" ) {
				HttpPost httpost = new HttpPost(this.BaseURI + resource);
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				// Now, attach the pay load to the request 
				httpost.setEntity(se);
				response = this.Client.execute(httpost);
			}
			else if ( method == "DELETE" ) {
				HttpDelete httpdelete = new HttpDelete(this.BaseURI + resource);
				response = this.Client.execute(httpdelete);
			}

			Integer serverCode = response.getStatusLine().getStatusCode();

	        if ( response.getEntity() != null ) {
	        	json = this.convertStreamToString(response.getEntity().getContent()).replaceFirst("\\{", String.format("{ \"server_code\": %s, ", serverCode.toString()));
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
			this.Client.getConnectionManager().shutdown();
		}
		
		return json;
    }
    
    private String convertStreamToString(InputStream istream) 
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
    
    private String getKeyValue(LinkedHashMap<String, String> params, String key) throws PlivoException {
        String value = "";
        if (params.containsKey(key)) {
            value = params.get(key);
            params.remove(key);
        } else {
            throw new PlivoException(String.format("Missing mandatory parameter %s.", key));
        }
        return value;
    }
    
    // Account
    public Account getAccount() throws PlivoException {
        return this.gson.fromJson(request("GET", "/", new LinkedHashMap<String, String>()), Account.class);
    }
    
    public GenericResponse editAccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/", parameters), GenericResponse.class);      
    }
    
    public SubAccountFactory getSubaccounts() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Subaccount/", new LinkedHashMap<String, String>()), SubAccountFactory.class);
    }
    
    public SubAccountFactory getSubaccounts(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Subaccount/", parameters), SubAccountFactory.class);
    }
    
    public SubAccount getSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
      String subauth_id = this.getKeyValue(parameters, "subauth_id");
      return this.gson.fromJson(request("GET", String.format("/Subaccount/%s/", subauth_id), parameters), SubAccount.class);
    }
    
    public SubAccount createSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Subaccount/", parameters), SubAccount.class);
    }
    
    public SubAccount editSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String subauth_id = this.getKeyValue(parameters, "subauth_id");
        return this.gson.fromJson(request("POST", String.format("/Subaccount/%s/", subauth_id), parameters), SubAccount.class);
    }
    
    public GenericResponse deleteSubaccount(LinkedHashMap<String, String> parameters) throws PlivoException {
        String subauth_id = this.getKeyValue(parameters, "subauth_id");
        return this.gson.fromJson(request("DELETE", String.format("/Subaccount/%s/", subauth_id), parameters), GenericResponse.class);
    }
    
    // Application
    public ApplicationFactory getApplications() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Application/", new LinkedHashMap<String, String>()), ApplicationFactory.class);
    }
    
    public ApplicationFactory getApplications(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Application/", parameters), ApplicationFactory.class);
    }
    
    public Application getApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
        String app_id = this.getKeyValue(parameters, "app_id");
        return this.gson.fromJson(request("GET", String.format("/Application/%s/", app_id), 
                new LinkedHashMap<String, String>()), Application.class);
    }
    
    public Application createApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Application/", parameters), Application.class);
    }
    
    public Application editApplication(LinkedHashMap<String, String> parameters) throws PlivoException {
        String app_id = this.getKeyValue(parameters, "app_id");
        return this.gson.fromJson(request("POST", String.format("/Application/%s/", app_id), parameters), Application.class);
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
    	String to = parameters.get("to");
    	if (to!=null && to.indexOf("<")!=-1)
    		throw new PlivoException("Use the makeBulkCall() method to make calls to multiple numbers.");
        return this.gson.fromJson(request("POST", "/Call/", parameters), Call.class);
    }
    
    public BulkCall makeBulkCall(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String to = parameters.get("to");
    	if (to!=null && to.indexOf("<")==-1)
    		throw new PlivoException("Use the makeCall() method to make calls to a single number.");
        return this.gson.fromJson(request("POST", "/Call/", parameters), BulkCall.class);
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
	    String text = HtmlEntity.convert(getKeyValue(parameters, "text"));
		parameters.put("text", text);
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/Speak/", call_uuid), parameters), GenericResponse.class);
    }

    public GenericResponse stopSpeak(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("DELETE", String.format("/Call/%s/Speak/", call_uuid), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse sendDigits(LinkedHashMap<String, String> parameters) throws PlivoException {
        String call_uuid = getKeyValue(parameters, "call_uuid");
        return this.gson.fromJson(request("POST", String.format("/Call/%s/DTMF/", call_uuid), parameters), GenericResponse.class);
    }
    
    public GenericResponse hangupRequest(LinkedHashMap<String, String> parameters) throws PlivoException {
        String request_uuid = getKeyValue(parameters, "request_uuid");
        return this.gson.fromJson(request("DELETE", String.format("/Request/%s/", request_uuid), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }
    
    // Conference
    public LiveConferenceFactory getLiveConferences() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Conference/", new LinkedHashMap<String, String>()), LiveConferenceFactory.class);
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
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%1$s/Member/%2$s/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse playMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%1$s/Member/%2$s/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse stopPlayMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%1$s/Member/%2$s/Play/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse speakMember(LinkedHashMap<String, String> parameters) throws PlivoException {
		String text = HtmlEntity.convert(getKeyValue(parameters, "text"));
		parameters.put("text", text);
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%1$s/Member/%2$s/Speak/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }
    
    public GenericResponse stopSpeakMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%1$s/Member/%2$s/Speak/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse deafMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String memberId = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%1$s/Member/%2$s/Deaf/", conference_name, memberId), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse undeafMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String memberId = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%1$s/Member/%2$s/Deaf/", conference_name, memberId), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse muteMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%1$s/Member/%2$s/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse unmuteMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("DELETE", String.format("/Conference/%1$s/Member/%2$s/Mute/", conference_name, member_id), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }

    public GenericResponse kickMember(LinkedHashMap<String, String> parameters) throws PlivoException {
        String conference_name = getKeyValue(parameters, "conference_name");
        String member_id = getKeyValue(parameters, "member_id");
        return this.gson.fromJson(request("POST", String.format("/Conference/%1$s/Member/%2$s/Kick/", conference_name, member_id), 
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

    public Endpoint createEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", "/Endpoint/", parameters), Endpoint.class);
    }

    public Endpoint getEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException { 
        String endpoint_id = getKeyValue(parameters, "endpoint_id");
        return this.gson.fromJson(request("GET", String.format("/Endpoint/%s/", endpoint_id), 
                new LinkedHashMap<String, String>()), Endpoint.class);
    }

    public Endpoint editEndpoint(LinkedHashMap<String, String> parameters) throws PlivoException {
        String endpoint_id = getKeyValue(parameters, "endpoint_id");
        return this.gson.fromJson(request("POST", String.format("/Endpoint/%s/", endpoint_id), parameters), Endpoint.class);
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
    
    public Number getNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("GET", String.format("/Number/%s/", number), 
        		new LinkedHashMap<String, String>()), Number.class);
    }
    
    public GenericResponse editNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("POST", String.format("/Number/%s/", number), parameters), GenericResponse.class);
    }
    
    @Deprecated
    public NumberSearchFactory searchNumbers(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/AvailableNumber/", parameters), NumberSearchFactory.class);
    }
    
    @Deprecated
    public GenericResponse rentNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("POST", String.format("/AvailableNumber/%s/", number, parameters), 
                new LinkedHashMap<String, String>()), GenericResponse.class);
    }
    
    public NumberGroupFactory searchNumberGroups(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/AvailableNumberGroup/", parameters), NumberGroupFactory.class);
    }
    
    public NumberResponse rentNumbers(LinkedHashMap<String, String> parameters) throws PlivoException {
        String groupId = getKeyValue(parameters, "group_id");
        return this.gson.fromJson(request("POST", String.format("/AvailableNumberGroup/%s/", groupId), parameters), NumberResponse.class);
    }

    public GenericResponse unRentNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("DELETE", String.format("/Number/%s/", number), parameters), GenericResponse.class);
    }
    
    public GenericResponse linkApplicationNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        return this.gson.fromJson(request("POST", String.format("/Number/%s/", number), parameters), GenericResponse.class);
    }

    public GenericResponse unlinkApplicationNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        String number = getKeyValue(parameters, "number");
        parameters.put("app_id", "");
        return this.gson.fromJson(request("POST", String.format("/Number/%s/", number), parameters), GenericResponse.class);
    }
    
    public PhoneNumberSearchFactory searchPhoneNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/PhoneNumber/", parameters), PhoneNumberSearchFactory.class);
    }
    
    public NumberResponse buyPhoneNumber(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("POST", String.format("/PhoneNumber/%s/", getKeyValue(parameters, "number")), 
        		parameters), NumberResponse.class);
    }
    
    // Message
    public MessageResponse sendMessage(LinkedHashMap<String, String> parameters) throws PlivoException {
	    String src = parameters.get("src");
	    String powerpackUUID = parameters.get("powerpack_uuid");
	    if (src == null && powerpackUUID == null) {
	        throw new PlivoException("Either of src number or powrpack UUID is required, none given");
        }

        if (src != null && powerpackUUID != null) {
	        throw new PlivoException("Either src number or powerpack UUID is required, both given");
        }
        return this.gson.fromJson(request("POST", "/Message/", parameters), MessageResponse.class);
    }
    
    public Message getMessage(LinkedHashMap<String, String> parameters) throws PlivoException {
        String record_id = getKeyValue(parameters, "record_id");
        return this.gson.fromJson(request("GET", String.format("/Message/%s/", record_id), 
                new LinkedHashMap<String, String>()), Message.class);
    }

    public MessageFactory getMessages() throws PlivoException {
        return this.gson.fromJson(request("GET", "/Message/", new LinkedHashMap<String, String>()), MessageFactory.class);
    }

    public MessageFactory getMessages(LinkedHashMap<String, String> parameters) throws PlivoException {
        return this.gson.fromJson(request("GET", "/Message/", parameters), MessageFactory.class);
    }
    
    // Incoming Carrier
    public IncomingCarrierFactory getIncomingCarriers(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("GET", "/IncomingCarrier/", parameters), IncomingCarrierFactory.class);
    }
    
    public IncomingCarrier getIncomingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("GET", String.format("/IncomingCarrier/%s/", carrier), parameters), IncomingCarrier.class);
    }
    
    public GenericResponse addIncomingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("POST", "/IncomingCarrier/", parameters), GenericResponse.class);
    }
    
    public GenericResponse editIncomingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("POST", String.format("/IncomingCarrier/", carrier), parameters), GenericResponse.class);
    }
    
    public GenericResponse dropIncomingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("DELETE", String.format("/IncomingCarrier/%s/", carrier), parameters), GenericResponse.class);
    }
    
    // Outgoing Carrier
    public OutgoingCarrierFactory getOutgoingCarriers(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("GET", "/OutgoingCarrier/", parameters), OutgoingCarrierFactory.class);
    }
    
    public OutgoingCarrier getOutgoingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("GET", String.format("/OutgoingCarrier/%s/", carrier), parameters), OutgoingCarrier.class);
    }
    
    public OutgoingCarrierCreatedResponse addOutgoingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("POST", "/OutgoingCarrier/", parameters), OutgoingCarrierCreatedResponse.class);
    }
    
    public GenericResponse editOutgoingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("POST", String.format("/OutgoingCarrier/%s/", carrier), parameters), GenericResponse.class);
    }
    
    public GenericResponse dropOutgoingCarrier(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "carrier_id");
    	return this.gson.fromJson(request("DELETE", String.format("/OutgoingCarrier/%s/", carrier), parameters), GenericResponse.class);
    }
    
    // Outgoing Carrier Routing
    public OutgoingCarrierRoutingFactory getOutgoingCarrierRoutings(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("GET", "/OutgoingCarrierRouting/", parameters), OutgoingCarrierRoutingFactory.class);
    }
    
    public OutgoingCarrierRouting getOutgoingCarrierRouting(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String carrier = getKeyValue(parameters, "routing_id");
    	return this.gson.fromJson(request("GET", String.format("/OutgoingCarrierRouting/%s/", carrier), parameters), OutgoingCarrierRouting.class);
    }
    
    public OutgoingCarrierRoutingCreatedResponse addOutgoingCarrierRouting(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("POST", "/OutgoingCarrierRouting/", parameters), OutgoingCarrierRoutingCreatedResponse.class);
    }
    
    public GenericResponse editOutgoingCarrierRouting(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String routing_id = getKeyValue(parameters, "routing_id");
    	return this.gson.fromJson(request("POST", String.format("/OutgoingCarrierRouting/%s/", routing_id), parameters), GenericResponse.class);
    }
    
    public GenericResponse dropOutgoingCarrierRouting(LinkedHashMap<String, String> parameters) throws PlivoException {
    	String routing_id = getKeyValue(parameters, "routing_id");
    	return this.gson.fromJson(request("DELETE", String.format("/OutgoingCarrierRouting/%s/", routing_id), parameters), GenericResponse.class);
    }
    
    // Pricing
    public PlivoPricing getPricing(LinkedHashMap<String, String> parameters) throws PlivoException {
    	return this.gson.fromJson(request("GET", "/Pricing/", parameters), PlivoPricing.class);
    }
}
