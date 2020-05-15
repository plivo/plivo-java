package com.plivo.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.plivo.api.exceptions.PlivoValidationException;
import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccessToken {

  private String authId;
  private String authToken;
  public String username;
  public Date validFrom;
  public Duration lifetime = Duration.ofHours(24);
  public Date validTill;
  public HashMap<String, HashMap<String, Object>> grants = new HashMap();
  public String uid;

  public AccessToken(String authId, String authToken, String username) {
    this.authId = authId;
    this.authToken = authToken;
    this.username = username;
    this.AllowIncoming(false);
    this.AllowOutgoing(false);
  }

  public AccessToken ValidFrom(Date validFrom) {
    this.validFrom = validFrom;
    return this;
  }

  public AccessToken Lifetime(Duration lifetime) throws PlivoValidationException {
    if (lifetime.toMillis() < 180000 || lifetime.toMillis() > 86400000) {
      throw new PlivoValidationException("lifetime out of [180, 86400]");
    }
    this.lifetime = lifetime;
    return this;
  }

  public AccessToken ValidTill(Date validTill) throws PlivoValidationException {
    if (this.validFrom == null && this.lifetime == null) {
      throw new PlivoValidationException("define either one of validFrom or lifetime as well");
    }
    if (this.validFrom != null && this.lifetime != null) {
      throw new PlivoValidationException("define either one of validFrom or lifetime only");
    }
    if (this.lifetime != null) {
      validTill.setTime(validTill.getTime() - this.lifetime.toMillis());
      this.validFrom = validTill;
    } else {
      this.lifetime = Duration.ofMillis(validTill.getTime() - this.validFrom.getTime());
    }
    return this;
  }

  public AccessToken Uid(String uid) {
    this.uid = uid;
    return this;
  }

  public AccessToken AllowIncoming(Boolean allow) {
    if (this.grants.get("voice") == null) this.grants.put("voice", new HashMap());
    this.grants.get("voice").put("incoming_allow", allow);
    return this;
  }

  public AccessToken AllowOutgoing(Boolean allow) {
    if (this.grants.get("voice") == null) this.grants.put("voice", new HashMap());
    this.grants.get("voice").put("outgoing_allow", allow);
    return this;
  }

  public String toJwt() {
    if (this.validFrom == null) this.validFrom = Date.from(Instant.now());
    if (this.lifetime == null) this.lifetime = Duration.ofHours(24);
    if (this.uid == null) this.uid = this.username + "-" + Long.toString(this.validFrom.getTime());
    Algorithm algorithm = Algorithm.HMAC256(this.authToken);
    Map<String, Object> headerClaims = new HashMap();
    headerClaims.put("cty", "plivo;v=1");
    return JWT.create()
        .withHeader(headerClaims)
        .withIssuer(this.authId)
        .withSubject(this.username)
        .withNotBefore(this.validFrom)
        .withExpiresAt(new Date((this.validFrom.getTime() + this.lifetime.toMillis())))
        .withJWTId(this.uid)
        .withClaim("grants", this.grants)
        .sign(algorithm);
  }
}
