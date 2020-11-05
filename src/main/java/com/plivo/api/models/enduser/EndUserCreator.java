package com.plivo.api.models.enduser;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class EndUserCreator extends Creator<EndUserCreateResponse> {

    private String name;
    private String lastName;
    private String endUserType;

    EndUserCreator(String name, String lastName, String endUserType) {
        if (!Utils.allNotNull(name, lastName)) {
            throw new IllegalArgumentException("name, lastName must not be null");
        }

        this.name = name;
        this.endUserType = endUserType;
        this.lastName = lastName;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Call<EndUserCreateResponse> obtainCall() {
        return client().getApiService().endUserCreate(client().getAuthId(), this);
    }
}
