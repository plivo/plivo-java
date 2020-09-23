package com.plivo.api.models.enduser;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class EndUserLister extends Lister<EndUser> {


    private String limit;
    private String offset;


    public EndUserLister limit(String limit) {
        this.limit = limit;
        return this;
    }

    public EndUserLister offset(String offset) {
        this.offset = offset;
        return this;
    }

    @Override
    protected Call<ListResponse<EndUser>> obtainCall() {
        return client().getApiService().endUserList(client().getAuthId(), toMap());
    }
}
