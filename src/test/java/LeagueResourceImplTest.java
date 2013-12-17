import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.util.Region;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public class LeagueResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final Region REGION = Region.NA;

    @org.junit.Test
    public void getLeaguesData() {
        Map<String, LeagueDto> leaguesData = Lol4JTestClient.getClient().getLeaguesData(REGION, SUMMONER_ID);

        Assert.assertNotNull(leaguesData);

        if (leaguesData.size() > 0) {
            LeagueDto leagueData = leaguesData.get(leaguesData.keySet().iterator().next());

            Assert.assertNotNull(leagueData);
            Assert.assertNotNull(leagueData.getName());
            Assert.assertNotNull(leagueData.getTier());
            Assert.assertNotNull(leagueData.getQueue());
            Assert.assertNotNull(leagueData.getEntries());
            Assert.assertNotEquals(leagueData.getEntries().size(), 0);
        }
    }

    @org.junit.Test
    public void getAllChampionsWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getLeaguesData(null, 0L);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
