package lol4j.client.impl;

import lol4j.client.Lol4JClient;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.resource.*;
import lol4j.protocol.resource.impl.ResourceFactory;
import lol4j.util.Region;
import lol4j.util.Season;

import java.util.Map;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class Lol4JClientImpl implements Lol4JClient {
    private ChampionResource championResource;
    private GameResource gameResource;
    private LeagueResource leagueResource;
    private StatsResource statsResource;
    private SummonerResource summonerResource;

    public Lol4JClientImpl(String apiKey) {
        ResourceFactory resourceFactory = new ResourceFactory(apiKey);

        championResource = resourceFactory.createChampionResource();
        gameResource = resourceFactory.createGameResource();
        leagueResource = resourceFactory.createLeagueResource();
        statsResource = resourceFactory.createStatsResource();
        summonerResource = resourceFactory.createSummonerResource();
    }

    @Override
    public ChampionListDto getAllChampions(Region region, boolean freeToPlay) {
        return championResource.getAllChampions(region, freeToPlay);
    }

    @Override
    public RecentGamesDto getRecentGames(Region region, long summonerId) {
        return gameResource.getRecentGames(region, summonerId);
    }

    @Override
    public Map<String, LeagueDto> getLeaguesData(Region region, long summonerId) {
        return leagueResource.getLeaguesData(region, summonerId);
    }

    @Override
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(Region region, long summonerId, Season season) {
        return statsResource.getPlayerStatsSummaries(region, summonerId, season);
    }

    @Override
    public RankedStatsDto getRankedStats(Region region, long summonerId, Season season) {
        return statsResource.getRankedStats(region, summonerId, season);
    }

    @Override
    public MasteryPagesDto getMasteryPages(Region region, long summonerId) {
        return summonerResource.getMasteryPages(region, summonerId);
    }
}
