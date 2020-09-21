package com.plivo.api.models.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


public class Carrier{
    private String mobileCountryCode;
    private String mobileNetworkCode;
    private String name;
    private boolean ported;
    private String type;

    @JsonProperty("name")
    public String getName() {
	    return name;
    }

    @JsonProperty("type")
    public String getType() {
	    return type;
    }

    @JsonProperty("mobile_country_code")
    public String getMobileCountryCode() {
	    return mobileCountryCode;
    }

    @JsonProperty("mobile_network_code")
    public String getMobileNetworkCode() {
	    return mobileNetworkCode;
    }

    @JsonProperty("ported")
    public boolean isPorted() {
	    return ported;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
           e.printStackTrace();
        }

        return null;
    }
}
