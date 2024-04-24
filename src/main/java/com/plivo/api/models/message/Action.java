package com.plivo.api.models.message;

import java.util.List;

public class Action {
    private List<Button> buttons; // List of buttons for multiple options
    private List<Section> sections; // List of sections

    public Action() {
    }

    // Getters and setters for buttons
    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    // Getters and setters for sections
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
