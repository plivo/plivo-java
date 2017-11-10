package com.plivo.api;

import com.plivo.api.util.Utils;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class UtilsTest {
  @Test
  public void computeSignatureShouldWork() throws Exception {
    assertEquals("ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc=",
      Utils.computeSignature("https://answer.url", "12345", "my_auth_token")
      );
  }

  @Test
  public void validateSignatureShouldWork() throws Exception {
    assertEquals(false,
      Utils.validateSignature("https://answer.url", "12345", "ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc", "my_auth_token")
    );
  }

  @Test
  public void validateSignatureShouldFail() throws Exception {
    assertEquals(false,
      Utils.validateSignature("https://answer.url", "12345", "ehV3IKhLysWBxC1sy8INm0qGoQYdYsHwuoKjsX7FsXc", "my_auth_tokens")
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void computeSignatureShouldThrowIllegalArgumentException() throws Exception {
    Utils.computeSignature(null, null, null);
  }
}
