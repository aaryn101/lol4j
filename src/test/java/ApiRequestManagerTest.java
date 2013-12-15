import lol4j.exception.TooManyRequestsException;
import org.junit.Assert;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public class ApiRequestManagerTest {
    @org.junit.Test
    public void rateLimiter() {
        Lol4JTestVariables vars = Lol4JTestVariables.getInstance();

        try {
            for (int i = 0; i < vars.getNumPerTenSeconds(); i++) {
                vars.getClient().getAllChampions(vars.getRegion(), false);
            }
        }
        catch(TooManyRequestsException e) {
            Assert.fail("Rate limiter broke!");
        }
    }
}
