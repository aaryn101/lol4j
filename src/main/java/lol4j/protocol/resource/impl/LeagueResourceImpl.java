package lol4j.protocol.resource.impl;

import lol4j.exception.SubTypeMismatchException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueEntryDto;
import lol4j.protocol.resource.LeagueResource;
import lol4j.util.Region;
import lol4j.util.game.SubType;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compatible with league-v2.5
 */
public class LeagueResourceImpl extends ApiResource implements LeagueResource {
    private static final String VERSION = "v2.5";
    private static final String NAME = "league";
    private static final String CHALLENGER_URI = "challenger";
    private static final String LEAGUE_URI = "by-summoner";
    private static final String LEAGUE_BY_TEAM_URI = "by-team";
    private static final String ENTRY = "entry";
    public static final int MAX_LIST_SIZE = 40;

    public LeagueResourceImpl() {
        super(
                NAME,
                VERSION,
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.JP,
                Region.KR,
                Region.LAN,
                Region.LAS,
                Region.NA,
                Region.OCE,
                Region.RU,
                Region.TR
        );
    }

    @Override
    public LeagueDto getChallengerLeague(Region region, SubType gameType) {
        if (gameType == null || !SubType.getChallengerSubTypes().contains(gameType)) {
            throw new SubTypeMismatchException(gameType);
        }
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("type", gameType.getSubType());

        return get(region, CHALLENGER_URI, queryParams, false, LeagueDto.class);
    }

    @Override
    public List<LeagueDto> getLeaguesData(long summonerId, Region region) {
        String path = LEAGUE_URI + SLASH + summonerId;
        Map<String, List<LeagueDto>> map = get(region, path, null, false, new GenericType<Map<String, List<LeagueDto>>>() {});

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

        return get(region, path, null, false, new GenericType<Map<String, List<LeagueDto>>>() {});
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryData(long summonerId, Region region) {
        String path = LEAGUE_URI + SLASH + summonerId + SLASH + ENTRY;
        Map<String, List<LeagueEntryDto>> map = get(region, path, null, false, new GenericType<Map<String, List<LeagueEntryDto>>>() {});

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

        return get(region, path, null, false, new GenericType<Map<String, List<LeagueEntryDto>>>() {});
    }

    @Override
    public List<LeagueEntryDto> getLeaguesEntryDataByTeam(String teamId, Region region) {
        if (teamId == null || teamId.isEmpty()) {
            throw new IllegalArgumentException("teamId must provided");
        }
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamId + SLASH + ENTRY;
        Map<String, List<LeagueEntryDto>> map = get(region, path, null, false, new GenericType<Map<String, List<LeagueEntryDto>>>() {});

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

        return get(region, path, null, false, new GenericType<Map<String, List<LeagueEntryDto>>>() {});
    }

    @Override
    public List<LeagueDto> getLeaguesDataByTeam(String teamId, Region region) {
        if (teamId == null || teamId.isEmpty()) {
            throw new IllegalArgumentException("teamId must provided");
        }
        String path = LEAGUE_BY_TEAM_URI + SLASH + teamId;
        Map<String, List<LeagueDto>> map = get(region, path, null, false, new GenericType<Map<String, List<LeagueDto>>>() {});

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

        return get(region, path, null, false, new GenericType<Map<String, List<LeagueDto>>>() {});
    }
}
