import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.*;
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
    private static final String RUNE_ID = "5235";
    private static final String CHAMP_ID = "35";
    private static final String ITEM_ID = "1027";
    private static final String MASTERY_ID = "4353";
    private static final int SUMMONER_SPELL_ID = 11; // SummonerSmite
    private static final List<ChampData> CHAMP_DATA = new ArrayList<>();
    private static final List<ItemData> ITEM_DATA = new ArrayList<>();
    private static final List<MasteryData> MASTERY_DATA = new ArrayList<>();
    private static final List<RuneData> RUNE_DATA = new ArrayList<>();
    private static final List<SummonerSpellData> SUMMONER_SPELL_DATA = new ArrayList<>();

    @BeforeClass
    public static void initializeTest() {
        CHAMP_DATA.add(ChampData.ALL);
        ITEM_DATA.add(ItemData.ALL);
        MASTERY_DATA.add(MasteryData.ALL);
        RUNE_DATA.add(RuneData.ALL);
        SUMMONER_SPELL_DATA.add(SummonerSpellData.ALL);
    }

    @Test
    public void getRune() {
        BasicDataDto rune = Lol4JTestClient.getClient().getRune(RUNE_ID, REGION, "en_US", null, RUNE_DATA);

        Assert.assertNotNull(rune);
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

    @Test(expected = IllegalArgumentException.class)
    public void getChampionWithNullId() {
        Lol4JTestClient.getClient().getChampion(null, REGION, "en_US", null, CHAMP_DATA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getChampionWithEmptyId() {
        Lol4JTestClient.getClient().getChampion("", REGION, "en_US", null, CHAMP_DATA);
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

    @Test(expected = IllegalArgumentException.class)
    public void getItemWithNullId() {
        Lol4JTestClient.getClient().getItem(null, REGION, "en_US", null, ITEM_DATA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getItemWithEmptyId() {
        Lol4JTestClient.getClient().getItem("", REGION, "en_US", null, ITEM_DATA);
    }

    @Test
    public void getItem() {
        BasicDataDto item = Lol4JTestClient.getClient().getItem(ITEM_ID, REGION, "en_US", null, ITEM_DATA);

        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getDescription());
        Assert.assertNotNull(item.getGold());
        Assert.assertNotNull(item.getImage());
        Assert.assertNotNull(item.getName());
        Assert.assertNotNull(item.getPlainText());
        Assert.assertNotNull(item.getStats());
    }

    @Test
    public void getItems() {
        ItemListDto itemList = Lol4JTestClient.getClient().getItemList(REGION, "en_US", null, ITEM_DATA);

        Assert.assertNotNull(itemList);
        Assert.assertNotNull(itemList.getType());
        Assert.assertNotNull(itemList.getVersion());

        BasicDataDto item = itemList.getBasic();
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getGold());
        Assert.assertNotNull(item.getStats());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMasteryWithNullId() {
        Lol4JTestClient.getClient().getMastery(null, REGION, "en_US", null, MASTERY_DATA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMasteryWithEmptyId() {
        Lol4JTestClient.getClient().getMastery("", REGION, "en_US", null, MASTERY_DATA);
    }

    @Test
    public void getMastery() {
        MasteryDto mastery = Lol4JTestClient.getClient().getMastery(MASTERY_ID, REGION, "en_US", null, MASTERY_DATA);

        Assert.assertNotNull(mastery);
        Assert.assertNotNull(mastery.getName());
    }

    @Test
    public void getMasteries() {
        MasteryListDto masteries = Lol4JTestClient.getClient().getMasteryList(REGION, "en_US", null, MASTERY_DATA);

        Assert.assertNotNull(masteries);
        Assert.assertNotNull(masteries.getType());
        Assert.assertNotNull(masteries.getVersion());
    }

    @Test
    public void getRealm() {
        RealmDto realm = Lol4JTestClient.getClient().getRealm(REGION);

        Assert.assertNotNull(realm);
        Assert.assertNotNull(realm.getCdnBaseUrl());
        Assert.assertNotNull(realm.getCssVersion());
        Assert.assertNotNull(realm.getDefaultLanguage());
        Assert.assertNotNull(realm.getDragonMagicVersion());
        Assert.assertNotNull(realm.getLegacyScriptMode());
        Assert.assertNotNull(realm.getVersion());
    }

    @Test
    public void getRunes() {
        RuneListDto runes = Lol4JTestClient.getClient().getRuneList(REGION, null, null, RUNE_DATA);

        Assert.assertNotNull(runes);
    }

    @Test
    public void testAllRegions() {
        for (Region region : Region.values()) {
            if (region == Region.UNKNOWN) {
                continue;
            }

            RuneListDto runes = Lol4JTestClient.getClient().getRuneList(region, null, null, RUNE_DATA);
            Assert.assertNotNull(runes);
        }
    }

    @Test
    public void getSummonerSpells() {
        SummonerSpellListDto summonerSpells = Lol4JTestClient.getClient().getSummonerSpellList(REGION, null, null, SUMMONER_SPELL_DATA);

        Assert.assertNotNull(summonerSpells);
    }

    @Test
    public void getSummonerSpell() {
        SummonerSpellDto summonerSpell = Lol4JTestClient.getClient().getSummonerSpell(SUMMONER_SPELL_ID, REGION, null, null, SUMMONER_SPELL_DATA);

        Assert.assertNotNull(summonerSpell);
    }
}
