package com.plivo.api.models.lookup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.plivo.api.models.base.BaseResource;


public class Number extends BaseResource{
    private String apiId;
    private Country country;
    private NumberFormat numberFormat;
    private ServiceProvider serviceProvider;

    private int statusCode;

    @Override
    @JsonProperty("api_id")
    public String getApiId() {
	    return apiId;
    }

    @JsonProperty("country")
    public Country getCountry() {
	    return country;
    }

    @JsonProperty("number_format")
    public NumberFormat getNumberFormat() {
	    return numberFormat;
    }

    @JsonProperty("service_provider")
    public ServiceProvider getServiceProvider() {
	    return serviceProvider;
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

    public static Lookup getter(String number, String info) {
        return new Lookup(number, info);
    }
}
