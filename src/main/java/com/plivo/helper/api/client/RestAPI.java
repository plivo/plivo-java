package com.plivo.helper.api.client;

//Exceptions
import java.io.*;
import java.net.URLEncoder;

import org.apache.http.client.AuthCache;
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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

// Authentication for HTTP resources
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;

// Handle HTTP requests
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

//Add pay load to POST request
import org.apache.http.entity.StringEntity;

// Handle JSON response
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// Handle unicode characters
import com.plivo.helper.util.HtmlEntity;

public class RestAPI implements Closeable {
    public final static String DEFAULT_API_VERSION = "v1";
	public final static String DEFAULT_API_HOST = "api.plivo.com";
	public final static int DEFAULT_API_PORT = 443;
	public final static String DEFAULT_API_PROTO = "https";

	private final String baseURI;
	private final CloseableHttpClient client;
	private final Gson gson;
    private final HttpHost target;

    public RestAPI(String auth_id, String auth_token) {
        this(auth_id, auth_token, DEFAULT_API_VERSION, DEFAULT_API_HOST, DEFAULT_API_PORT, DEFAULT_API_PROTO);
    }

	public RestAPI(String authId, String authToken, String apiVersion, String host, int port, String proto) {
        this.target = new HttpHost(host, port, proto);

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(authId, authToken));

		client = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

		gson = new Gson();

