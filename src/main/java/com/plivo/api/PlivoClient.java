package com.plivo.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.plivo.api.util.Utils;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
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
    protected static String VOICE_BASE_URL = "https://voice.plivo.com/v1/";
    protected static String VOICE_FALLBACK1_URL = "https://voice-usw1.plivo.com/v1/";
    protected static String VOICE_FALLBACK2_URL = "https://voice-use1.plivo.com/v1/";
    protected static String CALLINSIGHTS_BASE_URL = "https://stats.plivo.com/v1/";
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

    private final Interceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(Level.BODY);
    private final String authId;
    private final String authToken;
    private OkHttpClient httpClient;
    private Retrofit retrofit;
    private Retrofit voiceRetrofit;
    private Retrofit voiceFallback1Retrofit;
    private Retrofit voiceFallback2Retrofit;
    private Retrofit callInsightsRetrofit;
    private PlivoAPIService apiService = null;
    private PlivoAPIService voiceApiService = null;
    private PlivoAPIService voiceFallback1Service = null;
    private PlivoAPIService voiceFallback2Service = null;
    private CallInsightsAPIService callInsightsAPIService = null;

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
     */
    public PlivoClient(String authId, String authToken, OkHttpClient.Builder httpClientBuilder, final String baseUrl, final SimpleModule simpleModule) {
        if (!(Utils.isAccountIdValid(authId) || Utils.isSubaccountIdValid(authId))) {
            throw new IllegalArgumentException("invalid account ID");
        }

        this.authId = authId;
        this.authToken = authToken;
        this.objectMapper.registerModule(simpleModule);

        httpClient = httpClientBuilder
                .addNetworkInterceptor(interceptor)
                .addInterceptor(chain -> chain.proceed(
                        chain.request()
                                .newBuilder()
                                .addHeader("Authorization", Credentials.basic(getAuthId(), getAuthToken()))
                                .addHeader("User-Agent", String.format("%s/%s (Implementation: %s %s %s, Specification: %s %s %s)", "plivo-java", version,
                                        Runtime.class.getPackage().getImplementationVendor(),
                                        Runtime.class.getPackage().getImplementationTitle(),
                                        Runtime.class.getPackage().getImplementationVersion(),
                                        Runtime.class.getPackage().getSpecificationVendor(),
                                        Runtime.class.getPackage().getSpecificationTitle(),
                                        Runtime.class.getPackage().getSpecificationVersion()
                                ))
                                .build()
                ))
                .connectionPool(new ConnectionPool(5, 5, TimeUnit.MINUTES))
                .addNetworkInterceptor(chain -> {
                    Response response;
                    try {
                        response = chain.proceed(chain.request());
                    } catch (ProtocolException protocolException) {
                        // We return bodies for HTTP 204!
                        response = new Response.Builder()
                                .request(chain.request())
                                .code(204)
                                .protocol(Protocol.HTTP_1_1)
                                .body(ResponseBody.create(null, new byte[]{}))
                                .build();
                    }
                    return response;
                }).build();

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
        this(authId, authToken, new OkHttpClient.Builder(), BASE_URL, simpleModule);
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
    public PlivoClient(String authId, String authToken, OkHttpClient.Builder httpClientBuilder) {
        this(authId, authToken, httpClientBuilder, BASE_URL, simpleModule);
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

    public PlivoAPIService getVoiceApiService() {
        return voiceApiService;
    }

    public PlivoAPIService getVoiceFallback1Service() {
        return voiceFallback1Service;
    }

    public PlivoAPIService getVoiceFallback2Service() {
        return voiceFallback2Service;
    }

    public CallInsightsAPIService getCallInsightsAPIService() {
        return callInsightsAPIService;
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
