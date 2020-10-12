package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceApplicationLister extends Lister<ComplianceApplication> {

    private String endUserType;
    private String numberType;
    private String countryIso2;

    public ComplianceApplicationLister setNumberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public ComplianceApplicationLister setEndUserType(String endUserType) {
        this.endUserType = endUserType;
        return this;
    }

    public ComplianceApplicationLister setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
        return this;
    }

    @Override
    protected Call<ListResponse<ComplianceApplication>> obtainCall() {
        return client().getApiService().complianceApplicationList(client().getAuthId(), toMap());
    }
}
