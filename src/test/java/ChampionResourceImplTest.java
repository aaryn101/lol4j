import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.util.Region;
import org.junit.Assert;

/**
 * Created by Aaryn101 on 12/13/13.
 */
public class ChampionResourceImplTest extends AbstractResourceImplTest {
    @org.junit.Test
    public void test_getAllChampions() {
        ChampionListDto championList = getClient().getAllChampions(Region.NA, false);

        Assert.assertNotNull(championList);
        Assert.assertNotNull(championList.getChampions());
        Assert.assertNotEquals(championList.getChampions().size(), 0);

        ChampionDto champion = championList.getChampions().get(0);
        Assert.assertNotNull(champion.getAttackRank());
        Assert.assertNotNull(champion.getDefenseRank());
        Assert.assertNotNull(champion.getDifficultyRank());
        Assert.assertNotNull(champion.getId());
        Assert.assertNotNull(champion.getMagicRank());
        Assert.assertNotNull(champion.getName());
    }

    @org.junit.Test
    public void test_getAllChampionsWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            getClient().getAllChampions(Region.TR, false);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @org.junit.Test
    public void test_getAllChampionsWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            getClient().getAllChampions(null, false);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
