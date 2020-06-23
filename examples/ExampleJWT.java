import com.plivo.api.AccessToken;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;

class ExampleJWT {
  public static void main(String [] args) throws Exception {
    // auth_id, auth_token and endpoint username are mandatory
    AccessToken acctkn0 = new AccessToken("MADADADADADADADADADA", "auth_token", "username")
      .ValidFrom(Date.from(Instant.now()))
      .Lifetime(Duration.ofMillis(300000))
      .AllowIncoming(true)
      .AllowOutgoing(false);
    System.out.println(acctkn0.toJwt());

    AccessToken acctkn1 = new AccessToken("MADADADADADADADADADA", "auth_token", "username")
      .ValidFrom(Date.from(Instant.now()))
      .ValidTill(Date.from(Instant.now().plusSeconds(300)))
      .AllowIncoming(true)
      .AllowOutgoing(false);
    System.out.println(acctkn1.toJwt());

    return;
  }
}
