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

    @Test
    public void getMasteryPagesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(SUMMONER_IDS, Region.UNKNOWN);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(SUMMONER_IDS, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesWithNullList() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(null, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesWithEmptyList() {
        boolean exceptionThrown = false;
        List<Long> empty = new ArrayList<>();

        try {
            Lol4JTestClient.getClient().getMasteryPages(empty, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesWithBigList() {
        boolean exceptionThrown = false;
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }

        try {
            Lol4JTestClient.getClient().getMasteryPages(big, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
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
                Assert.assertNotNull(page.getTalents());

                for (TalentDto talent : page.getTalents()) {
                    Assert.assertNotNull(talent.getName());
                }
            }
        }
    }

    @Test
    public void getMasteryPagesSingleWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, Region.UNKNOWN);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesSingleWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, null);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPagesSingle() {
        MasteryPagesDto pages = Lol4JTestClient.getClient().getMasteryPages(SUMMONER_ID, REGION);

        Assert.assertNotNull(pages);

        for (MasteryPageDto page : pages.getPages()) {
            Assert.assertNotNull(page.getName());
            Assert.assertNotNull(page.getTalents());

            for (TalentDto talent : page.getTalents()) {
                Assert.assertNotNull(talent.getName());
            }
        }
    }

    @Test
    public void getRunePagesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, Region.UNKNOWN);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesWithNullList() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRunePages(null, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesWithEmptyList() {
        boolean exceptionThrown = false;
        List<Long> empty = new ArrayList<>();

        try {
            Lol4JTestClient.getClient().getRunePages(empty, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesWithBigList() {
        boolean exceptionThrown = false;
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }

        try {
            Lol4JTestClient.getClient().getRunePages(big, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePages() {
        Map<String, RunePagesDto> runePagesMap = Lol4JTestClient.getClient().getRunePages(SUMMONER_IDS, REGION);

        Assert.assertNotNull(runePagesMap);

        for (Map.Entry<String, RunePagesDto> entry : runePagesMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());

            for (RunePageDto runePage : entry.getValue().getPages()) {
                Assert.assertNotNull(runePage.getName());
                Assert.assertNotNull(runePage.getSlots());

                for (RuneSlotDto runeSlot : runePage.getSlots()) {
                    Assert.assertNotNull(runeSlot.getRune());
                    Assert.assertNotNull(runeSlot.getRune().getName());
                    Assert.assertNotNull(runeSlot.getRune().getDescription());
                    Assert.assertNotNull(runeSlot.getRuneSlot());
                }
            }
        }
    }

    @Test
    public void getRunePagesSingleWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, Region.UNKNOWN);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesSingleWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, null);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePagesSingle() {
        RunePagesDto pages = Lol4JTestClient.getClient().getRunePages(SUMMONER_ID, REGION);

        Assert.assertNotNull(pages);

        for (RunePageDto runePage : pages.getPages()) {
            Assert.assertNotNull(runePage.getName());
            Assert.assertNotNull(runePage.getSlots());

            for (RuneSlotDto runeSlot : runePage.getSlots()) {
                Assert.assertNotNull(runeSlot.getRune());
                Assert.assertNotNull(runeSlot.getRune().getName());
                Assert.assertNotNull(runeSlot.getRune().getDescription());
                Assert.assertNotNull(runeSlot.getRuneSlot());
            }
        }
    }

    @Test
    public void getSummonersByNameWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonersByName(SUMMONER_NAMES, Region.UNKNOWN);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersByNameWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonersByName(SUMMONER_NAMES, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersByNameWithNullList() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonersByName(null, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersByNameWithEmptyList() {
        boolean exceptionThrown = false;
        List<String> empty = new ArrayList<>();

        try {
            Lol4JTestClient.getClient().getSummonersByName(empty, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersByNameWithBigList() {
        boolean exceptionThrown = false;
        List<String> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add("Aaryn");
        }

        try {
            Lol4JTestClient.getClient().getSummonersByName(big, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
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

    @Test
    public void getSummonerByNameWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, Region.UNKNOWN);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerByNameWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, null);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerByNameWithNullName() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerByName(null, REGION);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerByNameWithEmptyName() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerByName("", REGION);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerByName() {
        SummonerDto summoner = Lol4JTestClient.getClient().getSummonerByName(SUMMONER_NAME, REGION);

        Assert.assertNotNull(summoner);
        Assert.assertNotNull(summoner.getName());
    }

    @Test
    public void getSummonersWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoners(SUMMONER_IDS, Region.TR);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoners(SUMMONER_IDS, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersWithNullList() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoners(null, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersWithEmptyList() {
        boolean exceptionThrown = false;
        List<Long> empty = new ArrayList<>();

        try {
            Lol4JTestClient.getClient().getSummoners(empty, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersWithBigList() {
        boolean exceptionThrown = false;
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }

        try {
            Lol4JTestClient.getClient().getSummoners(big, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
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

    @Test
    public void getSummonerWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, Region.TR);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, null);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummoner() {
        SummonerDto summoner = Lol4JTestClient.getClient().getSummoner(SUMMONER_ID, REGION);

        Assert.assertNotNull(summoner);
        Assert.assertNotNull(summoner.getName());
    }

    @Test
    public void getSummonerNamesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerNames(SUMMONER_IDS, Region.TR);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNamesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerNames(SUMMONER_IDS, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNamesWithNullList() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerNames(null, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNamesWithEmptyList() {
        boolean exceptionThrown = false;
        List<Long> empty = new ArrayList<>();

        try {
            Lol4JTestClient.getClient().getSummonerNames(empty, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNamesWithBigList() {
        boolean exceptionThrown = false;
        List<Long> big = new ArrayList<>();

        for (int i = 0; i < SummonerResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(SUMMONER_ID);
        }

        try {
            Lol4JTestClient.getClient().getSummonerNames(big, REGION);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
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

    @Test
    public void getSummonerNameWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, Region.TR);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNameWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, null);
        }
        catch (InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerName() {
        String summonerName = Lol4JTestClient.getClient().getSummonerName(SUMMONER_ID, REGION);

        Assert.assertNotNull(summonerName);
    }
}
