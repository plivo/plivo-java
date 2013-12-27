package com.plivo.helper.resource;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.DeleteResponse;
import com.plivo.helper.response.ModifyResponse;
import com.plivo.helper.response.SubAccountCreateResponse;

public class SubAccount extends Resource {
	private String account ;

    @SerializedName("api_id")
    private String apiId ;
    
    @SerializedName("auth_id")
    private String authId ;
    
    @SerializedName("auth_token")
    private String authToken ;
   
    @SerializedName("resource_uri")
    private String resourceUri ;
    
    @SerializedName("created")
    private String createdOn ;
    
    @SerializedName("enabled")
    private Boolean isEnabled ;
    
    @SerializedName("modified")
    private String lastModifiedOn ;
    
    private String name ;
    
    private static String baseLocation = "/Subaccount/";
    
    public static SubAccount get(String subauthId, PlivoRestConf conf) throws PlivoException {
    	Gson gson = new Gson();
    	SubAccount sa =  gson.fromJson(request("GET", String.format(baseLocation + "%s/", subauthId),
    			new LinkedHashMap<String, String>(), conf), 
    			SubAccount.class);
    	if (sa.isGetOK()) {
    		sa.conf = conf;
    		return sa;
    	}
    	return null;
    }
    
    public static SubAccountList getList(LinkedHashMap<String, String> parameters, PlivoRestConf conf) throws PlivoException {
    	Gson gson = new Gson();
    	SubAccountList sal = gson.fromJson(request("GET", baseLocation, parameters, conf), 
    			SubAccountList.class);
    	if (sal.isGetOK()) {
    		return sal;
    	}
    	return null;
    }
    
    public static String create(LinkedHashMap<String, String> parameters, PlivoRestConf conf) throws PlivoException {
    	Gson gson = new Gson();
		SubAccountCreateResponse scr =  gson.fromJson(request("POST", baseLocation, parameters, conf), 
				SubAccountCreateResponse.class);
		if (scr.isSuccessful()) {
			return scr.getAuthId();
		}else {
			return null;
		}
    }
    
    public static boolean modify(String subAuthId, LinkedHashMap<String, String> parameters, PlivoRestConf conf)throws PlivoException {
    	Gson gson = new Gson();
    	ModifyResponse mr = gson.fromJson(request("POST", String.format(baseLocation + "%s/", subAuthId),
    			parameters, conf), 
    			ModifyResponse.class);
    	return mr.isSuccessful();
    }
    
    public static boolean delete(String subAuthId, PlivoRestConf conf) throws PlivoException {
    	DeleteResponse dr;
    	Gson gson = new Gson();
    	dr = gson.fromJson(request("DELETE", String.format(baseLocation + "%s/", subAuthId), 
    			new LinkedHashMap<String, String>(), conf), 
    			DeleteResponse.class);
    	return dr.isSuccessful();
    }
    
    public boolean delete() throws PlivoException {
    	DeleteResponse dr;
    	Gson gson = new Gson();
    	dr = gson.fromJson(request("DELETE", String.format(baseLocation + "%s/", this.authId), 
    			new LinkedHashMap<String, String>(), this.conf), 
    			DeleteResponse.class);
    	return dr.isSuccessful();
    }

	public String getAccount() {
		return account;
	}

	public String getApiId() {
		return apiId;
	}

	public String getAuthId() {
		return authId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public String getLastModifiedOn() {
		return lastModifiedOn;
	}

	public String getName() {
		return name;
	}
}
