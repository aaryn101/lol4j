package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.protocol.resource.StatsResource;
import lol4j.service.impl.ApiRequestManager;
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
        super(
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
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(long summonerId, Region region, Season season) {
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + "summary";
        Map<String, Object> queryParams = null;
        if (season != null) {
            queryParams = new HashMap<>();
            queryParams.put("season", season.getName());
        }

        return get(region, path, queryParams, false, PlayerStatsSummaryListDto.class);
    }

    @Override
    public RankedStatsDto getRankedStats(long summonerId, Region region, Season season) {
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + "ranked";
        Map<String, Object> queryParams = null;
        if (season != null) {
            queryParams = new HashMap<>();
            queryParams.put("season", season.getName());
        }

        return get(region, path, queryParams, false, RankedStatsDto.class);
    }
}
