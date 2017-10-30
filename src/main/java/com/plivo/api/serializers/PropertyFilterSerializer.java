package com.plivo.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.plivo.api.util.PropertyFilter;
import java.io.IOException;

public class PropertyFilterSerializer<T> extends JsonSerializer<PropertyFilter<T>> {

  @Override
  public void serialize(PropertyFilter<T> value, JsonGenerator gen, SerializerProvider serializers)
    throws IOException, JsonProcessingException {
    gen.writeStartObject();
    if (value.equalTo() != null) {
      gen.writeObjectField("", value.equalTo());
    }
    if (value.greaterThan() != null) {
      gen.writeObjectField("__gt", value.greaterThan());
    }
    if (value.greaterOrEqual() != null) {
      gen.writeObjectField("__gte", value.greaterOrEqual());
    }
    if (value.lessThan() != null) {
      gen.writeObjectField("__lt", value.lessThan());
    }
    if (value.lessOrEqual() != null) {
      gen.writeObjectField("__lte", value.lessOrEqual());
    }
    gen.writeEndObject();
  }
}
