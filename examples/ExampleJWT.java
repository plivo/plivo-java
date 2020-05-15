import com.plivo.api.AccessToken;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;

class ExampleJWT {
  public static void main(String [] args) throws Exception {
    // auth_id, auth_token and endpoint username are mandatory
    AccessToken acctkn = new AccessToken("MADADADADADADADADADA", "auth_token", "username")
      .ValidFrom(Date.from(Instant.now()))
      .Lifetime(Duration.ofMillis(300000))
      .AllowIncoming(true)
      .AllowOutgoing(false);
    System.out.println(acctkn.toJwt());

    return;
  }
}