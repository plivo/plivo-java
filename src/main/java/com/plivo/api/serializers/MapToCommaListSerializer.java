package com.plivo.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class MapToCommaListSerializer extends JsonSerializer<Map<String, String>> {

  @Override
  public void serialize(Map<String, String> value, JsonGenerator gen,
    SerializerProvider serializers)
    throws IOException, JsonProcessingException {
    StringBuilder sb = new StringBuilder();
    for (Entry<String, String> entry : value.entrySet()) {
      sb.append(entry.getKey())
        .append("=")
        .append(entry.getValue())
        .append(",");
    }
    gen.writeString(sb.toString());
  }
}
