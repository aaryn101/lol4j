import lol4j.exception.InvalidRegionException;
import lol4j.protocol.resource.impl.AbstractResource;
import lol4j.util.Region;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by aaryn101 on 5/16/14.
 */
public class AbstractResourceTest {
    private static AbstractResource testObj;

    @BeforeClass
    public static void init() {
        testObj = new AbstractResource() {
            @Override
            protected String getBasePath(Region region) {
                return "";
            }
        };
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
