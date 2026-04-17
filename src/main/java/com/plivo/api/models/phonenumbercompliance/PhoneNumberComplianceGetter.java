package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.Getter;
import java.util.Map;
import retrofit2.Call;

public class PhoneNumberComplianceGetter extends Getter<PhoneNumberComplianceGetResponse> {

    private String expand;

    public PhoneNumberComplianceGetter(String id) {
        super(id);
    }

    public String expand() {
        return this.expand;
    }

    public PhoneNumberComplianceGetter expand(String expand) {
        this.expand = expand;
        return this;
    }

    @Override
    protected Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.remove("id");
        map.remove("secondaryId");
        return map;
    }

    @Override
    protected Call<PhoneNumberComplianceGetResponse> obtainCall() {
        return client().getApiService().phoneNumberComplianceGet(client().getAuthId(), id, toMap());
    }
}
