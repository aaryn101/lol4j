package lol4j.client.impl;

import lol4j.client.Lol4JClient;
import lol4j.protocol.resource.ChampionResource;
import lol4j.protocol.resource.GameResource;
import lol4j.protocol.resource.LeagueResource;
import lol4j.service.impl.ApiRequestManagerFactory;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class Lol4JClientImpl implements Lol4JClient {
    private ApiRequestManagerFactory apiRequestManagerFactory;
    private ChampionResource championResource;
    private GameResource gameResource;
    private LeagueResource leagueResource;

    public Lol4JClientImpl(String apiKey) {
        apiRequestManagerFactory = new ApiRequestManagerFactory();
        apiRequestManagerFactory.setApiKey(apiKey);

        championResource = apiRequestManagerFactory.createChampionResource();
        gameResource = apiRequestManagerFactory.createGameResource();
        leagueResource = apiRequestManagerFactory.createLeagueResource();
    }

    @Override
    public ChampionResource getChampionResource() {
        return championResource;
    }

    @Override
    public GameResource getGameResource() {
        return gameResource;
    }

    @Override
    public LeagueResource getLeagueResource() {
        return leagueResource;
    }
}
