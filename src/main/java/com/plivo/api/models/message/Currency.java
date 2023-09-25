package com.plivo.api.models.message;

import java.util.List;
import java.util.ArrayList;

public class Currency {
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