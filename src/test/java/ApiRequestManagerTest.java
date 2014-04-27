import lol4j.exception.TooManyRequestsException;
import lol4j.util.Region;
import org.junit.Assert;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class ApiRequestManagerTest {
    private static final Region REGION = Region.NA;

    @org.junit.Test
    public void rateLimiter() {
        try {
            for (int i = 0; i < Lol4JTestClient.getNumPerTenSeconds(); i++) {
                Lol4JTestClient.getClient().getAllChampions(REGION, false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }
}
