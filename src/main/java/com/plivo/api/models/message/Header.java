package com.plivo.api.models.message;

public class Header {
    private String type;
    private String text;
    private Media image;
    private Media document;
    private Media video;

    public Header() {
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

    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }

    public Media getDocument() {
        return document;
    }

    public void setDocument(Media document) {
        this.document = document;
    }

    public Media getVideo() {
        return video;
    }

    public void setVideo(Media video) {
        this.video = video;
    }
}
