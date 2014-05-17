package lol4j.protocol.resource.impl;

import lol4j.exception.SubTypeMismatchException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueEntryDto;
import lol4j.protocol.resource.LeagueResource;
import lol4j.util.Region;
import lol4j.util.game.SubType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compatible with league-v2.4
 */
public class LeagueResourceImpl extends AbstractResourceImpl implements LeagueResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v2.4";
    private static final String CHALLENGER_URI = RESOURCE_VERSION + SLASH + "league" + SLASH + "challenger";
    private static final String LEAGUE = "league" + SLASH + "by-summoner";
    private static final String LEAGUE_URI = RESOURCE_VERSION + SLASH + LEAGUE;
    private static final String LEAGUE_BY_TEAM = "league" + SLASH + "by-team";
    private static final String LEAGUE_BY_TEAM_URI = RESOURCE_VERSION + SLASH + LEAGUE_BY_TEAM;
    private static final String ENTRY = "entry";
    public static final int MAX_LIST_SIZE = 40;

    public LeagueResourceImpl() {
        super(
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.LAN,
                Region.LAS,
                Region.NA,
                Region.OCE,
                Region.RU,
                Region.TR,
                Region.KR
        );
    }

    @Override
    public LeagueDto getChallengerLeague(Region region, SubType gameType) {
        if (gameType == null || !SubType.getChallengerSubTypes().contains(gameType)) {
            throw new SubTypeMismatchException(gameType);
        }
        String path = CHALLENGER_URI;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("type", gameType.getSubType());

        return get(region, path, queryParams, false, LeagueDto.class);
    }

    @Override
    public List<LeagueDto> getLeaguesData(long summonerId, Region region) {
        String path = LEAGUE_URI + SLASH + summonerId;
        Map<String, List<LeagueDto>> map = getMapOfLists(region, path, null, false, String.class, LeagueDto.class);

        return map.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, List<LeagueDto>> getLeaguesData(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = LEAGUE_URI + SLASH + summonerIdList;

        return getMapOfLists(region, path, null, false, String.class, LeagueDto.class);
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryData(long summonerId, Region region) {
        String path = LEAGUE_URI + SLASH + summonerId + SLASH + ENTRY;
        Map<String, List<LeagueEntryDto>> map = getMapOfLists(region, path, null, false, String.class, LeagueEntryDto.class);

        return map.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, List<LeagueEntryDto>> getLeaguesEntryData(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = LEAGUE_URI + SLASH + summonerIdList + SLASH + ENTRY;

        return getMapOfLists(region, path, null, false, String.class, LeagueEntryDto.class);
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryDataByTeam(String teamId, Region region) {
        if (teamId == null || teamId.isEmpty()) {
            throw new IllegalArgumentException("teamId must provided");
        }
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamId + SLASH + ENTRY;
        Map<String, List<LeagueEntryDto>> map = getMapOfLists(region, path, null, false, String.class, LeagueEntryDto.class);

        return map.get(teamId);
    }

    @Override
    public Map<String, List<LeagueEntryDto>> getLeaguesEntryDataByTeam(List<String> teamIds, Region region) {
        if (teamIds == null || teamIds.size() > MAX_LIST_SIZE || teamIds.size() == 0) {
            throw new IllegalArgumentException("teamIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String teamIdList = StringUtils.join(teamIds, ",");
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamIdList + SLASH + ENTRY;

        return getMapOfLists(region, path, null, false, String.class, LeagueEntryDto.class);
    }

    @Override
    public List<LeagueDto> getLeaguesDataByTeam(String teamId, Region region) {
        if (teamId == null || teamId.isEmpty()) {
            throw new IllegalArgumentException("teamId must provided");
        }
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamId;
        Map<String, List<LeagueDto>> map = getMapOfLists(region, path, null, false, String.class, LeagueDto.class);

        return map.get(teamId);
    }

    @Override
    public Map<String, List<LeagueDto>> getLeaguesDataByTeam(List<String> teamIds, Region region) {
        if (teamIds == null || teamIds.size() > MAX_LIST_SIZE || teamIds.size() == 0) {
            throw new IllegalArgumentException("teamIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String teamIdList = StringUtils.join(teamIds, ",");
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamIdList;

        return getMapOfLists(region, path, null, false, String.class, LeagueDto.class);
    }
}
