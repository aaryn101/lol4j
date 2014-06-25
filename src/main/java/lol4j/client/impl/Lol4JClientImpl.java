package lol4j.client.impl;

import lol4j.client.Lol4JClient;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueEntryDto;
import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.resource.*;
import lol4j.protocol.resource.impl.ResourceFactory;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;
import lol4j.util.game.SubType;
import lol4j.util.lolstaticdata.*;
import lol4j.util.stats.Season;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public class Lol4JClientImpl implements Lol4JClient {
    private final Map<Region, ApiRequestManager> requestManagers = new HashMap<>();

    private static final String URL_SCHEME = "https://";
    private static final String SERVER_SUFFIX = ".api.pvp.net";
    private static final String URL_SUFFIX = "/api/lol";
    private static final String STATIC_DATA = "/static-data";

    private static final String STATIC_DATA_BASE = URL_SCHEME + "global" + SERVER_SUFFIX + URL_SUFFIX + STATIC_DATA;
    private ChampionResource championResource;
    private GameResource gameResource;
    private LeagueResource leagueResource;
    private StatsResource statsResource;
    private SummonerResource summonerResource;
    private TeamResource teamResource;
    private LolStaticDataResource lolStaticDataResource;

    public Lol4JClientImpl(String apiKey) {
        for (Region region : Region.values()) {
            if (region == Region.UNKNOWN) {
                continue;
            }

            requestManagers.put(region, new ApiRequestManager(
                    apiKey,
                    URL_SCHEME + region.getName() + SERVER_SUFFIX + URL_SUFFIX
            ));
        }

        ApiRequestManager staticDataApiRequestManager = new ApiRequestManager(apiKey, STATIC_DATA_BASE);
        ResourceFactory resourceFactory = new ResourceFactory(
                requestManagers,
                staticDataApiRequestManager);

        championResource = resourceFactory.createChampionResource();
        gameResource = resourceFactory.createGameResource();
        leagueResource = resourceFactory.createLeagueResource();
        statsResource = resourceFactory.createStatsResource();
        summonerResource = resourceFactory.createSummonerResource();
        teamResource = resourceFactory.createTeamResource();
        lolStaticDataResource = resourceFactory.createLolStaticDataResource();
    }

    @Override
    public ChampionListDto getAllChampions(Region region, boolean freeToPlay) {
        return championResource.getAllChampions(region, freeToPlay);
    }

    @Override
    public ChampionDto getChampion(Region region, int id) {
        return championResource.getChampion(region, id);
    }

    @Override
    public RecentGamesDto getRecentGames(Region region, long summonerId) {
        return gameResource.getRecentGames(region, summonerId);
    }

    @Override
    public LeagueDto getChallengerLeague(Region region, SubType gameType) {
        return leagueResource.getChallengerLeague(region, gameType);
    }

    @Override
    public List<LeagueDto> getLeaguesData(long summonerId, Region region) {
        return leagueResource.getLeaguesData(summonerId, region);
    }

    @Override
    public Map<String, List<LeagueDto>> getLeaguesData(List<Long> summonerIds, Region region) {
        return leagueResource.getLeaguesData(summonerIds, region);
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryData(long summonerId, Region region) {
        return leagueResource.getLeaguesEntryData(summonerId, region);
    }

    @Override
    public Map<String, List<LeagueEntryDto>> getLeaguesEntryData(List<Long> summonerIds, Region region) {
        return leagueResource.getLeaguesEntryData(summonerIds, region);
    }

    @Override
    public List<LeagueDto> getLeaguesDataByTeam(String teamId, Region region) {
        return leagueResource.getLeaguesDataByTeam(teamId, region);
    }

    @Override
    public Map<String, List<LeagueDto>> getLeaguesDataByTeam(List<String> teamIds, Region region) {
        return leagueResource.getLeaguesDataByTeam(teamIds, region);
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryDataByTeam(String teamId, Region region) {
        return leagueResource.getLeaguesEntryDataByTeam(teamId, region);
    }

    @Override
    public Map<String, List<LeagueEntryDto>> getLeaguesEntryDataByTeam(List<String> teamIds, Region region) {
        return leagueResource.getLeaguesEntryDataByTeam(teamIds, region);
    }

    @Override
    public RankedStatsDto getRankedStats(long summonerId, Region region, Season season) {
        return statsResource.getRankedStats(summonerId, region, season);
    }

    @Override
    public Map<String, MasteryPagesDto> getMasteryPages(List<Long> summonerIds, Region region) {
        return summonerResource.getMasteryPages(summonerIds, region);
    }

    @Override
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(long summonerId, Region region, Season season) {
        return statsResource.getPlayerStatsSummaries(summonerId, region, season);
    }

    @Override
    public MasteryPagesDto getMasteryPages(long summonerId, Region region) {
        return summonerResource.getMasteryPages(summonerId, region);
    }

    @Override
    public Map<String, RunePagesDto> getRunePages(List<Long> summonerIds, Region region) {
        return summonerResource.getRunePages(summonerIds, region);
    }

    @Override
    public RunePagesDto getRunePages(long summonerId, Region region) {
        return summonerResource.getRunePages(summonerId, region);
    }

    @Override
    public Map<String, SummonerDto> getSummonersByName(List<String> names, Region region) {
        return summonerResource.getSummonersByName(names, region);
    }

    @Override
    public SummonerDto getSummonerByName(String name, Region region) {
        return summonerResource.getSummonerByName(name, region);
    }

    @Override
    public Map<String, SummonerDto> getSummoners(List<Long> summonerIds, Region region) {
        return summonerResource.getSummoners(summonerIds, region);
    }

    @Override
    public SummonerDto getSummoner(long summonerId, Region region) {
        return summonerResource.getSummoner(summonerId, region);
    }

    @Override
    public Map<String, String> getSummonerNames(List<Long> summonerIds, Region region) {
        return summonerResource.getSummonerNames(summonerIds, region);
    }

    @Override
    public String getSummonerName(long summonerId, Region region) {
        return summonerResource.getSummonerName(summonerId, region);
    }

    @Override
    public List<TeamDto> getTeamsBySummonerId(long summonerId, Region region) {
        return teamResource.getTeamsBySummonerId(summonerId, region);
    }

    @Override
    public Map<String, List<TeamDto>> getTeamsBySummonerId(List<Long> summonerIds, Region region) {
        return teamResource.getTeamsBySummonerId(summonerIds, region);
    }

    @Override
    public TeamDto getTeam(String teamId, Region region) {
        return teamResource.getTeam(teamId, region);
    }

    @Override
    public Map<String, TeamDto> getTeams(List<String> teamIds, Region region) {
        return teamResource.getTeams(teamIds, region);
    }

    @Override
    public lol4j.protocol.dto.lolstaticdata.ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData) {
        return lolStaticDataResource.getChampionList(region, locale, version, requestedData);
    }

    @Override
    public lol4j.protocol.dto.lolstaticdata.ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData) {
        return lolStaticDataResource.getChampion(id, region, locale, version, requestedData);
    }

    @Override
    public BasicDataDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData) {
        return lolStaticDataResource.getItem(id, region, locale, version, requestedData);
    }

    @Override
    public ItemListDto getItemList(Region region, String locale, String version, List<ItemData> requestedData) {
        return lolStaticDataResource.getItemList(region, locale, version, requestedData);
    }

    @Override
    public MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData) {
        return lolStaticDataResource.getMastery(id, region, locale, version, requestedData);
    }

    @Override
    public MasteryListDto getMasteryList(Region region, String locale, String version, List<MasteryData> requestedData) {
        return lolStaticDataResource.getMasteryList(region, locale, version, requestedData);
    }

    @Override
    public RealmDto getRealm(Region region) {
        return lolStaticDataResource.getRealm(region);
    }

    @Override
    public RuneListDto getRuneList(Region region, String locale, String version, List<RuneData> requestedData) {
        return lolStaticDataResource.getRuneList(region, locale, version, requestedData);
    }

    @Override
    public BasicDataDto getRune(String id, Region region, String locale, String version, List<RuneData> requestedData) {
        return lolStaticDataResource.getRune(id, region, locale, version, requestedData);
    }

    @Override
    public SummonerSpellListDto getSummonerSpellList(Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        return lolStaticDataResource.getSummonerSpellList(region, locale, version, requestedData);
    }

    @Override
    public SummonerSpellDto getSummonerSpell(int id, Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        return lolStaticDataResource.getSummonerSpell(id, region, locale, version, requestedData);
    }

    @Override
    public void setRateLimit(int perTenSeconds, int perTenMinutes) {
        for (Region region : Region.values()) {
            if (region == Region.UNKNOWN) {
                continue;
            }

            requestManagers.get(region).setRateLimit(perTenSeconds, perTenMinutes);
        }
    }
}
