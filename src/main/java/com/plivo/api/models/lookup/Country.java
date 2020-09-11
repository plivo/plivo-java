package com.plivo.api.models.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


public class Country{
    private String name;
    private String codeISO2;
    private String codeISO3;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("code_iso2")
    public String getCodeISO2() {
        return codeISO2;
    }

    @JsonProperty("code_iso3")
    public String getCodeISO3() {
        return codeISO3;
    }

    @Override
    public String toString() {
       try {
           return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
       } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
           e.printStackTrace();
       }
       return null;
    }
}
