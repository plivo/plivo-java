package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.AuthenticationException;
import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.exceptions.ServerException;
import com.plivo.api.exceptions.GeoPermissionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import okhttp3.ResponseBody;
import retrofit2.Response;

// Needed because we use fluent style APIs
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public abstract class BaseRequest<T extends BaseResource> {
  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getClient();

  private static final List<String> GEO_PERMISSION_ENDPOINTS = Arrays.asList(
    "/Call/",
    "/Message/",
    "/Session/"
  );

  public PlivoClient client() {
      return this.plivoClient;
  }

  public BaseRequest client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  protected void validate() {
    if (plivoClient == null) {
      throw new IllegalStateException("client cannot be null");
    }

    // Convenient way to test setters and getters
    if (plivoClient.isTesting()) {
      HashMap<String, Object> values = new HashMap<>();
      for (Method method : this.getClass().getMethods()) {
        if (method.getParameterCount() == 0) {
          String methodName = method.getName();
          try {
            this.getClass().getDeclaredField(methodName);
            values.put(methodName, method.invoke(this));
          } catch (NoSuchFieldException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            //nop
          }
        }
      }
      for (Method method : this.getClass().getMethods()) {
        if (method.getParameterCount() == 1) {
          String methodName = method.getName();
          try {
            this.getClass().getDeclaredField(methodName);
            Object value = values.get(methodName);
            method.invoke(this, value);
          } catch (NoSuchFieldException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            //nop
          }
        }
      }
    }
  }

  protected void handleResponse(Response response) throws PlivoRestException, IOException {
    if (plivoClient.isTesting()) {
      if (response.body() != null) {
        if (!(response.body() instanceof ResponseBody)) {
          client().getObjectMapper().convertValue(response.body(), JsonNode.class);
        }
        //noinspection ResultOfMethodCallIgnored
        response.body().toString();
      }
    }

    int responseCode = response.code();
    switch (responseCode) {
      case 400:
        throw new InvalidRequestException(response.errorBody().string());
      case 401:
        throw new AuthenticationException(response.errorBody().string());
      case 403:
        try {
          String url = response.raw().request().url().toString();
          if ((this instanceof Creator || this instanceof VoiceCreator) && 
              GEO_PERMISSION_ENDPOINTS.stream().anyMatch(endpoint -> url.endsWith(endpoint))) {
            throw new GeoPermissionException(response.errorBody().string());
          }
        } catch (GeoPermissionException e) {
          throw e;
        } catch (Exception e) {
          // nop
        } 
      case 404:
        throw new ResourceNotFoundException(response.errorBody().string());
      case 405:
        throw new InvalidRequestException(response.errorBody().string());
      case 500:
        throw new ServerException(response.errorBody().string());
    }

    if (this instanceof Deleter && !(responseCode == 204 || responseCode == 200)) {
      throw new PlivoRestException(response.errorBody().string());
    }

    if (!response.isSuccessful()) {
      throw new PlivoRestException(response.errorBody().string());
    }
  }
}
