import lol4j.exception.InvalidRegionException;
import lol4j.protocol.resource.impl.AbstractResourceImpl;
import lol4j.util.Region;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by aaryn101 on 5/16/14.
 */
public class AbstractResourceImplTest {
    private static AbstractResourceImpl testObj;

    @BeforeClass
    public static void init() {
        testObj = new AbstractResourceImpl() { };
    }

    @Test(expected = InvalidRegionException.class)
    public void testSupportedRegionCheckWithNull() {
        testObj.doSupportedRegionCheck(null);
    }

    @Test(expected = InvalidRegionException.class)
    public void testSupportedRegionCheckWithInvalidRegion() {
        testObj.doSupportedRegionCheck(Region.UNKNOWN);
    }
}
