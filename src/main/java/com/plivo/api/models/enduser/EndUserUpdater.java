package com.plivo.api.models.enduser;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class EndUserUpdater extends Updater<EndUserUpdateResponse> {

    private String name;
    private String lastName;
    private String endUserType;

    public EndUserUpdater(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public EndUserUpdater name(final String name) {
        this.name = name;
        return this;
    }

    public EndUserUpdater lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EndUserUpdater endUserType(final String endUserType) {
        this.endUserType = endUserType;
        return this;
    }

    @Override
    protected Call<EndUserUpdateResponse> obtainCall() {
        return client().getApiService().endUserUpdate(client().getAuthId(), id, this);
    }
}
