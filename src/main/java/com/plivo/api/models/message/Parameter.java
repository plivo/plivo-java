package com.plivo.api.models.message;

import java.util.List;
import java.util.ArrayList;

public class Parameter {
    private String type;
    private String text;
    private String media;
    private Currency currency;
    private String displayText;
    private String url;
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

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}