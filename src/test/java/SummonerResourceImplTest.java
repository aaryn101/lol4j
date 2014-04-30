import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.summoner.*;
import lol4j.protocol.resource.impl.SummonerResourceImpl;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 12/16/13.
 */
public class SummonerResourceImplTest {
    private static final List<Long> SUMMONER_IDS = new ArrayList<>();
    private static final List<String> SUMMONER_NAMES = new ArrayList<>();
    private static final Region REGION = Region.NA;
    private static final long SUMMONER_ID = 19163557L;
    private static final String SUMMONER_NAME = "Aaryn";

    @BeforeClass
    public static void initializeTest() {
        SUMMONER_IDS.add(SUMMONER_ID);
        SUMMONER_NAMES.add(SUMMONER_NAME);
    }

    @Test(expected = InvalidRegionException.class)
    public void getMasteryPagesWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getMasteryPages(SUMMONER_IDS, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getMasteryPagesWithNullRegion() {
        Lol4JTestClient.getClient().getMasteryPages(SUMMONER_IDS, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMasteryPagesWithNullList() {
        Lol4JTestClient.getClient().getMasteryPages(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMasteryPagesWithEmptyList() {
        List<Long> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getMasteryPages(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMasteryPagesWithBigList() {
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }
        Lol4JTestClient.getClient().getMasteryPages(big, REGION);
    }

    @Test
    public void getMasteryPages() {
        Map<String, MasteryPagesDto> masteryPages = Lol4JTestClient.getClient().getMasteryPages(SUMMONER_IDS, REGION);

        Assert.assertNotNull(masteryPages);

        for (Map.Entry<String, MasteryPagesDto> entry: masteryPages.entrySet()) {
            MasteryPagesDto pages = entry.getValue();

            Assert.assertNotNull(pages);
            for (MasteryPageDto page : pages.getPages()) {
                Assert.assertNotNull(page.getName());
                Assert.assertNotNull(page.getMasteries());

                testMasteryPage(page);
            }
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getMasteryPagesSingleWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getMasteryPagesSingleWithNullRegion() {
        Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, null);
    }

    @Test
    public void getMasteryPagesSingle() {
        MasteryPagesDto pages = Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, REGION);

        Assert.assertNotNull(pages);

        for (MasteryPageDto page : pages.getPages()) {
            Assert.assertNotNull(page.getName());
            Assert.assertNotNull(page.getMasteries());

            testMasteryPage(page);
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getRunePagesWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getRunePagesWithNullRegion() {
        Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRunePagesWithNullList() {
        Lol4JTestClient.getClient().getRunePages(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRunePagesWithEmptyList() {
        List<Long> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getRunePages(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRunePagesWithBigList() {
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }
        Lol4JTestClient.getClient().getRunePages(big, REGION);
    }

    @Test
    public void getRunePages() {
        Map<String, RunePagesDto> runePagesMap = Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, REGION);

        Assert.assertNotNull(runePagesMap);

        for (Map.Entry<String, RunePagesDto> entry : runePagesMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());

            testRunePages(entry.getValue());
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getRunePagesSingleWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getRunePagesSingleWithNullRegion() {
        Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, null);
    }

    @Test
    public void getRunePagesSingle() {
        RunePagesDto pages = Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, REGION);

        Assert.assertNotNull(pages);

        testRunePages(pages);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonersByNameWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummonersByName(SUMMONER_NAMES, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonersByNameWithNullRegion() {
        Lol4JTestClient.getClient().getSummonersByName(SUMMONER_NAMES, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersByNameWithNullList() {
        Lol4JTestClient.getClient().getSummonersByName(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersByNameWithEmptyList() {
        List<String> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getSummonersByName(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersByNameWithBigList() {
        List<String> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add("Aaryn");
        }
        Lol4JTestClient.getClient().getSummonersByName(big, REGION);
    }

    @Test
    public void getSummonersByName() {
        Map<String, SummonerDto> summonerMap = Lol4JTestClient.getClient().getSummonersByName(SUMMONER_NAMES, REGION);

        Assert.assertNotNull(summonerMap);

        for (Map.Entry<String, SummonerDto> entry : summonerMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
            Assert.assertNotNull(entry.getValue().getName());
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerByNameWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerByNameWithNullRegion() {
        Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonerByNameWithNullName() {
        Lol4JTestClient.getClient().getSummonerByName(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonerByNameWithEmptyName() {
        Lol4JTestClient.getClient().getSummonerByName("", REGION);
    }

    @Test
    public void getSummonerByName() {
        SummonerDto summoner = Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, REGION);

        Assert.assertNotNull(summoner);
        Assert.assertNotNull(summoner.getName());
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonersWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummoners(SUMMONER_IDS, Region.TR);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonersWithNullRegion() {
        Lol4JTestClient.getClient().getSummoners(SUMMONER_IDS, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersWithNullList() {
        Lol4JTestClient.getClient().getSummoners(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersWithEmptyList() {
        List<Long> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getSummoners(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonersWithBigList() {
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }
        Lol4JTestClient.getClient().getSummoners(big, REGION);
    }

    @Test
    public void getSummoners() {
        Map<String, SummonerDto> summonerMap = Lol4JTestClient.getClient().getSummoners(SUMMONER_IDS, REGION);

        Assert.assertNotNull(summonerMap);

        for (Map.Entry<String, SummonerDto> entry : summonerMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
            Assert.assertNotNull(entry.getValue().getName());
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, Region.TR);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerWithNullRegion() {
        Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, null);
    }

    @Test
    public void getSummoner() {
        SummonerDto summoner = Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, REGION);

        Assert.assertNotNull(summoner);
        Assert.assertNotNull(summoner.getName());
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerNamesWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummonerNames(SUMMONER_IDS, Region.TR);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerNamesWithNullRegion() {
        Lol4JTestClient.getClient().getSummonerNames(SUMMONER_IDS, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonerNamesWithNullList() {
        Lol4JTestClient.getClient().getSummonerNames(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonerNamesWithEmptyList() {
        List<Long> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getSummonerNames(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSummonerNamesWithBigList() {
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }
        Lol4JTestClient.getClient().getSummonerNames(big, REGION);
    }

    @Test
    public void getSummonerNames() {
        Map<String, String> summonerNameMap = Lol4JTestClient.getClient().getSummonerNames(SUMMONER_IDS, REGION);

        Assert.assertNotNull(summonerNameMap);

        for (Map.Entry<String, String> entry : summonerNameMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerNameWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, Region.TR);
    }

    @Test(expected = InvalidRegionException.class)
    public void getSummonerNameWithNullRegion() {
        Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, null);
    }

    @Test
    public void getSummonerName() {
        String summonerName = Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, REGION);

        Assert.assertNotNull(summonerName);
    }

    // Utilities

    private void testMasteryPage(MasteryPageDto page) {
        int count = 0;
        for (MasteryDto talent : page.getMasteries()) {
            Assert.assertTrue(talent.getRank() > 0);
            count += talent.getRank();
        }

        Assert.assertTrue(count >= 0 && count <= 30);
    }

    private void testRunePages(RunePagesDto runePagesDto) {
        for (RunePageDto runePage : runePagesDto.getPages()) {
            Assert.assertNotNull(runePage.getName());
            Assert.assertNotNull(runePage.getSlots());

            for (RuneSlotDto runeSlot : runePage.getSlots()) {
                Assert.assertTrue(runeSlot.getRuneId() >= 0);
                Assert.assertNotNull(runeSlot.getRuneSlot());
            }
        }
    }
}
