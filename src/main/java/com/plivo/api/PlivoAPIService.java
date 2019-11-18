package com.plivo.api;

import com.plivo.api.models.account.Account;
import com.plivo.api.models.account.AccountUpdateResponse;
import com.plivo.api.models.account.AccountUpdater;
import com.plivo.api.models.account.Subaccount;
import com.plivo.api.models.account.SubaccountCreateResponse;
import com.plivo.api.models.account.SubaccountCreator;
import com.plivo.api.models.account.SubaccountUpdateResponse;
import com.plivo.api.models.account.SubaccountUpdater;
import com.plivo.api.models.account.SubaccountDeleter;
import com.plivo.api.models.address.Address;
import com.plivo.api.models.address.AddressCreateResponse;
import com.plivo.api.models.address.AddressCreator;
import com.plivo.api.models.address.AddressUpdateResponse;
import com.plivo.api.models.address.AddressUpdater;
import com.plivo.api.models.application.Application;
import com.plivo.api.models.application.ApplicationCreateResponse;
import com.plivo.api.models.application.ApplicationCreator;
import com.plivo.api.models.application.ApplicationUpdateResponse;
import com.plivo.api.models.application.ApplicationUpdater;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.call.CallCreateResponse;
import com.plivo.api.models.call.CallCreator;
import com.plivo.api.models.call.CallUpdateResponse;
import com.plivo.api.models.call.CallUpdater;
import com.plivo.api.models.call.LiveCall;
import com.plivo.api.models.call.LiveCallListResponse;
import com.plivo.api.models.call.QueuedCall;
import com.plivo.api.models.call.QueuedCallListResponse;
import com.plivo.api.models.call.actions.CallDtmfCreateResponse;
import com.plivo.api.models.call.actions.CallDtmfCreator;
import com.plivo.api.models.call.actions.CallPlayCreateResponse;
import com.plivo.api.models.call.actions.CallPlayCreator;
import com.plivo.api.models.call.actions.CallRecordCreateResponse;
import com.plivo.api.models.call.actions.CallRecordCreator;
import com.plivo.api.models.call.actions.CallSpeakCreateResponse;
import com.plivo.api.models.call.actions.CallSpeakCreator;
import com.plivo.api.models.conference.Conference;
import com.plivo.api.models.conference.ConferenceList;
import com.plivo.api.models.conference.ConferenceMemberActionResponse;
import com.plivo.api.models.conference.ConferenceMemberPlayCreator;
import com.plivo.api.models.conference.ConferenceMemberSpeakCreator;
import com.plivo.api.models.conference.ConferenceRecordCreateResponse;
import com.plivo.api.models.endpoint.Endpoint;
import com.plivo.api.models.endpoint.EndpointCreateResponse;
import com.plivo.api.models.endpoint.EndpointCreator;
import com.plivo.api.models.endpoint.EndpointUpdateResponse;
import com.plivo.api.models.endpoint.EndpointUpdater;
import com.plivo.api.models.identity.Identity;
import com.plivo.api.models.identity.IdentityCreateResponse;
import com.plivo.api.models.identity.IdentityCreator;
import com.plivo.api.models.identity.IdentityUpdateResponse;
import com.plivo.api.models.identity.IdentityUpdater;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageCreator;
import com.plivo.api.models.node.*;
import com.plivo.api.models.number.Number;
import com.plivo.api.models.number.NumberCreateResponse;
import com.plivo.api.models.number.NumberCreator;
import com.plivo.api.models.number.NumberUpdateResponse;
import com.plivo.api.models.number.NumberUpdater;
import com.plivo.api.models.number.PhoneNumber;
import com.plivo.api.models.number.PhoneNumberCreateResponse;
import com.plivo.api.models.number.PhoneNumberCreator;
import com.plivo.api.models.phlo.Phlo;
import com.plivo.api.models.phlo.PhloRunGetterResponse;
import com.plivo.api.models.phlo.PhloUpdateResponse;
import com.plivo.api.models.powerpack.*;
import com.plivo.api.models.pricing.Pricing;
import com.plivo.api.models.recording.Recording;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.HTTP;

public interface PlivoAPIService {

  // Address
  @POST("Account/{authId}/Verification/Address/")
  Call<AddressCreateResponse> addressCreate(@Path("authId") String authId,
                                            @Body AddressCreator addressCreator);

