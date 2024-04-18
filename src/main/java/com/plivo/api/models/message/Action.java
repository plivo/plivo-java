package com.plivo.api.models.message;

import java.util.List;

public class Action {
    private String button; // Single button
    private List<Button> buttons; // List of buttons for multiple options
    private String productRetailerID;
    private String catalogID;
    private List<Section> sections;
    private String name; // Name of the action
    private Parameter parameters; // Additional parameters for the action

    public Action() {
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public String getProductRetailerID() {
        return productRetailerID;
    }

    public void setProductRetailerID(String productRetailerID) {
        this.productRetailerID = productRetailerID;
    }

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public void setParameters(Parameter parameters) {
        this.parameters = parameters;
    }
}
