package com.plivo.api.models.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


public class Format{
    private String e164;
    private String international;
    private String national;
    private String rfc3966;

    @JsonProperty("e164")
    public String getE164() {
        return e164;
    }

    @JsonProperty("international")
    public String getInternational() {
        return international;
    }

    @JsonProperty("national")
    public String getNational() {
        return national;
    }

    @JsonProperty("rfc3966")
    public String getRFC3966() {
        return rfc3966;
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
