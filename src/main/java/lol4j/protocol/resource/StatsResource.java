package lol4j.protocol.resource;

import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.util.Region;
import lol4j.util.stats.Season;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public interface StatsResource {
    PlayerStatsSummaryListDto getPlayerStatsSummaries(long summonerId, Region region, Season season);

    RankedStatsDto getRankedStats(long summonerId, Region region, Season season);
}