  @GET("Account/{authId}/Verification/Address/")
  Call<ListResponse<Address>> addressList(@Path("authId") String authId,
                                          @QueryMap Map<String, Object> addressListRequest);

  @GET("Account/{authId}/Verification/Address/{addressId}/")
  Call<Address> addressGet(@Path("authId") String authId, @Path("addressId") String addressId);

  @POST("Account/{authId}/Verification/Address/{addressId}/")
  Call<AddressUpdateResponse> addressUpdate(@Path("authId") String authId,
                                            @Path("addressId") String addressId, @Body AddressUpdater addressUpdater);

  @DELETE("Account/{authId}/Verification/Address/{addressId}/")
  Call<ResponseBody> addressDelete(@Path("authId") String authId, @Path("addressId") String addressId);

  // Application
  @POST("Account/{authId}/Application/")
  Call<ApplicationCreateResponse> applicationCreate(@Path("authId") String authId,
    @Body ApplicationCreator application);

  @GET("Account/{authId}/Application/")
  Call<ListResponse<Application>> applicationList(@Path("authId") String authId,
    @QueryMap Map<String, Object> applicationListRequest);

  @GET("Account/{authId}/Application/{appId}/")
  Call<Application> applicationGet(@Path("authId") String authId, @Path("appId") String appId);

  @POST("Account/{authId}/Application/{appId}/")
  Call<ApplicationUpdateResponse> applicationUpdate(@Path("authId") String authId,
    @Path("appId") String appId, @Body ApplicationUpdater application);

  @DELETE("Account/{authId}/Application/{appId}/")
  Call<ResponseBody> applicationDelete(@Path("authId") String authId, @Path("appId") String appId);

  // Account
  @GET("Account/{authId}/")
  Call<Account> accountGet(@Path("authId") String authId);

  @POST("Account/{authId}/")
  Call<AccountUpdateResponse> accountModify(@Path("authId") String authId,
    @Body AccountUpdater accountUpdater);

  @POST("Account/{authId}/Subaccount/")
  Call<SubaccountCreateResponse> subaccountCreate(@Path("authId") String authId,
    @Body SubaccountCreator subaccountCreator);

  @POST("Account/{authId}/Subaccount/{subauthId}/")
  Call<SubaccountUpdateResponse> subaccountModify(@Path("authId") String authId,
    @Path("subauthId") String subauthId, @Body SubaccountUpdater subaccount);

  @GET("Account/{authId}/Subaccount/{subauthId}/")
  Call<Subaccount> subaccountGet(@Path("authId") String authId,
    @Path("subauthId") String subauthId);

  @GET("Account/{authId}/Subaccount/")
  Call<ListResponse<Subaccount>> subaccountList(@Path("authId") String authId,
    @Query("limit") Integer limit, @Query("offset") Integer offset);

  @HTTP(method = "DELETE", path= "Account/{authId}/Subaccount/{subauthId}/", hasBody = true)
  Call<ResponseBody> subaccountDelete(@Path("authId") String authId,
    @Path("subauthId") String subauthId, @Body SubaccountDeleter subaccount);

  // Call
  @POST("Account/{authId}/Call/")
  Call<CallCreateResponse> callCreate(@Path("authId") String authId,
    @Body CallCreator callCreator);

  @GET("Account/{authId}/Call/")
  Call<ListResponse<com.plivo.api.models.call.Call>> callList(@Path("authId") String authId,
    @QueryMap Map<String, Object> callListRequest);

  @GET("Account/{authId}/Call/{callId}/")
  Call<com.plivo.api.models.call.Call> callGet(@Path("authId") String authId,
    @Path("callId") String callId);

  @POST("Account/{authId}/Call/{callId}/")
  Call<CallUpdateResponse> callUpdate(@Path("authId") String authId,
    @Path("callId") String callId, @Body CallUpdater callUpdater);

  @DELETE("Account/{authId}/Call/{callId}/")
  Call<ResponseBody> callDelete(@Path("authId") String authId, @Path("callId") String callId);

  @GET("Account/{authId}/Call/?status=live")
  Call<LiveCallListResponse> liveCallListGet(@Path("authId") String authId, @QueryMap Map<String, Object> callListRequest);

  @GET("Account/{authId}/Call/{callId}/?status=live")
  Call<LiveCall> liveCallGet(@Path("authId") String authId, @Path("callId") String callId);