		baseURI = String.format("%s/%s/Account/%s", target.toURI(), apiVersion, authId);
	}

	public RestAPI setProxy(HttpHost proxy) {
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);
		return this;
	}

	private String request(String method, String resource, Map<String, String> parameters)
			throws PlivoException {
		HttpResponse response;
		String json;
		try {
            HttpUriRequest request;
            StringBuilder url = new StringBuilder(this.baseURI);
            url.append(resource);
			if ( "GET".equals(method) ) {
				// Append query string
                if (parameters != null && !parameters.isEmpty()) {
                    url.append("?");
                    boolean first = true;
                    for (Entry<String, String> pair : parameters.entrySet()) {
                        if (first) {
                            first = false;
                        } else {
                            url.append("&");
                        }
                        url.append(pair.getKey());
                        url.append("=");
                        url.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
                    }
                }

				request = new HttpGet(url.toString());
			} else if ( "POST".equals(method) ) {
				HttpPost httpost = new HttpPost(url.toString());
				Gson gson = new GsonBuilder().serializeNulls().create();
				// Create a String entity with the POST parameters
				StringEntity se = new StringEntity(gson.toJson(parameters),"utf-8");
				se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				// Now, attach the pay load to the request
				httpost.setEntity(se);
				request = httpost;
			} else if ( "DELETE".equals(method) ) {
				request = new HttpDelete(url.toString());
			} else {
                throw new PlivoException("Unknown request method '" + method + "'");
            }

            // Create AuthCache instance
            AuthCache authCache = new BasicAuthCache();
            // Generate BASIC scheme object and add it to the local
            // auth cache
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(target, basicAuth);

            // Add AuthCache to the execution context
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setAuthCache(authCache);

            response = this.client.execute(this.target, request, localContext);

			int serverCode = response.getStatusLine().getStatusCode();

	        if ( response.getEntity() != null ) {
	        	json = convertStreamToString(response.getEntity().getContent()).replaceFirst("\\{", String.format("{ \"server_code\": %d, ", serverCode));
	        } else {
	                // dummy response
	            json = String.format("{\"message\":\"no response\",\"api_id\":\"unknown\", \"server_code\":%d}", serverCode);
	        }

		} catch (ClientProtocolException e) {
			throw new PlivoException(e);
		} catch (IOException e) {
			throw new PlivoException(e);
		} catch (IllegalStateException e) {
			throw new PlivoException(e);
		}

		return json;
    }

    private <T> T requestAndUnmarshall(String method, String resource, Map<String, String> parameters, Class<T> clazz) throws PlivoException {
        String request = request(method, resource, parameters);
        return this.gson.fromJson(request, clazz);
    }

    /**
     * Release resources
     */
    public void close() throws IOException {
        this.client.close();
    }

    private static String convertStreamToString(InputStream istream)
            throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(istream));
        StringBuilder responseString = new StringBuilder();
        String line;
        while ((line = breader.readLine()) != null) {
            responseString.append(line);
        }
        breader.close();
        return responseString.toString();
    }
    
    // Account
    public Account getAccount() throws PlivoException {
        return requestAndUnmarshall("GET", "/", null, Account.class);
    }

    public GenericResponse editAccount(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("POST", "/", parameters, GenericResponse.class);
    }

    public SubAccountFactory getSubaccounts() throws PlivoException {
        return requestAndUnmarshall("GET", "/Subaccount/", null, SubAccountFactory.class);
    }

    public SubAccountFactory getSubaccounts(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Subaccount/", parameters, SubAccountFactory.class);
    }

    public SubAccount getSubaccount(Map<String, String> parameters, String subAuthId) throws PlivoException {
      return requestAndUnmarshall("GET", String.format("/Subaccount/%s/", subAuthId), parameters, SubAccount.class);
    }

    public SubAccount createSubaccount(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("POST", "/Subaccount/", parameters, SubAccount.class);
    }

    public SubAccount editSubaccount(Map<String, String> parameters, String subAuthId) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Subaccount/%s/", subAuthId), parameters, SubAccount.class);
    }

    public GenericResponse deleteSubaccount(String subAuthId) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Subaccount/%s/", subAuthId), null, GenericResponse.class);
    }

    // Application
    public ApplicationFactory getApplications() throws PlivoException {
        return requestAndUnmarshall("GET", "/Application/", null, ApplicationFactory.class);
    }

    public ApplicationFactory getApplications(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Application/", parameters, ApplicationFactory.class);
    }

    public Application getApplication(String appId) throws PlivoException {
        return requestAndUnmarshall("GET", String.format("/Application/%s/", appId),
                null, Application.class);
    }

    public Application createApplication(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("POST", "/Application/", parameters, Application.class);
    }

    public Application editApplication(Map<String, String> parameters, String appId) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Application/%s/", appId), parameters, Application.class);
    }

    public GenericResponse deleteApplication(String app_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Application/%s/", app_id), null, GenericResponse.class);
    }

    // Call
    public CDRFactory getCDRs(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Call/", parameters, CDRFactory.class);
    }

    public CDR getCDR(String record_id) throws PlivoException {
        return requestAndUnmarshall("GET", String.format("/Call/%s/", record_id),
                null, CDR.class);
    }

    public LiveCallFactory getLiveCalls() throws PlivoException {
        Map<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("status", "live");
        return requestAndUnmarshall("GET", "/Call/", parameters, LiveCallFactory.class);
    }

    public LiveCall getLiveCall(Map<String, String> parameters, String call_uuid) throws PlivoException {
        parameters.put("status", "live");
        return requestAndUnmarshall("GET", String.format("/Call/%s/", call_uuid), parameters, LiveCall.class);
    }

    public Call makeCall(Map<String, String> parameters) throws PlivoException {
    	String to = parameters.get("to");
    	if (to != null && to.contains("<"))
    		throw new PlivoException("Use the makeBulkCall() method to make calls to multiple numbers.");
        return requestAndUnmarshall("POST", "/Call/", parameters, Call.class);
    }

    public BulkCall makeBulkCall(Map<String, String> parameters) throws PlivoException {
    	String to = parameters.get("to");
    	if (to != null && !to.contains("<"))
    		throw new PlivoException("Use the makeCall() method to make calls to a single number.");
        return requestAndUnmarshall("POST", "/Call/", parameters, BulkCall.class);
    }

    public GenericResponse hangupAllCalls() throws PlivoException {
        return requestAndUnmarshall("DELETE", "/Call/", null, GenericResponse.class);
    }

    public GenericResponse hangupCall(String call_uuid) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Call/%s/", call_uuid),
                null, GenericResponse.class);
    }

    public GenericResponse transferCall(Map<String, String> parameters, String call_uuid) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Call/%s/", call_uuid), parameters, GenericResponse.class);
    }

    public Record record(Map<String, String> parameters, String call_uuid) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Call/%s/Record/", call_uuid), parameters, Record.class);
    }

    public GenericResponse stopRecord(String call_uuid) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Call/%s/Record/", call_uuid),
                null, GenericResponse.class);
    }

    public GenericResponse play(Map<String, String> parameters, String call_uuid) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Call/%s/Play/", call_uuid), parameters, GenericResponse.class);
    }

    public GenericResponse stopPlay(String call_uuid) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Call/%s/Play/", call_uuid),
                null, GenericResponse.class);
    }

    public GenericResponse speak(Map<String, String> parameters, String text, String call_uuid) throws PlivoException {
        if (parameters == null) {
            parameters = new LinkedHashMap<String, String>();
        }
        parameters.put("text", HtmlEntity.convert(text));
        return requestAndUnmarshall("POST", String.format("/Call/%s/Speak/", call_uuid), parameters, GenericResponse.class);
    }

    public GenericResponse stopSpeak(String call_uuid) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Call/%s/Speak/", call_uuid),
                null, GenericResponse.class);
    }

    public GenericResponse sendDigits(Map<String, String> parameters, String call_uuid) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Call/%s/DTMF/", call_uuid), parameters, GenericResponse.class);
    }

    public GenericResponse hangupRequest(String request_uuid) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Request/%s/", request_uuid),
                null, GenericResponse.class);
    }

    // Conference
    public LiveConferenceFactory getLiveConferences() throws PlivoException {
        return requestAndUnmarshall("GET", "/Conference/", null, LiveConferenceFactory.class);
    }

    public GenericResponse hangupAllConferences() throws PlivoException {
        return requestAndUnmarshall("DELETE", "/Conference/", null, GenericResponse.class);
    }

    public Conference getLiveConference(String conference_name) throws PlivoException{
        return requestAndUnmarshall("GET", String.format("/Conference/%s/", conference_name),
                null, Conference.class);
    }

    public GenericResponse hangupConference(String conference_name) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%s/", conference_name),
                null, GenericResponse.class);
    }

    public GenericResponse hangupMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%1$s/Member/%2$s/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse playMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Conference/%1$s/Member/%2$s/Play/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse stopPlayMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%1$s/Member/%2$s/Play/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse speakMember(String text, String conference_name, String member_id) throws PlivoException {
        Map<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("text", HtmlEntity.convert(text));
        return requestAndUnmarshall("POST", String.format("/Conference/%1$s/Member/%2$s/Speak/", conference_name, member_id),
                parameters, GenericResponse.class);
    }

    public GenericResponse stopSpeakMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%1$s/Member/%2$s/Speak/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse deafMember(String conference_name, String memberId) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Conference/%1$s/Member/%2$s/Deaf/", conference_name, memberId),
                null, GenericResponse.class);
    }

    public GenericResponse undeafMember(String conference_name, String memberId) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%1$s/Member/%2$s/Deaf/", conference_name, memberId),
                null, GenericResponse.class);
    }

    public GenericResponse muteMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Conference/%1$s/Member/%2$s/Mute/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse unmuteMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%1$s/Member/%2$s/Mute/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public GenericResponse kickMember(String conference_name, String member_id) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Conference/%1$s/Member/%2$s/Kick/", conference_name, member_id),
                null, GenericResponse.class);
    }

    public Record recordConference(Map<String, String> parameters, String conference_name) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Conference/%s/Record/", conference_name), parameters, Record.class);
    }

    public GenericResponse stopRecordConference(String conference_name) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Conference/%s/Record/", conference_name),
                null,GenericResponse.class);
    }


    // Endpoint
    public EndpointFactory getEndpoints(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Endpoint/", parameters, EndpointFactory.class);
    }

    public Endpoint createEndpoint(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("POST", "/Endpoint/", parameters, Endpoint.class);
    }

    public Endpoint getEndpoint(String endpoint_id) throws PlivoException {
        return requestAndUnmarshall("GET", String.format("/Endpoint/%s/", endpoint_id),
                null, Endpoint.class);
    }

    public Endpoint editEndpoint(Map<String, String> parameters, String endpoint_id) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Endpoint/%s/", endpoint_id), parameters, Endpoint.class);
    }

    public GenericResponse deleteEndpoint(String endpoint_id) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Endpoint/%s/", endpoint_id),
                null, GenericResponse.class);
    }


    // Number
    public NumberSearchFactory getNumbers() throws PlivoException {
        return requestAndUnmarshall("GET", "/Number/", null, NumberSearchFactory.class);
    }

    public NumberSearchFactory getNumbers(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Number/", parameters, NumberSearchFactory.class);
    }

    public Number getNumber(String number) throws PlivoException {
        return requestAndUnmarshall("GET", String.format("/Number/%s/", number),
        		null, Number.class);
    }

    public GenericResponse editNumber(Map<String, String> parameters, String number) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Number/%s/", number), parameters, GenericResponse.class);
    }

    @Deprecated
    public NumberSearchFactory searchNumbers(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/AvailableNumber/", parameters, NumberSearchFactory.class);
    }

    @Deprecated
    public GenericResponse rentNumber(Map<String, String> parameters, String number) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/AvailableNumber/%s/", number), parameters,
                GenericResponse.class);
    }

    public NumberGroupFactory searchNumberGroups(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/AvailableNumberGroup/", parameters, NumberGroupFactory.class);
    }

    public NumberResponse rentNumbers(Map<String, String> parameters, String groupId) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/AvailableNumberGroup/%s/", groupId), parameters, NumberResponse.class);
    }

    public GenericResponse unRentNumber(String number) throws PlivoException {
        return requestAndUnmarshall("DELETE", String.format("/Number/%s/", number), null, GenericResponse.class);
    }

    public GenericResponse linkApplicationNumber(Map<String, String> parameters, String number) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/Number/%s/", number), parameters, GenericResponse.class);
    }

    public GenericResponse unlinkApplicationNumber(Map<String, String> parameters, String number) throws PlivoException {
        parameters.put("app_id", "");
        return requestAndUnmarshall("POST", String.format("/Number/%s/", number), parameters, GenericResponse.class);
    }

    public PhoneNumberSearchFactory searchPhoneNumber(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/PhoneNumber/", parameters, PhoneNumberSearchFactory.class);
    }

    public NumberResponse buyPhoneNumber(Map<String, String> parameters, String number) throws PlivoException {
        return requestAndUnmarshall("POST", String.format("/PhoneNumber/%s/", number),
        		parameters, NumberResponse.class);
    }

    // Message
    public MessageResponse sendMessage(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("POST", "/Message/", parameters, MessageResponse.class);
    }

    public Message getMessage(String record_id) throws PlivoException {
        return requestAndUnmarshall("GET", String.format("/Message/%s/", record_id),
                null, Message.class);
    }

    public MessageFactory getMessages() throws PlivoException {
        return requestAndUnmarshall("GET", "/Message/", null, MessageFactory.class);
    }

    public MessageFactory getMessages(Map<String, String> parameters) throws PlivoException {
        return requestAndUnmarshall("GET", "/Message/", parameters, MessageFactory.class);
    }

    // Incoming Carrier
    public IncomingCarrierFactory getIncomingCarriers(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("GET", "/IncomingCarrier/", parameters, IncomingCarrierFactory.class);
    }

    public IncomingCarrier getIncomingCarrier(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("GET", String.format("/IncomingCarrier/%s/", carrier), parameters, IncomingCarrier.class);
    }

    public GenericResponse addIncomingCarrier(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("POST", "/IncomingCarrier/", parameters, GenericResponse.class);
    }

    public GenericResponse editIncomingCarrier(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("POST", String.format("/IncomingCarrier/%s/", carrier), parameters, GenericResponse.class);
    }

    public GenericResponse dropIncomingCarrier(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("DELETE", String.format("/IncomingCarrier/%s/", carrier), parameters, GenericResponse.class);
    }

    // Outgoing Carrier
    public OutgoingCarrierFactory getOutgoingCarriers(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("GET", "/OutgoingCarrier/", parameters, OutgoingCarrierFactory.class);
    }

    public OutgoingCarrier getOutgoingCarrier(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("GET", String.format("/OutgoingCarrier/%s/", carrier), parameters, OutgoingCarrier.class);
    }

    public OutgoingCarrierCreatedResponse addOutgoingCarrier(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("POST", "/OutgoingCarrier/", parameters, OutgoingCarrierCreatedResponse.class);
    }

    public GenericResponse editOutgoingCarrier(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("POST", String.format("/OutgoingCarrier/%s/", carrier), parameters, GenericResponse.class);
    }

    public GenericResponse dropOutgoingCarrier(String carrier) throws PlivoException {
    	return requestAndUnmarshall("DELETE", String.format("/OutgoingCarrier/%s/", carrier), null, GenericResponse.class);
    }

    // Outgoing Carrier Routing
    public OutgoingCarrierRoutingFactory getOutgoingCarrierRoutings(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("GET", "/OutgoingCarrierRouting/", parameters, OutgoingCarrierRoutingFactory.class);
    }

    public OutgoingCarrierRouting getOutgoingCarrierRouting(Map<String, String> parameters, String carrier) throws PlivoException {
    	return requestAndUnmarshall("GET", String.format("/OutgoingCarrierRouting/%s/", carrier), parameters, OutgoingCarrierRouting.class);
    }

    public OutgoingCarrierRoutingCreatedResponse addOutgoingCarrierRouting(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("POST", "/OutgoingCarrierRouting/", parameters, OutgoingCarrierRoutingCreatedResponse.class);
    }

    public GenericResponse editOutgoingCarrierRouting(Map<String, String> parameters, String routing_id) throws PlivoException {
    	return requestAndUnmarshall("POST", String.format("/OutgoingCarrierRouting/%s/", routing_id), parameters, GenericResponse.class);
    }

    public GenericResponse dropOutgoingCarrierRouting(String routing_id) throws PlivoException {
    	return requestAndUnmarshall("DELETE", String.format("/OutgoingCarrierRouting/%s/", routing_id), null, GenericResponse.class);
    }

    // Pricing
    public PlivoPricing getPricing(Map<String, String> parameters) throws PlivoException {
    	return requestAndUnmarshall("GET", "/Pricing/", parameters, PlivoPricing.class);
    }
}
