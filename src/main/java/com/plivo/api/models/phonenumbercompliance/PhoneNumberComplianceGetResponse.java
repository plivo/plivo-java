package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.BaseResource;

public class PhoneNumberComplianceGetResponse extends BaseResource {

    private PhoneNumberCompliance compliance;

    public PhoneNumberCompliance getCompliance() {
        return compliance;
    }

    @Override
    public String getId() {
        return compliance != null ? compliance.getId() : null;
    }
}