  @GET("Account/{authId}/Call/?status=queued")
  Call<QueuedCallListResponse> queuedCallListGet(@Path("authId") String authId);

  @GET("Account/{authId}/Call/{callId}/?status=queued")
  Call<QueuedCall> queuedCallGet(@Path("authId") String authId, @Path("callId") String callId);

  @POST("Account/{authId}/Call/{callId}/Record/")
  Call<CallRecordCreateResponse> callRecordCreate(@Path("authId") String authId,
    @Path("callId") String callId, @Body
    CallRecordCreator callRecordCreator);

  @DELETE("Account/{authId}/Call/{callId}/Record/")
  Call<ResponseBody> callRecordDelete(@Path("authId") String authId, @Path("callId") String callId);

  @POST("Account/{authId}/Call/{callId}/Play/")
  Call<CallPlayCreateResponse> callPlayCreate(@Path("authId") String authId,
    @Path("callId") String callId, @Body
    CallPlayCreator callPlayCreator);

  @DELETE("Account/{authId}/Call/{callId}/Play/")
  Call<ResponseBody> callPlayDelete(@Path("authId") String authId, @Path("callId") String callId);

  @POST("Account/{authId}/Call/{callId}/Speak/")
  Call<CallSpeakCreateResponse> callSpeakCreate(@Path("authId") String authId,
    @Path("callId") String callId, @Body
    CallSpeakCreator callSpeakCreator);

  @DELETE("Account/{authId}/Call/{callId}/Speak/")
  Call<ResponseBody> callSpeakDelete(@Path("authId") String authId, @Path("callId") String callId);

  @POST("Account/{authId}/Call/{callId}/DTMF/")
  Call<CallDtmfCreateResponse> callDtmfCreate(@Path("authId") String authId,
    @Path("callId") String callId, @Body
    CallDtmfCreator callDtmfCreator);

  // Identity
  @POST("Account/{authId}/Verification/Identity/")
  Call<IdentityCreateResponse> identityCreate(@Path("authId") String authId,
                                              @Body IdentityCreator identitycreator);

  @GET("Account/{authId}/Verification/Identity/")
  Call<ListResponse<Identity>> identityList(@Path("authId") String authId,
                                            @QueryMap Map<String, Object> identityListRequest);

  @GET("Account/{authId}/Verification/Identity/{id}/")
  Call<Identity> identityGet(@Path("authId") String authId, @Path("id") String id);

  @DELETE("Account/{authId}/Verification/Identity/{id}/")
  Call<ResponseBody> identityDelete(@Path("authId") String authId, @Path("id") String number);

  @POST("Account/{authId}/Verification/Identity/{id}/")
  Call<IdentityUpdateResponse> identityUpdate(@Path("authId") String authId, @Path("id") String identityId, @Body IdentityUpdater identityUpdater);

  // Message
  @POST("Account/{authId}/Message/")
  Call<MessageCreateResponse> messageSend(@Path("authId") String authId,
    @Body MessageCreator messageCreator);

  @GET("Account/{authId}/Message/")
  Call<ListResponse<Message>> messageList(@Path("authId") String authId,
    @QueryMap Map<String, Object> messageListRequest);

  @GET("Account/{authId}/Message/{id}/")
  Call<Message> messageGet(@Path("authId") String authId, @Path("id") String id);

  // Number

  @GET("Account/{authId}/Number/")
  Call<ListResponse<Number>> numberList(@Path("authId") String authId,
    @QueryMap Map<String, Object> params);

  @GET("Account/{authId}/Number/{number}/")
  Call<Number> numberGet(@Path("authId") String authId, @Path("number") String number);

  @POST("Account/{authId}/Number/")
  Call<NumberCreateResponse> numberCreate(@Path("authId") String authId,
    @Body NumberCreator numberCreator);

  @POST("Account/{authId}/Number/{number}/")
  Call<NumberUpdateResponse> numberUpdate(@Path("authId") String authId,
    @Path("number") String number, @Body NumberUpdater numberUpdater);

  @DELETE("Account/{authId}/Number/{number}/")
  Call<ResponseBody> numberDelete(@Path("authId") String authId, @Path("number") String number);

  @GET("Account/{authId}/PhoneNumber/")
  Call<ListResponse<PhoneNumber>> phoneNumberList(@Path("authId") String authId, @QueryMap Map<String, Object> params);

