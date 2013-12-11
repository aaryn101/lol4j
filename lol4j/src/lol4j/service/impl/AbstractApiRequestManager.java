package lol4j.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Created by Aaryn101 on 12/10/13.
 */
public abstract class AbstractApiRequestManager {
    private String apiKey;
    private String baseUri;
    private Client client;
    private List<Regions> supportedRegions = new ArrayList<>();
    private WebTarget baseWebTarget;

    protected AbstractApiRequestManager() {
        this.client = ClientBuilder.newClient();
    }

    <T> T get(String path, Class<T> clazz) {
        WebTarget webTarget = getBaseWebTarget().path(path).queryParam("api_key", apiKey);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).acceptEncoding("UTF-8");
        Response response = invocationBuilder.get();
        T returnObj = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String json = response.readEntity(String.class);

        try {
            returnObj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnObj;
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
