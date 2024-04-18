package com.plivo.api.models.message;

import java.util.List;

public class Button {
    private String type;
    private Reply reply;

    public Button() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}