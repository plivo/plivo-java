package com.plivo.api;

import static junit.framework.TestCase.*;

import org.junit.Test;
import java.util.Date;
import java.time.Duration;
import com.plivo.api.exceptions.PlivoValidationException;

public class JwtTest {
  @Test
  public void createAccessTokenShouldWork() throws Exception {
    assertEquals(
        "eyJjdHkiOiJwbGl2bzt2PTEiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJncmFudHMiOnsidm9pY2UiOnsiaW5jb21pbmdfYWxsb3ciOnRydWUsIm91dGdvaW5nX2FsbG93IjpmYWxzZX19LCJzdWIiOiJ1c2VybmFtZSIsIm5iZiI6MTIxMjEyMTIsImlzcyI6Ik1BREFEQURBREFEQURBREFEQURBIiwiZXhwIjoxMjEyMTUxMiwianRpIjoidXNlcm5hbWUtMTIxMjEyMTIwMDAifQ.GQas8Xo0i-J2Jg9F_zp2bmR_FAzohJ1IPkDY30v0U_g",
        new AccessToken("MADADADADADADADADADA", "qwerty", "username").ValidFrom(new Date(12121212000L)).Lifetime(Duration.ofMillis(300000)).AllowIncoming(true).toJwt());
  }


  @Test(expected = PlivoValidationException.class)
  public void createAccessTokenShouldThrowPlivoValidationException() throws Exception {
    new AccessToken("MADADADADADADADADADA", "qwerty", "username").ValidFrom(new Date(12121212000L)).Lifetime(Duration.ofMillis(300000)).AllowIncoming(true).ValidTill(new Date(12121212000L)).toJwt();
  }
}
