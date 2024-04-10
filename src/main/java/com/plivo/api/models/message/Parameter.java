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

    public String getPaylaod() {
        return payload;
    }

    public void getPaylaod(String payload) {
        this.payload = payload;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public DateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(DateTime date_time) {
        this.date_time = date_time;
    }
}