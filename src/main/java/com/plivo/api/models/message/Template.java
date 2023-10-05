package com.plivo.api.models.message;

import java.util.List;
import java.util.ArrayList;

public class Template {
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
