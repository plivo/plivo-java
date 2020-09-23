package com.plivo.api.models.enduser;

import com.plivo.api.models.base.BaseResource;

public class EndUser extends BaseResource {
    private String endUserId;
    private String createdAt;
    private String name;
    private String lastName;
    private String endUserType;

    public static EndUserGetter getter(String id) {
        return new EndUserGetter(id);
    }

    @Override
    public String getId() {
        return endUserId;
    }
}
