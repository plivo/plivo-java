package com.plivo.api.models.enduser;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class EndUserGetter extends Getter<EndUser> {

    public EndUserGetter(String id) {
        super(id);
    }

    @Override
    protected Call<EndUser> obtainCall() {
        return client().getApiService().endUserGet(client().getAuthId(), id);
    }
}
