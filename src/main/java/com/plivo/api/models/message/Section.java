package com.plivo.api.models.message;

import java.util.List;

public class Section {
    private String title;
    private List<Row> rows;

    public Section() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
