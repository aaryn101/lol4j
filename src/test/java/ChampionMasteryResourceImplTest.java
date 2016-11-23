import com.sun.org.apache.regexp.internal.RE;
import lol4j.protocol.dto.champion.ChampionMasteryDto;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Aaron Corley on 12/13/13.
 */
public class ChampionMasteryResourceImplTest {
    private static final Region REGION = Region.NA;
    private static final long SUMMONER_ID = 20295494;
    private static final int CHAMPION_ID = 35;

    @Test
    public void getChampionMastery() {
        ChampionMasteryDto championMastery = Lol4JTestClient.getClient().getChampionMastery(REGION, SUMMONER_ID, CHAMPION_ID);

        Assert.assertNotNull(championMastery.getChampionPoints());
        Assert.assertNotNull(championMastery.getPlayerId());
        Assert.assertNotNull(championMastery.getChampionPointsUntilNextLevel());
        Assert.assertNotNull(championMastery.isChestGranted());
        Assert.assertNotNull(championMastery.getChampionLevel());
        Assert.assertNotNull(championMastery.getTokensEarned());
        Assert.assertNotNull(championMastery.getChampionId());
        Assert.assertNotNull(championMastery.getChampionPointsSinceLastLevel());
        Assert.assertNotNull(championMastery.getLastPlayTime());
    }

    @Test
    public void getChampionMasteries() {
        List<ChampionMasteryDto> championMasteries = Lol4JTestClient.getClient().getChampionMasteries(REGION, SUMMONER_ID);

        Assert.assertTrue(championMasteries.size() > 0);
    }

    @Test
    public void getChampionMasteryScore() {
        int score = Lol4JTestClient.getClient().getChampionMasteryScore(REGION, SUMMONER_ID);

        Assert.assertTrue(score > 0);
    }

    @Test
    public void getTopChampions() {
        List<ChampionMasteryDto> championMasteries = Lol4JTestClient.getClient().getTopChampions(REGION, SUMMONER_ID);

        Assert.assertTrue(championMasteries.size() > 0);
    }
}
