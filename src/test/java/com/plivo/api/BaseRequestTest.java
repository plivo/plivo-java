package com.plivo.api;

import com.plivo.api.exceptions.AuthenticationException;
import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.exceptions.ServerException;
import com.plivo.api.models.message.Message;
import com.squareup.okhttp.mockwebserver.MockResponse;
import org.junit.Test;

public class BaseRequestTest extends BaseTest {
  private final String uuid = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";

  @Test(expected = InvalidRequestException.class)
  public void baseRequestShouldThrowInvalidRequestException() throws Exception {
    this.server.enqueue(new MockResponse().setResponseCode(400));

    Message.getter(uuid).get();
  }

  @Test(expected = InvalidRequestException.class)
  public void baseRequestShouldThrowInvalidRequestException1() throws Exception {
    this.server.enqueue(new MockResponse().setResponseCode(405));

    Message.getter(uuid).get();
  }

  @Test(expected = AuthenticationException.class)
  public void baseRequestShouldThrowAuthenticationException() throws Exception {
    this.server.enqueue(new MockResponse().setResponseCode(401));

    Message.getter(uuid).get();
  }

  @Test(expected = ResourceNotFoundException.class)
  public void baseRequestShouldThrowResourceNotFoundException() throws Exception {
    this.server.enqueue(new MockResponse().setResponseCode(404));

    Message.getter(uuid).get();
  }

  @Test(expected = ServerException.class)
  public void baseRequestShouldThrowServerException1() throws Exception {
    this.server.enqueue(new MockResponse().setResponseCode(500));

    Message.getter(uuid).get();
  }
}
