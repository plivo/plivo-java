package com.plivo.sdk.response.conference;

import java.util.List;

public class Conference {
    public String conference_name ;
    public String conference_run_time ;
    public String conference_member_count ;
    public List<ConferenceMember> members ;
    public String api_id ;
    
    public Conference() {
        // empty
    }

}
