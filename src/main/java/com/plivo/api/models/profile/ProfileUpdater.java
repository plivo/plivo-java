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

    public ProfileUpdator entityType (String entityType) {
        this.entityType = entityType;
        return this;
    }

    public ProfileUpdator companyName (String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ProfileUpdator address (ProfileAddress address) {
        this.address = address;
        return this;
    }

    public ProfileUpdator website (String website) {
        this.website = website;
        return this;
    }

    public ProfileUpdator vertical (String vertical) {
        this.vertical = vertical;
        return this;
    }

    public ProfileUpdator authorizedContact (ProfileAuthorizedContact authorizedContact) {
        this.authorizedContact = authorizedContact;
        return this;
    }

    @Override
    protected Call<Profile> obtainCall() {
      return client().getApiService().profileUpdate(client().getAuthId(), id, this);
    }
}