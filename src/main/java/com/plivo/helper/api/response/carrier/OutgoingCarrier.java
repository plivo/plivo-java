package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class OutgoingCarrier {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("carrier_id")
    public String carrierId ;
    
    public String ips ;
    
    public String name ;

	public String address ;
    
	public String prefix ;

    @SerializedName("failover_address")
	public String failoverAddress ;

    @SerializedName("failover_prefix")
	public String failoverPrefix ;
    
	public String suffix ;
    
    public Boolean enabled ;
    
	public Integer retries ;
    
    @SerializedName("retry_seconds")
	public Integer retrySeconds ;
        
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    public OutgoingCarrier() {
        // empty
    }
}
