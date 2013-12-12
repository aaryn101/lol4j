package lol4j.protocol.resource;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public interface StatsResource {
    PlayerStatsSummaryListDto getPlayerStatsSummaries(String region, long summonerId, String season) throws InvalidRegionException;
}
