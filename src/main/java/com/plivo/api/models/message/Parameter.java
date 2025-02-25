package com.plivo.api.models.message;

import java.util.List;
import java.util.ArrayList;

public class Parameter {
    private String type;
    private String text;
    private String media;
    private String payload;
    private Currency currency;
    private DateTime date_time;
    private Location location;
    private String parameter_name;

    
    public Parameter() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public DateTime getDateTime() {
        return date_time;
    }

    public void setDateTime(DateTime date_time) {
        this.date_time = date_time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

        public String getParameterName() {
        return parameter_name;
    }

    public void setParameterName(String parameter_name) {
        this.parameter_name = parameter_name;
    }
}