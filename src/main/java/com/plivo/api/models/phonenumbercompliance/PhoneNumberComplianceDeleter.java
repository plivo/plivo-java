package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class PhoneNumberComplianceDeleter extends Deleter<PhoneNumberCompliance> {

    public PhoneNumberComplianceDeleter(String id) {
        super(id);
    }

    @Override
    protected Call<ResponseBody> obtainCall() {
        return client().getApiService().phoneNumberComplianceDelete(client().getAuthId(), id);
    }
}
