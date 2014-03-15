import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.protocol.resource.ItemListDto;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.ChampData;
import lol4j.util.lolstaticdata.ItemData;
import lol4j.util.lolstaticdata.MasteryData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/9/14.
 */
public class LolStaticDataResourceImplTest {
    private static final Region REGION = Region.NA;
    private static final String CHAMP_ID = "35";
    private static final String ITEM_ID = "1027";
    private static final String MASTERY_ID = "4353";
    private static final List<ChampData> CHAMP_DATA = new ArrayList<>();
    private static final List<ItemData> ITEM_DATA = new ArrayList<>();
    private static final List<MasteryData> MASTERY_DATA = new ArrayList<>();

    @BeforeClass
    public static void initializeTest() {
        CHAMP_DATA.add(ChampData.ALL);
        ITEM_DATA.add(ItemData.ALL);
        MASTERY_DATA.add(MasteryData.ALL);
    }

    @Test
    public void getChampionListWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampionList(Region.UNKNOWN, "en_US", null, CHAMP_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampionListWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampionList(null, "en_US", null, CHAMP_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampionList() {
        ChampionListDto championList = Lol4JTestClient.getClient().getChampionList(REGION, "en_US", null, CHAMP_DATA);

        Assert.assertNotNull(championList);
        for (Map.Entry<String, ChampionDto> entry : championList.getData().entrySet()) {
            ChampionDto champion = entry.getValue();

            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(champion);

            Assert.assertNotNull(champion.getBlurb());
            Assert.assertNotNull(champion.getId());
            Assert.assertNotNull(champion.getImage());
            Assert.assertNotNull(champion.getImage().getFull());
            Assert.assertNotNull(champion.getImage().getGroup());
            Assert.assertNotNull(champion.getImage().getSprite());
            Assert.assertNotNull(champion.getInfo());
            Assert.assertNotNull(champion.getKey());
            Assert.assertNotNull(champion.getLore());
            Assert.assertNotNull(champion.getName());
            Assert.assertNotNull(champion.getPartype());
            Assert.assertNotNull(champion.getPassive());
            Assert.assertNotNull(champion.getPassive().getDescription());
            Assert.assertNotNull(champion.getPassive().getImage());
            Assert.assertNotNull(champion.getPassive().getName());
            for (RecommendedDto recommended : champion.getRecommended()) {
                for (BlockDto block : recommended.getBlocks()) {
                    for (BlockItemDto blockItem : block.getItems()) {
                        Assert.assertNotNull(blockItem.getId());
                    }
                    Assert.assertNotNull(block.getType());
                }
                Assert.assertNotNull(recommended.getChampion());
                Assert.assertNotNull(recommended.getMap());
                Assert.assertNotNull(recommended.getMode());
                Assert.assertNotNull(recommended.getTitle());
                Assert.assertNotNull(recommended.getType());
            }
            for (SkinDto skin : champion.getSkins()) {
                Assert.assertNotNull(skin.getId());
                Assert.assertNotNull(skin.getName());
            }
            for (ChampionSpellDto spell : champion.getSpells()) {
                Assert.assertNotNull(spell.getCooldownBurn());
                Assert.assertNotNull(spell.getCostBurn());
                Assert.assertNotNull(spell.getCostType());
                Assert.assertNotNull(spell.getDescription());
                Assert.assertNotNull(spell.getId());
                Assert.assertNotNull(spell.getImage());
                Assert.assertNotNull(spell.getLevelTip());
                Assert.assertNotNull(spell.getName());
                Assert.assertNotNull(spell.getRange());
                Assert.assertNotNull(spell.getRangeBurn());
                Assert.assertNotNull(spell.getTooltip());
                for (SpellVarsDto spellVar : spell.getVars()) {
                    Assert.assertNotNull(spellVar.getCoeff());
                    Assert.assertNotNull(spellVar.getKey());
                    Assert.assertNotNull(spellVar.getLink());
                }
            }
            Assert.assertNotNull(champion.getStats());
            Assert.assertNotNull(champion.getTitle());
        }
        Assert.assertNotNull(championList.getFormat());
        Assert.assertNotNull(championList.getType());
        Assert.assertNotNull(championList.getVersion());
    }

    @Test
    public void getChampionWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampion(CHAMP_ID, Region.UNKNOWN, "en_US", null, CHAMP_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampionWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampion(CHAMP_ID, null, "en_US", null, CHAMP_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampionWithNullId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampion(null, REGION, "en_US", null, CHAMP_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampionWithEmptyId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChampion("", REGION, "en_US", null, CHAMP_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChampion() {
        ChampionDto champion = Lol4JTestClient.getClient().getChampion(CHAMP_ID, REGION, "en_US", null, CHAMP_DATA);
        Assert.assertNotNull(champion);

        Assert.assertNotNull(champion.getBlurb());
        Assert.assertNotNull(champion.getId());
        Assert.assertNotNull(champion.getImage());
        Assert.assertNotNull(champion.getImage().getFull());
        Assert.assertNotNull(champion.getImage().getGroup());
        Assert.assertNotNull(champion.getImage().getSprite());
        Assert.assertNotNull(champion.getInfo());
        Assert.assertNotNull(champion.getKey());
        Assert.assertNotNull(champion.getLore());
        Assert.assertNotNull(champion.getName());
        Assert.assertNotNull(champion.getPartype());
        Assert.assertNotNull(champion.getPassive());
        Assert.assertNotNull(champion.getPassive().getDescription());
        Assert.assertNotNull(champion.getPassive().getImage());
        Assert.assertNotNull(champion.getPassive().getName());
        for (RecommendedDto recommended : champion.getRecommended()) {
            for (BlockDto block : recommended.getBlocks()) {
                for (BlockItemDto blockItem : block.getItems()) {
                    Assert.assertNotNull(blockItem.getId());
                }
                Assert.assertNotNull(block.getType());
            }
            Assert.assertNotNull(recommended.getChampion());
            Assert.assertNotNull(recommended.getMap());
            Assert.assertNotNull(recommended.getMode());
            Assert.assertNotNull(recommended.getTitle());
            Assert.assertNotNull(recommended.getType());
        }
        for (SkinDto skin : champion.getSkins()) {
            Assert.assertNotNull(skin.getId());
            Assert.assertNotNull(skin.getName());
        }
        for (ChampionSpellDto spell : champion.getSpells()) {
            Assert.assertNotNull(spell.getCooldownBurn());
            Assert.assertNotNull(spell.getCostBurn());
            Assert.assertNotNull(spell.getCostType());
            Assert.assertNotNull(spell.getDescription());
            Assert.assertNotNull(spell.getId());
            Assert.assertNotNull(spell.getImage());
            Assert.assertNotNull(spell.getLevelTip());
            Assert.assertNotNull(spell.getName());
            Assert.assertNotNull(spell.getRange());
            Assert.assertNotNull(spell.getRangeBurn());
            Assert.assertNotNull(spell.getTooltip());
            for (SpellVarsDto spellVar : spell.getVars()) {
                Assert.assertNotNull(spellVar.getCoeff());
                Assert.assertNotNull(spellVar.getKey());
                Assert.assertNotNull(spellVar.getLink());
            }
        }
        Assert.assertNotNull(champion.getStats());
        Assert.assertNotNull(champion.getTitle());
    }

    @Test
    public void getItemWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItem(ITEM_ID, Region.UNKNOWN, "en_US", null, ITEM_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItemWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItem(ITEM_ID, null, "en_US", null, ITEM_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItemWithNullId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItem(null, REGION, "en_US", null, ITEM_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItemWithEmptyId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItem("", REGION, "en_US", null, ITEM_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItem() {
        ItemDto item = Lol4JTestClient.getClient().getItem(ITEM_ID, REGION, "en_US", null, ITEM_DATA);

        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getColloq());
        Assert.assertNotNull(item.getDescription());
        Assert.assertNotNull(item.getGold());
        Assert.assertNotNull(item.getImage());
        Assert.assertNotNull(item.getName());
        Assert.assertNotNull(item.getPlainText());
        Assert.assertNotNull(item.getStats());
    }

    @Test
    public void getItemsWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItems(Region.UNKNOWN, "en_US", null, ITEM_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItemsWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getItems(null, "en_US", null, ITEM_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getItems() {
        ItemListDto itemList = Lol4JTestClient.getClient().getItems(REGION, "en_US", null, ITEM_DATA);

        Assert.assertNotNull(itemList);
        Assert.assertNotNull(itemList.getType());
        Assert.assertNotNull(itemList.getVersion());

        ItemDto item = itemList.getBasic();
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getColloq());
        Assert.assertNotNull(item.getGold());
        Assert.assertNotNull(item.getStats());
    }

    @Test
    public void getMasteryWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMastery(MASTERY_ID, Region.UNKNOWN, "en_US", null, MASTERY_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMastery(MASTERY_ID, null, "en_US", null, MASTERY_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryWithNullId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMastery(null, REGION, "en_US", null, MASTERY_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteryWithEmptyId() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMastery("", REGION, "en_US", null, MASTERY_DATA);
        }
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMastery() {
        MasteryDto mastery = Lol4JTestClient.getClient().getMastery(MASTERY_ID, REGION, "en_US", null, MASTERY_DATA);

        Assert.assertNotNull(mastery);
        Assert.assertNotNull(mastery.getName());
    }

    @Test
    public void getMasteriesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteries(Region.UNKNOWN, "en_US", null, MASTERY_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteriesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getMasteries(null, "en_US", null, MASTERY_DATA);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getMasteries() {
        MasteryListDto masteries = Lol4JTestClient.getClient().getMasteries(REGION, "en_US", null, MASTERY_DATA);

        Assert.assertNotNull(masteries);
        Assert.assertNotNull(masteries.getType());
        Assert.assertNotNull(masteries.getVersion());
    }
}
