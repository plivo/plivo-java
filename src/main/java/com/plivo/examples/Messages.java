package com.plivo.examples;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.media.Media;
import com.plivo.api.models.media.MediaResponse;
import com.plivo.api.models.media.MediaUploader;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.plivo.api.models.message.MmsMedia;

import java.io.IOException;
import java.util.Collections;

public class Messages {

  public static void main(String[] args) {
    Plivo.init("MAODZKMDFJMJU3MTEYNG", "YTZlMmQ3MTcxOWRlNjYzNWM0NDg1NzQ5YWQ4OTU5");
    sendmms();
    // getMessage();
    // listMedia();
    //getMedia();
    //deleteMedia();
//    uploadMedia();

  }

  // send mms
  private static void sendmms() {
    Plivo.init("xxxxx", "xxxx");
    try {
      MessageCreateResponse response = Message.creator("src", Collections.singletonList("dst"),
        "Hello, this is test message").type(MessageType.MMS).media_urls(new String[]{"https://test/test.jpg"})
        .create();
      System.out.println(response);
      System.out.println(response.getMessageUuid());
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // get message detail
  private static void getMessage() {
    try {
      Message response = Message.getter("message_uuid")
        .get();

      System.out.println(response);

    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  //list media detail
  private static void listMedia() {
    try {
      ListResponse<MmsMedia> response = Message.getter("message_uuid")
        .get().listMedia().list();

      System.out.println(response);

    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  // get single media
  private static void getMedia() {
    try {
      MmsMedia response = Message.getter("message_uuid")
        .get().getMedia("media_id").get();

      System.out.println(response);

    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  //delete media
  private static void deleteMedia() {
    try {
      Message.getter("message_uuid")
        .get().deleteMedia().delete();
      System.out.println("Deleted successfully.");

    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }

  private static void uploadMedia(){

    try {
      System.out.println("'Before Media upload");
      MediaResponse mediaResponse = Media.creator(new String[]{"/Users/shibinsurendranath/Downloads/image2.png",
    		  "/Users/shibinsurendranath/Downloads/Jira.csv.txt"}).create();
      System.out.println("'Response got " + mediaResponse.getApiId());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (PlivoRestException e) {
      e.printStackTrace();
    }
  }
}

