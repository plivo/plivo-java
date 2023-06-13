package com.plivo.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.plivo.api.models.base.LogLevel;
import com.plivo.api.util.Utils;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class PlivoClient {

  private static SimpleModule simpleModule = new SimpleModule();
  protected static String BASE_URL = "https://api.plivo.com/v1/";
  protected static String VOICE_BASE_URL = "https://api.plivo.com/v1/";
  protected static String VOICE_FALLBACK1_URL = "https://api.plivo.com/v1/";
  protected static String VOICE_FALLBACK2_URL = "https://api.plivo.com/v1/";
  protected static String CALLINSIGHTS_BASE_URL = "https://stats.plivo.com/v1/";
  protected static String LOOKUP_BASE_URL = "https://lookup.plivo.com/v1/";
  private static String version = "Unknown Version";
  private boolean testing = false;
  private static ObjectMapper objectMapper = new ObjectMapper();

  public void setTesting(boolean testing) {
    this.testing = testing;
  }

  public boolean isTesting() {
    return testing;
  }

  static {
    simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
      @Override
      public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig config, JavaType type,
                                                        BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        return new JsonDeserializer<Enum>() {
          @Override
          public Enum deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
            Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();
            return Enum.valueOf(rawClass, jp.getValueAsString().toUpperCase().replace("-", "_"));
          }
        };
      }
    });
    simpleModule.addSerializer(Enum.class, new StdSerializer<Enum>(Enum.class) {
      @Override
      public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeString(value.name().toLowerCase().replace("_", "-"));
      }
    });
  }

  {
    try {
      InputStream inputStream = PlivoClient.class
        .getResource("version.txt")
        .openStream();

      version = new BufferedReader(new InputStreamReader(inputStream)).readLine();
    } catch (IOException ignored) {
      ignored.printStackTrace();
    }
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
  }

  private Interceptor interceptor;
  private final String authId;
  private final String authToken;
  private OkHttpClient httpClient;
  private Retrofit retrofit;
  private Retrofit voiceRetrofit;
  private Retrofit voiceFallback1Retrofit;
  private Retrofit voiceFallback2Retrofit;
  private Retrofit callInsightsRetrofit;
  private Retrofit lookupRetrofit;
  private PlivoAPIService apiService = null;
  private PlivoAPIService voiceApiService = null;
  private PlivoAPIService voiceFallback1Service = null;
  private PlivoAPIService voiceFallback2Service = null;
  private CallInsightsAPIService callInsightsAPIService = null;
  private LookupAPIService lookupAPIService = null;

  /**
   * Constructs a new PlivoClient instance. To set a proxy, timeout etc, you can pass in an OkHttpClient.Builder, on which you can set
   * the timeout and proxy using:
   *
   * <pre><code>
   *   new OkHttpClient.Builder()
   *   .proxy(proxy)
   *   .connectTimeout(1, TimeUnit.MINUTES);
   * </code></pre>
   *
   * @param authId
   * @param authToken
   * @param httpClientBuilder
   * @param baseUrl
   * @param simpleModule
   * @param logLevel
   */
  public PlivoClient(String authId, String authToken, CloseableHttpClient httpClientBuilder, final String baseUrl, final SimpleModule simpleModule, final LogLevel logLevel) {
    if (!(Utils.isAccountIdValid(authId) || Utils.isSubaccountIdValid(authId))) {
      throw new IllegalArgumentException("invalid account ID");
    }

    this.authId = authId;
    this.authToken = authToken;
    this.objectMapper.registerModule(simpleModule);
    this.interceptor = new HttpLoggingInterceptor().setLevel(Level.valueOf(logLevel.toString()));

    httpClient  = HttpClientBuilder.create()
        .addInterceptorFirst((HttpRequestInterceptor) (request, context) -> {
            request.addHeader("Authorization", Credentials.basic(getAuthId(), getAuthToken()));
            request.addHeader("User-Agent", String.format("%s/%s (Implementation: %s %s %s, Specification: %s %s %s)", "plivo-java", version,
                    Runtime.class.getPackage().getImplementationVendor(),
                    Runtime.class.getPackage().getImplementationTitle(),
                    Runtime.class.getPackage().getImplementationVersion(),
                    Runtime.class.getPackage().getSpecificationVendor(),
                    Runtime.class.getPackage().getSpecificationTitle(),
                    Runtime.class.getPackage().getSpecificationVersion()
            ));
        })
        .setConnectionManager(new PoolingHttpClientConnectionManager(5, 5, TimeUnit.MINUTES))
        .addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
            try {
                HttpResponse response = context.getHttpClient().execute(request, context);
                if (response.getStatusLine().getStatusCode() == 204) {
                    response.setEntity(null);
                    response.setStatusCode(204);
                    response.setProtocolVersion(HttpVersion.HTTP_1_1);
                    response.removeHeaders("Content-Length");
                    response.removeHeaders("Content-Type");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        })
      .build();

    retrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl(baseUrl)
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.apiService = retrofit.create(PlivoAPIService.class);

    voiceRetrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl((VOICE_BASE_URL))
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.voiceApiService = voiceRetrofit.create(PlivoAPIService.class);

    voiceFallback1Retrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl((VOICE_FALLBACK1_URL))
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.voiceFallback1Service = voiceFallback1Retrofit.create(PlivoAPIService.class);

    voiceFallback2Retrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl((VOICE_FALLBACK2_URL))
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.voiceFallback2Service = voiceFallback2Retrofit.create(PlivoAPIService.class);

    callInsightsRetrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl((CALLINSIGHTS_BASE_URL))
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.callInsightsAPIService = callInsightsRetrofit.create(CallInsightsAPIService.class);

    lookupRetrofit = new Retrofit.Builder()
      .client(httpClient)
      .baseUrl((LOOKUP_BASE_URL))
      .addConverterFactory(JacksonConverterFactory.create(objectMapper))
      .build();

    this.lookupAPIService = lookupRetrofit.create(LookupAPIService.class);
  }

  /**
   * Constructs a new PlivoClient instance. To set a proxy, timeout etc, you can pass in an OkHttpClient.Builder, on which you can set
   * the timeout and proxy using:
   *
   * <pre><code>
   *   new OkHttpClient.Builder()
   *   .proxy(proxy)
   *   .connectTimeout(1, TimeUnit.MINUTES);
   * </code></pre>
   *
   * @param authId
   * @param authToken
   */
  public PlivoClient(String authId, String authToken) {
    RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(5000)
            .build();

    CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(requestConfig)
            .build();
    this(authId, authToken, httpClient, BASE_URL, simpleModule, LogLevel.NONE);
  }

  /**
   * Constructs a new PlivoClient instance. To set a proxy, timeout etc, you can pass in an OkHttpClient.Builder, on which you can set
   * the timeout and proxy using:
   *
   * <pre><code>
   *   new OkHttpClient.Builder()
   *   .proxy(proxy)
   *   .connectTimeout(1, TimeUnit.MINUTES);
   * </code></pre>
   *
   * @param authId
   * @param authToken
   * @param httpClientBuilder
   */
  public PlivoClient(String authId, String authToken, CloseableHttpClient httpClientBuilder) {
    this(authId, authToken, httpClientBuilder, BASE_URL, simpleModule, LogLevel.NONE);
}
  /**
   * Constructs a new PlivoClient instance. To set a proxy, timeout etc, you can pass in an OkHttpClient.Builder, on which you can set
   * the timeout and proxy using:
   *
   * <pre><code>
   *    new OkHttpClient.Builder()
   *    .proxy(proxy)
   *    .connectTimeout(1, TimeUnit.MINUTES);
   * </code></pre>
   *
   * To set Log level you can pass LogLevel enum.It can be set to following values:
   *
   * NONE - No logs
   * BASIC - Log request and response line
   * HEADER - Log request and response line along with their headers
   * BODY - Log request and response line along with their headers and bodies
   *
   * @param authId
   * @param authToken
   * @param logLevel
   */
  public PlivoClient(String authId, String authToken, LogLevel logLevel) {
    RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(5000)
            .build();

    CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(requestConfig)
            .build();
    this(authId, authToken, httpClient, BASE_URL, simpleModule, logLevel);
  }

  /**
   * Constructs a new PlivoClient instance. To set a proxy, timeout etc, you can pass in an OkHttpClient.Builder, on which you can set
   * the timeout and proxy using:
   *
   * <pre><code>
   *   new OkHttpClient.Builder()
   *   .proxy(proxy)
   *   .connectTimeout(1, TimeUnit.MINUTES);
   * </code></pre>
   * To set Log level you can pass LogLevel enum.It can be set to following values:
   *
   * NONE - No logs
   * BASIC - Log request and response line
   * HEADER - Log request and response line along with their headers
   * BODY - Log request and response line along with their headers and bodies
   *
   * @param authId
   * @param authToken
   * @param httpClientBuilder
   * @param logLevel
   */
  public PlivoClient(String authId, String authToken, CloseableHttpClient httpClientBuilder, LogLevel logLevel) {
    // CloseableHttpClient httpClient = httpClientBuilder.build();
    this(authId, authToken, httpClientBuilder, BASE_URL, simpleModule, logLevel);
}

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  Retrofit getRetrofit() {
    return retrofit;
  }

  public PlivoAPIService getApiService() {
    return apiService;
  }

  public PlivoAPIService getVoiceApiService(){
    return voiceApiService;
  }

  public PlivoAPIService getVoiceFallback1Service(){
    return voiceFallback1Service;
  }

  public PlivoAPIService getVoiceFallback2Service(){
    return voiceFallback2Service;
  }

  public CallInsightsAPIService getCallInsightsAPIService() {
    return callInsightsAPIService;
  }

  public LookupAPIService getLookupAPIService() {
    return lookupAPIService;
  }

  void setApiService(PlivoAPIService apiService) {
    this.apiService = apiService;
  }

  public String getAuthId() {
    return authId;
  }

  public String getAuthToken() {
    return authToken;
  }
}
