package com.plivo.api.serializers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimitedListXMLSerializer extends XmlAdapter<String, List<String>> {

  private final String delimiter;

  DelimitedListXMLSerializer(String delimiter) {
    this.delimiter = delimiter;
  }

  DelimitedListXMLSerializer() {
    this(",");
  }

  @Override
  public List<String> unmarshal(String v) throws Exception {
    if (v == null) {
      throw new IllegalArgumentException("cannot be null");
    }
    return Arrays.asList(v.split(delimiter));
  }

  @Override
  public String marshal(List<String> v) throws Exception {
    return v.stream().map(String::trim).collect(Collectors.joining(delimiter));
  }
}
