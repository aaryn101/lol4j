import lol4j.exception.TooManyRequestsException;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class ApiRequestManagerTest {
    private static final Region PROD_REGION = Region.NA;
    private static final Region EU_REGION = Region.RU;
    private static final Region ASIA_REGION = Region.KR;

    @Test
    public void rateLimiter() {
        try {
            for (int i = 0; i < Lol4JTestClient.getNumPerTenSeconds(); i++) {
                Lol4JTestClient.getClient().getAllChampions(PROD_REGION, false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }

    @Test
    public void rateLimiterWithMultipleRegions() {
        try {
            for (int i = 0; i < Lol4JTestClient.getNumPerTenSeconds(); i++) {
                Lol4JTestClient.getClient().getAllChampions(PROD_REGION, false);
                Lol4JTestClient.getClient().getAllChampions(EU_REGION, false);
                Lol4JTestClient.getClient().getAllChampions(ASIA_REGION, false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }

    @Test
    public void prodRegion() {
        ChampionListDto list = Lol4JTestClient.getClient().getAllChampions(PROD_REGION, false);
        Assert.assertNotNull(list);
    }

    @Test
    public void euRegion() {
        ChampionListDto list = Lol4JTestClient.getClient().getAllChampions(EU_REGION, false);
        Assert.assertNotNull(list);
    }

    @Test
    public void asiaRegion() {
        ChampionListDto list = Lol4JTestClient.getClient().getAllChampions(ASIA_REGION, false);
        Assert.assertNotNull(list);
    }
}
