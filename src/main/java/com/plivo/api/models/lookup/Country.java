package com.plivo.api.models.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


public class Country{
    private String name;
    private String iso2;
    private String iso3;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("iso2")
    public String getISO2() {
        return iso2;
    }

    @JsonProperty("iso3")
    public String getISO3() {
        return iso3;
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
