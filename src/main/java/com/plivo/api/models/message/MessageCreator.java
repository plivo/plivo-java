package com.plivo.api.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.plivo.api.models.base.Creator;
import com.plivo.api.serializers.DelimitedListSerializer;
import com.plivo.api.util.Utils;
import java.net.URL;
import java.util.List;
import retrofit2.Call;

/**
 * Represents an instance of a message created on PlivoClient.
 */
public class MessageCreator extends Creator<MessageCreateResponse> {

  @JsonProperty("src")
  private String source;
  @JsonSerialize(using = DelimitedListSerializer.class)
  @JsonProperty("dst")
  private final List<String> destination;
  private final String text;
  @JsonProperty("powerpack_uuid")
  private String powerpackUUID;
  private MessageType type = null;
  private URL url = null;
  private String method = "POST";
  private Boolean log = null;
  private Boolean trackable = null;
  private  String[] media_urls = null;


  /**
   * @param source The phone number that will be shown as the sender ID.
   * @param destination The numbers to which the message will be sent.
   * @param text The text message that will be sent.
   */
  MessageCreator(String source, List<String> destination, String text) {
    if (!Utils.allNotNull(source, destination)) {
      throw new IllegalArgumentException("source, destination must not be null");
    }

    if (destination.contains(source)) {
      throw new IllegalArgumentException("destination cannot include source");
    }

    this.source = source;
    this.destination = destination;
    this.text = text;
  }

  /**
   * @param destination The numbers to which the message will be sent.
   * @param text The text message that will be sent.
   * @param powerpackUUID The powerpack UUID to be used.
   */
  MessageCreator(List<String> destination, String text, String powerpackUUID) {
    if (!Utils.allNotNull(powerpackUUID, destination)) {
      throw new IllegalArgumentException("powerpack uuid, destination and text must not be null");
    }
    this.destination = destination;
    this.text = text;
    this.powerpackUUID = powerpackUUID;
  }

  public String source() {
    return this.source;
  }

  public List<String> destination() {
    return this.destination;
  }

  public String text() {
    return this.text;
  }

  public MessageType type() {
    return this.type;
  }

  public URL url() {
    return this.url;
  }

  public String method() {
    return this.method;
  }

  public Boolean log() {
    return this.log;
  }

  public String[] media_urls() { return this.media_urls; }


  /**
   * @param type Must be {@link MessageType#SMS}
   */
  public MessageCreator type(final MessageType type) {
    this.type = type;
    return this;
  }

  /**
   * @param url The URL to which with the status of the message is sent.
   */
  public MessageCreator url(final URL url) {
    this.url = url;
    return this;
  }

  /**
   * @param method The method used to call the url. Defaults to POST.
   */
  public MessageCreator method(final String method) {
    this.method = method;
    return this;
  }

  /**
   * @param log If set to false, the content of this message will not be logged on the Plivo
   * infrastructure and the dst value will be masked
   */
  public MessageCreator log(final Boolean log) {
    this.log = log;
    return this;
  }

  /**
   * @param trackable 
   */
  public MessageCreator trackable(final Boolean trackable) {
    this.trackable = trackable;
    return this;
  }
  /**
   +   * @param media_url The media url is used to send media for MMS.
   +   */
  public MessageCreator media_urls(final String[] media_urls) {
        this.media_urls = media_urls;
       return this;
  }



  @Override
  protected Call<MessageCreateResponse> obtainCall() {
    return client().getApiService().messageSend(client().getAuthId(), this);
  }
}
