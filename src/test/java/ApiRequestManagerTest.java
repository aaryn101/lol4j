import lol4j.exception.TooManyRequestsException;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class ApiRequestManagerTest {

    @Test
    public void rateLimiter() {
        try {
            for (int i = 0; i < Lol4JTestClient.getNumPerTenSeconds(); i++) {
                Lol4JTestClient.getClient().getAllChampions(Region.NA, false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }

    @Test
    public void rateLimiterWithMultipleRegions() {
        try {
            for (Region region : Region.values()) {
                if (region == Region.UNKNOWN || region == Region.PBE) {
                    continue;
                }
                Lol4JTestClient.getClient().getAllChampions(region, false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }

    @Test
    public void allRegions() {
        for (Region region : Region.values()) {
            if (region == Region.UNKNOWN || region == Region.PBE) {
                continue;
            }

            ChampionListDto list = Lol4JTestClient.getClient().getAllChampions(region, false);
            Assert.assertNotNull(list);
        }
    }
}
