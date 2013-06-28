package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class OutgoingCarrier {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("carrier_id")
    public String carrierId ;
    
    @SerializedName("ips")
    public String ips ;
    
    @SerializedName("name")
    public String name ;

    @SerializedName("address")
	public String address ;
    
    @SerializedName("prefix")
	public String prefix ;

    @SerializedName("failover_address")
	public String failoverAddress ;

    @SerializedName("failover_prefix")
	public String failoverPrefix ;
    
    @SerializedName("suffix")
	public String suffix ;
    
    @SerializedName("enabled")
    public Boolean enabled ;
    
    @SerializedName("retries")
	public Integer retries ;
    
    @SerializedName("retry_seconds")
	public Integer retrySeconds ;
        
    @SerializedName("resource_uri")
    public String resourceUri ;
    
    public OutgoingCarrier() {
        // empty
    }
}
