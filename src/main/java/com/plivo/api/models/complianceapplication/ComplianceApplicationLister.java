package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceApplicationLister extends Lister<ComplianceApplication> {

    private String endUserType;
    private String numberType;
    private String countryIso2;
    private String endUserId;
    private String alias ;
    private String status ;

    public String alias() {
      return this.alias;
    }
    public String countryIso2() {
      return this.countryIso2;
    }
    public String endUserId(){ return this.endUserId; }
    public String endUserType(){ return this.endUserType; }
    public String numberType(){ return this.numberType; }
    public String status(){ return this.status; }

    public ComplianceApplicationLister alias(final String alias) {
      this.alias = alias;
      return this;
    }

    public ComplianceApplicationLister countryIso2(final String countryIso2) {
      this.countryIso2 = countryIso2;
      return this;
    }

    public ComplianceApplicationLister endUserId(final String endUserId) {
      this.endUserId = endUserId;
      return this;
    }

    public ComplianceApplicationLister numberType(final String numberType) {
      this.numberType = numberType;
      return this;
    }

    public ComplianceApplicationLister endUserType(final String endUserType) {
      this.endUserType = endUserType;
      return this;
    }

  public ComplianceApplicationLister status(final String status) {
    this.status = status;
    return this;
  }

//  public ComplianceApplicationLister setNumberType(String numberType) {
//        this.numberType = numberType;
//        return this;
//    }
//
//    public ComplianceApplicationLister setEndUserType(String endUserType) {
//        this.endUserType = endUserType;
//        return this;
//    }
//
//    public ComplianceApplicationLister setCountryIso2(String countryIso2) {
//        this.countryIso2 = countryIso2;
//        return this;
//    }

    @Override
    protected Call<ListResponse<ComplianceApplication>> obtainCall() {
        return client().getApiService().complianceApplicationList(client().getAuthId(), toMap());
    }
}
