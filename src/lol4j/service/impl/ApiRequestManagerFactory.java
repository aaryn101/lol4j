package lol4j.service.impl;

import lol4j.protocol.resource.ChampionResource;
import lol4j.protocol.resource.GameResource;
import lol4j.protocol.resource.LeagueResource;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class ApiRequestManagerFactory {
    private static final String LOL_BASE = "http://prod.api.pvp.net/api/lol";
    private static final String PVP_NET_BASE = "http://prod.api.pvp.net/api";
    private String apiKey;

    public ChampionResource createChampionResource() {
        ChampionApiRequestManager championApiRequestManager = new ChampionApiRequestManager();
        championApiRequestManager.setApiKey(apiKey);
        championApiRequestManager.setBaseUri(LOL_BASE);

        return championApiRequestManager;
    }

    public GameResource createGameResource() {
        GameApiRequestManager gameApiRequestManager = new GameApiRequestManager();
        gameApiRequestManager.setApiKey(apiKey);
        gameApiRequestManager.setBaseUri(LOL_BASE);

        return gameApiRequestManager;
    }

    public LeagueResource createLeagueResource() {
        LeagueApiRequestManager leagueApiRequestManager = new LeagueApiRequestManager();
        leagueApiRequestManager.setApiKey(apiKey);
        leagueApiRequestManager.setBaseUri(PVP_NET_BASE);

        return leagueApiRequestManager;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
