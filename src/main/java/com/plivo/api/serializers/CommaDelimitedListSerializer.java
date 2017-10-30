package com.plivo.api.serializers;

/**
 * Unfortunately, this needs to exist due to how the @JsonSerialize(with) annotation works.
 */
public class CommaDelimitedListSerializer extends DelimitedListSerializer {

  CommaDelimitedListSerializer() {
    super(",");
  }
}
