package com.plivo.api.models.profile;

import com.plivo.api.models.base.MessagingProfileUpdater;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ProfileUpdater extends MessagingProfileUpdater<Profile> {
    private String profileUUID;
    private String entityType;
    private String companyName;
    private ProfileAddress address;
    private String website;
    private String vertical;
    private ProfileAuthorizedContact authorizedContact;
    private String businessContactEmail;
    private String ein;
    private String einIssuingCountry;
    private String altBusinessId;
    private String altBusinessIdType;
    private String doingBusinessAs;
    private Boolean enableCallerReputation;
    private java.util.List<String> vettingProvider;
    private String callbackUrl;
    private String callbackMethod;

    public ProfileUpdater(String id) {
        super(id);
    }

    public String getEntityType(){
        return entityType;
    }
    public String getCompanyName(){
        return companyName;
    }
    public ProfileAddress getAddress(){
        return address;
    }
    public String getWebsite(){
        return website;
    }
    public String getVertical(){
        return vertical;
    }
    public ProfileAuthorizedContact getAuthorizedContact(){
        return authorizedContact;
    }

    public ProfileUpdater entityType (String entityType) {
        this.entityType = entityType;
        return this;
    }

    public ProfileUpdater companyName (String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ProfileUpdater address (ProfileAddress address) {
        this.address = address;
        return this;
    }

    public ProfileUpdater website (String website) {
        this.website = website;
        return this;
    }

    public ProfileUpdater vertical (String vertical) {
        this.vertical = vertical;
        return this;
    }

    public ProfileUpdater authorizedContact (ProfileAuthorizedContact authorizedContact) {
        this.authorizedContact = authorizedContact;
        return this;
    }

    public ProfileUpdater businessContactEmail (String businessContactEmail) {
        this.businessContactEmail = businessContactEmail;
        return this;
    }

    public String getBusinessContactEmail(){
        return businessContactEmail;
    }

    public ProfileUpdater ein (String ein) {
        this.ein = ein;
        return this;
    }

    public String getEin(){
        return ein;
    }

    public ProfileUpdater einIssuingCountry (String einIssuingCountry) {
        this.einIssuingCountry = einIssuingCountry;
        return this;
    }

    public String getEinIssuingCountry(){
        return einIssuingCountry;
    }

    public ProfileUpdater altBusinessId (String altBusinessId) {
        this.altBusinessId = altBusinessId;
        return this;
    }

    public String getAltBusinessId(){
        return altBusinessId;
    }

    public ProfileUpdater altBusinessIdType (String altBusinessIdType) {
        this.altBusinessIdType = altBusinessIdType;
        return this;
    }

    public String getAltBusinessIdType(){
        return altBusinessIdType;
    }

    public ProfileUpdater doingBusinessAs (String doingBusinessAs) {
        this.doingBusinessAs = doingBusinessAs;
        return this;
    }

    public String getDoingBusinessAs(){
        return doingBusinessAs;
    }

    public ProfileUpdater enable_caller_reputation (Boolean enableCallerReputation) {
        this.enableCallerReputation = enableCallerReputation;
        return this;
    }

    public Boolean getEnableCallerReputation(){
        return enableCallerReputation;
    }

    public ProfileUpdater vetting_provider (java.util.List<String> vettingProvider) {
        this.vettingProvider = vettingProvider;
        return this;
    }

    public java.util.List<String> getVettingProvider(){
        return vettingProvider;
    }

    public ProfileUpdater callback_url (String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public String getCallbackUrl(){
        return callbackUrl;
    }

    public ProfileUpdater callback_method (String callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public String getCallbackMethod(){
        return callbackMethod;
    }

    @Override
    protected Call<Profile> obtainCall() {
      return client().getApiService().profileUpdate(client().getAuthId(), id, this);
    }
}