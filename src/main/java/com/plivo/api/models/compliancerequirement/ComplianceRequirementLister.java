package com.plivo.api.models.compliancerequirement;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceRequirementLister extends Getter<ComplianceRequirement> {
    private String number;
    private String countryIso2;
    private String endUserType;
    private String numberType;

    public ComplianceRequirementLister(String number) {
        super(number);
        this.number = number;
    }

//    public ComplianceRequirementLister limit(String limit) {
//        this.limit = limit;
//        return this;
//    }
//
//    public ComplianceRequirementLister offset(String offset) {
//        this.offset = offset;
//        return this;
//    }

    public ComplianceRequirementLister countryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
        return this;
    }

    public ComplianceRequirementLister endUserType(String endUserType) {
        this.endUserType = endUserType;
        return this;
    }

    public ComplianceRequirementLister numberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    @Override
    protected Call<ComplianceRequirement> obtainCall() {
        return client().getApiService().complianceRequirementList(client().getAuthId(), toMap());
    }
}
