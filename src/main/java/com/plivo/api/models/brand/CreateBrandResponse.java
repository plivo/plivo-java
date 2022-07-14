package com.plivo.api.models.brand;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;
public class CreateBrandResponse extends BaseResponse {
    private String brandID;
    private String message;
    private String profileUUID;
    private String error;

    public CreateBrandResponse() {
        public String getBrandID() {
            return brandID;
        }

        public String getMessage() {
            return message;
        }

        public String getProfileUUID() {
            return profileUUID;
        }

        public String getError() {
            return error;
        }
    }
}