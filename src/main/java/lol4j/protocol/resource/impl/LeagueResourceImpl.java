package lol4j.protocol.resource.impl;

import lol4j.exception.SubTypeMismatchException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueItemDto;
import lol4j.protocol.resource.LeagueResource;
import lol4j.util.Region;
import lol4j.util.game.SubType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compatible with league-v2.3
 */
public class LeagueResourceImpl extends AbstractResourceImpl implements LeagueResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v2.3";
    private static final String CHALLENGER_URI = RESOURCE_VERSION + SLASH + "league" + SLASH + "challenger";
    private static final String LEAGUE = "league" + SLASH + "by-summoner";
    private static final String LEAGUE_URI = RESOURCE_VERSION + SLASH + LEAGUE;
    private static final String ENTRY = "entry";

    public LeagueResourceImpl() {
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.LAN);
        getSupportedRegions().add(Region.LAS);
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.OCE);
        getSupportedRegions().add(Region.RU);
        getSupportedRegions().add(Region.TR);
    }

    @Override
    public LeagueDto getChallengerLeague(Region region, SubType gameType) {
        doSupportedRegionCheck(region);
        if (gameType == null || !SubType.getChallengerSubTypes().contains(gameType)) {
            throw new SubTypeMismatchException(gameType);
        }
        String path = region.getName() + SLASH + CHALLENGER_URI;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("type", gameType.getSubType());

        return getApiRequestManager().get(path, queryParams, false, LeagueDto.class);
    }

    @Override
    public List<LeagueDto> getLeaguesData(long summonerId, Region region) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + LEAGUE_URI + SLASH + summonerId;

        return getApiRequestManager().getList(path, null, false, LeagueDto.class);
    }

    @Override
    public List<LeagueItemDto> getLeaguesEntryData(long summonerId, Region region) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + LEAGUE_URI + SLASH + summonerId + SLASH + ENTRY;

        return getApiRequestManager().getList(path, null, false, LeagueItemDto.class);
    }
}