  @POST("Account/{authId}/PhoneNumber/{number}/")
  Call<PhoneNumberCreateResponse> phoneNumberCreate(@Path("authId") String authId,
    @Path("number") String number, @Body
    PhoneNumberCreator creator);

  // Recording

  @GET("Account/{authId}/Recording/")
  Call<ListResponse<Recording>> recordingList(@Path("authId") String authId,
    @QueryMap Map<String, Object> params);

  @GET("Account/{authId}/Recording/{recordingId}/")
  Call<Recording> recordingGet(@Path("authId") String authId,
    @Path("recordingId") String recordingId);

  @DELETE("Account/{authId}/Recording/{recordingId}/")
  Call<ResponseBody> recordingDelete(@Path("authId") String authId,
    @Path("recordingId") String recordingId);

  // Endpoint

  @POST("Account/{authId}/Endpoint/")
  Call<EndpointCreateResponse> endpointCreate(@Path("authId") String authId,
    @Body EndpointCreator endpointCreator);

  @GET("Account/{authId}/Endpoint/")
  Call<ListResponse<Endpoint>> endpointList(@Path("authId") String authId,
    @QueryMap Map<String, Object> params);

  @GET("Account/{authId}/Endpoint/{endpointId}/")
  Call<Endpoint> endpointGet(@Path("authId") String authId, @Path("endpointId") String endpointId);

  @POST("Account/{authId}/Endpoint/{endpointId}/")
  Call<EndpointUpdateResponse> endpointUpdate(@Path("authId") String authId,
    @Path("endpointId") String endpointId, @Body
    EndpointUpdater endpointUpdater);

  @DELETE("Account/{authId}/Endpoint/{endpointId}/")
  Call<ResponseBody> endpointDelete(@Path("authId") String authId,
    @Path("endpointId") String endpointId);

  // Conference

  @GET("Account/{authId}/Conference/")
  Call<ConferenceList> conferenceListGet(@Path("authId") String authId);

  @GET("Account/{authId}/Conference/{conferenceName}/")
  Call<Conference> conferenceGet(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName);

  @DELETE("Account/{authId}/Conference/")
  Call<ResponseBody> conferenceDeleteAll(@Path("authId") String authId);

