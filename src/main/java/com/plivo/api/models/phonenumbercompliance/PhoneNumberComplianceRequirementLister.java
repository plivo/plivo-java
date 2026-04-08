package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PhoneNumberComplianceRequirementLister extends Getter<PhoneNumberComplianceRequirement> {

    private String countryIso;
    private String numberType;
    private String userType;

    PhoneNumberComplianceRequirementLister() {
        super("requirements");
    }

    public PhoneNumberComplianceRequirementLister countryIso(String countryIso) {
        this.countryIso = countryIso;
        return this;
    }

    public PhoneNumberComplianceRequirementLister numberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public PhoneNumberComplianceRequirementLister userType(String userType) {
        this.userType = userType;
        return this;
    }

    @Override
    protected Call<PhoneNumberComplianceRequirement> obtainCall() {
        return client().getApiService().phoneNumberComplianceRequirementList(client().getAuthId(), toMap());
    }
}
