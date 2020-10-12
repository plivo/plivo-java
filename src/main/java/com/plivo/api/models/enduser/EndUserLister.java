package com.plivo.api.models.enduser;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class EndUserLister extends Lister<EndUser> {

    @Override
    protected Call<ListResponse<EndUser>> obtainCall() {
        return client().getApiService().endUserList(client().getAuthId(), toMap());
    }
}
