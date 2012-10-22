package com.plivo.sdk.response.account;

import java.util.List;

public class SubAccountList {
    public SubAccountMeta meta ;
    public String error ;
    public String api_id ;
    public List<SubAccount> objects ;
    
    public SubAccountList() {
        // empty
    }
}
