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

    @Override
    protected Call<Profile> obtainCall() {
      return client().getApiService().profileUpdate(client().getAuthId(), id, this);
    }
}