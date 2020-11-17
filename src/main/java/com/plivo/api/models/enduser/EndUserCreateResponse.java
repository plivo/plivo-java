package com.plivo.api.models.enduser;

import com.plivo.api.models.base.BaseResponse;

public class EndUserCreateResponse extends BaseResponse {
    private String endUserId;
    private String createdAt;
    private String name;
    private String lastName;
    private String endUserType;

    public String getEndUserId() {
        return endUserId;
    }
}
