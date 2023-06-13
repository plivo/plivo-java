package com.plivo.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.plivo.api.models.base.LogLevel;
import okhttp3.OkHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class PhloRestClient {

  protected static String BASE_URL = "https://phlorunner.plivo.com/v1/";
  private SimpleModule simpleModule = new SimpleModule();
  private final PlivoClient client;

  {
    simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
      @Override
      public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig config, JavaType type,
                                                        BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        return new JsonDeserializer<Enum>() {
          @Override
          public Enum deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
            Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();
            return Enum.valueOf(rawClass, jp.getValueAsString().toUpperCase().replace("-", "_"));
          }
        };
      }
    });
    simpleModule.addSerializer(Enum.class, new StdSerializer<Enum>(Enum.class) {
      @Override
      public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeString(value.name().toLowerCase());
      }
    });
  }

  public PhloRestClient(String authId, String authToken) {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    this.client = new PlivoClient(authId, authToken, httpClient, BASE_URL, simpleModule, LogLevel.NONE);
}

  public PhloRestClient(String authId, String authToken, HttpClientBuilder httpClientBuilder) {
    CloseableHttpClient httpClient = httpClientBuilder.build();
    this.client = new PlivoClient(authId, authToken, httpClient, BASE_URL, simpleModule, LogLevel.NONE);
}

  public PlivoClient getClient() {
    return client;
  }
}
