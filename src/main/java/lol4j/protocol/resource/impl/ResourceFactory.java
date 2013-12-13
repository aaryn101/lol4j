package lol4j.protocol.resource.impl;

import lol4j.protocol.resource.*;
import lol4j.service.impl.ApiRequestManager;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class ResourceFactory {
    private static final String LOL_BASE = "http://prod.api.pvp.net/api/lol";
    private static final String PVP_NET_BASE = "http://prod.api.pvp.net/api";
    private ApiRequestManager apiRequestManager;

    public ResourceFactory(String apiKey) {
        apiRequestManager = new ApiRequestManager();
        apiRequestManager.setApiKey(apiKey);
    }

    public ChampionResource createChampionResource() {
        ChampionResourceImpl championResource = new ChampionResourceImpl();
        championResource.setApiRequestManager(apiRequestManager);
        championResource.setBaseUri(LOL_BASE);

        return championResource;
    }

    public GameResource createGameResource() {
        GameResourceImpl gameResource = new GameResourceImpl();
        gameResource.setApiRequestManager(apiRequestManager);
        gameResource.setBaseUri(LOL_BASE);

        return gameResource;
    }

    public LeagueResource createLeagueResource() {
        LeagueResourceImpl leagueResource = new LeagueResourceImpl();
        leagueResource.setApiRequestManager(apiRequestManager);
        leagueResource.setBaseUri(PVP_NET_BASE);

        return leagueResource;
    }

    public StatsResource createStatsResource() {
        StatsResourceImpl statsResource = new StatsResourceImpl();
        statsResource.setApiRequestManager(apiRequestManager);
        statsResource.setBaseUri(LOL_BASE);

        return statsResource;
    }

    public SummonerResource createSummonerResource() {
        SummonerResourceImpl summonerResource = new SummonerResourceImpl();
        summonerResource.setApiRequestManager(apiRequestManager);
        summonerResource.setBaseUri(LOL_BASE);

        return summonerResource;
    }
}
