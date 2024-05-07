package com.plivo.api.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plivo.api.models.base.Creator;
import com.plivo.api.serializers.DelimitedListSerializer;
import com.plivo.api.util.Utils;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;

/**
 * Represents an instance of a message created on PlivoClient.
 */
public class MessageCreator extends Creator < MessageCreateResponse > {

  @JsonProperty("src")
  private String source;
  @JsonSerialize(using = DelimitedListSerializer.class)
  @JsonProperty("dst")
  private final List < String > destination;
  private String text;
  @JsonProperty("powerpack_uuid")
  private String powerpackUUID;
  private MessageType type = null;
  private URL url = null;
  private String method = "POST";
  private String log = "true";
  private Boolean trackable = null;
  private String[] media_urls = null;
  private String[] media_ids = null;
  private Long message_expiry;
  private String dlt_entity_id;
  private String dlt_template_id;
  private String dlt_template_category;
  @JsonProperty("template")
  private Template template;
  @JsonProperty("interactive")
  private Interactive interactive;

  /**
   * @param source The phone number that will be shown as the sender ID.
   * @param destination The numbers to which the message will be sent in string format.
   * @param text The text message that will be sent.
   */

  MessageCreator(String source, String destination, String text) {
    if (!Utils.allNotNull(source, destination)) {
      throw new IllegalArgumentException("source, destination must not be null");
    }
    if (destination.equals(source)) {
      throw new IllegalArgumentException("destination cannot include source");
    }
    if (source.length()<= 14) {
      this.source = source;
      this.destination = Collections.singletonList(destination);
      this.text = text;
    } else {
      this.powerpackUUID = source;
      this.destination = Collections.singletonList(destination);
      this.text = text;
    }

  }

   /**
   * @param source The phone number that will be shown as the sender.
   * @param destination The numbers to which the message will be sent.
   */
  MessageCreator(String source, String destination) {
    if (!Utils.allNotNull(source, destination)) {
      throw new IllegalArgumentException("source, destination must not be null");
    }
    if (destination.equals(source)) {
      throw new IllegalArgumentException("destination cannot include source");
    }
    this.source = source;
    this.destination = Collections.singletonList(destination);
  }

