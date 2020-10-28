package com.plivo.api.models.lookup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.plivo.api.models.base.BaseResource;


public class Number extends BaseResource{
    private String apiId;
    private String phoneNumber;
    private String resourceURI;
    private Country country;
    private Format format;
    private Carrier carrier;

    private int statusCode;

    @Override
    @JsonProperty("api_id")
    public String getApiId() {
	    return apiId;
    }

    @JsonProperty("phone_number")
    public String getPhoneNumber() {
	    return phoneNumber;
    }

    @JsonProperty("country")
    public Country getCountry() {
	    return country;
    }

    @JsonProperty("format")
    public Format getFormat() {
	    return format;
    }

    @JsonProperty("carrier")
    public Carrier getCarrier() {
	    return carrier;
    }

    @JsonProperty("resource_uri")
    public String getResourceURI() {
	    return resourceURI;
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

    @JsonIgnore
    public String getId() {
	    return apiId;
    }

    public static Lookup getter(String number, String type) {
        return new Lookup(number, type);
    }

    public static Lookup getter(String number) {
        return new Lookup(number, "carrier");
    }
}
