package lol4j.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lol4j.util.Regions;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public abstract class AbstractApiRequestManager {
    private String apiKey;
    private String baseUri;
    private Client client;
    private List<Regions> supportedRegions = new ArrayList<>();
    private WebTarget baseWebTarget;
    private ObjectMapper objectMapper;

    protected AbstractApiRequestManager() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    <T> T get(String path, List<Map.Entry<String, Object>> queryParams, Class<T> clazz) {
        String json = getJson(path, queryParams);
        T returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    <K, V> Map<K, V> get(String path, List<Map.Entry<String, Object>> queryParams, Class<K> keyClass, Class<V> valueClass) {
        String json = getJson(path, queryParams);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        Map<K, V> returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, typeFactory.constructMapType(Map.class, keyClass, valueClass));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    private String getJson(String path, List<Map.Entry<String, Object>> queryParams) {
        WebTarget webTarget = getBaseWebTarget().path(path).queryParam("api_key", apiKey);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams) {
                webTarget = webTarget.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).acceptEncoding("UTF-8");
        Response response = invocationBuilder.get();

        return response.readEntity(String.class);
    }

    @Override
    protected void finalize() throws Throwable {
        client.close();
        super.finalize();
    }

    private WebTarget getBaseWebTarget() {
        if (baseWebTarget == null) {
            baseWebTarget = client.target(baseUri);
        }
        return baseWebTarget;
    }

    public boolean isSupportedRegion(String region) {
        return supportedRegions.contains(Regions.valueOf(region.toUpperCase()));
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public List<Regions> getSupportedRegions() {
        return supportedRegions;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
