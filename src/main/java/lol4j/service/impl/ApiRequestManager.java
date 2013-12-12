package lol4j.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class ApiRequestManager {
    private String apiKey;
    private Client client;
    private ObjectMapper objectMapper;

    public ApiRequestManager() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    public <T> T get(String baseUri, String path, Map<String, Object> queryParams, Class<T> clazz) {
        String json = getJson(baseUri, path, queryParams);
        T returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    public <K, V> Map<K, V> get(String baseUri, String path,  Map<String, Object> queryParams, Class<K> keyClass, Class<V> valueClass) {
        String json = getJson(baseUri, path, queryParams);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        Map<K, V> returnObj = null;

        try {
            returnObj = objectMapper.readValue(json, typeFactory.constructMapType(Map.class, keyClass, valueClass));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    private String getJson(String baseUri, String path,  Map<String, Object> queryParams) {
        WebTarget webTarget = client.target(baseUri).path(path).queryParam("api_key", apiKey);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
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

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
