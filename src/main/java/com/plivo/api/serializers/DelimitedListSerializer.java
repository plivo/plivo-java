package com.plivo.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.List;

public class DelimitedListSerializer extends JsonSerializer<List<String>> {

  private final String delimiter;

  DelimitedListSerializer() {
    this("<");
  }

  DelimitedListSerializer(String delimiter) {
    this.delimiter = delimiter;
  }

  @Override
  public void serialize(List<String> value, JsonGenerator gen, SerializerProvider serializers)
    throws IOException, JsonProcessingException {
    gen.writeString(String.join(delimiter, value));
  }
}
