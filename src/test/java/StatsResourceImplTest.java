import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.stats.ChampionStatsDto;
import lol4j.protocol.dto.stats.PlayerStatsSummaryDto;
import lol4j.protocol.dto.stats.PlayerStatsSummaryListDto;
import lol4j.protocol.dto.stats.RankedStatsDto;
import lol4j.util.Region;
import lol4j.util.Season;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aaryn101 on 12/16/13.
 */
public class StatsResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final Region REGION = Region.NA;
    private static final Season SEASON = Season.SEASON_3;

    @Test
    public void getPlayerStatsSummaries() {
        PlayerStatsSummaryListDto playerStatsSummaryList = Lol4JTestClient.getClient()
                .getPlayerStatsSummaries(REGION, SUMMONER_ID, SEASON);

        Assert.assertNotNull(playerStatsSummaryList);
        Assert.assertNotNull(playerStatsSummaryList.getPlayerStatSummaries());
        Assert.assertTrue(playerStatsSummaryList.getPlayerStatSummaries().size() > 0);

        for (PlayerStatsSummaryDto statSummary : playerStatsSummaryList.getPlayerStatSummaries()) {
            Assert.assertNotNull(statSummary);
            Assert.assertNotNull(statSummary.getAggregatedStats());
            Assert.assertNotNull(statSummary.getPlayerStatSummaryType());
            Assert.assertTrue(statSummary.getLosses() >= 0);
            Assert.assertTrue(statSummary.getWins() >= 0);
        }

        playerStatsSummaryList = Lol4JTestClient.getClient()
                .getPlayerStatsSummaries(REGION, SUMMONER_ID, null);

        Assert.assertNotNull(playerStatsSummaryList);
        Assert.assertNotNull(playerStatsSummaryList.getPlayerStatSummaries());
        Assert.assertTrue(playerStatsSummaryList.getPlayerStatSummaries().size() > 0);

        for (PlayerStatsSummaryDto statSummary : playerStatsSummaryList.getPlayerStatSummaries()) {
            Assert.assertNotNull(statSummary);
            Assert.assertNotNull(statSummary.getAggregatedStats());
            Assert.assertNotNull(statSummary.getPlayerStatSummaryType());
            Assert.assertTrue(statSummary.getLosses() >= 0);
            Assert.assertTrue(statSummary.getWins() >= 0);
        }
    }

    @Test
    public void getRankedStats() {
        RankedStatsDto rankedStats = Lol4JTestClient.getClient().getRankedStats(REGION, SUMMONER_ID, SEASON);

        Assert.assertNotNull(rankedStats);
        Assert.assertNotNull(rankedStats.getChampions());
        Assert.assertTrue(rankedStats.getSummonerId() == SUMMONER_ID);
        Assert.assertTrue(rankedStats.getChampions().size() > 0);

        for (ChampionStatsDto championStats : rankedStats.getChampions()) {
            Assert.assertTrue(championStats.getName() != null || championStats.getId() == 0);
            Assert.assertTrue(championStats.getId() >= 0);
            Assert.assertNotNull(championStats.getStats());
        }

        rankedStats = Lol4JTestClient.getClient().getRankedStats(REGION, SUMMONER_ID, null);

        Assert.assertNotNull(rankedStats);
        Assert.assertNotNull(rankedStats.getChampions());
        Assert.assertTrue(rankedStats.getSummonerId() == SUMMONER_ID);
        Assert.assertTrue(rankedStats.getChampions().size() >= 0);

    }

    @Test
    public void getPlayerStatsSummariesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getPlayerStatsSummaries(Region.TR, 0L, SEASON);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getPlayerStatsSummariesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getPlayerStatsSummaries(null, 0L, SEASON);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
