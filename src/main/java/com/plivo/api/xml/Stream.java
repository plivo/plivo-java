package com.plivo.api.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Stream")
public class Stream extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private Boolean bidirectional;

  @XmlAttribute
  private String audioTrack;

  @XmlAttribute
  private Integer streamTimeout;

  @XmlAttribute
  private String statusCallbackUrl;

  @XmlAttribute
  private String statusCallbackMethod;

  @XmlAttribute
  private String contentType;

  @XmlAttribute
  private String extraHeaders;

  private Stream() {

  }

  public Stream(String content) {
    this.content = content;
  }

  public Boolean bidirectional() {
    return this.bidirectional;
  }

  public String audioTrack() {
    return this.audioTrack;
  }

  public Integer streamTimeout() {
    return this.streamTimeout;
  }

  public String statusCallbackUrl() {
    return this.statusCallbackUrl;
  }

  public String statusCallbackMethod() {
    return this.statusCallbackMethod;
  }

  public String extraHeaders() {
    return this.extraHeaders;
  }

  public String contentType() {
    return this.contentType;
  }

  public Stream bidirectional(final Boolean bidirectional) {
    this.bidirectional = bidirectional;
    return this;
  }

  public Stream audioTrack(final String audioTrack) {
    this.audioTrack = audioTrack;
    return this;
  }

  public Stream streamTimeout(final Integer streamTimeout) {
    this.streamTimeout = streamTimeout;
    return this;
  }

  public Stream statusCallbackUrl(final String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }

  public Stream statusCallbackMethod(final String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  public Stream contentType(final String contentType) {
    this.contentType = contentType;
    return this;
  }

  public Stream extraHeaders(Map<String, String> inputMap) throws JsonProcessingException {
    Map<String, String> headersMap = new HashMap<String, String>();
    for (Map.Entry<String,String> entry : inputMap.entrySet()) {
      if (!entry.getKey().endsWith("X-PH")) {
        headersMap.put(entry.getKey() + "X-PH", entry.getValue());
      } else {
        headersMap.put(entry.getKey(), entry.getValue());
      }
    }
    this.extraHeaders = new ObjectMapper().writeValueAsString(headersMap);
    return this;
  }

}