  /**
   * @param source The phone number that will be shown as the sender ID.
   * @param destination The numbers to which the message will be sent.
   * @param text The text message that will be sent.
   */
  MessageCreator(String source, List < String > destination, String text) {
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
  MessageCreator(List < String > destination, String text, String powerpackUUID) {
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

  public List < String > destination() {
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

  public String log() {
    return this.log;
  }

  public String[] media_urls() {
    return this.media_urls;
  }

  public String[] media_ids() {
    return this.media_ids;
  }

  public Long message_expiry() {
      return this.message_expiry;
  }

  public String dlt_entity_id() {
    return this.dlt_entity_id;
  }

  public String dlt_template_id() {
    return this.dlt_template_id;
  }

  public String dlt_template_category() {
    return this.dlt_template_category;
  }

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
  public MessageCreator log(final Object log) {
    if (log instanceof Boolean) {
        this.log = ((Boolean) log).toString();
    } else if (log instanceof String) {
        this.log = (String) log;
    } else {
        throw new IllegalArgumentException("Invalid log value. Expected boolean or string.");
    }
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

  /**
   +   * @param media_ids The media ids is used to send media for MMS.
   +   */
  public MessageCreator media_ids(final String[] media_ids) {
    this.media_ids = media_ids;
    return this;
  }

  //@param message_expiry used to set message expiry.
  public MessageCreator message_expiry(final Long message_expiry) {
    this.message_expiry = message_expiry;
    return this;
  }

  /**
   * @param dlt_entity_id This is the DLT entity id passed in the message request.
   */
  public MessageCreator dlt_entity_id(final String dlt_entity_id) {
    this.dlt_entity_id = dlt_entity_id;
    return this;
  }

  /**
   * @param dlt_template_id This is the DLT template id passed in the message request.
   */
  public MessageCreator dlt_template_id(final String dlt_template_id) {
    this.dlt_template_id = dlt_template_id;
    return this;
  }

  /**
   * @param dlt_template_category This is the DLT template category passed in the message request.
   */
  public MessageCreator dlt_template_category(final String dlt_template_category) {
    this.dlt_template_category = dlt_template_category;
    return this;
  }

  /**
   * @param template_json_string This is the template passed as a json string in the whatsapp message request.
   */
  public MessageCreator template_json_string(final String template_json_string) {
    if (this.type == null) {
      this.type = MessageType.WHATSAPP;
    } else {
      if (this.type.equals(MessageType.SMS) || (this.type.equals(MessageType.MMS)))
      throw new IllegalArgumentException("type parameter should be whatsapp");
    }
    if (Utils.allNotNull(this.template)) {
      throw new IllegalArgumentException("template parameter is already set");
    }
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Template temp = objectMapper.readValue(template_json_string, Template.class);
      if (temp.getName() == null || temp.getName().isEmpty()) {
        throw new IllegalArgumentException("template name must not be null or empty");
      }
      if (temp.getLanguage() == null || temp.getLanguage().isEmpty()) {
          throw new IllegalArgumentException("template language must not be null or empty");
      }
      this.template = temp;
    } catch (Exception e) {
        	e.printStackTrace();
          throw new IllegalArgumentException("failed to read template");
    }
    return this;
  }

  /**
   * @param temp This is the template passed as a template object in the whatsapp message request.
   */
  public MessageCreator template(final Template temp) {
    if (this.type == null) {
      this.type = MessageType.WHATSAPP;
    } else {
      if (type.equals(MessageType.SMS) || (type.equals(MessageType.MMS)))
      throw new IllegalArgumentException("type parameter should be whatsapp");
    }
    if (Utils.allNotNull(this.template)) {
      throw new IllegalArgumentException("template parameter is already set");
    }
    if (temp.getName() == null || temp.getName().isEmpty()) {
      throw new IllegalArgumentException("template name must not be null or empty");
    }
    if (temp.getLanguage() == null || temp.getLanguage().isEmpty()) {
        throw new IllegalArgumentException("template language must not be null or empty");
    }
    this.template = temp;
    
    return this;
  }


   /**
   * @param intractv This is the interactive messages passed as a interactive object in the whatsapp message request.
   */
  public MessageCreator interactive(final Interactive intractv) {
    if (this.type == null) {
      this.type = MessageType.WHATSAPP;
    } else {
      if (type.equals(MessageType.SMS) || (type.equals(MessageType.MMS)))
      throw new IllegalArgumentException("type parameter should be whatsapp");
    }
    if (Utils.allNotNull(this.interactive)) {
      throw new IllegalArgumentException("interacitve parameter is already set");
    }
    this.interactive = intractv;
    
    return this;
  }

   /**
   * @param interactive_json_string This is the interactive message passed as a json string in the whatsapp message request.
   */
  public MessageCreator interactive_json_string(final String interactive_json_string) {
    if (this.type == null) {
      this.type = MessageType.WHATSAPP;
    } else {
      if (this.type.equals(MessageType.SMS) || (this.type.equals(MessageType.MMS)))
      throw new IllegalArgumentException("type parameter should be whatsapp");
    }
    if (Utils.allNotNull(this.interactive)) {
      throw new IllegalArgumentException("interactive parameter is already set");
    }
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Interactive parsedInteractive = objectMapper.readValue(interactive_json_string, Interactive.class);
      this.interactive = parsedInteractive;
    } catch (Exception e) {
        	e.printStackTrace();
          throw new IllegalArgumentException("failed to read interactive message");
    }
    return this;
  }

  @Override
  protected Call < MessageCreateResponse > obtainCall() {
    return client().getApiService().messageSend(client().getAuthId(), this);
  }
}