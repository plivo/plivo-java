package com.plivo.api;

import com.plivo.api.models.account.*;
import com.plivo.api.models.address.*;
import com.plivo.api.models.application.*;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.call.*;
import com.plivo.api.models.call.actions.*;
import com.plivo.api.models.complianceapplication.*;
import com.plivo.api.models.compliancedocument.*;
import com.plivo.api.models.compliancedocumenttype.*;
import com.plivo.api.models.compliancerequirement.*;
import com.plivo.api.models.conference.*;
import com.plivo.api.models.endpoint.*;
import com.plivo.api.models.enduser.*;
import com.plivo.api.models.identity.*;
import com.plivo.api.models.media.Media;
import com.plivo.api.models.media.MediaResponse;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageCreator;
import com.plivo.api.models.message.MmsMedia;
import com.plivo.api.models.node.*;
import com.plivo.api.models.number.*;
import com.plivo.api.models.number.Number;
import com.plivo.api.models.phlo.Phlo;
import com.plivo.api.models.phlo.PhloRunGetterResponse;
import com.plivo.api.models.phlo.PhloUpdateResponse;
import com.plivo.api.models.powerpack.*;
import com.plivo.api.models.pricing.Pricing;
import com.plivo.api.models.recording.Recording;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

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

    @HTTP(method = "DELETE", path = "Account/{authId}/Application/{appId}/", hasBody = true)
    Call<ResponseBody> applicationDelete(@Path("authId") String authId, @Path("appId") String appId, @Body ApplicationDeleter application);

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

    @HTTP(method = "DELETE", path = "Account/{authId}/Subaccount/{subauthId}/", hasBody = true)
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

    @GET("Account/{authId}/Message/{id}/Media/")
    Call<ListResponse<MmsMedia>> mmsMediaList(@Path("authId") String authId, @Path("id") String id);

    @GET("Account/{authId}/Message/{id}/Media/{media_id}/")
    Call<MmsMedia> mmsMediaGet(@Path("authId") String authId, @Path("id") String id, @Path("media_id") String media_id);

    @DELETE("Account/{authId}/Message/{id}/Media/")
    Call<ResponseBody> mmsMediaDelete(@Path("authId") String authId, @Path("id") String id);

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
    @HTTP(method = "DELETE", path = "Account/{authId}/Powerpack/{id}/", hasBody = true)
    Call<ResponseBody> powerpackDeleter(@Path("authId") String authId, @Path("id") String id, @Body PowerpackDeleter powerpackDelete);

    @GET("Account/{authId}/NumberPool/{uuid}/Number/")
    Call<ListResponse<Numbers>> powerpackNumberList(@Path("authId") String authId, @Path("uuid") String uuid,
                                                    @QueryMap Map<String, Object> powerpackNumberListRequest);

    @GET("Account/{authId}/NumberPool/{uuid}/Shortcode/")
    Call<ListResponse<Shortcode>> powerpackShortcodeList(@Path("authId") String authId, @Path("uuid") String uuid,
                                                         @QueryMap Map<String, Object> powerpackShortcodeListRequest);

    //
    @GET("Account/{authId}/NumberPool/{uuid}/Tollfree/")
    Call<ListResponse<Tollfree>> powerpackTollfreeList(@Path("authId") String authId, @Path("uuid") String uuid,
                                                       @QueryMap Map<String, Object> powerpackTollfreeListRequest);

    @GET("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
    Call<Numbers> powerpackFindNumberGet(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number);

    @GET("Account/{authId}/NumberPool/{uuid}/Shortcode/{shortcode}/")
    Call<Shortcode> powerpackFindShortcodeGet(@Path("authId") String authId, @Path("uuid") String uuid, @Path("shortcode") String shortcode);

    @GET("Account/{authId}/NumberPool/{uuid}/Tollfree/{tollfree}/")
    Call<Tollfree> powerpackFindTollfreeGet(@Path("authId") String authId, @Path("uuid") String uuid, @Path("tollfree") String tollfree);

    @POST("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
    Call<Numbers> powerpackAddNumberCreate(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number, @Body PowerpackAddNumber addnumber);

    @POST("Account/{authId}/NumberPool/{uuid}/Tollfree/{tollfree}/")
    Call<Tollfree> powerpackAddTollfreeCreate(@Path("authId") String authId, @Path("uuid") String uuid, @Path("tollfree") String tollfree, @Body PowerpackAddTollfree addtollfree);

    @HTTP(method = "DELETE", path = "Account/{authId}/NumberPool/{uuid}/Number/{number}/", hasBody = true)
    Call<ResponseBody> powerpackNumberDelete(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number, @Body RemoveNumber numberDeleter);

    @HTTP(method = "DELETE", path = "Account/{authId}/NumberPool/{uuid}/Tollfree/{tollfree}/", hasBody = true)
    Call<ResponseBody> powerpackTollfreeDelete(@Path("authId") String authId, @Path("uuid") String uuid, @Path("tollfree") String tollfree, @Body RemoveTollfree tollfreeDeleter);

    @HTTP(method = "DELETE", path = "Account/{authId}/NumberPool/{uuid}/Shortcode/{shortcode}/", hasBody = true)
    Call<ResponseBody> powerpackShortcodeDelete(@Path("authId") String authId, @Path("uuid") String uuid, @Path("shortcode") String shortcode, @Body RemoveShortcode shortcodeDeleter);

    @POST("Account/{authId}/NumberPool/{uuid}/Number/{number}/")
    Call<Numbers> powerpackBuyAddNumberCreate(@Path("authId") String authId, @Path("uuid") String uuid, @Path("number") String number, @Body BuyAddNumbers numbers);

    @GET("Account/{authId}/Media/")
    Call<ListResponse<Media>> mediaList(@Path("authId") String authId, @QueryMap Map<String, Object> mediaListRequest);

    @GET("Account/{authId}/Media/{id}/")
    Call<Media> mediaGet(@Path("authId") String authId, @Path("id") String id);

    @POST("Account/{authId}/Media/")
    Call<MediaResponse> uploadMedia(@Path("authId") String authId,
                                    @Body RequestBody mediaUploads);


    // Enduser
    // Get
    @GET("Account/{authId}/EndUser/{id}/")
    Call<EndUser> endUserGet(@Path("authId") String authId, @Path("id") String id);

    // Create
    @POST("Account/{authId}/EndUser/")
    Call<EndUserCreateResponse> endUserCreate(@Path("authId") String authId,
                                              @Body EndUserCreator endUserCreator);

    // Update
    @POST("Account/{authId}/EndUser/{id}/")
    Call<EndUserUpdateResponse> endUserUpdate(@Path("authId") String authId, @Path("id") String id,
                                              @Body EndUserUpdater endUserUpdater);

    // List all end user
    @GET("Account/{authId}/EndUser/")
    Call<ListResponse<EndUser>> endUserList(@Path("authId") String authId,
                                            @QueryMap Map<String, Object> endUserListRequest);

    @DELETE("Account/{authId}/EndUser/{id}/")
    Call<ResponseBody> endUserDelete(@Path("authId") String authId, @Path("id") String endUserId);

    // Compliance Document Type
    // Get
    @GET("Account/{authId}/ComplianceDocumentType/{id}/")
    Call<ComplianceDocumentType> complianceDocumentTypeGet(@Path("authId") String authId, @Path("id") String id);

    // List
    @GET("Account/{authId}/ComplianceDocumentType/")
    Call<ListResponse<ComplianceDocumentType>> complianceDocumentTypeList(@Path("authId") String authId,
                                                                          @QueryMap Map<String, Object> complianceDocumentListRequest);


    // Compliance Requirement
    // Get
    @GET("Account/{authId}/ComplianceRequirement/{id}/")
    Call<ComplianceRequirement> complianceRequirementGet(@Path("authId") String authId, @Path("id") String id);

    // List
    @GET("Account/{authId}/ComplianceRequirement/")
    Call<ComplianceRequirement> complianceRequirementList(@Path("authId") String authId,
                                                          @QueryMap Map<String, Object> complianceDocumentListRequest);


    // Compliance Application
    // Get
    @GET("Account/{authId}/ComplianceApplication/{id}/")
    Call<ComplianceApplication> complianceApplicationGet(@Path("authId") String authId, @Path("id") String id);

    // Create
    @POST("Account/{authId}/ComplianceApplication/")
    Call<ComplianceApplicationCreateResponse> complianceApplicationCreate(@Path("authId") String authId,
                                                                          @Body ComplianceApplicationCreator complianceApplicationCreator);

    // Update
    @POST("Account/{authId}/ComplianceApplication/{id}/")
    Call<ComplianceApplicationUpdateResponse> complianceApplicationUpdate(@Path("authId") String authId, @Path("id") String id,
                                                                          @Body ComplianceApplicationUpdater complianceApplicationUpdater);

    // List
    @GET("Account/{authId}/ComplianceApplication/")
    Call<ListResponse<ComplianceApplication>> complianceApplicationList(@Path("authId") String authId,
                                                                        @QueryMap Map<String, Object> complianceApplicationLister);


    // Delete
    @DELETE("Account/{authId}/ComplianceApplication/{id}/")
    Call<ResponseBody> complianceApplicationDelete(@Path("authId") String authId, @Path("id") String complianceApplicationId);

    // Submit
    @POST("Account/{authId}/ComplianceApplication/{id}/Submit")
    Call<ComplianceApplication> complianceApplicationSubmit(@Path("authId") String authId, @Path("id") String id);


    // Compliance Document
    // Get
    @GET("Account/{authId}/ComplianceDocument/{id}/")
    Call<ComplianceDocument> complianceDocumentGet(@Path("authId") String authId, @Path("id") String id);

    // Create
    @POST("Account/{authId}/ComplianceDocument/")
    Call<ComplianceDocumentCreateResponse> complianceDocumentCreate(@Path("authId") String authId,
                                                                    @Body ComplianceDocumentCreator complianceDocumentCreator,
                                                                    @Body RequestBody file);

    // Update
    @POST("Account/{authId}/ComplianceDocument/{id}/")
    Call<ComplianceDocumentUpdateResponse> complianceDocumentUpdate(@Path("authId") String authId, @Path("id") String id,
                                                                    @Body ComplianceDocumentUpdater complianceDocumentUpdater,
                                                                    @Body RequestBody file);

    // List
    @GET("Account/{authId}/ComplianceDocument/")
    Call<ListResponse<ComplianceDocument>> complianceDocumentList(@Path("authId") String authId,
                                                                  @QueryMap Map<String, Object> complianceDocumentLister);


    // Delete
    @DELETE("Account/{authId}/ComplianceDocument/{id}/")
    Call<ResponseBody> complianceDocumentDelete(@Path("authId") String authId, @Path("id") String complianceDocumentId);

}

