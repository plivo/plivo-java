package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceApplicationLister extends Lister<ComplianceApplication> {


    private String limit;
    private String offset;

    private String status;
    private String endUserType;
    private String numberType;
    private String countryIso2;
    private String alias;

    public ComplianceApplicationLister limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ComplianceApplicationLister offset(String offset) {
        this.offset = offset;
        return this;
    }

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
