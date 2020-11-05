package com.plivo.api.models.enduser;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.models.enduser.EndUser;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class EndUserDeleter extends Deleter<EndUser> {

    public EndUserDeleter(String id) {
        super(id);
    }

    @Override
    protected Call<ResponseBody> obtainCall() {
        return client().getApiService().endUserDelete(client().getAuthId(), id);
    }
}

