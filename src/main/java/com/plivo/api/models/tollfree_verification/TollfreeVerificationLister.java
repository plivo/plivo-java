package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.PropertyFilter;
import retrofit2.Call;

public class TollfreeVerificationLister extends Lister<TollfreeVerification> {
  private String usecase;
  private String status;
  private PropertyFilter<String> created;
  private String number;
  private String profileUuid;

  public String usecase() {
    return usecase;
  }

  public TollfreeVerificationLister usecase(String usecase) {
    this.usecase = usecase;
    return this;
  }

  public String status() {
    return status;
  }

  public TollfreeVerificationLister status(final String status) {
    this.status = status;
    return this;
  }

  public PropertyFilter<String> created() {
    return created;
  }

  public TollfreeVerificationLister created(final PropertyFilter<String> created) {
    this.created = created;
    return this;
  }

  public String number() {
    return number;
  }

  public TollfreeVerificationLister number(final String number) {
    this.number = number;
    return this;
  }

  public String profileUuid() {
    return profileUuid;
  }

  public TollfreeVerificationLister profileUuid(final String profileUuid) {
    this.profileUuid = profileUuid;
    return this;
  }



  @Override
  protected Call<ListResponse<TollfreeVerification>> obtainCall() {
    return client().getApiService().tollfreeVerificationList(client().getAuthId(), toMap());
  }

}