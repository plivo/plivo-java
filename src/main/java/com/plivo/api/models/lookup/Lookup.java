package com.plivo.api.models.lookup;

import retrofit2.Call;

import com.plivo.api.models.base.Getter;

public class Lookup extends Getter<Number> {

    protected final String number;
    protected final String type;

    public Lookup(String number, String type) {
        super(number); // use number as id of the resource
        this.number = number;
        this.type = type;
    }

    @Override
    protected Call<Number> obtainCall() {
       return client().getApiService().lookupGet(number, type);
    }
}
