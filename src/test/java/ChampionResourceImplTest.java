import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aaron Corley on 12/13/13.
 */
public class ChampionResourceImplTest {
    private static final Region REGION = Region.NA;
    private static final int CHAMPION_ID = 17; // Teemo

    @Test
    public void getAllChampions() {
        ChampionListDto championList = Lol4JTestClient.getClient().getAllChampions(REGION, false);

        Assert.assertNotNull(championList);
        Assert.assertNotNull(championList.getChampions());
        Assert.assertNotEquals(championList.getChampions().size(), 0);

        ChampionDto champion = championList.getChampions().get(0);
        Assert.assertTrue(champion.getId() > 0);
    }

    @Test
    public void getChampion() {
        ChampionDto champion = Lol4JTestClient.getClient().getChampion(REGION, CHAMPION_ID);

        Assert.assertEquals(CHAMPION_ID, champion.getId());
    }

    @Test(expected = InvalidRegionException.class)
    public void getChampionWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getChampion(Region.UNKNOWN, CHAMPION_ID);
    }

    @Test(expected = InvalidRegionException.class)
    public void getChampionWithNullRegion() {
        Lol4JTestClient.getClient().getChampion(null, CHAMPION_ID);
    }

    @Test(expected = InvalidRegionException.class)
    public void getAllChampionsWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getAllChampions(Region.UNKNOWN, false);
    }

    @Test(expected = InvalidRegionException.class)
    public void getAllChampionsWithNullRegion() {
        Lol4JTestClient.getClient().getAllChampions(null, false);
    }
}