  @DELETE("Account/{authId}/Conference/{conferenceName}/")
  Call<ResponseBody> conferenceDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/")
  Call<ConferenceMemberActionResponse> conferenceMemberDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  // Required as there is no body
  @Headers("Content-Type: application/json")
  @POST("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Kick/")
  Call<ConferenceMemberActionResponse> conferenceMemberKickCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  // Required as there is no body
  @Headers("Content-Type: application/json")
  @POST("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Mute/")
  Call<ConferenceMemberActionResponse> conferenceMemberMuteCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Mute/")
  Call<ResponseBody> conferenceMemberMuteDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  @POST("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Play/")
  Call<ConferenceMemberActionResponse> conferenceMemberPlayCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId,
    @Body ConferenceMemberPlayCreator conferenceMemberPlayCreator);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Play/")
  Call<ResponseBody> conferenceMemberPlayDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  @POST("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Speak/")
  Call<ConferenceMemberActionResponse> conferenceMemberSpeakCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId,
    @Body ConferenceMemberSpeakCreator conferenceMemberSpeakCreator);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Speak/")
  Call<ResponseBody> conferenceMemberSpeakDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  // Required as there is no body
  @Headers("Content-Type: application/json")
  @POST("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Deaf/")
  Call<ConferenceMemberActionResponse> conferenceMemberDeafCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Member/{memberId}/Deaf/")
  Call<ResponseBody> conferenceMemberDeafDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName, @Path("memberId") String memberId);

  // Required as there is no body
  @Headers("Content-Type: application/json")
  @POST("Account/{authId}/Conference/{conferenceName}/Record/")
  Call<ConferenceRecordCreateResponse> conferenceRecordCreate(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName);

  @DELETE("Account/{authId}/Conference/{conferenceName}/Record/")
  Call<ResponseBody> conferenceRecordDelete(@Path("authId") String authId,
    @Path("conferenceName") String conferenceName);

  // Pricing

  @GET("Account/{authId}/Pricing/")
  Call<Pricing> pricingGet(@Path("authId") String authId, @Query("country_iso") String countryIso);

  @DELETE("Account/{authId}/Request/{requestUuid}/")
  Call<ResponseBody> requestDelete(@Path("authId") String authId, @Path("requestUuid") String requestUuid);

  // PHLO - server is different from plivo server. Need content-type setting for POST
  @GET("phlo/{phloId}")
  Call<Phlo> phloGet(@Path("phloId") String phloId);

  @GET("phlo/{phloId}/runs/{runId}")
  Call<PhloRunGetterResponse> phloRunGet(@Path("phloId") String phloId, @Path("runId") String runId);

  @Headers("Content-Type: application/json")
  @POST("phlo/{phloId}/{nodeType}/{nodeId}")
  Call<MultiPartyCallUpdateResponse> nodeAction(@Path("phloId") String phloId,
                                                @Path("nodeType") NodeType nodeType,
                                                @Path("nodeId") String nodeId,
                                                @Body MultiPartyCallUpdatePayload payload);

  @Headers("Content-Type: application/json")
  @POST("phlo/{phloId}/{nodeType}/{nodeId}/members/{memberId}")
  Call<MultiPartyCallUpdateResponse> memberAction(@Path("phloId") String phloId,
                                        @Path("nodeType") NodeType nodeType,
                                        @Path("nodeId") String nodeId,
                                        @Path("memberId") String memberId,
                                        @Body MultiPartyCallUpdatePayload payload);

  @GET("phlo/{phloId}/{nodeType}/{nodeId}")
  Call<MultiPartyCall> multiPartyCallGet(@Path("phloId") String phloId,
                                         @Path("nodeType") NodeType nodeType,
                                         @Path("nodeId") final String nodeId);

  @Headers("Content-Type: application/json")
  @POST("account/{authId}/phlo/{phloId}")
  Call<PhloUpdateResponse> runPhlo(@Path("authId") String authId,
                                   @Path("phloId") String phloId,
                                   @Body Map<String, Object> payload);
  //Powerpack
  @POST("Account/{authId}/Powerpack/")
  Call<PowerpackResponse> createPowerpack(@Path("authId") String authId, @Body PowerpackCreator powerpackCreator);

  @GET("Account/{authId}/Powerpack/{uuid}/")
  Call<Powerpack> powerpackGet(@Path("authId") String authId, @Path("uuid") String uuid);

  @GET("Account/{authId}/Powerpack/")
  Call<ListResponse<Powerpack>> powerpackList(@Path("authId") String authId,
                                              @QueryMap Map<String, Object> powerpackListRequest);
  //
  @POST("Account/{authId}/Powerpack/{uuid}/")
  Call<PowerpackUpdateResponse> powerpackUpdate(@Path("authId") String authId,
                                                @Path("uuid") String uuid, @Body PowerpackUpdater powerpackUpdater);
  //
  @DELETE("Account/{authId}/Powerpack/{id}/")
  Call<ResponseBody> powerpackDeleter(@Path("authId") String authId, @Path("uuid") String uuid, @Body PowerpackDeleter powerpackDelete);

  @GET("Account/{authId}/NumberPool/{uuid}/Number/")
  Call <ListResponse<Numbers>> powerpackNumberList(@Path("authId") String authId, @Path("uuid") String uuid,
                                                   @QueryMap Map<String,Object> powerpackNumberListRequest);

  @GET("Account/{authId}/NumberPool/{uuid}/Shortcode/")
  Call<ListResponse<Shortcode>> powerpackShortcodeList(@Path("authId") String authId, @Path("uuid") String uuid,
                                                       @QueryMap Map<String,Object> powerpackShortcodeListRequest);
  //
  @GET("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
  Call<Numbers> powerpackFindNumberGet(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number);

  @GET("Account/{authId}/NumberPool/{uuid}/Shortcode/{shortcode}/")
  Call<Shortcode> powerpackFindShortcodeGet(@Path("authId") String authId, @Path("uuid") String uuid, @Path("shortcode") String shortcode);

  @POST("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
  Call<Numbers> powerpackAddNumberCreate(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number);

  @DELETE("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
  Call<ResponseBody> powerpackNumberDelete(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number, @Body RemoveNumber numberDeleter);

  @POST("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
  Call<Numbers> powerpackBuyAddNumberCreate(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number, @Body BuyAddNumbers numbers);
}
