import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.league.LeagueDto;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public class LeagueResourceImplTest {
    @org.junit.Test
    public void getLeaguesData() {
        Lol4JTestVariables vars = Lol4JTestVariables.getInstance();
        Map<String, LeagueDto> leaguesData = vars.getClient().getLeaguesData(vars.getRegion(), vars.getSummonerId());

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
            Lol4JTestVariables.getInstance().getClient().getLeaguesData(null, 0L);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
