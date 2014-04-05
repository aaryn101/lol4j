package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.protocol.resource.StatsResource;
import lol4j.util.Region;
import lol4j.util.stats.Season;

import java.util.HashMap;
import java.util.Map;

/**
 * Compatible with stats-v1.3
 */
public class StatsResourceImpl extends AbstractResourceImpl implements StatsResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v1.3";
    private static final String RESOURCE_PATH = "stats" + SLASH + "by-summoner";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public StatsResourceImpl() {
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.LAN);
        getSupportedRegions().add(Region.LAS);
        getSupportedRegions().add(Region.NA);
    }

    @Override
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(long summonerId, Region region, Season season) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "summary";
        Map<String, Object> queryParams = null;
        if (season != null) {
            queryParams = new HashMap<>();
            queryParams.put("season", season.getName());
        }

        return getApiRequestManager().get(path, queryParams, false, PlayerStatsSummaryListDto.class);
    }

    @Override
    public RankedStatsDto getRankedStats(long summonerId, Region region, Season season) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "ranked";
        Map<String, Object> queryParams = null;
        if (season != null) {
            queryParams = new HashMap<>();
            queryParams.put("season", season.getName());
        }

        return getApiRequestManager().get(path, queryParams, false, RankedStatsDto.class);
    }
}
