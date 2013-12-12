package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.resource.StatsResource;
import lol4j.util.Regions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class StatsResourceImpl extends AbstractResourceImpl implements StatsResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "stats" + SLASH + "by-summoner";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public StatsResourceImpl() {
        getSupportedRegions().add(Regions.EUW);
        getSupportedRegions().add(Regions.EUNE);
        getSupportedRegions().add(Regions.NA);
    }

    @Override
    public PlayerStatsSummaryListDto getPlayerStatsSummaries(String region, long summonerId, String season) throws InvalidRegionException {
        if (isSupportedRegion(region)) {
            String path = region + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "summary";
            Map<String, Object> queryParams = null;
            if (season != null && !season.isEmpty()) {
                queryParams = new HashMap<>();
                queryParams.put("season", season);
            }

            return getApiRequestManager().get(getBaseUri(), path, queryParams, PlayerStatsSummaryListDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }
}
