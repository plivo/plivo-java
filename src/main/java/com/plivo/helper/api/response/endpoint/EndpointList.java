package com.plivo.helper.api.response.endpoint;

import java.util.List;

public class EndpointList {
    public EndpointMeta meta ;
    public String error ;
    public String api_id ;
    public List<Endpoint> objects ;
    
    public EndpointList() {
        // empty
    }

}
