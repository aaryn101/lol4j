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
public class StatsResourceImpl extends ApiResource implements StatsResource {
    private static final String VERSION = "v1.3";
    private static final String NAME = "stats" + SLASH + "by-summoner";

    public StatsResourceImpl() {
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
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(long summonerId, Region region, Season season) {
        String path = summonerId + SLASH + "summary";
        Map<String, Object> queryParams = addSeason(season);

        return get(region, path, queryParams, false, PlayerStatsSummaryListDto.class);
    }

    @Override
    public RankedStatsDto getRankedStats(long summonerId, Region region, Season season) {
        String path = summonerId + SLASH + "ranked";
        Map<String, Object> queryParams = addSeason(season);

        return get(region, path, queryParams, false, RankedStatsDto.class);
    }

    private Map<String, Object> addSeason(Season season) {
        Map<String, Object> queryParams = null;

        if (season != null) {
            queryParams = new HashMap<>();
            queryParams.put("season", season.getName());
        }

        return queryParams;
    }
}
