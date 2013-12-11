package lol4j.service.impl;

import lol4j.protocol.resource.ChampionResource;
import lol4j.protocol.resource.GameResource;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class ApiRequestManagerFactory {
    private String apiKey;
    private String baseUri;

    public ChampionResource createChampionResource() {
        ChampionApiRequestManager championApiRequestManager = new ChampionApiRequestManager();
        championApiRequestManager.setApiKey(apiKey);
        championApiRequestManager.setBaseUri(baseUri);

        return championApiRequestManager;
    }

    public GameResource createGameResource() {
        GameApiRequestManager gameApiRequestManager = new GameApiRequestManager();
        gameApiRequestManager.setApiKey(apiKey);
        gameApiRequestManager.setBaseUri(baseUri);

        return gameApiRequestManager;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }
}
