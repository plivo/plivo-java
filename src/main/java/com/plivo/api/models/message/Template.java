package com.plivo.api.models.message;

import java.util.List;
import java.util.ArrayList;

class Template {
    private String name;
    private String language;
    private List<Component> components;

    public Template() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}

class Component {
    private String type;
    private String sub_type;
    private String index;
    private List<Parameter> parameters;

    public Component() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}

class Parameter {
    private String type;
    private String text;
    private String media;
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

class Currency {
    private String fallback_value;
    private String currency_code;
    private Integer amount_1000;

    public Currency() {
    }

    public String getFallback_value() {
        return fallback_value;
    }

    public void setFallback_value(String fallback_value) {
        this.fallback_value = fallback_value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public Integer getAmount_1000() {
        return amount_1000;
    }

    public void setAmount_1000(Integer amount_1000) {
        this.amount_1000 = amount_1000;
    }
}

class DateTime {
    private String fallback_value;

    public DateTime() {
    }

    public String getFallback_value() {
        return fallback_value;
    }

    public void setFallback_value(String fallback_value) {
        this.fallback_value = fallback_value;
    }
}