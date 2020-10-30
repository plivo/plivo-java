package com.plivo.api;

import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface LookupAPIService {
  @GET("Number/{number}")
  Call<com.plivo.api.models.lookup.Number> lookupGet(@Path("number") String number, @Query("type") String type);
}
