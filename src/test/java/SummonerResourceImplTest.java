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
 * Created by Aaryn101 on 12/16/13.
 */
public class SummonerResourceImplTest {
    private static final List<Long> SUMMONER_IDS = new ArrayList<>();
    private static final List<String> SUMMONER_NAMES = new ArrayList<>();
    private static final Region REGION = Region.NA;

    @BeforeClass
    public static void initializeTest() {
        SUMMONER_IDS.add(19163557L);
        SUMMONER_NAMES.add("Aaryn");
    }

    @Test
    public void getMasteryPagesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteryPages(Region.TR, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getMasteryPages(null, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getMasteryPages(REGION, null);
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
            Lol4JTestClient.getClient().getMasteryPages(REGION, empty);
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
            big.add(19163557L);
        }

        try {
            Lol4JTestClient.getClient().getMasteryPages(REGION, big);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryPages() {
        MasteryPagesDto masteryPages = Lol4JTestClient.getClient().getMasteryPages(REGION, SUMMONER_IDS);

        for (MasteryPageDto page : masteryPages.getPages()) {
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
            Lol4JTestClient.getClient().getRunePages(Region.TR, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getRunePages(null, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getRunePages(REGION, null);
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
            Lol4JTestClient.getClient().getRunePages(REGION, empty);
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
            big.add(19163557L);
        }

        try {
            Lol4JTestClient.getClient().getRunePages(REGION, big);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getRunePages() {
        Map<String, RunePagesDto> runePagesMap = Lol4JTestClient.getClient().getRunePages(REGION, SUMMONER_IDS);

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
    public void getSummonersByNameWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonersByName(Region.TR, SUMMONER_NAMES);
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
            Lol4JTestClient.getClient().getSummonersByName(null, SUMMONER_NAMES);
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
            Lol4JTestClient.getClient().getSummonersByName(REGION, null);
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
            Lol4JTestClient.getClient().getSummonersByName(REGION, empty);
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
            Lol4JTestClient.getClient().getSummonersByName(REGION, big);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonersByName() {
        Map<String, SummonerDto> summonerMap = Lol4JTestClient.getClient().getSummonersByName(REGION, SUMMONER_NAMES);

        Assert.assertNotNull(summonerMap);

        for (Map.Entry<String, SummonerDto> entry : summonerMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
            Assert.assertNotNull(entry.getValue().getName());
        }
    }

    @Test
    public void getSummonersWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummoners(Region.TR, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getSummoners(null, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getSummoners(REGION, null);
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
            Lol4JTestClient.getClient().getSummoners(REGION, empty);
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
            big.add(19163557L);
        }

        try {
            Lol4JTestClient.getClient().getSummoners(REGION, big);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummoners() {
        Map<String, SummonerDto> summonerMap = Lol4JTestClient.getClient().getSummoners(REGION, SUMMONER_IDS);

        Assert.assertNotNull(summonerMap);

        for (Map.Entry<String, SummonerDto> entry : summonerMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
            Assert.assertNotNull(entry.getValue().getName());
        }
    }

    @Test
    public void getSummonerNamesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getSummonerNames(Region.TR, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getSummonerNames(null, SUMMONER_IDS);
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
            Lol4JTestClient.getClient().getSummonerNames(REGION, null);
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
            Lol4JTestClient.getClient().getSummonerNames(REGION, empty);
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
            big.add(19163557L);
        }

        try {
            Lol4JTestClient.getClient().getSummonerNames(REGION, big);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getSummonerNames() {
        Map<String, String> summonerNameMap = Lol4JTestClient.getClient().getSummonerNames(REGION, SUMMONER_IDS);

        Assert.assertNotNull(summonerNameMap);

        for (Map.Entry<String, String> entry : summonerNameMap.entrySet()) {
            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(entry.getValue());
        }
    }
}
