package com.plivo.api.models.message;

public class Button {
    private String id; // Unique identifier for the button
    private String title; // Display text for the button
    private String cta_url;

    public Button() {
    }

    // Getters and setters for ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and setters for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters for CTA URL
    public String getCta_url() {
        return cta_url;
    }

    public void setCta_url(String cta_url) {
        this.cta_url = cta_url;
    }
}
