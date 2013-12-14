package lol4j.protocol.resource;

import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.util.Region;
import lol4j.util.Season;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public interface StatsResource {
    PlayerStatsSummaryListDto getPlayerStatsSummaries(Region region, long summonerId, Season season);

    RankedStatsDto getRankedStats(Region region, long summonerId, Season season);
}
