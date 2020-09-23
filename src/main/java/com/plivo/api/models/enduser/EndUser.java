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

    public static EndUserCreator creator(String name, String lastName, String endUserType) {
        return new EndUserCreator(name, lastName, endUserType);
    }

    public EndUserUpdater updater() {
        return new EndUserUpdater(getEndUserId());
    }

    public EndUserDeleter deleter() {
        return new EndUserDeleter(getEndUserId());
    }

    public static EndUserLister lister() {
        return new EndUserLister();
    }

    public String getEndUserId() {
        return endUserId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEndUserType() {
        return endUserType;
    }

    @Override
    public String getId() {
        return endUserId;
    }
}
