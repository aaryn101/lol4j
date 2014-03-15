package lol4j.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lol4j.exception.TooManyRequestsException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public class ApiRequestManager {
    public static final String ENCODING = "UTF-8";
    private static final int TEN_SECONDS = 10000;
    private static final int TEN_MINUTES = 600000;
    private String apiKey;
    private Client client;
    private ObjectMapper objectMapper;
    private DelayQueue<Token> perSecondsBucket;
    private DelayQueue<Token> perMinutesBucket;
    private boolean usingRateLimiter = false;
    private String baseUri;

    public ApiRequestManager(String apiKey, String baseUri) {
        this.apiKey = apiKey;
        this.baseUri = baseUri;
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    public <T> T get(String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<T> clazz) {
        String json = doRequest(path, queryParams, ignoreRateLimiter);
        T returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    public <T> List<T> getList(String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<T> clazz) {
        String json = doRequest(path, queryParams, ignoreRateLimiter);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<T> returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, typeFactory.constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    public <K, V> Map<K, V> getMap(String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<K> keyClass, Class<V> valueClass) {
        String json = doRequest(path, queryParams, ignoreRateLimiter);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        Map<K, V> returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, typeFactory.constructMapType(Map.class, keyClass, valueClass));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    private String doRequest(String path, Map<String, Object> queryParams, boolean ignoreRateLimiter) {
        if (usingRateLimiter && !ignoreRateLimiter) {
            try {
                perSecondsBucket.take();
                perMinutesBucket.take();
            } catch (InterruptedException e) {
            }
        }
        WebTarget webTarget = client.target(baseUri).path(path).queryParam("api_key", apiKey);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                webTarget = webTarget.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).acceptEncoding(ENCODING);
        Response response = invocationBuilder.get();

        if (usingRateLimiter && !ignoreRateLimiter) {
            perSecondsBucket.put(new Token(TEN_SECONDS, false));
            perMinutesBucket.put(new Token(TEN_MINUTES, false));
        }

        if (response.getStatus() != 200) {
            switch(response.getStatus()) {
                case 400: throw new BadRequestException();
                case 401: throw new NotAuthorizedException("Unauthorized: bad api key or bad request uri");
                case 404: throw new NotFoundException();
                case 429: throw new TooManyRequestsException();
                case 500: throw new InternalServerErrorException();
            }
        }

        return response.readEntity(String.class);
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    @Override
    protected void finalize() throws Throwable {
        client.close();
        super.finalize();
    }

    public void setRateLimit(int perTenSeconds, int perTenMinutes) {
        if (!usingRateLimiter) {
            perSecondsBucket = new DelayQueue<>();
            for (int i = 0; i < perTenSeconds; i++) {
                perSecondsBucket.put(new Token(TEN_SECONDS, true));
            }
            perMinutesBucket = new DelayQueue<>();
            for (int i = 0; i < perTenMinutes; i++) {
                perMinutesBucket.put(new Token(TEN_MINUTES, true));
            }
            usingRateLimiter = true;
        }
        else {
            throw new IllegalStateException("Can't set rate limit after it has already been set");
        }
    }

    private class Token implements Delayed {
        private int delay;
        private long origin;
        private boolean initial;

        public Token(int delay, boolean initial) {
            origin = System.currentTimeMillis();
            this.delay = delay;
            this.initial = initial;
        }

        @Override
        public long getDelay(TimeUnit unit) {
           return initial ? 0 : unit.convert(delay - (System.currentTimeMillis() - origin), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed delayed) {
            if (delayed == this) {
                return 0;
            }

            long d = (getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS));
            return ((d == 0) ? 0 : ((d < 0) ? -1 : 1));
        }
    }
}
