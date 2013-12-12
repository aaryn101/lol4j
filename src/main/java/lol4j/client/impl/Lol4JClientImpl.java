package lol4j.client.impl;

import lol4j.client.Lol4JClient;
import lol4j.protocol.resource.ChampionResource;
import lol4j.protocol.resource.GameResource;
import lol4j.protocol.resource.LeagueResource;
import lol4j.protocol.resource.StatsResource;
import lol4j.protocol.resource.impl.ResourceFactory;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class Lol4JClientImpl implements Lol4JClient {
    private ResourceFactory resourceFactory;
    private ChampionResource championResource;
    private GameResource gameResource;
    private LeagueResource leagueResource;
    private StatsResource statsResource;

    public Lol4JClientImpl(String apiKey) {
        resourceFactory = new ResourceFactory(apiKey);

        championResource = resourceFactory.createChampionResource();
        gameResource = resourceFactory.createGameResource();
        leagueResource = resourceFactory.createLeagueResource();
        statsResource = resourceFactory.createStatsResource();
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

    @Override
    public StatsResource getStatsResource() {
        return statsResource;
    }
}
