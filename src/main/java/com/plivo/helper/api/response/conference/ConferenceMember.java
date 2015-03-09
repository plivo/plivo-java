package com.plivo.helper.api.response.conference;

import com.google.gson.annotations.SerializedName;

public class ConferenceMember {
    public Boolean muted ;
    
    @SerializedName("member_id")
    public String memberId ;
    
    public Boolean deaf ;
    
    public String from ;
    
    public String to ;
    
    @SerializedName("caller_name")
    public String callerName ;
    
    public String direction ;
    
    @SerializedName("call_uuid")
    public String callUUID ;
    
    @SerializedName("join_time")
    public String joinTime ;
    
    public ConferenceMember() {
        // empty
    }

	@Override
	public String toString() {
		return "ConferenceMember [muted=" + muted + ", memberId=" + memberId
				+ ", deaf=" + deaf + ", from=" + from + ", to=" + to
				+ ", callerName=" + callerName + ", direction=" + direction
				+ ", callUUID=" + callUUID + ", joinTime=" + joinTime + "]";
	}
}
